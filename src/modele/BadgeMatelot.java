package modele;

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

    public BadgeMatelot colorer(String couleur) {
        this.setStyle("-fx-background-color: " + couleur + ";");
        return this;
    }

    public BadgeMatelot afficherTexte(String texte) {
        Label motto = new Label();
        motto.setText(texte);
        motto.setStyle("-fx-font: 25px Tahoma;");
        motto.setLayoutY(motto.getLayoutY() + 35);
        motto.setLayoutX(motto.getLayoutX() + 25);
        this.getChildren().add(motto);
        return this;
    }

    public enum DAUPHIN_TYPE{BLEU,ROSE};
    public BadgeMatelot afficherDauphin(DAUPHIN_TYPE type) {
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
        return this;
    }

    public enum VAGUES_TYPE{PETITE,MOYENNE,GRANDE};
    public BadgeMatelot afficherVagues(VAGUES_TYPE type) {
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
        return this;
    }

    public enum ECUSSON_TYPE{ETOILE, BADGE, FIRST};
    public BadgeMatelot afficherEcusson(ECUSSON_TYPE type) {
        ImageView ecusson = new ImageView();

        switch (type) {
            case ETOILE -> ecusson.setImage(new Image("images/etoile.png"));
            case BADGE -> ecusson.setImage(new Image("images/badge.png"));
            case FIRST -> ecusson.setImage(new Image("images/first.png"));
        }

        ecusson.setLayoutX(0);
        ecusson.setLayoutY(0);
        ecusson.setFitHeight(this.getPrefHeight());
        ecusson.setFitWidth(this.getPrefWidth());
        this.getChildren().add(ecusson);
        return this;
    }

    public BadgeMatelot surClick(double x, double y) {
        this.setLayoutX(x - this.getPrefWidth() / 2);
        this.setLayoutY(y - this.getPrefHeight() / 2);
        return this;
    }

    private void centerImage(ImageView image) {
        image.setLayoutX((this.getPrefWidth() - image.getFitWidth()) / 2);
        image.setLayoutY((this.getPrefHeight() - image.getFitHeight()) / 2);
    }

    private void centerText(Label label) {
        // TODO implementer
    }

    private void centerObject(Object object) {
        if (object instanceof ImageView) centerImage((ImageView) object);
        if (object instanceof Label) centerText((Label) object);
    }
}
