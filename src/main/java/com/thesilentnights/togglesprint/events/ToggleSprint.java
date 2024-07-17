package com.thesilentnights.togglesprint.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class ToggleSprint {
    private static Minecraft mc = Minecraft.getMinecraft();
    private boolean toggled = false;

    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent e) {
        if (this.toggled) {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
        }
    }

    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent e) {
        if (Keyboard.getEventKeyState() && Keyboard.getEventKey() == mc.gameSettings.keyBindSprint.getKeyCode()) {
            this.toggled = !this.toggled;
        }
    }
}
