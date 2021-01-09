package com.winglet.itsdangeroustogoalone;

import ca.landonjw.gooeylibs.inventory.api.InventoryAPI;
import com.winglet.itsdangeroustogoalone.commands.Reload;
import com.winglet.itsdangeroustogoalone.commands.StarterCommand;
import com.winglet.itsdangeroustogoalone.config.FileHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(
        modid = Itsdangeroustogoalone.MOD_ID,
        name = Itsdangeroustogoalone.MOD_NAME,
        version = Itsdangeroustogoalone.VERSION,
        acceptableRemoteVersions = "*"
)
public class Itsdangeroustogoalone {

    public static final String MOD_ID = "itsdangeroustogoalone";
    public static final String MOD_NAME = "ItsDangerousToGoAlone";
    public static final String VERSION = "1.1.3";
    public static final String AUTHORS = "Winglet";

    public static Logger log = LogManager.getLogger(MOD_NAME);
    public static File configDir;
    public static File configFile;


    @Mod.Instance(MOD_ID)
    public static Itsdangeroustogoalone INSTANCE;

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        InventoryAPI.register();
        event.registerServerCommand(new StarterCommand());
        event.registerServerCommand(new Reload());
    }

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent e) {
        log.info("Booting up " + MOD_NAME + " - by " + AUTHORS + " @2020 v:" + VERSION + "Now Translateable and with Custom Mon Support!");
        configDir = new File(e.getModConfigurationDirectory() + "/" + MOD_ID);
        configDir.mkdir();
        configFile = new File(configDir, "itsdangeroustogoalone.json");
        FileHandler.readAllFiles();
        FileHandler.creationCheck();
        FileHandler.writeAllFiles();
    }
}
