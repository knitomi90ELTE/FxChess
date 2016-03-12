/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygontest;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

/**
 *
 * @author knizner
 */
public class PolygonTest extends Application {

    private double size = 100.0;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        int polygonPerRow = 8;
        int polygonPerCol = 8;
        Group circles = new Group();
        /*for (int i = 0; i < 63; i++) {
            Polygon hex = new Polygon();
            int p = i % polygonPerRow;
            hex.getPoints().addAll(new Double[]{
                10.0 + p * width, (p < polygonPerRow) ? 10.0 : 10.0 + width * p,
                110.0 + p * width, (p < polygonPerRow) ? 10.0 : 10.0 + width * p,
                110.0 + p * width, (p < polygonPerRow) ? 110.0 : 110.0 + width * p,
                10.0 + p * width, (p < polygonPerRow) ? 110.0 : 110.0 + width * p});
            hex.setStrokeType(StrokeType.CENTERED);
            hex.setStroke(Color.web("black"));
            hex.setStrokeWidth(2);
            hex.setFill(Paint.valueOf("green"));
            circles.getChildren().add(hex);
        }*/

        for (int i = 0; i < polygonPerRow; i++) {
            for (int j = 0; j < polygonPerCol; j++) {
                Polygon hex = new Polygon();
                hex.getPoints().addAll(getPoints(i, j));
                hex.setStrokeType(StrokeType.CENTERED);
                hex.setStroke(Color.web("black"));
                hex.setStrokeWidth(2);
                hex.setFill(Paint.valueOf("green"));
                circles.getChildren().add(hex);
            }
        }

        root.getChildren().add(circles);

        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private Double[] getPoints(double i, double j) {
        Double[] points = new Double[]{
            i*size, j*size,
            i*size + size, j*size,
            i*size + size, j*size + size,
            i*size, j*size + size
        };
        return points;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
