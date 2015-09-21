import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by surajpatel on 3/11/15.
 */
public class Circledot extends Application {
    Circle circle = new Circle();
    Circle circle2 = new Circle();
Text t ;
    private class Handler1 implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            circle.setCenterX(event.getX());
            circle.setCenterY(event.getY());
            t.setText(((circle2.getCenterY()-circle.getCenterY()) + circle2.getCenterX()-circle.getCenterX())/2 +"");
            t.setY((circle2.getCenterY()+circle.getCenterY())/2);
            t.setX((circle2.getCenterX()+circle.getCenterX())/2);

        }
    }

    private class Handler2 implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            circle2.setCenterX(event.getX());
            circle2.setCenterY(event.getY());


            t.setText(((circle2.getCenterY()-circle.getCenterY()) + circle2.getCenterX()-circle.getCenterX())/2 + "");
            t.setY((circle2.getCenterY()+circle.getCenterY())/2);
            t.setX((circle2.getCenterX()+circle.getCenterX())/2);
        }
    }
    public void start(Stage primaryStage) {

        Pane pane = new Pane();



        circle.setCenterX(100.0f);
        circle.setCenterY(100.0f);
        circle.setRadius(30.0f);

        circle.setFill(Color.ORANGE);
        circle.setStroke(Color.BLACK);
        circle.setOnMouseDragged(new Handler1());




        circle2.setCenterX(150.0f);
        circle2.setCenterY(150.0f);
        circle2.setRadius(30.0f);

        circle2.setFill(Color.ORANGE);
        circle2.setStroke(Color.BLACK);
        circle2.setOnMouseDragged(new Handler2());


        Line line = new Line();
        line.startXProperty().bind(circle.centerXProperty());
        line.startYProperty().bind(circle.centerYProperty());
        line.endXProperty().bind(circle2.centerXProperty());
        line.endYProperty().bind(circle2.centerYProperty());
        pane.getChildren().add(line );
        pane.getChildren().add(circle);
        pane.getChildren().add(circle2);
        Double distance = ((circle2.getCenterY()-circle.getCenterY()) + circle2.getCenterX()-circle.getCenterX())/2;
         t = new Text (distance + " ");
        t.setX(100);
        t.setY(100);

        pane.getChildren().add(t);

        Scene scene = new Scene(pane, 600, 600);
        scene.setFill(Color.SKYBLUE);
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }



}