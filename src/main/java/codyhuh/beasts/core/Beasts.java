package codyhuh.beasts.core;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Beasts.MOD_ID)
public class Beasts {
    public static final String MOD_ID = "beasts";

    public Beasts() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    }
}
