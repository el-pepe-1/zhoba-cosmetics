package com.elpepe.items;

import com.elpepe.Zbcosmetics;
import com.elpepe.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup MAIN_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Zbcosmetics.MOD_ID, "main"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.zbcosmetics_main"))
                    .icon(() -> new ItemStack(ModItems.HAY_HAT))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModBlocks.HAT_STATION);
                        entries.add(ModItems.COWBOY_HAT);
                        entries.add(ModItems.HAY_HAT);
                        entries.add(ModItems.BOW_KNOT_ABOBA);
                        entries.add(ModItems.BOW_KNOT_SAYORI);
                        entries.add(ModItems.ZARIF_CLOTH);
                        entries.add(ModItems.OLYOSHA);
                        entries.add(ModItems.BUILDER_HELMET);
                        entries.add(ModItems.BIG_SHOT_GLASSES);
                        entries.add(ModItems.SELIASET_HORNS);
                        entries.add(ModItems.PRESENT_HAT);
                        entries.add(ModItems.CAKE_HAT);
                        entries.add(ModItems.CRAZY_DAVE);
                        entries.add(ModItems.ANVIL_HAT);
                        entries.add(ModItems.SOMBRERO);
                        entries.add(ModItems.OLEZHE_HAT);
                    })).build());

    public static void registerItemGroups() {
        Zbcosmetics.LOGGER.info("Registering mod item group for " + Zbcosmetics.MOD_ID);
    }
}
