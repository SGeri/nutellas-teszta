package dev.sarffy;

import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin implements Listener {
    static String selectedPlayerName = "SGeriLOL";

    @Override
    public void onEnable() {
        // Register the event listeners
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("NutellasTeszta has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("NutellasTeszta has been disabled.");
    }

    @EventHandler
    public void onPlayerConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItem();

        getLogger().info(player.getName() + " " + itemStack.getType().name());

        //if (itemStack.getType().name().equals("")) {
        //    return;
        //}

        //if (player.getName().equalsIgnoreCase("patkanykiraly")) {
        //    return;
        //}

        TextComponent message = new TextComponent(player.getName() + "! Nuh-uh, ez bizony nem nutellás tészta...");
        player.sendMessage(message);

        PotionEffect poison = new PotionEffect(PotionEffectType.POISON, 200, 1);
        PotionEffect weakness = new PotionEffect(PotionEffectType.WEAKNESS, 400, 0);

        player.addPotionEffect(poison);
        player.addPotionEffect(weakness);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        TextComponent message = new TextComponent("Üdvözöllek újra ezen a világon <333");
        player.sendMessage(message);

        if (player.getName().equalsIgnoreCase(this.selectedPlayerName)) {
            ItemStack item = new ItemStack(Material.BREAD, 10);
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.displayName(Component.text("Nutellás tészta"));
            item.setItemMeta(itemMeta);
            player.getInventory().addItem(item);
        }
    }
}