package com.studyCenter.controller;

import com.studyCenter.view.ViewManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
controller of the studentMainView.fxml
 */
public class StudentMainViewController {
    @FXML
    private Button buildingManagement;
    @FXML
    private Button courseManagement;
    @FXML
    private Button modelManagement;
    @FXML
    private Button selfInfoBtn;
    @FXML
    private Button studyRoomBtn;
    @FXML
    private Button exitBtn;
    @FXML
    private Button logoutBtn;
    @FXML
    private Button goToCheckInInfo;

    private LoginViewController loginViewController;
    private CourseManagementViewController courseManagementViewController;
    private ProjectViewController projectViewController;
    private AwardManagementViewController awardManagementViewController;
    private StudyRoomManagementViewController studyRoomManagementViewController;


    /**
     * set the parent controller of the login view
     * @param controller the controller of the login view
     */
    public void setParentControllerLogin(LoginViewController controller) {
        loginViewController = controller;
    }

    /**
     * set the parent controller of the course view
     * @param controller the controller of the course view
     */
    public void setParentControllerCourseManagement(CourseManagementViewController controller) {
        courseManagementViewController = controller;
    }

    /**
     * set the parent controller of the award view
     * @param controller the controller of the award view
     */
    public void setParentControllerAwardManagement(AwardManagementViewController controller) {
        awardManagementViewController = controller;
    }

    /**
     * set the parent controller of the new window
     * @param controller the controller of the project view
     */
    public void setParentControllerProject(ProjectViewController controller) {
        projectViewController = controller;
    }

    /**
     * set the parent controller of the new window
     * @param controller the controller of the study room view
     */
    public void setParentControllerStudyRoom(StudyRoomManagementViewController controller) {
        studyRoomManagementViewController = controller;
    }


    /**
     * go to the exit view
     * @param event the mouse event of the button clicked
     */
    @FXML
    public void exitButton(MouseEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    /**
     * go to the logout view
     * @param event the mouse event of the button clicked
     */
    @FXML
    public void logoutButton(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        LoginViewController controller = (LoginViewController) ViewManager.newWindow("loginView.fxml");
        controller.setParentControllerStudent(this);
    }

    /**
     * go to the course management view
     * @param event the mouse event of the button clicked
     */
    @FXML
    public void goToCourseManagement(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        CourseManagementViewController controller = (CourseManagementViewController) ViewManager.newWindow("courseManagementView.fxml");
        controller.setParentController(this);
    }

    /**
     * go to the other management view
     * @param event the mouse event of the button clicked
     */
    @FXML
    public void goToOtherManagement(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        ProjectViewController controller = (ProjectViewController) ViewManager.newWindow("projectView.fxml");
        controller.setParentController(this);
    }

    /**
     * go to the award management view
     * @param event the mouse event of the button clicked
     */
    @FXML
    public void goToAwardManagement(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        AwardManagementViewController controller = (AwardManagementViewController) ViewManager.newWindow("awardManagementView.fxml");
        controller.setParentController(this);
    }

    /**
     * go to the study room management view
     * @param event the mouse event of the button clicked
     */
    @FXML
    public void goToStudyRoomManagement(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        StudyRoomManagementViewController controller = (StudyRoomManagementViewController) ViewManager.newWindow("studyRoomManagementView.fxml");
        controller.setParentController(this);
    }


    /**
     * go to the login view
     * @param loginViewController the controller of the new window
     */
    public void setLoginViewController(LoginViewController loginViewController) {
        this.loginViewController = loginViewController;
    }
}
