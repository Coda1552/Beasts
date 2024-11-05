package codyhuh.beasts.core.registry;

import codyhuh.beasts.common.blocks.*;
import codyhuh.beasts.core.Beasts;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.MangroveTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Beasts.MOD_ID);

    public static final RegistryObject<Block> JELLYWOOD_SAPLING = register("jellywood_sapling", () -> new BeastsSaplingBlock(new MangroveTreeGrower(1.0F), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).mapColor(MapColor.COLOR_MAGENTA).instabreak().ignitedByLava().noCollission().sound(SoundType.WET_GRASS)));
    public static final RegistryObject<Block> POTTED_JELLYWOOD_SAPLING = registerExcludeFromTab("potted_jellywood_sapling", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.JELLYWOOD_SAPLING, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    // Logs
    public static final RegistryObject<Block> JELLY_LOG = register ("jelly_log", () -> new FlammableWoodLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_JELLY_LOG = register ("stripped_jelly_log", () -> new FlammableWoodLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JELLY_WOOD = register ("jelly_wood", () -> new FlammableWoodLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_JELLY_WOOD = register ("stripped_jelly_wood", () -> new FlammableWoodLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> JELLYBELL = register("jellybell", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LEAVES).sound(SoundType.WET_GRASS).ignitedByLava()));

    // Planks
    public static final RegistryObject<Block> JELLYWOOD_PLANKS = register("jellywood_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> JELLYWOOD_STAIRS = register("jellywood_stairs", () -> new StairBlock(() -> ModBlocks.JELLYWOOD_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JELLYWOOD_SLAB = register("jellywood_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> JELLYWOOD_BUTTON = register("jellywood_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 25, true));
    public static final RegistryObject<Block> JELLYWOOD_PRESSURE_PLATE = register("jellywood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final RegistryObject<Block> JELLYWOOD_FENCE = register("jellywood_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> JELLYWOOD_FENCE_GATE = register("jellywood_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    // Doors
    public static final RegistryObject<Block> JELLYWOOD_DOOR = register("jellywood_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> JELLYWOOD_TRAPDOOR = register("jellywood_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).noOcclusion(),BlockSetType.OAK));
    
    
    public static final RegistryObject<Block> JELLYWOOD_SIGN = BLOCKS.register("jellywood_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_SIGN), ModWoodTypes.JELLYWOOD));

    public static final RegistryObject<Block> JELLYWOOD_WALL_SIGN = BLOCKS.register("jellywood_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_WALL_SIGN), ModWoodTypes.JELLYWOOD));

    public static final RegistryObject<Block> JELLYWOOD_HANGING_SIGN = BLOCKS.register("jellywood_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_HANGING_SIGN), ModWoodTypes.JELLYWOOD));

    public static final RegistryObject<Block> JELLYWOOD_WALL_HANGING_SIGN = BLOCKS.register("jellywood_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_WALL_HANGING_SIGN), ModWoodTypes.JELLYWOOD));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        return register(name, block, new Item.Properties());
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, Item.Properties itemProperties) {
        return register(name, block, BlockItem::new, itemProperties);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, BiFunction<Block, Item.Properties, BlockItem> item, Item.Properties itemProperties) {
        final RegistryObject<T> registryObject = BLOCKS.register(name, block);
        if (itemProperties != null)
            ModItems.ITEMS.register(name, () -> item == null ? new BlockItem(registryObject.get(), itemProperties) : item.apply(registryObject.get(), itemProperties));
        return registryObject;
    }

    private static <T extends Block> RegistryObject<T> registerExcludeFromTab(String name, Supplier<T> block){
        return BLOCKS.register(name, block);
    }
}
