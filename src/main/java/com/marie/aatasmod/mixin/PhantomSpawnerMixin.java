package com.marie.aatasmod.mixin;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.gen.PhantomSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(PhantomSpawner.class)
public class PhantomSpawnerMixin {

    @Redirect(method = "spawn", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 0))
    public int phantomsPartOne(Random random, int i) {
        return 0;
    }

    @Redirect(method = "spawn", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F", ordinal = 0))
    public float phantomsPartTwo(Random random) {
        return 0;
    }

    @Redirect(method = "spawn", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 1))
    public int phantomsPartThree(Random random, int i) {
        return Integer.MAX_VALUE;
    }

    @Redirect(method = "spawn", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 5))
    public int phantomsPartFour(Random random, int i, ServerWorld serverWorld) {
        return serverWorld.getDifficulty().getId();
    }
}
