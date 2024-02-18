package com.elpepe.mixin;

import com.elpepe.Zbcosmetics;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(ModelLoader.class)
public abstract class ModelLoaderMixin {
    @Shadow
    protected abstract void addModel(ModelIdentifier modelId);

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 3, shift = At.Shift.AFTER))
    public void addCosmeticArmor(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStates, CallbackInfo ci) {
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "cowboy_hat_3d", "inventory"));
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "hay_hat_3d", "inventory"));
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "bow_knot_aboba", "inventory"));
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "bow_knot_sayori", "inventory"));
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "zarif_cloth", "inventory"));
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "olyosha", "inventory"));
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "builder_helmet", "inventory"));
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "big_shot_glasses", "inventory"));
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "seliaset_horns", "inventory"));
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "present_hat", "inventory"));
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "cake_hat", "inventory"));
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "crazy_dave", "inventory"));
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "anvil_hat", "inventory"));
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "sombrero", "inventory"));
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "bandanna", "inventory"));
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "glasses", "inventory"));
        this.addModel(new ModelIdentifier(Zbcosmetics.MOD_ID, "radio_monocle", "inventory"));
    }
}
