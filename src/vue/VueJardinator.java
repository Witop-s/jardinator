package vue;
import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurJardinator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import modele.Legume;

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



		Rectangle jardin = (Rectangle) lookup("#jardin-terre");
		jardin.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent clic)
			{
				Logger.logMsg(Logger.INFO, "Jardin cliqué");

				ImageView legumePlante = new ImageView();
				legumePlante.setImage(new Image("vue/decoration/semis/" + controleur.getLegumeChoisi().toString().toLowerCase() + ".png"));
				legumePlante.preserveRatioProperty().set(true);
				legumePlante.setFitHeight(100);
				legumePlante.setFitWidth(50);

				planterSemis(clic, legumePlante);

			}
		});

	}

	private void planterSemis(MouseEvent clic, ImageView legumePlante) {
		// add the image to the pane
		AnchorPane cloture = (AnchorPane) lookup("#jardin-cloture");
		// place the center of the image to the center of the pane
		legumePlante.setX(clic.getX() - legumePlante.getFitWidth() / 3.5);
		legumePlante.setY(clic.getY() - legumePlante.getFitHeight() / 2);
		cloture.getChildren().add(legumePlante);
	}
}
