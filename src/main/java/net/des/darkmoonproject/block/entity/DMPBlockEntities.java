package net.des.darkmoonproject.block.entity;

import net.des.darkmoonproject.DarkMoonProject;
import net.des.darkmoonproject.block.entity.machine.CobblestoneCrusherEntity;
import net.des.darkmoonproject.init.DMPBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DMPBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DarkMoonProject.MOD_ID);

    public static final RegistryObject<BlockEntityType<CobblestoneCrusherEntity>> COBBLESTONE_CRUSHER =
            BLOCK_ENTITIES.register("cobblestone_crusher", () ->
                    BlockEntityType.Builder.of(CobblestoneCrusherEntity::new,
                            DMPBlocks.COBBLESTONE_CRUSHER.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
