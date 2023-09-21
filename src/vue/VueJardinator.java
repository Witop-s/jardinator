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
		ImageView legumePlante = new ImageView();
		legumePlante.setImage(new Image("vue/decoration/semis/" + legumeChoisi.toString().toLowerCase() + ".png"));
		legumePlante.preserveRatioProperty().set(true);
		legumePlante.setFitHeight(100);
		legumePlante.setFitWidth(50);
		// add the image to the pane
		AnchorPane cloture = (AnchorPane) lookup("#jardin-cloture");
		// place the center of the image to the center of the pane
		legumePlante.setX(x - legumePlante.getFitWidth() / 3.5);
		legumePlante.setY(y - legumePlante.getFitHeight() / 2);
		cloture.getChildren().add(legumePlante);
	}
}
