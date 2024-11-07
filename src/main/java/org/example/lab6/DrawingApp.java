package org.example.lab6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.example.lab6.geometry2d.Circle;
import org.example.lab6.geometry2d.Rectangle;

public class DrawingApp extends Application {

    private static final double CANVAS_WIDTH = 600;
    private static final double CANVAS_HEIGHT = 400;

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Button drawCircleButton = new Button("Draw Circle");
        drawCircleButton.setOnAction(e -> drawRandomCircle(gc));

        Button drawRectangleButton = new Button("Draw Rectangle");
        drawRectangleButton.setOnAction(e -> drawRandomRectangle(gc));

        HBox buttonBox = new HBox(10, drawCircleButton, drawRectangleButton);

        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(buttonBox);

        Scene scene = new Scene(root, CANVAS_WIDTH, CANVAS_HEIGHT + 50);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Geometry Drawing App");
        primaryStage.show();
    }

    private void drawRandomCircle(GraphicsContext gc) {
        double radius = 20 + Math.random() * 50; // случайный радиус от 20 до 70
        double x = Math.random() * (CANVAS_WIDTH - 2 * radius);
        double y = Math.random() * (CANVAS_HEIGHT - 2 * radius);
        Circle circle = new Circle(radius);
        circle.draw(gc, x, y);
    }

    private void drawRandomRectangle(GraphicsContext gc) {
        double side = 20 + Math.random() * 50; // случайная сторона от 20 до 70
        double x = Math.random() * (CANVAS_WIDTH - side);
        double y = Math.random() * (CANVAS_HEIGHT - side);
        Rectangle rectangle = new Rectangle(side);
        rectangle.draw(gc, x, y);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
