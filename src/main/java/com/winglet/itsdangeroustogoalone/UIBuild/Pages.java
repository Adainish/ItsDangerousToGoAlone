package com.winglet.itsdangeroustogoalone.UIBuild;

import ca.landonjw.gooeylibs.inventory.api.Button;
import ca.landonjw.gooeylibs.inventory.api.Page;
import ca.landonjw.gooeylibs.inventory.api.Template;
import com.pixelmonmod.pixelmon.config.PixelmonItemsHeld;
import com.pixelmonmod.pixelmon.config.PixelmonItemsPokeballs;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import com.winglet.itsdangeroustogoalone.config.FileHandler;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import scala.reflect.io.File;

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
                .set(3, 4, back(player, false, false))
                .set(1, 1, first)
                .set(1, 4, second)
                .set(1, 7, third)
                .build();

        return Page.builder()
                .template(template)
                .title(FileHandler.config.getHeaderNormalGen() + firstStarter.getGeneration())
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
                .set(3, 4, back(player, true, false))
                .set(1, 1, first)
                .set(1, 4, second)
                .set(1, 7, third)
                .build();

        return Page.builder()
                .template(template)
                .title(FileHandler.config.getHeaderShinyGen() + firstStarter.getGeneration())
                .build();
    }
    public static Page ShinyStartersMenu(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button gen1 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny " + FileHandler.config.getGenerationText() + "1")
                .onClick(buttonAction -> {
                    Pages.ShinyGen(player, EnumSpecies.Bulbasaur).forceOpenPage(player);})
                .build();

        Button gen2 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny " + FileHandler.config.getGenerationText() + "2")
                .onClick(buttonAction -> {
                    Pages.ShinyGen(player, EnumSpecies.Chikorita).forceOpenPage(player);})
                .build();

        Button gen3 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny " + FileHandler.config.getGenerationText() + "3")
                .onClick(buttonAction -> {
                    Pages.ShinyGen(player, EnumSpecies.Treecko).forceOpenPage(player);})
                .build();

        Button gen4 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny " + FileHandler.config.getGenerationText() + "4")
                .onClick(buttonAction -> {
                    Pages.ShinyGen(player, EnumSpecies.Turtwig).forceOpenPage(player);})
                .build();

        Button gen5 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny " + FileHandler.config.getGenerationText() + "5")
                .onClick(buttonAction -> {
                    Pages.ShinyGen(player, EnumSpecies.Snivy).forceOpenPage(player);})
                .build();

        Button gen6 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny " + FileHandler.config.getGenerationText() + "6")
                .onClick(buttonAction -> {
                    Pages.ShinyGen(player, EnumSpecies.Chespin).forceOpenPage(player);})
                .build();

        Button gen7 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny " + FileHandler.config.getGenerationText() + "7")
                .onClick(buttonAction -> {
                    Pages.ShinyGen(player, EnumSpecies.Rowlet).forceOpenPage(player);})
                .build();

        Button gen8 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName("§6Shiny " + FileHandler.config.getGenerationText() + "8")
                .onClick(buttonAction -> {
                    Pages.ShinyGen(player, EnumSpecies.Grookey).forceOpenPage(player);})
                .build();

        Button back = Button.builder()
                .item(new ItemStack(PixelmonItemsHeld.ejectButton))
                .displayName(FileHandler.config.getButtonBack())
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
                .set(2, 4, gen8)
                .set(3, 4, back)
                .build();

        return Page.builder()
                .template(template)
                .title(FileHandler.config.getMenuHeaderShiny())
                .build();
    }
    public static Page StarterSelect(EntityPlayerMP player) {
        Button redPane = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.RED.getMetadata()))
                .displayName("")
                .build();

        Button orangePane = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.ORANGE.getMetadata()))
                .displayName("")
                .build();

        Button shiny = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .displayName(FileHandler.config.getStarterShiny())
                .onClick(buttonAction -> {Pages.ShinyStartersMenu(player).forceOpenPage(player);})
                .build();

        Button normal = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName(FileHandler.config.getStarterNormal())
                .onClick(buttonAction -> {Pages.StartersMenu(player).forceOpenPage(player);})
                .build();

        Button custom = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.beastBall))
                .displayName(FileHandler.config.getHeaderCustomGen())
                .onClick(buttonAction -> {Pages.CustomStartersMenu(player).forceOpenPage(player);})
                .build();

        Template template = Template.builder(5)
                .build();

        for (int i = 0; i < 5; i++) {
            for(int j = 0; j < 9; j++) {
                if ((i % 2 == 0 && j %2 == 0) || (i % 2 != 0 && j %2 != 0)){
                    template.toBuilder().set(i, j, redPane);
                } else {
                    template.toBuilder().set(i, j, orangePane);
                }
            }
        }

        template.toBuilder()
                .set(2, FileHandler.config.getNormalSlot(), normal)
                .set(2, FileHandler.config.getShinySlot(), shiny)
                .set(2, FileHandler.config.getCustomSlot(), custom)
                .build();

        return Page.builder()
                .template(template)
                .title(FileHandler.config.getMenuHeaderNormal())
                .build();
    }

    public static Page StartersMenu(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button gen1 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName(FileHandler.config.getGenerationText() + "1")
                .onClick(buttonAction -> {
                    Pages.Gen(player, EnumSpecies.Bulbasaur).forceOpenPage(player);})
                .build();

        Button gen2 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName(FileHandler.config.getGenerationText() + "2")
                .onClick(buttonAction -> {
                    Pages.Gen(player, EnumSpecies.Chikorita).forceOpenPage(player);})
                .build();

        Button gen3 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName(FileHandler.config.getGenerationText() + "3")
                .onClick(buttonAction -> {
                    Pages.Gen(player, EnumSpecies.Treecko).forceOpenPage(player);})
                .build();

        Button gen4 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName(FileHandler.config.getGenerationText() + "4")
                .onClick(buttonAction -> {
                    Pages.Gen(player, EnumSpecies.Turtwig).forceOpenPage(player);})
                .build();

        Button gen5 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName(FileHandler.config.getGenerationText() + "5")
                .onClick(buttonAction -> {
                    Pages.Gen(player, EnumSpecies.Snivy).forceOpenPage(player);})
                .build();

        Button gen6 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName(FileHandler.config.getGenerationText() + "6")
                .onClick(buttonAction -> {
                    Pages.Gen(player, EnumSpecies.Chespin).forceOpenPage(player);})
                .build();

        Button gen7 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName(FileHandler.config.getGenerationText() + "7")
                .onClick(buttonAction -> {
                    Pages.Gen(player, EnumSpecies.Rowlet).forceOpenPage(player);})
                .build();

        Button gen8 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.pokeBall))
                .displayName(FileHandler.config.getGenerationText() + "8")
                .onClick(buttonAction -> {
                    Pages.Gen(player, EnumSpecies.Grookey).forceOpenPage(player);})
                .build();

        Button back = Button.builder()
                .item(new ItemStack(PixelmonItemsHeld.ejectButton))
                .displayName(FileHandler.config.getButtonBack())
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
                .set(2, 4, gen8)
                .set(3, 4, back)
                .build();

        return Page.builder()
                .template(template)
                .title(FileHandler.config.getStarterNormal())
                .build();
    }

    public static Page CustomGen(EntityPlayerMP player, EnumSpecies firstStarter) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button premierball = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.premierBall))
                .build();
        Button first = buildCustomSkinStarterPokemonButton(firstStarter, player, true);
        Button second = buildCustomSkinStarterPokemonButton(EnumSpecies.getFromDex(firstStarter.getNationalPokedexInteger() + 3), player, true);
        Button third = buildCustomSkinStarterPokemonButton(EnumSpecies.getFromDex(firstStarter.getNationalPokedexInteger() + 6), player, true);

        Template template = Template.builder(5)
                .fill(panes)
                .set(3, 4, back(player, false, true))
                .set(1, 1, first)
                .set(1, 4, second)
                .set(1, 7, third)
                .build();

        return Page.builder()
                .template(template)
                .title("§4Gen " + firstStarter.getGeneration() + " §6Custom Starter Pokemon")
                .build();
    }
    public static Page CustomStartersMenu(EntityPlayerMP player) {
        Button panes = Button.builder()
                .item(new ItemStack(Blocks.STAINED_GLASS_PANE, 1, EnumDyeColor.GRAY.getMetadata()))
                .displayName("")
                .build();

        Button gen1 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.beastBall))
                .displayName("§9Generation 1 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.CustomGen(player, EnumSpecies.Bulbasaur).forceOpenPage(player);})
                .build();

        Button gen2 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.beastBall))
                .displayName("§9Generation 2 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.CustomGen(player, EnumSpecies.Chikorita).forceOpenPage(player);})
                .build();

        Button gen3 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.beastBall))
                .displayName("§9Generation 3 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.CustomGen(player, EnumSpecies.Treecko).forceOpenPage(player);})
                .build();

        Button gen4 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.beastBall))
                .displayName("§9Generation 4 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.CustomGen(player, EnumSpecies.Turtwig).forceOpenPage(player);})
                .build();

        Button gen5 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.beastBall))
                .displayName("§9Generation 5 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.CustomGen(player, EnumSpecies.Snivy).forceOpenPage(player);})
                .build();

        Button gen6 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.beastBall))
                .displayName("§9Generation 6 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.CustomGen(player, EnumSpecies.Chespin).forceOpenPage(player);})
                .build();

        Button gen7 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.beastBall))
                .displayName("§9Generation 7 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.CustomGen(player, EnumSpecies.Rowlet).forceOpenPage(player);})
                .build();

        Button gen8 = Button.builder()
                .item(new ItemStack(PixelmonItemsPokeballs.beastBall))
                .displayName("§9Generation 8 Starter Pokemon")
                .onClick(buttonAction -> {
                    Pages.CustomGen(player, EnumSpecies.Grookey).forceOpenPage(player);})
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
                .set(2, 4, gen8)
                .set(3, 4, back)
                .build();

        return Page.builder()
                .template(template)
                .title("§4 "+ FileHandler.config.getHeaderCustomGen())
                .build();
    }


}
