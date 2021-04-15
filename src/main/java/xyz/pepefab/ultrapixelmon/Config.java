package xyz.pepefab.ultrapixelmon;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static int perChunkLimit;

    public static void load(){
        Configuration config = new Configuration(new File("config/UPTilesChunkLimit/uptileschunklimit.cfg"));
        config.load();

        perChunkLimit = config.get(Configuration.CATEGORY_GENERAL, "Nombre de Block Tiles maximum dans un seul chunk", 200,"Default: 200 | Impossible de poser des blocks dans le chunk lorsque ce nombre est atteint").getInt(200);

        config.save();
    }
}
