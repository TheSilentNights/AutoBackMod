package com.thesilentnights.autoback.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class BackTest extends CommandBase {
    @Override
    public String getName() {
        return "back";
    }

    @Override
    public String getUsage(ICommandSender iCommandSender) {
        return "";
    }

    @Override
    public void execute(MinecraftServer minecraftServer, ICommandSender iCommandSender, String[] strings) throws CommandException {
        iCommandSender.sendMessage(new TextComponentString("back commandExecute"));
    }
}
