package no.openshell.oddstr13.minecraft.choosyzombols;

import java.util.logging.Level;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class ZombieEventListener implements Listener {
	private final ChoosyZombols plugin;

	public ZombieEventListener(ChoosyZombols instance) {
		plugin = instance;
	}

	@EventHandler
	public void onZombiePickup(EntityPickupItemEvent event) {
		if (plugin.getConfigEnabled()) {
			Entity entity = event.getEntity();
			String item_name = event.getItem().getName();
			if (plugin.getConfigDebug()) {
				plugin.getLogger().log(Level.INFO, "Item {0} picked up by {1} @ {2}",
						new Object[] { item_name, entity.getName(), entity.getLocation() });
			}
			if (entity instanceof Zombie) {
				boolean in_list = plugin.getConfigList().contains(item_name);
				boolean reject = plugin.getConfigReject();

				if (reject && in_list) {
					if (plugin.getConfigDebug()) {
						plugin.getLogger().log(Level.INFO, "Item {0} in list, rejecting ({1} @ {2})",
								new Object[] { item_name, entity.getName(), entity.getLocation() });
					}
					event.setCancelled(true);
				} else if (!reject && !in_list) {
					if (plugin.getConfigDebug()) {
						plugin.getLogger().log(Level.INFO, "Item {0} not in list, rejecting ({1} @ {2})",
								new Object[] { item_name, entity.getName(), entity.getLocation() });
					}
					event.setCancelled(true);
				}
			}
		}
	}
}
