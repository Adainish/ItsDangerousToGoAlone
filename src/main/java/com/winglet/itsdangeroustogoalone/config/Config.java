package com.winglet.itsdangeroustogoalone.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Config {
    private String PluginPrefix = "§aIDTGA §7§l>>§r";
    private String Prefix = "§eOAK >> ";
    private String SpeciesNameColour = "§e";
    private String LoreSpeciesFront = "§7Take§e ";
    private String LoreSpeciesBack = " §7on your Journey!";
    private String MessageProfessor = "§7It's Dangerous to go Alone, take your new Partner!";
    private String MessageProfessor2Front = "§7You received §e";
    private String MessageProfessor2Back = "§7as your Starter Pokemon!";
    private String ButtonBack = "§7Click to go back.";
    private String SpecsShiny = "lvl:5 untradeable";
    private String SpecsNormal = "lvl:5 untradeable";
    private String SpecsCustom = "lvl:5 untradeable";
    private String MenuHeaderNormal = "§9Select your Starter Pokemon!";
    private String MenuHeaderShiny = "§6Select your Shiny Starter Pokemon!";
    private String GenerationText = "§4Gen ";
    private String StarterNormal = "§4Starter Pokemon";
    private String StarterShiny = "§6Shiny Starter §4Pokemon";
    private String HeaderShinyStarter = "§4Shiny Starter Pokemon";
    private String HeaderStarter = "§4Starter Pokemon";
    private String HeaderShinyGen = "§4Shiny Starter Pokemon";
    private String HeaderNormalGen = "§4Starter Pokemon";
    private String HeaderCustomGen = "§4Custom Starter Pokemon";
    private int NormalSlot = 3;
    private int CustomSlot = 4;
    private int ShinySlot = 5;

    private String Comment = "If you are NOT using a type of starter (for example ShinySlot) you can fill in a slot that doesn't exist, " +
            "like 64 or 65 and it won't be on the menu!";
    public Config() {
    }

}
