package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import modele.Legume;

public class ControleurJardinator extends Controleur{

	private Legume legumeChoisi = new Legume();

	public ControleurJardinator()
	{
		Logger.logMsg(Logger.INFO, "new ControleurJardinator()");
	}
	
	public void initialiser()
	{
		
	}

}
