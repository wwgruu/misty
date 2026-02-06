package me.lotiny.misty.nms.v1_12_2;

import com.cryptomorin.xseries.XAttribute;
import com.cryptomorin.xseries.XPotion;
import io.fairyproject.util.ConditionUtils;
import me.lotiny.misty.nms.v1_8_8.v1_8_8;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;

public class v1_12_2 extends v1_8_8 {

    @Override
    public boolean isItem(Material material) {
        return material.isItem();
    }

    @Override
    public XPotion getPotionEffect(ItemStack item) {
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        if (meta == null) return null;

        PotionType type = meta.getBasePotionData().getType();
        return type != null ? XPotion.of(type) : null;
    }

    @Override
    public int getPotionEffectLevel(ItemStack item) {
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        if (meta == null) return 1;

        if (meta.hasCustomEffects() && !meta.getCustomEffects().isEmpty()) {
            PotionEffect first = meta.getCustomEffects().getFirst();
            return first.getAmplifier() + 1;
        }

        return 1;
    }

    @Override
    public ItemStack getItemInHand(Player player) {
        return player.getInventory().getItemInMainHand();
    }

    @Override
    public void setItemInHand(Player player, ItemStack item) {
        player.getInventory().setItemInMainHand(item);
    }

    @Override
    public ItemStack getItemInOffHand(Player player) {
        return player.getInventory().getItemInOffHand();
    }

    @Override
    public void setItemInOffHand(Player player, ItemStack item) {
        player.getInventory().setItemInOffHand(item);
    }

    @Override
    public double getMaxHealth(Player player) {
        Attribute attribute = XAttribute.MAX_HEALTH.get();
        ConditionUtils.notNull(attribute, "Cannot get Attribute MAX_HEALTH from player");

        AttributeInstance instance = player.getAttribute(attribute);
        ConditionUtils.notNull(instance, "Cannot get AttributeInstance MAX_HEALTH from player");
        return instance.getValue();
    }

    @Override
    public void setMaxHealth(Player player, double health) {
        Attribute attribute = XAttribute.MAX_HEALTH.get();
        ConditionUtils.notNull(attribute, "Cannot get Attribute MAX_HEALTH from player");

        AttributeInstance instance = player.getAttribute(attribute);
        ConditionUtils.notNull(instance, "Cannot get AttributeInstance MAX_HEALTH from player");
        instance.setBaseValue(health);
    }
}
