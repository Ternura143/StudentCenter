package com.studyCenter.controller;

import com.jfoenix.controls.JFXButton;
import com.studyCenter.view.ViewManager;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.net.URL;
import java.util.ResourceBundle;

/*
 * @Author DengYimo
 * @Date  4:58
 * @Description 这是登录主页面的控制器类
 * @Since version-1.0
 */
public class LoginViewController implements Initializable {
    @FXML
    private StackPane basicLayer;
    @FXML
    private AnchorPane mainLayer;
    @FXML
    private AnchorPane moveLayer;
    @FXML
    private JFXButton toAdminPage;
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label s1;
    @FXML
    private Label s2;
    @FXML
    private Label s3;
    @FXML
    private JFXButton toStudentPage;
    @FXML
    private Label studentTitle;
    @FXML
    private Label adminTitle;
    @FXML
    private Label studentTips;
    @FXML
    private Label adminTips;
    @FXML
    private JFXButton studentLoginBtn;
    @FXML
    private JFXButton adminLoginBtn;
    @FXML
    private TextField studentUsername;
    @FXML
    private Label studentPWForgot;
    @FXML
    private PasswordField studentPassword;
    @FXML
    private TextField adminUserName;
    @FXML
    private PasswordField adminPassword;
    @FXML
    private Label adminPWForgot;
    @FXML
    private AnchorPane loginLayer;
    @FXML
    private JFXButton otherAccess1;
    @FXML
    private JFXButton otherAccess2;
    @FXML
    private JFXButton otherAccess3;
    @FXML
    private Label Exit;

//    private AdminMainViewController adminMainViewController;
    private StudentMainViewController studentMainViewController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        s1.setVisible(false);
        s2.setVisible(false);
        s3.setVisible(false);
        toStudentPage.setVisible(false);
        adminTips.setVisible(false);
        adminTitle.setVisible(false);
        adminLoginBtn.setVisible(false);
        adminUserName.setVisible(false);
        adminPassword.setVisible(false);
        adminPWForgot.setVisible(false);
        studentUsername.setVisible(true);
        studentPWForgot.setVisible(true);
        studentPassword.setVisible(true);
    }

    @FXML
    private void btn(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(moveLayer);

        slide.setToX(491);
        slide.play();

        loginLayer.setTranslateX(-309);
        adminLoginBtn.setVisible(true);
        adminTips.setVisible(true);
        adminTitle.setVisible(true);

        s1.setVisible(true);
        s2.setVisible(true);
        s3.setVisible(true);
        toStudentPage.setVisible(true);
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        moveLayer.setStyle("-fx-background-color: linear-gradient(to bottom left, #A868A0, #2D75E8);");
        otherAccess1.setStyle("-fx-background-color: linear-gradient(to bottom left, #A868A0, #2D75E8); -fx-background-radius: 300");
        otherAccess2.setStyle("-fx-background-color: linear-gradient(to bottom left, #A868A0, #2D75E8); -fx-background-radius: 300");
        otherAccess3.setStyle("-fx-background-color: linear-gradient(to bottom left, #A868A0, #2D75E8); -fx-background-radius: 300");
        toAdminPage.setVisible(false);
        studentTips.setVisible(false);
        studentTitle.setVisible(false);
        studentLoginBtn.setVisible(false);
        adminUserName.setVisible(true);
        adminPassword.setVisible(true);
        adminPWForgot.setVisible(true);
        studentUsername.setVisible(false);
        studentPWForgot.setVisible(false);
        studentPassword.setVisible(false);

        slide.setOnFinished((e->{
        }));
    }

    @FXML
    private void btn2(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(moveLayer);

        slide.setToX(0);
        slide.play();

        loginLayer.setTranslateX(0);
        adminLoginBtn.setVisible(false);
        adminTips.setVisible(false);
        adminTitle.setVisible(false);

        s1.setVisible(false);
        s2.setVisible(false);
        s3.setVisible(false);
        toStudentPage.setVisible(false);
        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        moveLayer.setStyle("-fx-background-color:linear-gradient(to bottom left, #0250c5 0%, #d43f8d 100%);");
        otherAccess1.setStyle("-fx-background-color: linear-gradient(to bottom left, #0250c5 0%, #d43f8d 100%); -fx-background-radius: 300");
        otherAccess2.setStyle("-fx-background-color: linear-gradient(to bottom left, #0250c5 0%, #d43f8d 100%); -fx-background-radius: 300");
        otherAccess3.setStyle("-fx-background-color: linear-gradient(to bottom left, #0250c5 0%, #d43f8d 100%); -fx-background-radius: 300");
        toAdminPage.setVisible(true);
        studentTips.setVisible(true);
        studentTitle.setVisible(true);
        studentLoginBtn.setVisible(true);
        adminUserName.setVisible(false);
        adminPassword.setVisible(false);
        adminPWForgot.setVisible(false);
        studentUsername.setVisible(true);
        studentPWForgot.setVisible(true);
        studentPassword.setVisible(true);

        slide.setOnFinished((e->{
        }));
    }

    @FXML
    private void studentLoginBtn() {
        if("student".equals(studentUsername.getText())||"user".equals(studentUsername.getText())||"西天主".equals(studentUsername.getText())||"红孩儿".equals(studentUsername.getText())||"牛魔王".equals(studentUsername.getText())||"孙悟空".equals(studentUsername.getText())&&"123456".equals(studentPassword.getText())){
            studentSign();
            Stage stage = (Stage)Exit.getScene().getWindow();
            stage.close();
            String tilte = "Sign In";
            String message = studentUsername.getText() + " log in!";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
        }else if (!"student".equals(studentUsername.getText()) || !"123456".equals(studentPassword.getText())){
            String tilte = "Sign In";
            String message = "Error Student Information ";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));
        }

    }

    private void studentSign() {
        StudentMainViewController controller = (StudentMainViewController) ViewManager.newWindow("studentMainView.fxml");
        controller.setParentControllerLogin(this);
    }


