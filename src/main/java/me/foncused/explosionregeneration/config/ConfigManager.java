package me.foncused.explosionregeneration.config;

import me.foncused.explosionregeneration.util.ExplosionRenerationUtil;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConfigManager {

    private final boolean random;
    private int speed;
    private final int delay;
    private Particle particle;
    private Sound sound;
    private final boolean tntChainingEnabled;
	private final boolean fallingBlocks;
    private Set<Material> filter;
    private Set<String> blacklist;
    private final boolean entityProtection;
    private final boolean dropsEnabled;
    private final double dropsRadius;
    private Set<Material> dropsBlacklist;

    public ConfigManager(
            final boolean random,
            final int speed,
            final int delay,
            String particle,
            String sound,
            final boolean tntChainingEnabled,
            final int tntChainingMaxFuseTicks,
            final boolean fallingBlocks,
            final List<String> filter,
            final List<String> blacklist,
            final boolean entityProtection,
            final boolean dropsEnabled,
            final double dropsRadius,
            final List<String> dropsBlacklist
    ) {
        this.random = random;
        if (speed <= 0) {
            this.speed = 10;
            ExplosionRenerationUtil.consoleWarning("Set speed to " + speed + " ticks is not safe, reverting to default...");
        } else {
            this.speed = speed;
        }
        if (delay < 0) {
            this.delay = 0;
            ExplosionRenerationUtil.consoleWarning("Set delay to " + delay + " ticks is not safe, reverting to default...");
        } else {
            this.delay = delay;
        }
        try {
            if (particle.equals("")) {
                particle = null;
            } else {
                this.particle = Particle.valueOf(particle.toUpperCase());
            }
        } catch (final IllegalArgumentException e) {
            this.particle = Particle.VILLAGER_HAPPY;
            ExplosionRenerationUtil.consoleWarning("Set particle to " + particle + " is not safe, reverting to default...");
        }
        try {
            if (sound.isEmpty()) {
                sound = null;
            } else {
                this.sound = Sound.valueOf(sound.toUpperCase());
            }
        } catch (final IllegalArgumentException e) {
            this.sound = Sound.ENTITY_CHICKEN_EGG;
            ExplosionRenerationUtil.consoleWarning("Set sound to " + sound + " is not safe, reverting to default...");
        }
        this.tntChainingEnabled = tntChainingEnabled;
        if (this.tntChainingEnabled) {
			int tntChainingMaxFuseTicks1;
			if (tntChainingMaxFuseTicks <= 0 || tntChainingMaxFuseTicks > 200) {
                tntChainingMaxFuseTicks1 = 20;
                ExplosionRenerationUtil.consoleWarning("Set chaining max fuse ticks to " + tntChainingMaxFuseTicks + " ticks is not safe, reverting to default...");
            } else {
                tntChainingMaxFuseTicks1 = tntChainingMaxFuseTicks;
            }
        }
        this.fallingBlocks = fallingBlocks;
        this.filter = new HashSet<>();
        filter.forEach(material -> {
            Material m;
            try {
                m = Material.valueOf(material.toUpperCase());
            } catch (final IllegalArgumentException e) {
                ExplosionRenerationUtil.consoleWarning("Material " + material + " is invalid, reverting to default...");
                m = Material.FIRE;
            }
            this.filter.add(m);
        });
        this.filter = Collections.unmodifiableSet(this.filter);
        this.blacklist = new HashSet<>();
        this.blacklist.addAll(blacklist);
        this.blacklist = Collections.unmodifiableSet(this.blacklist);
        this.entityProtection = entityProtection;
        this.dropsEnabled = dropsEnabled;
        if (dropsRadius < 0.0) {
            this.dropsRadius = 4.0;
            ExplosionRenerationUtil.consoleWarning("Set drops radius to " + dropsRadius + " is not safe, reverting to default...");
        } else {
            this.dropsRadius = dropsRadius;
        }
        if (this.dropsEnabled) {
            this.dropsBlacklist = new HashSet<>();
            dropsBlacklist.forEach(material -> {
                Material m;
                try {
                    m = Material.valueOf(material.toUpperCase());
                    this.dropsBlacklist.add(m);
                } catch (final IllegalArgumentException e) {
                    ExplosionRenerationUtil.consoleWarning("Material " + material + " is invalid, skipping...");
                }
            });
            this.dropsBlacklist = Collections.unmodifiableSet(this.dropsBlacklist);
        }
    }

    public boolean isRandom() {
        return this.random;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(final int speed) {
        this.speed = speed;
    }

    public int getDelay() {
        return this.delay;
    }

    public Particle getParticle() {
        return this.particle;
    }

    public Sound getSound() {
        return this.sound;
    }

    public boolean isTntChainingEnabled() {
        return this.tntChainingEnabled;
    }

    public boolean isFallingBlocks() {
        return this.fallingBlocks;
    }

    public Set<Material> getFilter() {
        return Collections.unmodifiableSet(this.filter);
    }

    public Set<String> getBlacklist() {
        return Collections.unmodifiableSet(this.blacklist);
    }

    public boolean isEntityProtection() {
        return this.entityProtection;
    }

    public boolean isDropsEnabled() {
        return this.dropsEnabled;
    }

    public double getDropsRadius() {
        return this.dropsRadius;
    }

    public Set<Material> getDropsBlacklist() {
        return this.dropsBlacklist;
    }

}
