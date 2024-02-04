package com.elpepe.mixin;

import com.elpepe.Zbcosmetics;
import com.elpepe.config.ZbcosmeticsConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Mixin(ServerWorld.class)
public abstract class WorldMixin extends World implements StructureWorldAccess {
    private static final TagKey<EntityType<?>> CAN_SPAWN_WITH_HAT = TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier(Zbcosmetics.MOD_ID, "can_spawn_with_hat"));

    protected WorldMixin(MutableWorldProperties properties, RegistryKey<World> registryRef, DynamicRegistryManager registryManager, RegistryEntry<DimensionType> dimensionEntry, Supplier<Profiler> profiler, boolean isClient, boolean debugWorld, long biomeAccess, int maxChainedNeighborUpdates) {
        super(properties, registryRef, registryManager, dimensionEntry, profiler, isClient, debugWorld, biomeAccess, maxChainedNeighborUpdates);
    }

    @Inject(method = "spawnEntity", at = @At("HEAD"))
    private void spawnEntity(Entity entity, CallbackInfoReturnable<Boolean> cir) {

        Random rand = new Random();
        if(entity.getType().isIn(CAN_SPAWN_WITH_HAT) && rand.nextInt(0, 101) <= 10 && entity instanceof MobEntity mob) {
            ServerWorld serverWorld = (ServerWorld) (Object) this;

            LootTable lootTable = entity.getWorld().getServer().getLootManager().getLootTable(new Identifier(Zbcosmetics.MOD_ID, "gameplay/mob_hats"));
            LootContextParameterSet context = new LootContextParameterSet.Builder(serverWorld).add(LootContextParameters.THIS_ENTITY, entity).add(LootContextParameters.ORIGIN, entity.getPos()).build(LootContextTypes.GIFT);
            List<ItemStack> loot = lootTable.generateLoot(context);

            entity.equipStack(EquipmentSlot.HEAD, loot.get(0));

            ZbcosmeticsConfig config = Zbcosmetics.config;
            ((ArmorDropChancesAccessor) mob).getArmorDropChances()[3] = (float) config.serverModule.hatDropChance / 100;
        }
    }
}
