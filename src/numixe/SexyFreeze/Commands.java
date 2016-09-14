package numixe.SexyFreeze;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import static numixe.SexyFreeze.SexyFreeze.*;

public class Commands {

	@SuppressWarnings("deprecation")
	public static void freeze(Player sender, String[] args) {
		Player p = (Player) sender;
		Location loc = p.getLocation();
	    String F1  = plugin.getConfig().getString("Title.Msg.Freeze");
	    String UNF1  = plugin.getConfig().getString("Title.Msg.UnFreeze");
	    String Sub = plugin.getConfig().getString("Title.Msg.SubTitle").replace("%p%", p.getName());
	    
		if (p.hasPermission("freeze.use"))
	      {
	        if (args.length == 1)
	        {
	        	Player t = Bukkit.getPlayer(args[0]);
	          if (t == null)
	          {
	            p.sendMessage("§9Freeze> §cThis player is not online");
	            return;
	          }
	          if (freeze.contains(t))
	          {
	            freeze.remove(t);
	            p.sendMessage(plugin.getConfig().getString("Message.UnFreeze").replace("&", "§").replace("%p%", args[0]));
	            t.getWorld().playSound(loc, Sound.ORB_PICKUP, 5.0F, 5.0F);
	            t.sendTitle(UNF1, Sub);
	          }
	          else
	          {
	            freeze.add(t);
	            p.sendMessage(plugin.getConfig().getString("Message.Freeze").replace("&", "§").replace("%p%", args[0]));
	            t.getWorld().playSound(loc, Sound.NOTE_PLING, 5.0F, 5.0F);
	            t.sendTitle(F1, Sub);
	          }
	        }
	        else
	        {
	          p.sendMessage(plugin.getConfig().getString("Message.Error").replace("&", "§"));
	          return;
	        }
	      } else
	      {
	        p.sendMessage(plugin.getConfig().getString("Message.NoPermission").replace("&", "§"));
	        return;
	      }
	  }
	}