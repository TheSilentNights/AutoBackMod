package com.thesilentnights.autoback.events;


import com.thesilentnights.autoback.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class TickEventListener {
    private static int tick = 0;
    private static int maxTick = Config.getInt("maxTick");
    private static boolean ifEnabled = false;



    @SubscribeEvent
    public void executeCommand(TickEvent event){
        if (ifEnabled){
            if (tick > maxTick){
                TickEventListener.executeCommand();
                ifEnabled = false;
                tick = 0;
                return;
            }
            tick++;
        }
    }

    public static void start(){
        ifEnabled = true;
    }

    public static void setTick(int tick) {
        TickEventListener.maxTick = tick;
    }

    public static void executeCommand(){
        ClientCommandHandler.instance.executeCommand(Minecraft.getMinecraft().player, "back");
    }
}
