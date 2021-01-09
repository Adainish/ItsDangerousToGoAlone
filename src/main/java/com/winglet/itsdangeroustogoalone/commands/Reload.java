package com.winglet.itsdangeroustogoalone.commands;

import com.winglet.itsdangeroustogoalone.config.FileHandler;
import com.winglet.itsdangeroustogoalone.config.PermissionManager;
import com.winglet.itsdangeroustogoalone.config.PermissionUtils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reload extends CommandBase {

    @Override
    public String getName() {
        return "itsdangerous";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return TextFormatting.RED + "Usage: /" + this.getName();
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload") && PermissionUtils.canUse(PermissionManager.ADMIN_RELOAD, sender)) {
                FileHandler.readAllFiles();
                this.send(sender, "&4&lReloaded the configuration please double check the console for any internal errors!");
            } else
                sender.sendMessage(new TextComponentString(this.getUsage(sender)));
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("idtga");
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        List<String> possibleArgs = new ArrayList<>();
        if (args.length == 1 && PermissionUtils.canUse(PermissionManager.ADMIN_RELOAD, sender))
            possibleArgs.add("reload");
        return getListOfStringsMatchingLastWord(args, possibleArgs);
    }

    private void send(ICommandSender recipient, String message) {
        recipient.sendMessage(new TextComponentString((FileHandler.config.getPluginPrefix() + message).replaceAll("&([0-9a-fk-or])","\u00a7$1")));
    }

}
