package numixe.SexyFreeze;

import java.util.ArrayList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class SexyFreeze extends JavaPlugin implements Listener {
	
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static ArrayList<Player> freeze = new ArrayList();
  public static SexyFreeze plugin;
  
  public void onEnable()
  {
	SexyFreeze.plugin = this;
    System.out.println("SexyFreeze Enabled!");
    getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
    getConfig().options().copyDefaults(true);
    saveConfig();
  }
  
  public void onDisable()
  {
    System.out.println("SexyFreeze Disabled!");
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
	if (!(sender instanceof Player)) {
		System.out.println("You can not execute this command because you're not a player");
		return true;
	} else {		
    Player p = (Player) sender;
    if (cmd.getName().equalsIgnoreCase("freeze")) {
      Commands.freeze(p, args);
     }
	}
    return false;
  } 
}
