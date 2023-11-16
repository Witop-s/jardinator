package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import modele.Badge;
import vue.VueJardinator;

public class ControleurJardinator extends Controleur{

	private Badge.BADGE BadgeChoisi;

	public ControleurJardinator()
	{
		Logger.logMsg(Logger.INFO, "new ControleurJardinator()");
	}
	
	public void initialiser()
	{
		
	}

	public void notifierChoixBadge(Badge.BADGE BADGE) {
		this.BadgeChoisi = BADGE;
	}

	public Object getBadgeChoisi() {
		return this.BadgeChoisi;
	}

	public void notifierClicJardin(double x, double y) {
		//VueJardinator.getInstance().planterSemis(this.legumeChoisi, x, y);
		VueJardinator.getInstance().planterEcusson(this.BadgeChoisi, x, y);
	}
}
