package com.thesilentnights.togglesprint;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;


@Mod(modid = ToggleSprint.MODID, name = ToggleSprint.NAME, version = ToggleSprint.VERSION)
public class ToggleSprint {
    public static final String MODID = "ToggleSprint";
    public static final String NAME = "ToggleSprint";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Logger logger = event.getModLog();

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        //register listener

        MinecraftForge.EVENT_BUS.register(new com.thesilentnights.togglesprint.events.ToggleSprint());
        //register command


    }
}
