package modele;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BadgeMatelot extends AnchorPane {

    public BadgeMatelot() {
        this.setPrefHeight(50);
        this.setPrefWidth(50);
        this.setStyle("-fx-background-color: #ff0000;");
    }

    public void colorer(String couleur) {
        this.setStyle("-fx-background-color: " + couleur + ";");
    }

    public void afficherTexte(String texte) {
        Label motto = new Label();
        motto.setText(texte);
        motto.setLayoutX(95);
        motto.setLayoutY(250);
        motto.setStyle("-fx-font: 25px Tahoma;");
        this.getChildren().add(motto);
    }

    public enum DAUPHIN_TYPE{BLEU,ROSE};
    public void afficherDauphin(DAUPHIN_TYPE type) {
        ImageView dauphin = new ImageView();
        dauphin.setImage(new Image("images/daulphin.png"));
        dauphin.setLayoutX(0);
        dauphin.setLayoutY(0);
        dauphin.setFitHeight(50);
        dauphin.setFitWidth(50);
        this.getChildren().add(dauphin);
    }

    public enum VAGUES_TYPE{PETITE,MOYENNE,GRANDE};
    public void afficherVagues(VAGUES_TYPE type) {
    }

    public enum ECUSSON_TYPE{ARMOIRIE};
    public void afficherEcusson(ECUSSON_TYPE type) {
    }
}
