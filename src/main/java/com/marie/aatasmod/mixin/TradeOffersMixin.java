package com.marie.aatasmod.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.TradeOffers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TradeOffers.SellPotionHoldingItemFactory.class)
public class TradeOffersMixin {

    @Redirect(method = "create", at = @At(value = "INVOKE", target = "Lnet/minecraft/potion/PotionUtil;setPotion(Lnet/minecraft/item/ItemStack;Lnet/minecraft/potion/Potion;)Lnet/minecraft/item/ItemStack;"))
    private ItemStack slowFalling(ItemStack stack, Potion potion) {
        Identifier identifier = Registry.POTION.getId(Potions.SLOW_FALLING);
        stack.getOrCreateTag().putString("Potion", identifier.toString());
        return stack;
    }
}
