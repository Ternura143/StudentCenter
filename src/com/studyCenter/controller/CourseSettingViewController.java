package com.studyCenter.controller;

import com.studyCenter.service.CourseManager;
import com.studyCenter.entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
/*
 * @Author DengYimo
 * @Date  5:02
 * @Description 这是病人信息设置页面的控制器类
 * @Since version-1.0
 */
public class CourseSettingViewController implements Initializable {
    @FXML
    private TextField courseNameField;
    @FXML
    private TextField courseIDField;
    @FXML
    private TextField categoryField;
    @FXML
    private TextField scoreField;
    @FXML
    private TextField idField;

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
    void saveHandled(MouseEvent event) {
        String courseName = courseNameField.getText();
        String courseID = courseIDField.getText();
        String category = categoryField.getText();
        String id = idField.getText();
        String score = scoreField.getText();

        if (checkBox.isSelected()) {
            if (courseName.equals("") || category.equals("") || courseID.equals("") || score.equals("") ) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "核对一下再试试吧");
                alert.setHeaderText("信息输入不能有空值");
                alert.show();
                return;
            }
            if (inCourse != null) {
                CourseManager.getInstance().removeCourse(inCourse);
            }
            CourseManager.getInstance().addCourse(new Course(courseName, courseID, category, id, score));
            Alert info = new Alert(Alert.AlertType.INFORMATION, "课程" + courseName + "信息已修改");
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Type> typeObservableList = FXCollections.observableArrayList();
    }

    public void setCourse(Course course) {
        inCourse = course;
        courseNameField.setText(course.getCourseName());
        courseIDField.setText(course.getCourseID());
        categoryField.setText(course.getCategory());
        idField.setText(course.getId());
        scoreField.setText(course.getScore());
    }

    @FXML
    void close(MouseEvent event) {
        Stage currentStage = (Stage) exitLabel.getScene().getWindow();
        currentStage.close();
    }
}
