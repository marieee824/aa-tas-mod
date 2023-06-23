package com.marie.aatasmod.mixin;

import net.minecraft.entity.mob.ZombieVillagerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(ZombieVillagerEntity.class)
public class ZombieVillagerEntityMixin {

    @Redirect(method = "interactMob", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    public int minDelay(Random random, int i) {
        return 0;
    }

    @Redirect(method = "getConversionRate", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F", ordinal = 0))
    public float onePercent(Random random) {
        return 0;
    }

    @Redirect(method = "getConversionRate", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F", ordinal = 1))
    public float thirtyPercent(Random random) {
        return 0;
    }
}
