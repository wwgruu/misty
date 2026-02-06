package me.lotiny.misty.paper;

import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Consumable;
import io.papermc.paper.datacomponent.item.consumable.ConsumeEffect;
import io.papermc.paper.datacomponent.item.consumable.ItemUseAnimation;
import lombok.experimental.UtilityClass;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.components.FoodComponent;
import org.bukkit.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@UtilityClass
public final class MistyPaper {

    @SuppressWarnings("UnstableApiUsage")
    public void applyConsumable(@NotNull ItemStack item, float time, List<PotionEffect> effects) {
        item.editMeta(meta -> {
            if (!meta.hasFood()) {
                FoodComponent food = meta.getFood();
                food.setCanAlwaysEat(true);
                food.setNutrition(4);
                food.setSaturation(9.6F);
                meta.setFood(food);
            }
        });

        Consumable consumable = Consumable.consumable()
                .consumeSeconds(time)
                .animation(ItemUseAnimation.EAT)
                .hasConsumeParticles(true)
                .addEffect(ConsumeEffect.applyStatusEffects(effects, 1))
                .build();

        item.setData(DataComponentTypes.CONSUMABLE, consumable);
    }
}
