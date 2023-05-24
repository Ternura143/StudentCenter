package com.studyCenter.controller;

import com.jfoenix.controls.JFXButton;
import com.studyCenter.entity.Student;
import com.studyCenter.entity.Type;
import com.studyCenter.service.UserManager;
import com.studyCenter.view.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/*
 * @Author DengYimo
 * @Date  4:54
 * @Description 这是主页面的控制器类
 * @Since version-1.0
 */
public class AdminMainViewController implements Initializable {

    @FXML
    private TableView<Student> tableView;
    @FXML
    private ComboBox<Type> chooseTitle;
    @FXML
    private Button createAccount;
    @FXML
    private JFXButton closePage;
    @FXML
    private Button deleteAccount;
    @FXML
    private Label exitAccount;
    @FXML
    private TableColumn<Student, String> usernameCol;
    @FXML
    private TableColumn<Student, String> nameCol;
    @FXML
    private TableColumn<Student, String> birthdayCol;
    @FXML
    private TableColumn<Student, String> titleCol;
    @FXML
    private TableColumn<Student, String> specialtyCol;
    @FXML
    private TableColumn<Student, String> idCol;
    @FXML
    private TableColumn<Student, String> contactCol;
    @FXML
    private TableColumn<Student, String> passwordEater;

    private ObservableList<Student> studentObservableList = FXCollections.observableArrayList();

    private LoginViewController loginViewController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        studentObservableList.clear();
        List<Student> students = UserManager.getInstance().getStudents();
        studentObservableList.addAll(students);
        tableView.setItems(studentObservableList);
        birthdayCol.setCellValueFactory(new PropertyValueFactory<Student, String>("birthday"));
        specialtyCol.setCellValueFactory(new PropertyValueFactory<Student, String>("specialty"));
        titleCol.setCellValueFactory(new PropertyValueFactory<Student, String>("title"));
        contactCol.setCellValueFactory(new PropertyValueFactory<Student, String>("contact"));
        idCol.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("account"));
        passwordEater.setCellValueFactory(new PropertyValueFactory<Student, String>("password"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
    }

    @FXML
    void modifyStudent(MouseEvent event) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Student selectedStudent = tableView.getSelectionModel().getSelectedItem();
            NewStudentSettingViewController controller = (NewStudentSettingViewController) ViewManager.newWindow("studentSettingView.fxml");
            controller.setStudent(selectedStudent);
            controller.setParentController(this);
        } else {
            Alert nullWarning = new Alert(Alert.AlertType.ERROR, "请选中表格中一名员工");
            nullWarning.setHeaderText("未选中任何一名员工！");
            nullWarning.show();
        }
    }

    public void setParentController(LoginViewController controller) {
        loginViewController = controller;
    }

    @FXML
    public void closeAdminPage(MouseEvent event) {
        Stage stage = (Stage) closePage.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void exitBtnToRed(MouseEvent event) {
        closePage.setTextFill(Paint.valueOf("Red"));
    }

    @FXML
    public void exitBtnToPurple(MouseEvent event) {
        closePage.setTextFill(Paint.valueOf("#33277b"));
    }

//    @FXML
//    public void createNewAccount(MouseEvent event) {
//        NewStudentViewController controller = (NewStudentViewController) ViewManager.newWindow("newStudentView.fxml");
//        controller.setParentController(this);
//    }

    @FXML
    public void logoutAccount(MouseEvent event) {
        Stage stage = (Stage) closePage.getScene().getWindow();
        stage.close();
        LoginViewController controller = (LoginViewController) ViewManager.newWindow("loginView.fxml");
        controller.setParentControllerAdmin(this);
    }

    @FXML
    void removeStudent(MouseEvent event) {
        if (tableView.getSelectionModel().getSelectedItems().size() >= 1) {
            Alert delWarning = new Alert(Alert.AlertType.CONFIRMATION, "确定删除所选员工吗？");
            delWarning.setHeaderText("点击确认删除账号");
            delWarning.setTitle("");
            Optional<ButtonType> op = delWarning.showAndWait();
            if (op.get() == ButtonType.OK) {
                for (Student selectedStudentSingle : tableView.getSelectionModel().getSelectedItems()) {
                    UserManager.getInstance().removeStudent(selectedStudentSingle);
                }
                initialize(null, null);
            }
        } else {
            Alert nullWarning = new Alert(Alert.AlertType.ERROR, "请选中表格中至少一名员工");
            nullWarning.setHeaderText("未选中任何一名员工！");
            nullWarning.show();
        }
    }

}
