package codyhuh.beasts.core.registry;

import codyhuh.beasts.core.Beasts;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType JELLYWOOD = WoodType.register(new WoodType(Beasts.MOD_ID + ":jelly", BlockSetType.OAK));
}
