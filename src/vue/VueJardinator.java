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
import modele.Legume;

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
				Logger.logMsg(Logger.INFO, "Bouton Choisir Carotte activé");
				controleur.notifierChoixSemis(Legume.LEGUME.CAROTTE);
			}
		});

		Button choisirNavet = (Button) lookup("#action-choisir-navet");
		choisirNavet.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				Logger.logMsg(Logger.INFO, "Bouton Choisir Navet activé");
				controleur.notifierChoixSemis(Legume.LEGUME.NAVET);
			}
		});

		Button choisirChou = (Button) lookup("#action-choisir-chou");
		choisirChou.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				Logger.logMsg(Logger.INFO, "Bouton Choisir Chou activé");
				controleur.notifierChoixSemis(Legume.LEGUME.CHOU);
			}
		});

		Button choisirOignon = (Button) lookup("#action-choisir-oignon");
		choisirOignon.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				Logger.logMsg(Logger.INFO, "Bouton Choisir Oignon activé");
				controleur.notifierChoixSemis(Legume.LEGUME.OIGNON);
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

	public void planterSemis(Legume.LEGUME legumeChoisi, double x, double y) {
		if (legumeChoisi == null) return;
		ImageView legumePlante = new ImageView();
		legumePlante.setImage(new Image("vue/decoration/semis/" + legumeChoisi.toString().toLowerCase() + ".png"));
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
		composant.colorer("blue");
		composant.afficherTexte("Faire face");
		composant.afficherDauphin(DAUPHIN_TYPE.ROSE);
		//composant.afficherVagues(VAGUES_TYPE.MOYENNE);
		//composant.afficherEcusson(ECUSSON_TYPE.ARMOIRIE);
		System.out.println("composant = " + composant);

		AnchorPane espace = (AnchorPane) lookup("#jardin-cloture");
		composant.setLayoutX(x);
		composant.setLayoutY(y);
		espace.getChildren().add(composant);

		// afficher les propriétés de l'écusson
		System.out.println("composant.getStyle() = " + composant.getStyle());
		System.out.println("composant.getStyleClass() = " + composant.getStyleClass());
		System.out.println("composant.getLayoutX() = " + composant.getLayoutX());
		System.out.println("composant.getLayoutY() = " + composant.getLayoutY());
		System.out.println("composant.getWidth() = " + composant.getWidth());
		System.out.println("composant.getHeight() = " + composant.getHeight());

	}
}
