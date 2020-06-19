package com.winglet.itsdangeroustogoalone.UIBuild;

import ca.landonjw.gooeylibs.inventory.api.Button;
import ca.landonjw.gooeylibs.inventory.api.InventoryAPI;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.config.PixelmonItemsHeld;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import com.pixelmonmod.pixelmon.items.ItemPixelmonSprite;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.Arrays;

public class Buttons {

    public static Button panes = Button.builder()
            .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
            .displayName("")
            .build();

    public static Button buildStarterPokemonButton(EnumSpecies species, EntityPlayerMP player, boolean isShiny){
        Pokemon poke = Pixelmon.pokemonFactory.create(species);
        poke.setShiny(isShiny);
        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
        Button button = Button.builder()
                .displayName("§e"+species.name)
                .item(ItemPixelmonSprite.getPhoto(poke))
                .lore(Arrays.asList("§7Are you sure you want §e"+species.name+" §7as your starter?"))
                .onClick(buttonAction ->  {
                    player.getServer().getCommandManager().executeCommand(server, "pokegive "+ buttonAction.getPlayer().getName() +" "+species.name+" level:5");
                    player.getServer().getCommandManager().executeCommand(server, "plaintell "+ buttonAction.getPlayer().getName()+ " §6§lOak §8§l>§r §7It's dangerous to go alone, take your partner with you!");
                    player.getServer().getCommandManager().executeCommand(server, "plaintell "+ buttonAction.getPlayer().getName()+ " §7You received §e"+species.name+"§7,§b "+ buttonAction.getPlayer().getName()+"§7!");
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
                .lore(Arrays.asList("§7Are you sure you want §e"+species.name+" §7as your starter?"))
                .onClick(buttonAction ->  {
                    player.getServer().getCommandManager().executeCommand(server, "pokegive "+ buttonAction.getPlayer().getName() +" "+species.name+" level:5 s");
                    player.getServer().getCommandManager().executeCommand(server, "plaintell "+ buttonAction.getPlayer().getName()+ " §6§lOak §8§l>§r §7It's dangerous to go alone, take your partner with you!");
                    player.getServer().getCommandManager().executeCommand(server, "plaintell "+ buttonAction.getPlayer().getName()+ " §7You received §e"+species.name+"§7,§b "+ buttonAction.getPlayer().getName()+"§7!");
                    player.getServer().getCommandManager().executeCommand(server, "lp user "+ buttonAction.getPlayer().getName()+ " permission set itsdangeroustogoalone.command.starters false");
                    InventoryAPI.getInstance().closePlayerInventory(player);
                })
                .build();
        return button;
    }

    public static Button back(EntityPlayerMP player, boolean isShinyMenu){
        if(isShinyMenu){
            Button back = Button.builder()
                    .item(new ItemStack(PixelmonItemsHeld.ejectButton))
                    .displayName("§7Click to go back.")
                    .onClick(buttonAction -> {
                        Pages.ShinyStartersMenu(player).forceOpenPage(player);})
                    .build();
            return back;
        }else{
            Button back = Button.builder()
                    .item(new ItemStack(PixelmonItemsHeld.ejectButton))
                    .displayName("§7Click to go back.")
                    .onClick(buttonAction -> {Pages.StartersMenu(player).forceOpenPage(player);})
                    .build();
            return back;
        }
    }

}
