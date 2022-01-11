package no.openshell.oddstr13.minecraft.choosyzombols;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

import org.bukkit.configuration.Configuration;

/**
 * CI-Test-Plugin
 *
 * @author Oddstr13
 */
public class ChoosyZombols extends JavaPlugin {

	private PluginDescriptionFile pdfFile;
	public Configuration config;

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
	}

}
