package me.lotiny.misty.nms.v1_21_4;

import me.lotiny.misty.nms.v1_21.v1_21;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.MenuType;

@SuppressWarnings("UnstableApiUsage")
public class v1_21_4 extends v1_21 {

    @Override
    public InventoryView openWorkbench(Player player) {
        return MenuType.CRAFTING.create(player, "Crafting");
    }
}
