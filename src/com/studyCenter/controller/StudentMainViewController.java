package com.studyCenter.controller;

import com.studyCenter.view.ViewManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/*
 * @Author DengYimo
 * @Date  5:03
 * @Description 这是员工主页面
 * @Since version-1.0
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
//    private BuildingMainViewController buildingMainViewController;
//    private CheckInInfoViewController checkInInfoViewController;

    public void setParentControllerLogin(LoginViewController controller) {
        loginViewController = controller;
    }

    public void setParentControllerCourseManagement(CourseManagementViewController controller) {
        courseManagementViewController = controller;
    }

    public void setParentControllerAwardManagement(AwardManagementViewController controller) {
        awardManagementViewController = controller;
    }

    public void setParentControllerProject(ProjectViewController controller) {
        projectViewController = controller;
    }

    public void setParentControllerStudyRoom(StudyRoomManagementViewController controller) {
        studyRoomManagementViewController = controller;
    }

//    public void setParentControllerBuilding(BuildingMainViewController controller) {
//        buildingMainViewController = controller;
//    }

//    public void setParentControllerCheckIn(CheckInInfoViewController controller) {
//        checkInInfoViewController = controller;
//    }

    @FXML
    public void exitButton(MouseEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void logoutButton(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        LoginViewController controller = (LoginViewController) ViewManager.newWindow("loginView.fxml");
        controller.setParentControllerStudent(this);
    }

    @FXML
    public void goToCourseManagement(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        CourseManagementViewController controller = (CourseManagementViewController) ViewManager.newWindow("courseManagementView.fxml");
        controller.setParentController(this);
    }

    @FXML
    public void goToOtherManagement(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        ProjectViewController controller = (ProjectViewController) ViewManager.newWindow("projectView.fxml");
        controller.setParentController(this);
    }

    @FXML
    public void goToAwardManagement(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        AwardManagementViewController controller = (AwardManagementViewController) ViewManager.newWindow("awardManagementView.fxml");
        controller.setParentController(this);
    }

    @FXML
    public void goToStudyRoomManagement(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        StudyRoomManagementViewController controller = (StudyRoomManagementViewController) ViewManager.newWindow("studyRoomManagementView.fxml");
        controller.setParentController(this);
    }

    @FXML
    public void goToBuildingManagement(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
//        BuildingMainViewController controller = (BuildingMainViewController) ViewManager.newWindow("buildingMainView.fxml");
//        controller.setParentController(this);
    }

    @FXML
    public void goToCheckInInfoManagement(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
    }

    public void setLoginViewController(LoginViewController loginViewController) {
        this.loginViewController = loginViewController;
    }
}
