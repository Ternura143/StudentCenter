package com.studyCenter.controller;

import com.jfoenix.controls.JFXButton;
import com.studyCenter.entity.Course;
import com.studyCenter.service.CourseManager;
import com.studyCenter.view.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


/**
 * the controller of the course management page
 */
public class CourseManagementViewController implements Initializable {
    @FXML
    private JFXButton newFileBtn;
    @FXML
    private JFXButton delFileBtn;
    @FXML
    private JFXButton modFileBtn;
    @FXML
    private JFXButton gpaBtn;
    @FXML
    private ImageView searchBtn;
    @FXML
    private ImageView searchCancelBtn;
    @FXML
    private TextField searchText;
    @FXML
    private JFXButton backToMain;
    @FXML
    private TableView<Course> tableView;
    @FXML
    private TableColumn<Course, String> courseNameCol;
    @FXML
    private TableColumn<Course, String> courseIDCol;
    @FXML
    private TableColumn<Course, String> categoryCol;
    @FXML
    private TableColumn<Course, String> scoreCol;


    private List<Course> searchedList = new ArrayList<Course>();

    private StudentMainViewController studentMainViewController;

    private ObservableList<Course> courseObservableList = FXCollections.observableArrayList();

    /**
     * set the parent controller of the course management page and initialize the table view
     * @param location the location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resources resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        courseObservableList.clear();
        List<Course> courses = CourseManager.getInstance().getCourses();
        courseObservableList.addAll(courses);
        tableView.setItems(courseObservableList);
        courseNameCol.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
        courseIDCol.setCellValueFactory(new PropertyValueFactory<Course, String>("courseID"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<Course, String>("category"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<Course, String>("score"));

    }

    /**
     * set the parent controller of the course management page
     * @param event the mouse event that triggered the method call
     */
    @FXML
    public void gpaCalculate(MouseEvent event) {
        double totalGradePoints = 0;
        int numCourses = 0;

        for (Course course : tableView.getItems()) {
            String gradeText = scoreCol.getCellObservableValue(course).getValue();
            double grade = Double.parseDouble(gradeText);
            totalGradePoints += grade;
            numCourses++;
        }

        double gpa = convertToGradePoints(totalGradePoints / numCourses);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Your GPA is: " + gpa);
            alert.show();

    }

    /**
     * set the parent controller of the course management page
     * @param grade the grade to be converted to grade points
     * @return double
     */
    public double convertToGradePoints(double grade) {
        if (grade >= 90) {
            return 4.0;
        } else if (grade >= 80) {
            return 3.0;
        } else if (grade >= 70) {
            return 2.0;
        } else if (grade >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }


    /**
     * modify course information in the table view
     * @param event the mouse event that triggered the method call
     */
    @FXML
    public void modifyCourse(MouseEvent event) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Course selectedCourse = tableView.getSelectionModel().getSelectedItem();
            CourseSettingViewController controller = (CourseSettingViewController) ViewManager.newWindow("courseSettingView.fxml");
            controller.setCourse(selectedCourse);
            controller.setParentController(this);
        } else {
            Alert nullWarning = new Alert(Alert.AlertType.ERROR, "Please select a course in the table");
            nullWarning.setHeaderText("No courses selected");
            nullWarning.show();
        }
    }

    /**
     * delete course information from the table view
     * @param event the mouse event that triggered the method call
     */
    @FXML
    void removeCourse(MouseEvent event) {
        if (tableView.getSelectionModel().getSelectedItems().size() >= 1) {
            Alert delWarning = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete the selected course information?");
            delWarning.setHeaderText("Click to delete the course");
            delWarning.setTitle("");
            Optional<ButtonType> op = delWarning.showAndWait();
            if (op.get() == ButtonType.OK) {
                for (Course selectedStudentSingle : tableView.getSelectionModel().getSelectedItems()) {
                    CourseManager.getInstance().removeCourse(selectedStudentSingle);
                }
                initialize(null, null);
            }
        } else {
            Alert nullWarning = new Alert(Alert.AlertType.ERROR, "Please select at least one course in the table");
            nullWarning.setHeaderText("None of the courses selected");
            nullWarning.show();
        }
    }

    /**
     * create a new course
     * @param event the mouse event that triggered the method call
     */
    @FXML
    public void createNewAccount(MouseEvent event) {
        NewCourseViewController controller = (NewCourseViewController) ViewManager.newWindow("newCourseView.fxml");
        controller.setParentController(this);
    }

    /**
     * search by name in the table view and display the search results
     * @param event the mouse event that triggered the method call
     */
    @FXML
    public void searchByName(MouseEvent event) {
        searchedList.clear();
        String courseName = searchText.getText();
        for (Course course : CourseManager.getInstance().getCourses()) {
            if (course.getCourseName().contains(courseName)) {
                searchedList.add(course);
            }
        }
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        courseObservableList.clear();
        courseObservableList.addAll(searchedList);
        tableView.setItems(courseObservableList);
        courseNameCol.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
        courseIDCol.setCellValueFactory(new PropertyValueFactory<Course, String>("courseID"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<Course, String>("category"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<Course, String>("score"));
    }

    /**
     * cancel search and display all the courses in the table view
     * @param event the mouse event that triggered the method call
     */
    @FXML
    public void cancelSearch(MouseEvent event) {
        initialize(null, null);
        searchText.setText("");
    }

    /**
     * set parent controller
     * @param controller the controller of the main page
     */
    public void setParentController(StudentMainViewController controller) {
        studentMainViewController = controller;
    }


    /**
     * back to main page and close the current window
     * @param event the mouse event that triggered the method call
     */
    public void backToMainPage(MouseEvent event) {
        StudentMainViewController controller = (StudentMainViewController) ViewManager.newWindow("studentMainView.fxml");
        controller.setParentControllerCourseManagement(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }

}
