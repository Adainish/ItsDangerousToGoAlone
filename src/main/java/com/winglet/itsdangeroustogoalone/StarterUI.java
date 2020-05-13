package com.winglet.itsdangeroustogoalone;

import ca.landonjw.gooeylibs.inventory.api.Button;
import ca.landonjw.gooeylibs.inventory.api.InventoryAPI;
import ca.landonjw.gooeylibs.inventory.api.Page;
import ca.landonjw.gooeylibs.inventory.api.Template;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.config.PixelmonItemsHeld;
import com.pixelmonmod.pixelmon.config.PixelmonItemsPokeballs;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import com.pixelmonmod.pixelmon.items.ItemPixelmonSprite;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.Arrays;

public class StarterUI {
    private static Button buildStarterPokemonButton(EnumSpecies species, EntityPlayerMP player, boolean isShiny){
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
    private static Button back(EntityPlayerMP player, boolean isShinyMenu){
        if(isShinyMenu){
            Button back = Button.builder()
                    .item(new ItemStack(PixelmonItemsHeld.ejectButton))
                    .displayName("§7Click to go back.")
                    .onClick(buttonAction -> {StarterUI.ShinyStartersMenu(player).forceOpenPage(player);})
                    .build();
            return back;
        }else{
            Button back = Button.builder()
                    .item(new ItemStack(PixelmonItemsHeld.ejectButton))
                    .displayName("§7Click to go back.")
                    .onClick(buttonAction -> {StarterUI.StartersMenu(player).forceOpenPage(player);})
                    .build();
            return back;
        }
    }
    public static Page StarterSelect(EntityPlayerMP player) {
        Button greenPane = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.LIME.getMetadata()))
                .displayName("")
                .build();

