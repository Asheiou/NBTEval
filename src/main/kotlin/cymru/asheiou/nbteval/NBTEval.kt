package cymru.asheiou.nbteval

import de.tr7zw.nbtapi.NBT
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class NBTEval : JavaPlugin() {

  override fun onEnable() {
    if (!NBT.preloadApi()) {
      logger.warning("NBT was not initialised correctly.")
      Bukkit.getPluginManager().disablePlugin(this)
    }
    getCommand("nbt")?.setExecutor(NBTCommand())
  }

  override fun onDisable() {
    // Plugin shutdown logic
  }
}
