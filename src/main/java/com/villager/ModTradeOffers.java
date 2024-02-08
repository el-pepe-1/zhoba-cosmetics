package com.villager;

import com.elpepe.Zbcosmetics;
import com.elpepe.items.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

public class ModTradeOffers {
    public static void register() {
        TradeOfferHelper.registerVillagerOffers(ModVillagers.HAT_TRADER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, random.nextBetween(10, 20)),
                            new ItemStack(ModItems.HAY_HAT, 1),
                            5, 6, 0.05f
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, random.nextBetween(20, 40)),
                            new ItemStack(ModItems.ANVIL_HAT, 1),
                            5, 6, 0.05f
                    ));

                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HAT_TRADER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, random.nextBetween(20, 64)),
                            new ItemStack(ModItems.PRESENT_HAT, 1),
                            5, 6, 0.05f
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, random.nextBetween(20, 40)),
                            new ItemStack(ModItems.COWBOY_HAT, 1),
                            5, 6, 0.05f
                    ));

                });
    }
}
