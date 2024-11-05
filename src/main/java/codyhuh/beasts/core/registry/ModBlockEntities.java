package codyhuh.beasts.core.registry;

import codyhuh.beasts.common.blocks.entity.ModHangingSignBlockEntity;
import codyhuh.beasts.common.blocks.entity.ModSignBlockEntity;
import codyhuh.beasts.core.Beasts;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Beasts.MOD_ID);

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN = BLOCK_ENTITIES.register( "mod_sign", () -> BlockEntityType.Builder.of(ModSignBlockEntity::new, ModBlocks.JELLYWOOD_SIGN.get(), ModBlocks.JELLYWOOD_WALL_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN = BLOCK_ENTITIES.register( "mod_hanging_sign", () -> BlockEntityType.Builder.of(ModHangingSignBlockEntity::new, ModBlocks.JELLYWOOD_HANGING_SIGN.get(), ModBlocks.JELLYWOOD_WALL_HANGING_SIGN.get()).build(null));
}
