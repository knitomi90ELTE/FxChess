package polygontest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import polygontest.gui.ChessGrid;
import polygontest.gui.Statusbar;

public class PolygonTest extends Application {

    Statusbar statusbar;
    BorderPane borderPane;
    ChessGrid board;
    Scene scene;

    @Override
    public void start(Stage primaryStage) {

        borderPane = new BorderPane();
        statusbar = new Statusbar();
        board = new ChessGrid(statusbar);
        borderPane.setBottom(statusbar);
        borderPane.setCenter(board);
        scene = new Scene(borderPane, 800, 850);
        scene.getStylesheets().add("polygontest/resources/style/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
