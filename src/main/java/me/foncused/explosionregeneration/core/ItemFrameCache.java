package me.foncused.explosionregeneration.core;

import org.bukkit.Rotation;
import org.bukkit.inventory.ItemStack;

public class ItemFrameCache {
    private final ItemStack stack;
    private final Rotation rotation;

    public ItemFrameCache(
            final ItemStack stack,
            final Rotation rotation
    ) {
        this.stack = stack;
        this.rotation = rotation;
    }

    public ItemStack getItem() {
        return this.stack;
    }

    public Rotation getRotation() {
        return this.rotation;
    }

}
