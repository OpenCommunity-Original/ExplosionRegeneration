package me.foncused.explosionregeneration.core;

import net.kyori.adventure.text.Component;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ExplosionCache {

    private final Material material;
    private Location location;
    private final BlockData data;
    private final String[] sign;
    private final BlockState state;
    private ItemStack[] inventory;
    private DyeColor color;
    private List<Pattern> patterns;

    public ExplosionCache(final Material material, final Location location, final BlockData data, final BlockState state) {
        this(material, location, data, state, null, null, null, null);
    }

    private ExplosionCache(
            final Material material,
            final Location location,
            final BlockData data,
            final BlockState state,
            final String[] sign,
            final ItemStack[] inventory,
            final DyeColor color,
            final List<Pattern> patterns
    ) {
        this.material = material;
        this.location = location;
        this.data = data;
        this.state = state;
        this.sign = sign;
        this.inventory = inventory;
        this.color = color;
        this.patterns = patterns;
    }

    public Material getMaterial() {
        return this.material;
    }

    public Location getLocation() {
        return this.location;
    }

    public BlockData getBlockData() {
        return this.data;
    }

    public BlockState getBlockState() {
        return this.state;
    }

    public ItemStack[] getInventory() {
        return this.inventory;
    }

    public void setInventory(final ItemStack[] inventory) {
        this.inventory = inventory;
    }

    public DyeColor getDyeColor() {
        return this.color;
    }

    public void setDyeColor(final DyeColor color) {
        this.color = color;
    }

    public List<Pattern> getPatterns() {
        return this.patterns;
    }

    public void setPatterns(final List<Pattern> patterns) {
        this.patterns = patterns;
    }

    private List<Component> signLines;

    public void setSignLines(List<Component> lines) {
        this.signLines = lines;
    }

    public List<Component> getSignLines() {
        return this.signLines;
    }

    private BlockData upperDoorBlockData;
    private Location upperDoorBlockLocation;

    public void setUpperDoorBlockData(BlockData upperDoorBlockData) {
        this.upperDoorBlockData = upperDoorBlockData;
    }

    public BlockData getUpperDoorBlockData() {
        return this.upperDoorBlockData;
    }

    public void setUpperDoorBlockLocation(Location upperDoorBlockLocation) {
        this.upperDoorBlockLocation = upperDoorBlockLocation;
    }

    public Location getUpperDoorBlockLocation() {
        return this.upperDoorBlockLocation;
    }

    public void setLocation(Location location) {
        if (location != null)
            this.location = location;
    }

    private BlockData blockData;

    public void setBlockData(BlockData blockData) {
        if (blockData != null)
            this.blockData = blockData;
    }

}
