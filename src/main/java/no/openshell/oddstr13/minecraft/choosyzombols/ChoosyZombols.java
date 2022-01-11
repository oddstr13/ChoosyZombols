package no.openshell.oddstr13.minecraft.choosyzombols;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.configuration.Configuration;

/**
 * CI-Test-Plugin
 *
 * @author Oddstr13
 */
public class ChoosyZombols extends JavaPlugin {

	private PluginDescriptionFile pdfFile;
	private Configuration config;

	private boolean config_enabled;
	private boolean config_debug;
	private boolean config_reject;
	private List<String> config_list;

	public void onEnable() {
		this.pdfFile = getDescription();

		refreshConfigFile();

		getLogger().log(Level.INFO, "{0} version {1} is enabled.",
				new Object[] { pdfFile.getName(), pdfFile.getVersion() });
	}

	public void onDisable() {
		getLogger().log(Level.INFO, "{0} version {1} is disabled.",
				new Object[] { pdfFile.getName(), pdfFile.getVersion() });
	}

	public void refreshConfigFile() {
		saveDefaultConfig();

		config = getConfig();

		config.addDefault("lastversion", pdfFile.getVersion());

		saveConfig();

		config_enabled = config.getBoolean("enabled", true);
		config_debug = config.getBoolean("debug", false);
		config_reject = config.getBoolean("reject", true);
		config_list = config.getStringList("list");
	}

	public boolean getConfigEnabled() {
		return config_enabled;
	}

	public boolean getConfigDebug() {
		return config_debug;
	}

	public boolean getConfigReject() {
		return config_reject;
	}

	public List<String> getConfigList() {
		return Collections.unmodifiableList(config_list);
	}
}
