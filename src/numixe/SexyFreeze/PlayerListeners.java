package numixe.SexyFreeze;

import static numixe.SexyFreeze.SexyFreeze.*;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerListeners implements Listener {
	
	@EventHandler
	  public void onMove(PlayerMoveEvent e)
	  {
	    Player p = e.getPlayer();
	    if (freeze.contains(p)) {
	      e.setTo(e.getFrom());
	    }
	  }
}
