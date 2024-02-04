package com.elpepe.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class ConfigZbcosmeticsMain {
    @ConfigEntry.Category("General Settings")
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip
    public ConfigGeneral general = new ConfigGeneral();
}
