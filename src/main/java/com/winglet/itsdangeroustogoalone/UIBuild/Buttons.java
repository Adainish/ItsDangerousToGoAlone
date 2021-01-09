package com.winglet.itsdangeroustogoalone.UIBuild;

import ca.landonjw.gooeylibs.inventory.api.Button;
import ca.landonjw.gooeylibs.inventory.api.InventoryAPI;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.config.PixelmonItemsHeld;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import com.pixelmonmod.pixelmon.items.ItemPixelmonSprite;
import com.winglet.itsdangeroustogoalone.config.FileHandler;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.Arrays;

public class Buttons {

    public static Button panes = Button.builder()
            .item(new ItemStack(Blocks.STAINED_GLASS_PANE, -1, EnumDyeColor.GRAY.getMetadata()))
            .displayName("")
            .build();

    public static Button buildStarterPokemonButton(EnumSpecies species, EntityPlayerMP player, boolean isShiny){
        Pokemon poke = Pixelmon.pokemonFactory.create(species);
        poke.setShiny(isShiny);
        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
        Button button = Button.builder()
                .displayName("§e"+species.name)
                .item(ItemPixelmonSprite.getPhoto(poke))
                .lore(Arrays.asList(FileHandler.config.getLoreSpeciesFront() + FileHandler.config.getSpeciesNameColour() +" " +species.name+ FileHandler.config.getLoreSpeciesBack()))
                .onClick(buttonAction ->  {
                    player.getServer().getCommandManager().executeCommand(server, "pokegive "+ buttonAction.getPlayer().getName() +" "+species.name+" " +FileHandler.config.getSpecsNormal());
                    player.sendMessage(new TextComponentString(FileHandler.config.getPrefix() + " " + FileHandler.config.getMessageProfessor()));
                    player.sendMessage(new TextComponentString(FileHandler.config.getMessageProfessor2Front() + FileHandler.config.getSpeciesNameColour() + species.name));
                    player.getServer().getCommandManager().executeCommand(server, "lp user "+ buttonAction.getPlayer().getName()+ " permission set itsdangeroustogoalone.command.starters false");
                    InventoryAPI.getInstance().closePlayerInventory(player);
                })
                .build();
        return button;
    }

    public static Button buildShinyStarterPokemonButton(EnumSpecies species, EntityPlayerMP player, boolean isShiny){
        Pokemon poke = Pixelmon.pokemonFactory.create(species);
        poke.setShiny(isShiny);
        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
        Button button = Button.builder()
                .displayName("§e"+species.name)
                .item(ItemPixelmonSprite.getPhoto(poke))
                .lore(Arrays.asList(FileHandler.config.getLoreSpeciesFront() + FileHandler.config.getSpeciesNameColour() +" " +species.name+ FileHandler.config.getLoreSpeciesBack()))
                .onClick(buttonAction ->  {
                    player.getServer().getCommandManager().executeCommand(server, "pokegive "+ buttonAction.getPlayer().getName() +" "+species.name+" " +FileHandler.config.getSpecsShiny());
                    player.sendMessage(new TextComponentString(FileHandler.config.getPrefix() + " " + FileHandler.config.getMessageProfessor()));
                    player.sendMessage(new TextComponentString(FileHandler.config.getMessageProfessor2Front() + FileHandler.config.getSpeciesNameColour() + species.name));
                    player.getServer().getCommandManager().executeCommand(server, "lp user "+ buttonAction.getPlayer().getName()+ " permission set itsdangeroustogoalone.command.starters false");
                    InventoryAPI.getInstance().closePlayerInventory(player);
                })
                .build();
        return button;
    }

    public static Button back(EntityPlayerMP player, boolean isShinyMenu, boolean isCS){
        if(isCS){
            Button back = Button.builder()
                    .item(new ItemStack(PixelmonItemsHeld.ejectButton))
                    .displayName(FileHandler.config.getButtonBack())
                    .onClick(buttonAction -> {
                        Pages.CustomStartersMenu(player).forceOpenPage(player);})
                    .build();
            return back;
        }
        else if(isShinyMenu){
            Button back = Button.builder()
                    .item(new ItemStack(PixelmonItemsHeld.ejectButton))
                    .displayName(FileHandler.config.getButtonBack())
                    .onClick(buttonAction -> {
                        Pages.ShinyStartersMenu(player).forceOpenPage(player);})
                    .build();
            return back;
        }else{
            Button back = Button.builder()
                    .item(new ItemStack(PixelmonItemsHeld.ejectButton))
                    .displayName(FileHandler.config.getButtonBack())
                    .onClick(buttonAction -> {Pages.StartersMenu(player).forceOpenPage(player);})
                    .build();
            return back;
        }
    }

    public static Button buildCustomSkinStarterPokemonButton(EnumSpecies species, EntityPlayerMP player, boolean isCS) {
        Pokemon poke = Pixelmon.pokemonFactory.create(species);
        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
        Button button = Button.builder()
                .displayName("§e"+species.name)
                .item(ItemPixelmonSprite.getPhoto(poke))
                .lore(Arrays.asList(FileHandler.config.getLoreSpeciesFront() + FileHandler.config.getSpeciesNameColour() +"" +species.name+ FileHandler.config.getLoreSpeciesBack()))
                .onClick(buttonAction ->  {
                    player.getServer().getCommandManager().executeCommand(server, "pokegive "+ buttonAction.getPlayer().getName() +" "+species.name+" " +FileHandler.config.getSpecsCustom());
                    player.sendMessage(new TextComponentString(FileHandler.config.getPrefix() + " " + FileHandler.config.getMessageProfessor()));
                    player.sendMessage(new TextComponentString(FileHandler.config.getMessageProfessor2Front() + FileHandler.config.getSpeciesNameColour() + species.name));
                    player.getServer().getCommandManager().executeCommand(server, "lp user "+ buttonAction.getPlayer().getName()+ " permission set itsdangeroustogoalone.command.starters false");
                    InventoryAPI.getInstance().closePlayerInventory(player);
                })
                .build();
        return button;
    }

    public static Button customskinback(EntityPlayerMP player) {
        Button back = Button.builder()
                .item(new ItemStack(PixelmonItemsHeld.ejectButton))
                .displayName(FileHandler.config.getButtonBack())
                .onClick(buttonAction -> {
                    Pages.CustomStartersMenu(player).forceOpenPage(player);})
                .build();
        return back;
    }


}
