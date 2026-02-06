package me.lotiny.misty.nms.v1_21;

import com.cryptomorin.xseries.XPotion;
import me.lotiny.misty.nms.v1_16_5.v1_16_5;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.RenderType;
import org.bukkit.scoreboard.Scoreboard;

public class v1_21 extends v1_16_5 {

    @Override
    public XPotion getPotionEffect(ItemStack item) {
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        if (meta == null) return null;

        PotionType type = meta.getBasePotionType();
        return type != null ? XPotion.of(type) : null;
    }

    @Override
    public Objective registerHealthObjective(Scoreboard scoreboard) {
        return scoreboard.registerNewObjective("showHealth", Criteria.HEALTH, "Health", RenderType.HEARTS);
    }
}
