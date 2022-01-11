package no.openshell.oddstr13.minecraft.choosyzombols;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.Configuration;

/**
 * CI-Test-Plugin
 *
 * @author Oddstr13
 */
public class ChoosyZombols extends JavaPlugin {

	private PluginDescriptionFile pdfFile;
	public Configuration config;

	public void onDisable() {
		System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion() + " is disabled.");
	}

	public void onEnable() {
		this.pdfFile = getDescription();

		refreshConfigFile();

		System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled.");

	}

	public void refreshConfigFile() {
		saveDefaultConfig();

		config = getConfig();

		config.addDefault("lastversion", pdfFile.getVersion());

		saveConfig();
	}

}
