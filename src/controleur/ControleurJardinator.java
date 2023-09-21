package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import modele.Legume;

public class ControleurJardinator extends Controleur{

	private Legume.LEGUME legumeChoisi;

	public ControleurJardinator()
	{
		Logger.logMsg(Logger.INFO, "new ControleurJardinator()");
	}
	
	public void initialiser()
	{
		
	}

	public void notifierChoixSemis(Legume.LEGUME legume) {
		this.legumeChoisi = legume;
	}

	public Object getLegumeChoisi() {
		return this.legumeChoisi;
	}
}
