package com.elpepe.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class ConfigGeneral {
    @ConfigEntry.Gui.Tooltip(count = 2)
    public double test = .1;

    @ConfigEntry.Gui.Tooltip(count = 2)
    public double test1 = .3;
}
