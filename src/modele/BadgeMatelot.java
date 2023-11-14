package modele;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BadgeMatelot extends AnchorPane {

    public BadgeMatelot() {
        this.setPrefHeight(200);
        this.setPrefWidth(200);
        this.setStyle("-fx-background-color: #ff0000;");
    }

    public void colorer(String couleur) {
        this.setStyle("-fx-background-color: " + couleur + ";");
    }

    public void afficherTexte(String texte) {
        Label motto = new Label();
        motto.setText(texte);
        motto.setStyle("-fx-font: 25px Tahoma;");
        motto.setLayoutY(motto.getLayoutY() + 35);
        motto.setLayoutX(motto.getLayoutX() + 25);
        this.getChildren().add(motto);
    }

    public enum DAUPHIN_TYPE{BLEU,ROSE};
    public void afficherDauphin(DAUPHIN_TYPE type) {
        ImageView dauphin = new ImageView();

        switch (type) {
            case BLEU -> dauphin.setImage(new Image("images/daulphin_blue.png"));
            case ROSE -> dauphin.setImage(new Image("images/daulphin_pink.png"));
        }

        dauphin.preserveRatioProperty().set(true);
        dauphin.setFitHeight(this.getPrefHeight()/2);
        dauphin.setFitWidth(this.getPrefWidth()/2);
        centerObject(dauphin);
        this.getChildren().add(dauphin);
    }

    public enum VAGUES_TYPE{PETITE,MOYENNE,GRANDE};
    public void afficherVagues(VAGUES_TYPE type) {
        ImageView vagues = new ImageView();
        vagues.setImage(new Image("images/wave.png"));

        double taille = switch (type) {
            case PETITE -> 100;
            case MOYENNE -> 150;
            case GRANDE -> 200;
        };

        vagues.setFitHeight(taille);
        vagues.setFitWidth(taille);
        centerObject(vagues);
        this.getChildren().add(vagues);
    }

    public enum ECUSSON_TYPE{ARMOIRIE};
    public void afficherEcusson(ECUSSON_TYPE type) {
        ImageView ecusson = new ImageView();
        ecusson.setImage(new Image("images/badge.png"));
        ecusson.setLayoutX(0);
        ecusson.setLayoutY(0);
        ecusson.setFitHeight(this.getPrefHeight());
        ecusson.setFitWidth(this.getPrefWidth());
        this.getChildren().add(ecusson);
    }

    private void centerImage(ImageView image) {
        image.setLayoutX((this.getPrefWidth() - image.getFitWidth()) / 2);
        image.setLayoutY((this.getPrefHeight() - image.getFitHeight()) / 2);
    }

    private void centerText(Label label) {
        // TODO implementer
    }

    public void centerObject(Object object) {
        if (object instanceof ImageView) centerImage((ImageView) object);
        if (object instanceof Label) centerText((Label) object);
    }
}
