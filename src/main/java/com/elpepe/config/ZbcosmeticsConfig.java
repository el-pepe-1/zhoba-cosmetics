package com.elpepe.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;

@Config(name="zbcosmetics")
@Config.Gui.Background("minecraft:textures/block/spruce_planks.png")
@Config.Gui.CategoryBackground(category = "server", background = "minecraft:textures/block/cobblestone.png")
public class ZbcosmeticsConfig extends PartitioningSerializer.GlobalData {
    @ConfigEntry.Category("client")
    @ConfigEntry.Gui.TransitiveObject
    public ClientModule clientModule = new ClientModule();

    @ConfigEntry.Category("server")
    @ConfigEntry.Gui.TransitiveObject
    public ServerModule serverModule = new ServerModule();

    @Config(name = "client")
    public static class ClientModule implements ConfigData {
        public boolean builderHelmetEmitsLight = true;
    }

    @Config(name = "server")
    public static class ServerModule implements ConfigData {
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
        public int hatDropChance = 45;
    }
}
