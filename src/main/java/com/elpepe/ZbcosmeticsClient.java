package com.elpepe;

import com.elpepe.events.PlayerClientTick;
import com.elpepe.networking.ModMessages;
import net.fabricmc.api.ClientModInitializer;

public class ZbcosmeticsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModMessages.registerS2CPackets();
        PlayerClientTick.register();
    }
}
