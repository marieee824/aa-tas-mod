package com.marie.aatasmod.mixin;

import net.minecraft.entity.passive.CatEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(CatEntity.class)
public class CatEntityMixin {

    @Redirect(method = "interactMob", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 0))
    public int optimizeTame(Random instance, int i) {
        return 0;
    }
}
