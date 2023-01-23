package me.foncused.explosionregeneration.data;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaterialLists {
    // auto build material lists
    public static List<Material> signs = Arrays.stream(Material.values())
            .filter(mat -> mat.name().endsWith("SIGN"))
            .collect(Collectors.toList());

    public static List<Material> banners = Arrays.stream(Material.values())
            .filter(mat -> mat.name().endsWith("BANNER"))
            .collect(Collectors.toList());

    public static List<Material> shulkerBoxes = Arrays.stream(Material.values())
            .filter(mat -> mat.name().endsWith("SHULKER_BOX"))
            .collect(Collectors.toList());

    public static List<Material> doors = Arrays.stream(Material.values())
            .filter(mat -> mat.name().endsWith("DOOR"))
            .collect(Collectors.toList());
}
