package codyhuh.beasts.core.registry;

import codyhuh.beasts.core.Beasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Beasts.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_TABS.register("beasts_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + Beasts.MOD_ID))
            .icon(ModBlocks.JELLYWOOD_SAPLING.get().asItem()::getDefaultInstance)
            .displayItems((itemDisplayParameters, output) -> {
                ModItems.ITEMS.getEntries().forEach(itemRegistryObject -> output.accept(itemRegistryObject.get()));
            })
            .build()
    );

}
