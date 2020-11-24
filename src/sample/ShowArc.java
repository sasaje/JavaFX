package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShowArc extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Arc arc1 = new Arc(150,100,80,80,30,35);
        arc1.setFill(Color.RED);
        arc1.setType(ArcType.ROUND);

        Arc arc2 = new Arc(150,100,80,80,30+90,35);
        arc2.setFill(Color.BLACK);
        arc2.setType(ArcType.OPEN);

        Arc arc3 = new Arc(150,100,80,80,30+180,35);
        arc3.setFill(Color.BLACK);
        arc3.setType(ArcType.CHORD);

        Arc arc4 = new Arc(150,100,80,80,30+270,35);
        arc4.setFill(Color.BLACK);
        arc4.setType(ArcType.CHORD);

        //Create group and add nodes to the group
        Group group = new Group();
        group.getChildren().addAll(new Text(210,40,"arc1: round"), arc1,
                new Text(20,40,"arc2: chord"), arc2, new Text(20,170,"arc3: chord"), arc3,
                new Text(210,170,"arc4: chord"), arc4);

        //Create a scene and place it in the stage
        Scene scene = new Scene(new BorderPane(group), 300, 200);
        primaryStage.setTitle("ShowArc");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
