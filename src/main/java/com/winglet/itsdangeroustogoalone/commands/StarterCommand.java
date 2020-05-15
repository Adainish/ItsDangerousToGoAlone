package com.winglet.itsdangeroustogoalone.commands;

import com.winglet.itsdangeroustogoalone.UIBuild.Pages;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class StarterCommand extends CommandBase {

    @Override
    public String getName() {
        return "starters";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/starters (player)";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        if (sender instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) sender;
            if (player.canUseCommand(0, "itsdangeroustogoalone.command.starters")) {
                Pages.StarterSelect(player).forceOpenPage(player);
            }
        } else {
            server.sendMessage(new TextComponentString("&cYou don't have permission!"));
        }
    }
}
