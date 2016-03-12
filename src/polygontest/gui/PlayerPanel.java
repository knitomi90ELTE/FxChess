package polygontest.gui;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PlayerPanel extends HBox {

    private final Image active = new Image("polygontest/resources/images/active.png");

    private Label nameLabel = new Label();
    private Label scoreLabel = new Label();
    private ImageView imageView = new ImageView();

    public PlayerPanel(String name) {
        nameLabel.setText(name);
        scoreLabel.setText("score: 0");

        nameLabel.getStyleClass().add("my-label");
        scoreLabel.getStyleClass().add("my-label");

        imageView.setFitHeight(35);
        imageView.setFitWidth(35);

        setSpacing(10.0);
        //setHeight(100);
        //setWidth(400);
        getChildren().addAll(nameLabel, scoreLabel, imageView);
    }

    public void setScore(int score){
        scoreLabel.setText("score: " + String.valueOf(score));
    }

    public void setActive(){
        imageView.setImage(active);
    }

    public void setPassive(){
        imageView.setImage(null);
    }


}
