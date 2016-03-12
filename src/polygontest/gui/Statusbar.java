package polygontest.gui;

import javafx.scene.layout.HBox;

public class Statusbar extends HBox{

    private PlayerPanel PlayerLight;
    private PlayerPanel PlayerDark;
    private PlayerPanel[] players;


    public Statusbar() {
        PlayerLight = new PlayerPanel("Világos");
        PlayerDark = new PlayerPanel("Sötét");

        players = new PlayerPanel[]{PlayerLight, PlayerDark};

        setMinSize(800, 50);
        setSpacing(100);
        getChildren().addAll(PlayerLight, PlayerDark);

        PlayerLight.setActive();
    }

    public void switchActive(int i){
        players[i].setActive();
        players[(i+1)%2].setPassive();
    }

    public void updateScores(int score1, int score2){
        PlayerLight.setScore(score1);
        PlayerDark.setScore(score2);
    }

}
