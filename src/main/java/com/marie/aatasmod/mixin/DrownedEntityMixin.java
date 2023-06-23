package com.marie.aatasmod.mixin;

import net.minecraft.entity.mob.DrownedEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(DrownedEntity.class)
public class DrownedEntityMixin {

    @Redirect(method = "initialize", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F"))
    public float guaranteeShell(Random instance) {
        return 0;
    }

    @Redirect(method = "initEquipment", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F"))
    public float firstPartTrident(Random instance) {
        return 1;
    }

    @Redirect(method = "initEquipment", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    public int secondPartTrident(Random instance, int i) {
        return 0;
    }
}
