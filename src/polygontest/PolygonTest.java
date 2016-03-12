/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygontest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import polygontest.gui.ChessGrid;

/**
 *
 * @author knizner
 */
public class PolygonTest extends Application {

    ChessGrid board;
    Scene scene;

    @Override
    public void start(Stage primaryStage) {

        board = new ChessGrid();
        scene = new Scene(board, 800, 800);
        scene.getStylesheets().add("polygontest/resources/style/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
