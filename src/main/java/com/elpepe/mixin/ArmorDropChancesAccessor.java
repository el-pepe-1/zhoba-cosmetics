package com.elpepe.mixin;

import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MobEntity.class)
public interface ArmorDropChancesAccessor {
    @Accessor("armorDropChances")
    public float[] getArmorDropChances();
}
