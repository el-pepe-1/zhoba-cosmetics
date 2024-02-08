package com.villager;

import com.elpepe.Zbcosmetics;
import com.elpepe.blocks.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> HAT_POI_KEY = poiKey("hatpoi");
    public static final PointOfInterestType HAT_POI = registerPoi("hatpoi", ModBlocks.HAT_STATION);

    public static final VillagerProfession HAT_TRADER = registerProfession("hat_trader", HAT_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(Zbcosmetics.MOD_ID, name), new VillagerProfession(name ,entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_LEATHERWORKER));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(Zbcosmetics.MOD_ID, name), 1, 1, block);
    }

    public static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(Zbcosmetics.MOD_ID, name));
    }

    public static void register() {
        Zbcosmetics.LOGGER.info("Registering mod villager for " + Zbcosmetics.MOD_ID);
    }
}
