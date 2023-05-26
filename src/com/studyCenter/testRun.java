package com.studyCenter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

/**
 * This class is used to run the application
 */
public class testRun extends Application {
    private double xOffSet;
    private double yOffSet;


    /**
     * This method is used to start the application
     * @param primaryStage the stage to be displayed
     * @throws Exception if the fxml file is not found
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view/loginView.fxml")));

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.getIcons().add(new Image("com/studyCenter/view/icons/Home.png"));
        root.setOnMousePressed(event -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffSet);
            primaryStage.setY(event.getScreenY() - yOffSet);
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    /**
     * This method is used to launch the application
     * @param args the arguments to be passed
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("javafx.version"));
        launch(args);
    }

}
