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
                Alert alert = new Alert(Alert.AlertType.WARNING, "Check it and try again");
                alert.setHeaderText("No null values for message input");
                alert.show();
                return;
            }
            if (inCourse != null) {
                CourseManager.getInstance().removeCourse(inCourse);
            }
            CourseManager.getInstance().addCourse(new Course(courseName, courseID, category, id, score));
            Alert info = new Alert(Alert.AlertType.INFORMATION, "Course" + courseName + "'s information has been amended");
            info.showAndWait();
            courseManagementViewController.initialize(null, null);
            Stage currentStage = (Stage) exitLabel.getScene().getWindow();
            currentStage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please check the agreement");
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
