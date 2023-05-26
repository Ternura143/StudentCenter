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

/**
 * the controller of the new course view page
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

    /**
     * set the course to be edited on the new course view page
     * @param controller the course management view controller
     */
    public void setParentController(CourseManagementViewController controller) {
        courseManagementViewController = controller;
    }

    /**
     * save the new course information to the course list
     * if the course is already in the list, remove it first and then add the new one
     * if the course information is incomplete, show a warning
     * if the agreement is not checked, show a warning
     * if the course is added successfully, show a information
     * close the current window
     * refresh the course list on course management view page
     * close the current window
     * @param event mouse event of save button clicked on new course view page
     */
    @FXML
    public void saveHandled(MouseEvent event) {
        String courseName = courseNameField.getText();
        String courseID = courseIDField.getText();
        String category = categoryField.getText();
        String id = "" + IdGenerator.getCode();
        String score = scoreField.getText();

        if (checkBox.isSelected()) {
            if (courseName.equals("") || category.equals("") || courseID.equals("") || score.equals("") ) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "check it and try again");
                alert.setHeaderText("Incomplete information input");
                alert.show();
                return;
            }
            if (inCourse != null) {
                CourseManager.getInstance().removeCourse(inCourse);
            }
            CourseManager.getInstance().addCourse(new Course(courseName, courseID, category, id, score));
            Alert info = new Alert(Alert.AlertType.INFORMATION,"Course has been added");
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
     * close the current window
     * @param event mouse event of cancel button clicked on new course view page
     */
    @FXML
    public void close(MouseEvent event) {
        Stage currentStage = (Stage) exitLabel.getScene().getWindow();
        currentStage.close();
    }

    /**
     * set the course to be edited on the new course view page
     * @param location  the location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resources the resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
