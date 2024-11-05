package codyhuh.beasts.core.registry;

import codyhuh.beasts.common.entity.item.ModBoatEntity;
import codyhuh.beasts.common.item.ModBoatItem;
import codyhuh.beasts.core.Beasts;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Beasts.MOD_ID);

    public static final RegistryObject<Item> JELLYWOOD_SIGN = ITEMS.register("jellywood_sign", () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.JELLYWOOD_SIGN.get(), ModBlocks.JELLYWOOD_WALL_SIGN.get()));
    public static final RegistryObject<Item> JELLYWOOD_HANGING_SIGN = ITEMS.register("jellywood_hanging_sign", () -> new HangingSignItem(ModBlocks.JELLYWOOD_HANGING_SIGN.get(), ModBlocks.JELLYWOOD_WALL_HANGING_SIGN.get(),new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> JELLYWOOD_BOAT = ITEMS.register("jellywood_boat", () -> new ModBoatItem(false, ModBoatEntity.Type.JELLY, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JELLYWOOD_CHEST_BOAT = ITEMS.register("jellywood_chest_boat", () -> new ModBoatItem(true, ModBoatEntity.Type.JELLY, new Item.Properties().stacksTo(1)));

}