package com.studyCenter.controller;

import com.jfoenix.controls.JFXButton;
import com.studyCenter.view.ViewManager;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
the controller of the project view page
 */
public class ProjectViewController {
    @FXML
    private JFXButton backToMain;

    private StudentMainViewController studentMainViewController;

    /**
     * set the parent controller of this controller
     * @param controller the parent controller
    */
    public void setParentController(StudentMainViewController controller) {
        studentMainViewController = controller;
    }

    /**
     * back to the main page
     * @param event the mouse event of the button clicked
    */
    public void backToMainPage(MouseEvent event){
        StudentMainViewController controller = (StudentMainViewController) ViewManager.newWindow("studentMainView.fxml");
        controller.setParentControllerProject(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }
}
