package vue;

import architecture.Vue;
import com.sun.media.jfxmedia.logging.Logger;
import controleur.ControleurJardinator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import modele.BadgeMatelot;
import modele.Badge;

import static modele.BadgeMatelot.DAUPHIN_TYPE;
import static modele.BadgeMatelot.VAGUES_TYPE;
import static modele.BadgeMatelot.ECUSSON_TYPE;

public class VueJardinator extends Vue {

	protected ControleurJardinator controleur;
	protected static VueJardinator instance = null; 
	public static VueJardinator getInstance() {if(null==instance)instance = new VueJardinator();return VueJardinator.instance;}; 
	
	private VueJardinator() 
	{
		super("jardinator.fxml", VueJardinator.class, 1294,743);
		super.controleur = this.controleur = new ControleurJardinator();
		Logger.logMsg(Logger.INFO, "new VueJardinator()");
	}
		
	public void activerControles()
	{
		super.activerControles();

		Button choisirCarotte = (Button) lookup("#action-choisir-carotte");
		choisirCarotte.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				Logger.logMsg(Logger.INFO, "Bouton Choisir Badge1 activé");
				controleur.notifierChoixBadge(Badge.BADGE.MARIN1);
			}
		});

		Button choisirNavet = (Button) lookup("#action-choisir-navet");
		choisirNavet.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				Logger.logMsg(Logger.INFO, "Bouton Choisir Badge2 activé");
				controleur.notifierChoixBadge(Badge.BADGE.MARIN2);
			}
		});



		Rectangle jardin = (Rectangle) lookup("#jardin-terre");
		jardin.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent clic)
			{
				Logger.logMsg(Logger.INFO, "Jardin cliqué");

				double x = clic.getX();
				double y = clic.getY();
				controleur.notifierClicJardin(x, y);

			}
		});

	}

	public void planterSemis(Badge.BADGE BADGEChoisi, double x, double y) {
		if (BADGEChoisi == null) return;
		ImageView legumePlante = new ImageView();
		legumePlante.setImage(new Image("vue/decoration/semis/" + BADGEChoisi.toString().toLowerCase() + ".png"));
		legumePlante.preserveRatioProperty().set(true);
		legumePlante.setFitHeight(100);
		legumePlante.setFitWidth(50);

		AnchorPane cloture = (AnchorPane) lookup("#jardin-cloture");

		legumePlante.setX(x - legumePlante.getFitWidth() / 3.5);
		legumePlante.setY(y - legumePlante.getFitHeight() / 2);
		cloture.getChildren().add(legumePlante);
	}

	public void testEcusson(double x, double y) {
		Logger.logMsg(Logger.INFO, "testEcusson()");
		// Créer un écusson custom
		BadgeMatelot composant = new BadgeMatelot();

		/*composant.colorer("blue");
		composant.afficherVagues(VAGUES_TYPE.GRANDE);
		composant.afficherDauphin(DAUPHIN_TYPE.ROSE);
		composant.afficherTexte("'me souviens");
		composant.afficherEcusson(ECUSSON_TYPE.BADGE);*/

		composant.colorer("blue").afficherVagues(VAGUES_TYPE.GRANDE).afficherDauphin(DAUPHIN_TYPE.ROSE).afficherTexte("'me souviens").afficherEcusson(ECUSSON_TYPE.BADGE).surClick(x, y);
		AnchorPane espace = (AnchorPane) lookup("#jardin-cloture");
		espace.getChildren().add(composant);

	}

	public void planterEcusson(Badge.BADGE badgeChoisi, double x, double y) {
		if (badgeChoisi == null) return;
		BadgeMatelot ecussonPlante = new BadgeMatelot();

		switch (badgeChoisi) {
			case MARIN1 -> ecussonPlante.colorer("blue").afficherVagues(VAGUES_TYPE.GRANDE).afficherDauphin(DAUPHIN_TYPE.ROSE).afficherTexte("'me souviens").afficherEcusson(ECUSSON_TYPE.BADGE).surClick(x, y);
			case MARIN2 -> ecussonPlante.colorer("red").afficherVagues(VAGUES_TYPE.PETITE).afficherDauphin(DAUPHIN_TYPE.BLEU).afficherTexte("~~hello~~").afficherEcusson(ECUSSON_TYPE.ETOILE).surClick(x, y);
		}
		AnchorPane cloture = (AnchorPane) lookup("#jardin-cloture");
		cloture.getChildren().add(ecussonPlante);
	}
}
