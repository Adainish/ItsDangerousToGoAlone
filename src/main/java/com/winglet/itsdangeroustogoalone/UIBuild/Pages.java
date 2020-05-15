package com.winglet.itsdangeroustogoalone.UIBuild;

import ca.landonjw.gooeylibs.inventory.api.Button;
import ca.landonjw.gooeylibs.inventory.api.Page;
import ca.landonjw.gooeylibs.inventory.api.Template;
import com.pixelmonmod.pixelmon.config.PixelmonItemsHeld;
import com.pixelmonmod.pixelmon.config.PixelmonItemsPokeballs;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;

import static com.winglet.itsdangeroustogoalone.UIBuild.Buttons.*;

public class Pages {
    public static Page Gen(EntityPlayerMP player, EnumSpecies firstStarter) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button first = buildStarterPokemonButton(firstStarter, player, false);
        Button second = buildStarterPokemonButton(EnumSpecies.getFromDex(firstStarter.getNationalPokedexInteger() + 3), player, false);
        Button third = buildStarterPokemonButton(EnumSpecies.getFromDex(firstStarter.getNationalPokedexInteger() + 6), player, false);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, false))
                .set(1, 1, first)
                .set(1, 4, second)
                .set(1, 7, third)
                .build();

        return Page.builder()
                .template(template)
                .title("§4Gen " + firstStarter.getGeneration() + " Starter Pokemon")
                .build();
    }
    public static Page ShinyGen(EntityPlayerMP player, EnumSpecies firstStarter) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button first = buildShinyStarterPokemonButton(firstStarter, player, true);
        Button second = buildShinyStarterPokemonButton(EnumSpecies.getFromDex(firstStarter.getNationalPokedexInteger() + 3), player, true);
        Button third = buildShinyStarterPokemonButton(EnumSpecies.getFromDex(firstStarter.getNationalPokedexInteger() + 6), player, true);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, true))
                .set(1, 1, first)
                .set(1, 4, second)
                .set(1, 7, third)
                .build();

        return Page.builder()
                .template(template)
                .title("§4Gen " + firstStarter.getGeneration() + "§6Shiny Starter Pokemon")
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
                .onClick(buttonAction -> {
                    Pages.ShinyGen(player, EnumSpecies.Bulbasaur).forceOpenPage(player);})
                .build();

        Button gen2 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny Generation 2 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.ShinyGen(player, EnumSpecies.Chikorita).forceOpenPage(player);})
                .build();

        Button gen3 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny Generation 3 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.ShinyGen(player, EnumSpecies.Treecko).forceOpenPage(player);})
                .build();

        Button gen4 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny Generation 4 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.ShinyGen(player, EnumSpecies.Turtwig).forceOpenPage(player);})
                .build();

        Button gen5 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny Generation 5 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.ShinyGen(player, EnumSpecies.Snivy).forceOpenPage(player);})
                .build();

        Button gen6 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny Generation 6 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.ShinyGen(player, EnumSpecies.Chespin).forceOpenPage(player);})
                .build();

        Button gen7 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny Generation 7 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.ShinyGen(player, EnumSpecies.Rowlet).forceOpenPage(player);})
                .build();

        Button back = Button.builder()
                .item(new ItemStack(PixelmonItemsHeld.ejectButton))
                .displayName("§7Click to go back.")
                .onClick(buttonAction -> {Pages.StarterSelect(player).forceOpenPage(player);})
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
                .onClick(buttonAction -> {Pages.ShinyStartersMenu(player).forceOpenPage(player);})
                .build();

        Button normal = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName("§4Starter Pokemon")
                .onClick(buttonAction -> {Pages.StartersMenu(player).forceOpenPage(player);})
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
                .onClick(buttonAction -> {
                    Pages.Gen(player, EnumSpecies.Bulbasaur).forceOpenPage(player);})
                .build();

        Button gen2 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName("§9Generation 2 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.Gen(player, EnumSpecies.Chikorita).forceOpenPage(player);})
                .build();

        Button gen3 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName("§9Generation 3 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.Gen(player, EnumSpecies.Treecko).forceOpenPage(player);})
                .build();

        Button gen4 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName("§9Generation 4 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.Gen(player, EnumSpecies.Turtwig).forceOpenPage(player);})
                .build();

        Button gen5 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName("§9Generation 5 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.Gen(player, EnumSpecies.Snivy).forceOpenPage(player);})
                .build();

        Button gen6 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName("§9Generation 6 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.Gen(player, EnumSpecies.Chespin).forceOpenPage(player);})
                .build();

        Button gen7 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName("§9Generation 7 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.Gen(player, EnumSpecies.Rowlet).forceOpenPage(player);})
                .build();

        Button back = Button.builder()
                .item(new ItemStack(PixelmonItemsHeld.ejectButton))
                .displayName("§7Click to go back.")
                .onClick(buttonAction -> {
                    Pages.StarterSelect(player).forceOpenPage(player);})
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
}
