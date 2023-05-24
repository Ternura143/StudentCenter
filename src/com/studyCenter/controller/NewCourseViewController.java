package com.studyCenter.controller;

import com.studyCenter.service.CourseManager;
import com.studyCenter.entity.*;
import com.studyCenter.util.IdGenerator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
/*
 * @Author DengYimo
 * @Date  4:59
 * @Description 这是新建病患的控制器类
 * @Since version-1.0
 */
public class NewCourseViewController implements Initializable {
    @FXML
    private TextField courseNameField;
    @FXML
    private TextField courseIDField;
    @FXML
    private TextField categoryField;
    @FXML
    private TextField scoreField;

    @FXML
    private Label exitLabel;
    @FXML
    private CheckBox checkBox;

    private CourseManagementViewController courseManagementViewController;
    private Course inCourse;

    public void setParentController(CourseManagementViewController controller) {
        courseManagementViewController = controller;
    }

    @FXML
    public void saveHandled(MouseEvent event) {
        String courseName = courseNameField.getText();
        String courseID = courseIDField.getText();
        String category = categoryField.getText();
        String id = "" + IdGenerator.getCode();
        String score = scoreField.getText();

        if (checkBox.isSelected()) {
            if (courseName.equals("") || category.equals("") || courseID.equals("") || score.equals("") ) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "核对一下再试试吧");
                alert.setHeaderText("病患信息输入不完整");
                alert.show();
                return;
            }
            if (inCourse != null) {
                CourseManager.getInstance().removeCourse(inCourse);
            }
            CourseManager.getInstance().addCourse(new Course(courseName, courseID, category, id, score));
            Alert info = new Alert(Alert.AlertType.INFORMATION,"病患已添加");
            info.showAndWait();
            courseManagementViewController.initialize(null, null);
            Stage currentStage = (Stage) exitLabel.getScene().getWindow();
            currentStage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "请勾选同意协议");
            alert.setHeaderText("");
            alert.show();
        }
    }

    @FXML
    public void close(MouseEvent event) {
        Stage currentStage = (Stage) exitLabel.getScene().getWindow();
        currentStage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
