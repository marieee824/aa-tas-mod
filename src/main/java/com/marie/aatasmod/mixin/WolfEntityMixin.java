package com.marie.aatasmod.mixin;

import net.minecraft.entity.passive.WolfEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(WolfEntity.class)
public class WolfEntityMixin {

    @Redirect(method = "interactMob", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 0))
    public int optimizeTame(Random random, int i) {
        return 0;
    }
}