        Button bluePane = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.LIGHT_BLUE.getMetadata()))
                .displayName("")
                .build();

        Button shiny = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny §4Starter Pokemon")
                .onClick(buttonAction -> {StarterUI.ShinyStartersMenu(player).forceOpenPage(player);})
                .build();

        Button normal = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName("§4Starter Pokemon")
                .onClick(buttonAction -> {StarterUI.StartersMenu(player).forceOpenPage(player);})
                .build();

        Template template = Template.builder(5)
                .build();

        for (int i = 0; i < 5; i++) {
            for(int j = 0; j < 9; j++) {
                if ((i % 2 == 0 && j %2 == 0) || (i % 2 != 0 && j %2 != 0)){
                    template.toBuilder().set(i, j, greenPane);
                } else {
                    template.toBuilder().set(i, j, bluePane);
                }
            }
        }

        template.toBuilder()
                .set(2, 3, normal)
                .set(2, 5, shiny)
                .build();

        return Page.builder()
                .template(template)
                .title("§9Starter Selection")
                .build();
    }
    public static Page StartersMenu(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button gen1 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName("§9Generation 1 Starter Pokemon")
                .onClick(buttonAction -> {StarterUI.Gen1(player).forceOpenPage(player);})
                .build();

        Button gen2 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName("§9Generation 2 Starter Pokemon")
                .onClick(buttonAction -> {StarterUI.Gen2(player).forceOpenPage(player);})
                .build();

        Button gen3 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName("§9Generation 3 Starter Pokemon")
                .onClick(buttonAction -> {StarterUI.Gen3(player).forceOpenPage(player);})
                .build();

        Button gen4 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName("§9Generation 4 Starter Pokemon")
                .onClick(buttonAction -> {StarterUI.Gen4(player).forceOpenPage(player);})
                .build();

        Button gen5 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName("§9Generation 5 Starter Pokemon")
                .onClick(buttonAction -> {StarterUI.Gen5(player).forceOpenPage(player);})
                .build();

        Button gen6 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName("§9Generation 6 Starter Pokemon")
                .onClick(buttonAction -> {StarterUI.Gen6(player).forceOpenPage(player);})
                .build();

        Button gen7 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName("§9Generation 7 Starter Pokemon")
                .onClick(buttonAction -> {StarterUI.Gen7(player).forceOpenPage(player);})
                .build();

        Button back = Button.builder()
                .item(new ItemStack(PixelmonItemsHeld.ejectButton))
                .displayName("§7Click to go back.")
                .onClick(buttonAction -> {StarterUI.StarterSelect(player).forceOpenPage(player);})
                .build();

        Template template = Template.builder(5)
                .fill(panes)
                .set(1, 1, gen1)
                .set(1, 2, gen2)
                .set(1, 3, gen3)
                .set(1, 4, gen4)
                .set(1, 5, gen5)
                .set(1, 6, gen6)
                .set(1, 7, gen7)
                .set(3, 4, back)
                .build();

        return Page.builder()
                .template(template)
                .title("§4Starter Pokemon")
                .build();
    }
    public static Page ShinyStartersMenu(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button gen1 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny Generation 1 Starter Pokemon")
                .onClick(buttonAction -> {StarterUI.ShinyGen1(player).forceOpenPage(player);})
                .build();

        Button gen2 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny Generation 2 Starter Pokemon")
                .onClick(buttonAction -> {StarterUI.ShinyGen2(player).forceOpenPage(player);})
                .build();

        Button gen3 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny Generation 3 Starter Pokemon")
                .onClick(buttonAction -> {StarterUI.ShinyGen3(player).forceOpenPage(player);})
                .build();

        Button gen4 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny Generation 4 Starter Pokemon")
                .onClick(buttonAction -> {StarterUI.ShinyGen4(player).forceOpenPage(player);})
                .build();

        Button gen5 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny Generation 5 Starter Pokemon")
                .onClick(buttonAction -> {StarterUI.ShinyGen5(player).forceOpenPage(player);})
                .build();

        Button gen6 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny Generation 6 Starter Pokemon")
                .onClick(buttonAction -> {StarterUI.ShinyGen6(player).forceOpenPage(player);})
                .build();

        Button gen7 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny Generation 7 Starter Pokemon")
                .onClick(buttonAction -> {StarterUI.ShinyGen7(player).forceOpenPage(player);})
                .build();

        Button back = Button.builder()
                .item(new ItemStack(PixelmonItemsHeld.ejectButton))
                .displayName("§7Click to go back.")
                .onClick(buttonAction -> {StarterUI.StarterSelect(player).forceOpenPage(player);})
                .build();

        Template template = Template.builder(5)
                .fill(panes)
                .set(1, 1, gen1)
                .set(1, 2, gen2)
                .set(1, 3, gen3)
                .set(1, 4, gen4)
                .set(1, 5, gen5)
                .set(1, 6, gen6)
                .set(1, 7, gen7)
                .set(3, 4, back)
                .build();

        return Page.builder()
                .template(template)
                .title("§6Shiny Starter Pokemon")
                .build();
    }
    public static Page Gen1(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button bulbasaur = buildStarterPokemonButton(EnumSpecies.Bulbasaur, player, false);
        Button charmander = buildStarterPokemonButton(EnumSpecies.Charmander, player, false);
        Button squirtle = buildStarterPokemonButton(EnumSpecies.Squirtle, player, false);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, false))
                .set(1, 1, bulbasaur)
                .set(1, 4, charmander)
                .set(1, 7, squirtle)
                .build();

        return Page.builder()
                .template(template)
                .title("§4Gen 1 Starter Pokemon")
                .build();
    }
    public static Page Gen2(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button chikorita = buildStarterPokemonButton(EnumSpecies.Chikorita, player, false);
        Button cyndaquil = buildStarterPokemonButton(EnumSpecies.Cyndaquil, player, false);
        Button totodile = buildStarterPokemonButton(EnumSpecies.Totodile, player, false);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, false))
                .set(1, 1, chikorita)
                .set(1, 4, cyndaquil)
                .set(1, 7, totodile)
                .build();

        return Page.builder()
                .template(template)
                .title("§4Gen 2 Starter Pokemon")
                .build();
    }
    public static Page Gen3 (EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button treecko = buildStarterPokemonButton(EnumSpecies.Treecko, player, false);
        Button torchic = buildStarterPokemonButton(EnumSpecies.Torchic, player, false);
        Button mudkip = buildStarterPokemonButton(EnumSpecies.Mudkip, player, false);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, false))
                .set(1, 1, treecko)
                .set(1, 4, torchic)
                .set(1, 7, mudkip)
                .build();

        return Page.builder()
                .template(template)
                .title("§4Gen 3 Starter Pokemon")
                .build();
    }
    public static Page Gen4(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button turtwig = buildStarterPokemonButton(EnumSpecies.Turtwig, player, false);
        Button chimchar = buildStarterPokemonButton(EnumSpecies.Chimchar, player, false);
        Button piplup = buildStarterPokemonButton(EnumSpecies.Piplup, player, false);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, false))
                .set(1, 1, turtwig)
                .set(1, 4, chimchar)
                .set(1, 7, piplup)
                .build();

        return Page.builder()
                .template(template)
                .title("§4Gen 4 Starter Pokemon")
                .build();
    }
    public static Page Gen5(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button snivy = buildStarterPokemonButton(EnumSpecies.Snivy, player, false);
        Button tepig = buildStarterPokemonButton(EnumSpecies.Tepig, player, false);
        Button oshawott = buildStarterPokemonButton(EnumSpecies.Oshawott, player, false);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, false))
                .set(1, 1, snivy)
                .set(1, 4, tepig)
                .set(1, 7, oshawott)
                .build();

        return Page.builder()
                .template(template)
                .title("§4Gen 5 Starter Pokemon")
                .build();
    }
    public static Page Gen6(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button chespin = buildStarterPokemonButton(EnumSpecies.Chespin, player, false);
        Button fennekin = buildStarterPokemonButton(EnumSpecies.Fennekin, player, false);
        Button froakie = buildStarterPokemonButton(EnumSpecies.Squirtle, player, false);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, false))
                .set(1, 1, chespin)
                .set(1, 4, fennekin)
                .set(1, 7, froakie)
                .build();

        return Page.builder()
                .template(template)
                .title("§4Gen 6 Starter Pokemon")
                .build();
    }
    public static Page Gen7(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button rowlet = buildStarterPokemonButton(EnumSpecies.Rowlet, player, false);
        Button litten = buildStarterPokemonButton(EnumSpecies.Litten, player, false);
        Button popplio = buildStarterPokemonButton(EnumSpecies.Popplio, player, false);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, false))
                .set(1, 1, rowlet)
                .set(1, 4, litten)
                .set(1, 7, popplio)
                .build();

        return Page.builder()
                .template(template)
                .title("§4Gen 7 Starter Pokemon")
                .build();
    }
    public static Page ShinyGen1(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button bulbasaur = buildStarterPokemonButton(EnumSpecies.Bulbasaur, player, true);
        Button charmander = buildStarterPokemonButton(EnumSpecies.Charmander, player, true);
        Button squirtle = buildStarterPokemonButton(EnumSpecies.Squirtle, player, true);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, true))
                .set(1, 1, bulbasaur)
                .set(1, 4, charmander)
                .set(1, 7, squirtle)
                .build();

        return Page.builder()
                .template(template)
                .title("§6Shiny Gen 1 Starter Pokemon")
                .build();
    }
    public static Page ShinyGen2(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button chikorita = buildStarterPokemonButton(EnumSpecies.Bulbasaur, player, true);
        Button cyndaquil = buildStarterPokemonButton(EnumSpecies.Charmander, player, true);
        Button totodile = buildStarterPokemonButton(EnumSpecies.Squirtle, player, true);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, true))
                .set(1, 1, chikorita)
                .set(1, 4, cyndaquil)
                .set(1, 7, totodile)
                .build();

        return Page.builder()
                .template(template)
                .title("§6Shiny Gen 2 Starter Pokemon")
                .build();
    }
    public static Page ShinyGen3 (EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button treecko = buildStarterPokemonButton(EnumSpecies.Treecko, player, true);
        Button torchic = buildStarterPokemonButton(EnumSpecies.Torchic, player, true);
        Button mudkip = buildStarterPokemonButton(EnumSpecies.Mudkip, player, true);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, true))
                .set(1, 1, treecko)
                .set(1, 4, torchic)
                .set(1, 7, mudkip)
                .build();

        return Page.builder()
                .template(template)
                .title("§6Shiny Gen 3 Starter Pokemon")
                .build();
    }
    public static Page ShinyGen4(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button turtwig = buildStarterPokemonButton(EnumSpecies.Turtwig, player, true);
        Button chimchar = buildStarterPokemonButton(EnumSpecies.Chimchar, player, true);
        Button piplup = buildStarterPokemonButton(EnumSpecies.Piplup, player, true);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, true))
                .set(1, 1, turtwig)
                .set(1, 4, chimchar)
                .set(1, 7, piplup)
                .build();

        return Page.builder()
                .template(template)
                .title("§6Shiny Gen 4 Starter Pokemon")
                .build();
    }
    public static Page ShinyGen5(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button snivy = buildStarterPokemonButton(EnumSpecies.Snivy, player, true);
        Button tepig = buildStarterPokemonButton(EnumSpecies.Tepig, player, true);
        Button oshawott = buildStarterPokemonButton(EnumSpecies.Oshawott, player, true);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, true))
                .set(1, 1, snivy)
                .set(1, 4, tepig)
                .set(1, 7, oshawott)
                .build();

        return Page.builder()
                .template(template)
                .title("§6Shiny Gen 5 Starter Pokemon")
                .build();
    }
    public static Page ShinyGen6(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button chespin = buildStarterPokemonButton(EnumSpecies.Chespin, player, true);
        Button fennekin = buildStarterPokemonButton(EnumSpecies.Fennekin, player, true);
        Button froakie = buildStarterPokemonButton(EnumSpecies.Froakie, player, true);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, true))
                .set(1, 1, chespin)
                .set(1, 4, fennekin)
                .set(1, 7, froakie)
                .build();

        return Page.builder()
                .template(template)
                .title("§4Gen 6 Starter Pokemon")
                .build();
    }
    public static Page ShinyGen7(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button rowlet = buildStarterPokemonButton(EnumSpecies.Rowlet, player, true);
        Button litten = buildStarterPokemonButton(EnumSpecies.Litten, player, true);
        Button popplio = buildStarterPokemonButton(EnumSpecies.Popplio, player, true);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, true))
                .set(1, 1, rowlet)
                .set(1, 4, litten)
                .set(1, 7, popplio)
                .build();

        return Page.builder()
                .template(template)
                .title("§6Shiny Gen 7 Starter Pokemon")
                .build();
    }
}
