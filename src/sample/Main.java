package sample;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    // Book example 14.1-14.12 from Liang

    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane rootPane = new StackPane();
        Scene scene = new Scene(rootPane, 800, 600);

        //Creates Multiply Stages
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.show();
        stage2.setTitle("Show MultipleStageDemo");
        stage2.setScene(new Scene(new Button("New Stage button")));
        stage2.setAlwaysOnTop(true); //always the top window

        //Create button with label
        Button btButton = new Button("Button"); //adds new button
        btButton.setTranslateX(200);
        //Create a scene and place a button in the scene
        StackPane pane2 = new StackPane();
        pane2.setTranslateX(0);
        pane2.getChildren().add(btButton);

        //Create a scene and place a circle in the scene
        Circle circle = new Circle();
        circle.setCenterX(150);
        circle.setCenterY(300);//create a pane to hold the circle
        StackPane pane3 = new StackPane();
//        circle.centerXProperty().bind(pane2.widthProperty().divide(2)); //centered circle in the scene
//        circle.centerYProperty().bind(pane2.widthProperty().divide(2)); //centered circle in the scene
        circle.setRadius(100);
        circle.setStroke(Color.TURQUOISE);
        circle.setStrokeWidth(4);
        circle.setFill(Color.TRANSPARENT);
        //Create a pane to hold the circle
        pane3.getChildren().add(circle);

        // Create a label and set its properties
        Label label = new Label("JAVAFX");
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        pane3.getChildren().add(label);

        //Create a pane to hold the image views
        Pane pane4 = new HBox(150);
        pane4.setPadding(new Insets(50,10,10,10)); // padding on image
        Image image = new Image("sample/image/elephant.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(300);
        imageView.setY(200);
        imageView.setX(200);
        pane4.getChildren().add(imageView); //add imageView to pane3

        //FLOWPANE - Create a flowPane and set its properties
        FlowPane pane5 = new FlowPane();
        pane5.setPadding(new Insets(10,10,10,10));
        pane5.setHgap(5);
        pane5.setVgap(5);
        //Place nodes in the pane
        pane5.getChildren().addAll(new Label("First Name:"), new TextField(), new Label("MI:"));
        TextField tfMi = new TextField();
        tfMi.setPrefColumnCount(1);
        pane5.getChildren().addAll(tfMi, new Label("Last Name:"), new TextField());

        //GRIDPANE - Create a pane and set its properties
        GridPane pane6 = new GridPane();
        pane6.setAlignment(Pos.CENTER_LEFT);
        pane6.setPadding(new Insets(60.5,12.5, 13.5, 14.5));
        pane6.setHgap(5.5);
        pane6.setVgap(5.5);
        //Place the nodes in the pane
        pane6.add(new Label("First Name:"), 0,0);
        pane6.add(new TextField(), 1,0);
        pane6.add(new Label("MI:"), 0,1);
        pane6.add(new TextField(), 1,1);
        pane6.add(new Label("Last Name:"), 0,2);
        pane6.add(new TextField(), 1,2);
        Button btAdd = new Button("Add Name");
        pane6.add(btAdd, 1,3);
        GridPane.setHalignment(btAdd, HPos.RIGHT);

        //BORDERPANE - Create a pane and set its properties
        BorderPane pane7 = new BorderPane();
        // Place the nodes in the pane
        pane7.setTop(new CustomPane("Top"));
        pane7.setRight(new CustomPane("Right"));
        pane7.setBottom(new CustomPane("Bottom"));
        pane7.setLeft(new CustomPane("Left"));
        pane7.setCenter(new CustomPane("Center"));

        primaryStage.setTitle("MyFirstJavaFXProject with button in a pane"); //title of the stage (window title)
        rootPane.getChildren().addAll(pane2, pane3, pane4, pane5, pane6, pane7);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //BORDERPANE
    class CustomPane extends StackPane{
        public CustomPane(String title){
            getChildren().add(new Label(title));
            setStyle("-fx-border-color: red");
            setPadding(new Insets(60.5,12.5,13.5,14.5));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
