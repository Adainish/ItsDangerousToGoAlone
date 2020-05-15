package com.winglet.itsdangeroustogoalone;

import ca.landonjw.gooeylibs.inventory.api.InventoryAPI;
import com.winglet.itsdangeroustogoalone.commands.StarterCommand;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(
        modid = Itsdangeroustogoalone.MOD_ID,
        name = Itsdangeroustogoalone.MOD_NAME,
        version = Itsdangeroustogoalone.VERSION,
        acceptableRemoteVersions = "*"
)
public class Itsdangeroustogoalone {

    public static final String MOD_ID = "itsdangeroustogoalone";
    public static final String MOD_NAME = "ItsDangerousToGoAlone";
    public static final String VERSION = "1.0.3";


    @Mod.Instance(MOD_ID)
    public static Itsdangeroustogoalone INSTANCE;

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        InventoryAPI.register();
        event.registerServerCommand(new StarterCommand());
    }
}
