package com.thesilentnights.autoback.events;

import com.thesilentnights.autoback.repo.State;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerDieListener {
    @SubscribeEvent
    public void onPlayerDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            if (State.isEnabled) {
                TickEventListener.start();
            }
        }
    }


}
