package com.studyCenter.controller;

import com.jfoenix.controls.JFXButton;
import com.studyCenter.view.ViewManager;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/*
 * @Author DengYimo
 * @Date  4:57
 * @Description 这事拓展页面的控制器类
 * @Since version-1.0
 */
public class ConstructionViewController {
    @FXML
    private JFXButton backToMain;

    private StudentMainViewController studentMainViewController;

    public void setParentController(StudentMainViewController controller) {
        studentMainViewController = controller;
    }

    public void backToMainPage(MouseEvent event){
        StudentMainViewController controller = (StudentMainViewController) ViewManager.newWindow("studentMainView.fxml");
        controller.setParentControllerConstruction(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }
}
