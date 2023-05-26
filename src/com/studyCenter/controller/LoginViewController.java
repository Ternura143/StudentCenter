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


/**
 * controller of the login page of the student
 */
public class LoginViewController implements Initializable {
    @FXML
    private StackPane basicLayer;
    @FXML
    private AnchorPane mainLayer;
    @FXML
    private AnchorPane moveLayer;
    @FXML
    private JFXButton toTeacherPage;
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
    private Label teacherTitle;
    @FXML
    private Label studentTips;
    @FXML
    private Label teacherTips;
    @FXML
    private JFXButton studentLoginBtn;
    @FXML
    private JFXButton teacherLoginBtn;
    @FXML
    private TextField studentUsername;
    @FXML
    private Label studentPWForgot;
    @FXML
    private PasswordField studentPassword;
    @FXML
    private TextField teacherUserName;
    @FXML
    private PasswordField teacherPassword;
    @FXML
    private Label teacherPWForgot;
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

    private StudentMainViewController studentMainViewController;

    /**
     * initialize the controller of the login page of the student
     * @param url url of the fxml file of the controller
     * @param rb resource bundle of the fxml file of the controller
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        s1.setVisible(false);
        s2.setVisible(false);
        s3.setVisible(false);
        toStudentPage.setVisible(false);
        teacherTips.setVisible(false);
        teacherTitle.setVisible(false);
        teacherLoginBtn.setVisible(false);
        teacherUserName.setVisible(false);
        teacherPassword.setVisible(false);
        teacherPWForgot.setVisible(false);
        studentUsername.setVisible(true);
        studentPWForgot.setVisible(true);
        studentPassword.setVisible(true);
    }

    /**
     * switch to the student main page
     * @param event event of the mouse click
     */
    @FXML
    private void btn(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(moveLayer);

        slide.setToX(491);
        slide.play();

        loginLayer.setTranslateX(-309);
        teacherLoginBtn.setVisible(true);
        teacherTips.setVisible(true);
        teacherTitle.setVisible(true);

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
        toTeacherPage.setVisible(false);
        studentTips.setVisible(false);
        studentTitle.setVisible(false);
        studentLoginBtn.setVisible(false);
        teacherUserName.setVisible(true);
        teacherPassword.setVisible(true);
        teacherPWForgot.setVisible(true);
        studentUsername.setVisible(false);
        studentPWForgot.setVisible(false);
        studentPassword.setVisible(false);

        slide.setOnFinished((e->{
        }));
    }

    /**
     * switch to the teacher main page
     * @param event event of the mouse click
     */
    @FXML
    private void btn2(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(moveLayer);

        slide.setToX(0);
        slide.play();

        loginLayer.setTranslateX(0);
        teacherLoginBtn.setVisible(false);
        teacherTips.setVisible(false);
        teacherTitle.setVisible(false);

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
        toTeacherPage.setVisible(true);
        studentTips.setVisible(true);
        studentTitle.setVisible(true);
        studentLoginBtn.setVisible(true);
        teacherUserName.setVisible(false);
        teacherPassword.setVisible(false);
        teacherPWForgot.setVisible(false);
        studentUsername.setVisible(true);
        studentPWForgot.setVisible(true);
        studentPassword.setVisible(true);

        slide.setOnFinished((e->{
        }));
    }

    /**
     * login as a student
     */
    @FXML
    private void studentLoginBtn() {
        if("student".equals(studentUsername.getText())||"user1".equals(studentUsername.getText())||"user2".equals(studentUsername.getText())||"user3".equals(studentUsername.getText())||"user4".equals(studentUsername.getText())&&"123456".equals(studentPassword.getText())){
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
        }else if ("student".equals(studentUsername.getText()) && "123456".equals(studentPassword.getText())){
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

    /**
     * sign in as a student
     */
    private void studentSign() {
        StudentMainViewController controller = (StudentMainViewController) ViewManager.newWindow("studentMainView.fxml");
        controller.setParentControllerLogin(this);
    }


    /**
     * login as a teacher
     */
    @FXML
    private void teacherLoginBtn() {
        if("teacher".equals(teacherUserName.getText())&&"123456".equals(teacherPassword.getText())){
            Stage stage = (Stage)Exit.getScene().getWindow();
            stage.close();
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Sign In");
            tray.setMessage(teacherUserName.getText() + " log in!");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
        }else if (!"teacher".equals(teacherUserName.getText()) || !"123456".equals(teacherPassword.getText())){
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle("Sign In");
            tray.setMessage("Error Teacher Information");
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));
        }
    }

    /**
     * switch to the teacher main page
     * @param event event of the mouse click
     */
    @FXML
    void enterPressedTeacher(KeyEvent event) throws Exception {
        if(event.getCode() == KeyCode.ENTER) {
            teacherLoginBtn();
        }
    }

    /**
     * switch to the student main page
     * @param event event of the mouse click
     */
    @FXML
    void enterPressedStudent(KeyEvent event) throws Exception {
        if(event.getCode() == KeyCode.ENTER) {
            studentLoginBtn();
        }
    }

    /**
     * exit the login page
     * @param event event of the mouse click
     */
    @FXML
    public void exitLoginPage(MouseEvent event){
        Stage stage = (Stage)Exit.getScene().getWindow();
        stage.close();
    }

    /**
     * change the color of the exit button
     * @param event event of the mouse click
     */
    @FXML
    public void exitBtnToRed(MouseEvent event){
        Exit.setTextFill(Paint.valueOf("Red"));
    }

    /**
     * change the color of the exit button
     * @param event event of the mouse click
     */
    @FXML
    public void exitBtnToPurple(MouseEvent event){
        Exit.setTextFill(Paint.valueOf("#3F2B63"));
    }

    /**
     * remind the teacher of the default account and password
     * @param event event of the mouse click
     */
    @FXML
    public void forgotRemindTeacher(MouseEvent event) {
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.FADE;

        tray.setAnimationType(type);
        tray.setTitle("Default Teacher");
        tray.setMessage("Account：teacher\nPassword: 123456");
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss(Duration.millis(3000));
    }

    /**
     * remind the student of the default account and password
     * @param event event of the mouse click
     */
    @FXML
    public void forgotRemindStudent(MouseEvent event) {
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.FADE;

        tray.setAnimationType(type);
        tray.setTitle("Default Student");
        tray.setMessage("Account: student\nPassword: 123456");
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss(Duration.millis(100));
    }


    /**
     * set the controller of the student main page
     * @param controller the controller of the student main page
     */
    public void setParentControllerStudent(StudentMainViewController controller) {
        studentMainViewController = controller;
    }

}