//    private void adminSign() {
//        AdminMainViewController controller = (AdminMainViewController) ViewManager.newWindow("adminMainView.fxml");
//        controller.setParentController(this);
//    }


    @FXML
    private void adminLoginBtn() {
        if("admin".equals(adminUserName.getText())&&"123456".equals(adminPassword.getText())){
//            adminSign();
            Stage stage = (Stage)Exit.getScene().getWindow();
            stage.close();
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Sign In");
            tray.setMessage(adminUserName.getText() + " log in!");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
        }else if (!"admin".equals(adminUserName.getText()) || !"123456".equals(adminPassword.getText())){
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle("Sign In");
            tray.setMessage("Error Admin Information");
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));
        }
    }

    @FXML
    void enterPressedAdmin(KeyEvent event) throws Exception {
        if(event.getCode() == KeyCode.ENTER) {
            adminLoginBtn();
        }
    }

    @FXML
    void enterPressedStudent(KeyEvent event) throws Exception {
        if(event.getCode() == KeyCode.ENTER) {
            studentLoginBtn();
        }
    }

    @FXML
    public void exitLoginPage(MouseEvent event){
        Stage stage = (Stage)Exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void exitBtnToRed(MouseEvent event){
        Exit.setTextFill(Paint.valueOf("Red"));
    }

    @FXML
    public void exitBtnToPurple(MouseEvent event){
        Exit.setTextFill(Paint.valueOf("#3F2B63"));
    }

    @FXML
    public void forgotRemindAdmin(MouseEvent event) {
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.FADE;

        tray.setAnimationType(type);
        tray.setTitle("默认管理员");
        tray.setMessage("账号：admin\n密码: 123456");
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss(Duration.millis(3000));
    }

    @FXML
    public void forgotRemindStudent(MouseEvent event) {
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.FADE;

        tray.setAnimationType(type);
        tray.setTitle("默认员工");
        tray.setMessage("账号: student\n密码: 123456");
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss(Duration.millis(100));
    }

//    public void setParentControllerAdmin(AdminMainViewController controller) {
//        adminMainViewController = controller;
//    }

    public void setParentControllerStudent(StudentMainViewController controller) {
        studentMainViewController = controller;
    }

}

