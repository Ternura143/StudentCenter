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

/**
* the controller of the course setting page
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

    /**
     * set the parent controller of the course setting page
     * @param controller the parent controller of the course setting page
     */
    public void setParentController(CourseManagementViewController controller) {
        courseManagementViewController = controller;
    }

    /**
     * save the course information and close the page when the save button is clicked
     * @param event the mouse event of the save button being clicked
     */
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

    /**
     * close the page when the cancel button is clicked
     * @param location the URL of the course setting page
     *@param resources the resource bundle of the course setting page
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Type> typeObservableList = FXCollections.observableArrayList();
    }

    /**
     * set the course information
     * @param course the course to be set
     */
    public void setCourse(Course course) {
        inCourse = course;
        courseNameField.setText(course.getCourseName());
        courseIDField.setText(course.getCourseID());
        categoryField.setText(course.getCategory());
        idField.setText(course.getId());
        scoreField.setText(course.getScore());
    }

    /**
     * close the page when the exit button is clicked
     * @param event the mouse event of the exit button being clicked
     */
    @FXML
    void close(MouseEvent event) {
        Stage currentStage = (Stage) exitLabel.getScene().getWindow();
        currentStage.close();
    }
}
