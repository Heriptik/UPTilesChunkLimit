package xyz.pepefab.ultrapixelmon;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.server.permission.PermissionAPI;

public class EventHandler {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onBlockPlace(BlockEvent.PlaceEvent event){

        final boolean hasPermission = PermissionAPI.hasPermission(event.getPlayer(), "uptileschunklimit.nolimit");

        if(event.getBlockSnapshot().getCurrentBlock().getBlock().getLocalizedName().equals("Sign")){
            return;
        }

        if(!hasPermission){
            if(event.getBlockSnapshot().getCurrentBlock().getBlock().hasTileEntity()){
                if(event.getWorld().getChunkFromBlockCoords(event.getPos()).getTileEntityMap().size() > Config.perChunkLimit){
                    event.getPlayer().sendMessage(new TextComponentString(TextFormatting.RED + "Vous ne pouvez pas placer plus de " + Config.perChunkLimit + " Tiles Entity dans un m\u00eame chunk. Ex : Coffre, Four, Healer, PC, Ranch, Safe ..."));
                    event.setCanceled(true);
                }
            }
        }
    }
}
