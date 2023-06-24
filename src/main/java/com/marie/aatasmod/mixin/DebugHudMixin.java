package com.marie.aatasmod.mixin;

import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(DebugHud.class)
public class DebugHudMixin {
    @Inject(method = "getRightText", at = @At("RETURN"), cancellable = true)
    public void addDebugText(CallbackInfoReturnable<List<String>> cir) {
        List<String> strings = cir.getReturnValue();
        strings.add("Cheat mod yeah");
        cir.setReturnValue(strings);
    }
}
