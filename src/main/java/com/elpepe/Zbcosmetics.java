package com.elpepe;

import com.elpepe.blocks.ModBlocks;
import com.elpepe.config.IdentifierTypeAdapter;
import com.elpepe.config.ZbcosmeticsConfig;
import com.elpepe.items.ModItemGroups;
import com.elpepe.items.ModItems;
import com.elpepe.networking.ModMessages;
import com.google.gson.GsonBuilder;
import com.elpepe.villager.ModTradeOffers;
import com.elpepe.villager.ModVillagers;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Zbcosmetics implements ModInitializer {

	public static final String MOD_ID = "zbcosmetics";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static ZbcosmeticsConfig config;

	@Override
	public void onInitialize() {
		initConfig();

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();

		ModBlocks.register();

		ModVillagers.register();
		ModTradeOffers.register();

		ModMessages.registerC2SPackets();
	}

	private void initConfig() {
		ConfigHolder<ZbcosmeticsConfig> holder = AutoConfig.register(ZbcosmeticsConfig.class, (definition, configClass) -> {
			return new GsonConfigSerializer<>(definition, configClass, new GsonBuilder()
					.setPrettyPrinting()
					.disableHtmlEscaping()
					.registerTypeAdapter(Identifier.class, IdentifierTypeAdapter.INST)
					.create());
		});

		config = holder.getConfig();
	}
}