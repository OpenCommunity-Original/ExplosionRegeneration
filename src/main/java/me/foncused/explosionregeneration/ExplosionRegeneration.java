package me.foncused.explosionregeneration;

import me.foncused.explosionregeneration.command.BlockRegenSpeedCommand;
import me.foncused.explosionregeneration.config.ConfigManager;
import me.foncused.explosionregeneration.event.Regeneration;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ExplosionRegeneration extends JavaPlugin {

	private ConfigManager cm;

	@Override
	public void onEnable() {
		this.registerConfig();
		this.registerCommands();
		this.registerEvents();
	}

	private void registerConfig() {
		this.saveDefaultConfig();
		final FileConfiguration config = this.getConfig();
		this.cm = new ConfigManager(
				config.getBoolean("random", true),
				config.getInt("speed", 2),
				config.getInt("delay", 0),
				config.getString("particle", "VILLAGER_HAPPY"),
				config.getString("sound", "ENTITY_CHICKEN_EGG"),
				config.getBoolean("tnt-chaining.enabled", false),
				config.getInt("tnt-chaining.max-fuse-ticks", 40),
				config.getBoolean("falling-blocks", false),
				config.getStringList("filter"),
				config.getStringList("blacklist"),
				config.getBoolean("entity-protection", true),
				config.getBoolean("drops.enabled", false),
				config.getDouble("drops.radius", 6.0),
				config.getStringList("drops.blacklist")
		);
	}


	private void registerCommands() {
		this.getCommand("blockregenspeed").setExecutor(new BlockRegenSpeedCommand(this));
	}

	private void registerEvents() {
		Bukkit.getPluginManager().registerEvents(new Regeneration(this), this);
	}

	public ConfigManager getConfigManager() {
		return this.cm;
	}

}
