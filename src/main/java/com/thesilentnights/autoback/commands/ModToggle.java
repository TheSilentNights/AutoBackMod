package com.thesilentnights.autoback.commands;

import com.thesilentnights.autoback.config.Config;
import com.thesilentnights.autoback.repo.State;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class ModToggle extends CommandBase {
    @Override
    public String getName() {
        return "autoback";
    }

    @Override
    public String getUsage(ICommandSender iCommandSender) {
        return "/autoback off/on";
    }

    @Override
    public void execute(MinecraftServer minecraftServer, ICommandSender iCommandSender, String[] args) throws CommandException {
        if (args.length == 0) {
            iCommandSender.sendMessage(new TextComponentString("must have at least one argument"));
            return;
        }
        if (args[0].equals("off")) {
            State.isEnabled = false;
            Config.saveBoolean("ifEnabled", false);
            iCommandSender.sendMessage(new TextComponentString("autoback mod off"));
        } else if (args[0].equals("on")) {
            State.isEnabled = true;
            Config.saveBoolean("ifEnabled", true);
            iCommandSender.sendMessage(new TextComponentString("autoback mod on"));
        } else {
            iCommandSender.sendMessage(new TextComponentString("param must be \"off\" or \"on\""));
        }
    }
}
