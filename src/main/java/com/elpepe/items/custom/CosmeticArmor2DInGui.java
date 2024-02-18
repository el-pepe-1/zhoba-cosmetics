package com.elpepe.items.custom;

import com.elpepe.Zbcosmetics;
import com.elpepe.items.CosmeticArmor;
import com.elpepe.items.Item2DInGui;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;

public class CosmeticArmor2DInGui extends CosmeticArmor implements Item2DInGui {
    private final String modelName;

    public CosmeticArmor2DInGui(String modelName, Settings settings, EquipmentSlot slotType) {
        super(settings, slotType);
        this.modelName = modelName;
    }

    @Override
    public Identifier getModelPath() {
        return new Identifier(Zbcosmetics.MOD_ID, this.modelName + "_3d");
    }
}
