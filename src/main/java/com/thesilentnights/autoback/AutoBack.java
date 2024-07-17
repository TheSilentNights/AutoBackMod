package com.thesilentnights.autoback;

import com.thesilentnights.autoback.commands.ModToggle;
import com.thesilentnights.autoback.commands.SetMaxTick;
import com.thesilentnights.autoback.config.Config;
import com.thesilentnights.autoback.events.PlayerDieListener;
import com.thesilentnights.autoback.events.TickEventListener;
import com.thesilentnights.autoback.events.ToggleSprint;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;


@Mod(modid = AutoBack.MODID, name = AutoBack.NAME, version = AutoBack.VERSION)
public class AutoBack {
    public static final String MODID = "autoback";
    public static final String NAME = "AutoBack";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Logger logger = event.getModLog();
        Config.load(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        //register listener
        MinecraftForge.EVENT_BUS.register(new PlayerDieListener());
        MinecraftForge.EVENT_BUS.register(new TickEventListener());
        MinecraftForge.EVENT_BUS.register(new ToggleSprint());
        //register command
        ClientCommandHandler.instance.registerCommand(new ModToggle());
        ClientCommandHandler.instance.registerCommand(new SetMaxTick());

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        Config.save();
    }
}
