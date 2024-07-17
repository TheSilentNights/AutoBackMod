package com.thesilentnights.autoback.commands;

import com.thesilentnights.autoback.config.Config;
import com.thesilentnights.autoback.events.TickEventListener;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class SetMaxTick extends CommandBase {
    @Override
    public String getName() {
        return "setMaxTick";
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public String getUsage(ICommandSender iCommandSender) {
        return "";
    }

    @Override
    public void execute(MinecraftServer minecraftServer, ICommandSender iCommandSender, String[] strings) throws CommandException {
        if (strings.length < 1) {
            iCommandSender.sendMessage(new TextComponentString("Please enter a tick number"));
        }
        TickEventListener.setTick(Integer.parseInt(strings[0]));
        Config.saveInt("maxTick", Integer.parseInt(strings[0]));

        iCommandSender.sendMessage(new TextComponentString("set max tick to " + strings[0]));
    }
}
