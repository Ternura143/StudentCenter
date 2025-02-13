package com.studyCenter.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

/**
 * This class is used to manage the views of the application
 */
public class ViewManager {
    private static double yOffSet;
    private static double xOffSet;

    /**
     * This method is used to create a new window
     *
     * @param fxmlFileName the name of the fxml file to be loaded
     * @return the controller of the fxml file
     */
    public static Object newWindow(String fxmlFileName) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(ViewManager.class.getResource(fxmlFileName));
            Parent root = loader.load();
            root.setOnMousePressed(event -> {
                xOffSet = event.getSceneX();
                yOffSet = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - xOffSet);
                stage.setY(event.getScreenY() - yOffSet);
            });
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loader.getController();
    }

    /**
     * This method is used to get the pane of a fxml file
     *
     * @param fxmlFileName the name of the fxml file to be loaded
     * @return the pane of the fxml file
     */
    public static AnchorPane getPane(String fxmlFileName) {
        AnchorPane pane = null;
        try {
            new FXMLLoader();
            pane = (AnchorPane) FXMLLoader.load(Objects.requireNonNull(ViewManager.class.getResource(fxmlFileName)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pane;
    }
}
