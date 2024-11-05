package codyhuh.beasts.client;

import codyhuh.beasts.core.Beasts;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation JELLYWOOD_BOAT_LAYER = create("boat/jelly");
    public static final ModelLayerLocation JELLYWOOD_CHEST_BOAT_LAYER = create("chest_boat/jelly");

    private static ModelLayerLocation create(String name) {
        return new ModelLayerLocation(new ResourceLocation(Beasts.MOD_ID, name), "main");
    }
}
