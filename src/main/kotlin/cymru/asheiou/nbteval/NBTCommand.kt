package cymru.asheiou.nbteval

import de.tr7zw.nbtapi.NBT
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class NBTCommand : CommandExecutor {
  override fun onCommand(
    sender: CommandSender,
    command: Command,
    label: String,
    args: Array<out String>
  ): Boolean {
    if (sender !is Player) return true
    val item = sender.inventory.itemInMainHand
    var keys: Set<String> = emptySet()
    NBT.get(item) {
      keys = it.keys
    }
    keys.forEach {
      sender.sendMessage(it)
    }
    return true
  }
}