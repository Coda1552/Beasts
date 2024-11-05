package codyhuh.beasts.core.registry;

import codyhuh.beasts.core.Beasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class ModConfiguredFeatures {
  public static final ResourceKey<ConfiguredFeature<?, ?>> JELLYWOOD_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Beasts.MOD_ID, "jellywood_tree"));

}
