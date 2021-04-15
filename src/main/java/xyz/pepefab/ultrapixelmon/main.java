package xyz.pepefab.ultrapixelmon;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;
import org.apache.logging.log4j.Logger;

@Mod(modid = main.MODID, name = main.NAME, version = main.VERSION, serverSideOnly = true, acceptableRemoteVersions = "*")
public class main
{
    public static final String MODID = "uptileschunklimit";
    public static final String NAME = "UPTilesChunkLimit";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        Config.load();
        MinecraftForge.EVENT_BUS.register(new xyz.pepefab.ultrapixelmon.EventHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("[UPTilesChunkLimit] Initialisation effectue avec succes. Version: " + main.VERSION);

        PermissionAPI.registerNode("uptileschunklimit.nolimit", DefaultPermissionLevel.OP, "Permet de ne pas avoir de restriction de pose");
    }
}
