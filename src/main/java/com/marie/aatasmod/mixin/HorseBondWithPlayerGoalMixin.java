package com.marie.aatasmod.mixin;

import net.minecraft.entity.ai.goal.HorseBondWithPlayerGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(HorseBondWithPlayerGoal.class)
public class HorseBondWithPlayerGoalMixin {

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 0))
    public int modifySpeed(Random instance, int i) {
        return 0;
    }

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 1))
    public int modifySuccess(Random instance, int i) {
        return 0;
    }
}
