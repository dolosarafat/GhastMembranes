package com.abdullaharafat.ghastmembranes;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class GhastMembranePlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("GhastMembranes Version 1.0.3 enabled.");
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntityType() == EntityType.GHAST) {
            Ghast ghast = (Ghast) event.getEntity();
            ItemStack membrane = new ItemStack(Material.PHANTOM_MEMBRANE, getRandomMembraneAmount());
            membrane.getItemMeta().setDisplayName("§b-Ghast Membrane-");
            event.getDrops().add(membrane);
        }
    }

    private int getRandomMembraneAmount() {
        // Generate a random integer between 1 and 5
        return new Random().nextInt(5) + 1;
    }

    @Override
    public void onDisable() {
        getLogger().info("GhastMembranes disabled.");
    }
}
