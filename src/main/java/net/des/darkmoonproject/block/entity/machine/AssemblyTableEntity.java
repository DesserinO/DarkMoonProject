package net.des.darkmoonproject.block.entity.machine;

import net.des.darkmoonproject.block.custom.AssemblyTable;
import net.des.darkmoonproject.block.entity.DMPBlockEntities;
import net.des.darkmoonproject.block.entity.WrappedHandler;
import net.des.darkmoonproject.client.gui.machine.AssemblyTableMenu;
import net.des.darkmoonproject.init.DMPItems;
import net.des.darkmoonproject.recipe.AssemblyTableRecipe;
import net.des.darkmoonproject.util.DMPTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class AssemblyTableEntity extends BlockEntity implements MenuProvider {
    // itemHandler → Amount of slots
    private final ItemStackHandler itemHandler = new ItemStackHandler(6) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 3 -> stack.is(DMPTags.Items.HAMMER_TOOLS);
                case 4 -> stack.is(DMPTags.Items.SCREWDRIVER_TOOLS);
                case 5 -> stack.is(DMPTags.Items.WIRE_CUTTER_TOOLS);
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    private final Map<Direction, LazyOptional<WrappedHandler>> directionWrappedHandlerMap =
            Map.of(Direction.UP, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 0,
                            (index, stack) -> itemHandler.isItemValid(0, stack) || itemHandler.isItemValid(1, stack))),
                    Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 0,
                            (index, stack) -> itemHandler.isItemValid(0, stack) || itemHandler.isItemValid(1, stack))),
                    Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 1, (i, s) -> false)),
                    Direction.EAST, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 1,
                            (index, stack) -> itemHandler.isItemValid(0, stack) || itemHandler.isItemValid(1, stack))),
                    Direction.WEST, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 0 || index == 1,
                            (index, stack) -> itemHandler.isItemValid(0, stack) || itemHandler.isItemValid(1, stack))));

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;

    public AssemblyTableEntity(BlockPos pos, BlockState state) {
        super(DMPBlockEntities.ASSEMBLY_TABLE.get(), pos, state);

        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> AssemblyTableEntity.this.progress;
                    case 1 -> AssemblyTableEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> AssemblyTableEntity.this.progress = value;
                    case 1 -> AssemblyTableEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    // Name of block in GUI
    @Override
    public Component getDisplayName() {
        return Component.literal("Assembly Table");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new AssemblyTableMenu(id, inventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            if(side == null) {
                return lazyItemHandler.cast();
            }

            if(directionWrappedHandlerMap.containsKey(side)) {
                Direction localDir = this.getBlockState().getValue(AssemblyTable.FACING);

                if(side == Direction.UP || side == Direction.DOWN) {
                    return directionWrappedHandlerMap.get(side).cast();
                }

                return switch (localDir) {
                    default -> directionWrappedHandlerMap.get(side.getOpposite()).cast();
                    case EAST -> directionWrappedHandlerMap.get(side.getClockWise()).cast();
                    case SOUTH -> directionWrappedHandlerMap.get(side).cast();
                    case WEST -> directionWrappedHandlerMap.get(side.getCounterClockWise()).cast();
                };
            }
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory", itemHandler.serializeNBT());
        nbt.putInt("assembly_table.progress", this.progress);

        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("assembly_table.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, AssemblyTableEntity pEntity) {
        if(level.isClientSide()) {
            return;
        }
        if(hasRecipe(pEntity)) {
            pEntity.progress++;
            setChanged(level, pos, state);

            if(pEntity.progress >= pEntity.maxProgress) {
                craftItem(pEntity);
            }
        } else {
            pEntity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    private static void craftItem(AssemblyTableEntity pEntity) {
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        Optional<AssemblyTableRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(AssemblyTableRecipe.Type.INSTANCE, inventory, level);

        if(hasRecipe(pEntity)) {
            if (pEntity.itemHandler.getStackInSlot(1).is(DMPTags.Items.PATTERNS)) {
                if (pEntity.itemHandler.getStackInSlot(3).is(DMPItems.COBBLESTONE_HAMMER.get())) {
                    pEntity.itemHandler.extractItem(3, 1, false);
                }
                pEntity.itemHandler.extractItem(0, 1, false);
                pEntity.itemHandler.insertItem(2, recipe.get().getResultItem(), false);

                pEntity.resetProgress();
            } if (!pEntity.itemHandler.getStackInSlot(1).is(DMPTags.Items.PATTERNS)) {
                if (pEntity.itemHandler.getStackInSlot(3).is(DMPItems.COBBLESTONE_HAMMER.get())) {
                    pEntity.itemHandler.extractItem(3, 1, false);
                }
                pEntity.itemHandler.extractItem(0, 1, false);
                pEntity.itemHandler.extractItem(1, 1, false);
                pEntity.itemHandler.insertItem(2, recipe.get().getResultItem(), false);

                pEntity.resetProgress();
            }


            /*if(pEntity.itemHandler.getStackInSlot(1).is(DMPTags.Items.PATTERNS)) {
                pEntity.itemHandler.extractItem(0, 1, false);
                pEntity.itemHandler.insertItem(2, recipe.get().getResultItem(), false);
                if (pEntity.itemHandler.getStackInSlot(3).is(DMPItems.COBBLESTONE_HAMMER.get())) {
                    pEntity.itemHandler.extractItem(3, 1, false);
                }

                pEntity.resetProgress();
            } if(!pEntity.itemHandler.getStackInSlot(1).is(DMPTags.Items.PATTERNS)) {
                pEntity.itemHandler.extractItem(0, 1, false);
                pEntity.itemHandler.extractItem(1, 1, false);
                pEntity.itemHandler.insertItem(2, recipe.get().getResultItem(), false);
                if (pEntity.itemHandler.getStackInSlot(3).is(DMPItems.COBBLESTONE_HAMMER.get())) {
                    pEntity.itemHandler.extractItem(3, 1, false);
                }

                pEntity.resetProgress();
            }*/

        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean hasRecipe(AssemblyTableEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<AssemblyTableRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(AssemblyTableRecipe.Type.INSTANCE, inventory, level);

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(inventory) &&
                canInsertItemIntoOutputSlot(inventory, recipe.get().getResultItem());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(2).getItem() == stack.getItem() || inventory.getItem(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }
}
