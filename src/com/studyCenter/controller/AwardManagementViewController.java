package com.studyCenter.controller;

import com.jfoenix.controls.JFXButton;
import com.studyCenter.service.MLSManager;
import com.studyCenter.entity.*;
import com.studyCenter.view.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
/*
 * @Author DengYimo
 * @Date  5:04
 * @Description 这是模板管理主页面
 * @Since version-1.0
 */
public class AwardManagementViewController implements Initializable {
    @FXML
    private JFXButton backToMain;
    @FXML
    private JFXButton showBtn;
    @FXML
    private TableView<ModelListShow> tableView;
    @FXML
    private TableColumn<ModelListShow, String> idCol;
    @FXML
    private TableColumn<ModelListShow, String> contentCol;
    @FXML
    private TableColumn<ModelListShow, String> modeCol;
    @FXML
    private JFXButton delFileBtn;

    private StaffMainViewController staffMainViewController;
    private ShowAwardViewController showAwardViewController;

    private ObservableList<ModelListShow> MLSObservableList = FXCollections.observableArrayList();

    public void setParentController(StaffMainViewController controller) {
        staffMainViewController = controller;
    }

    public void setParentControllerShow(ShowAwardViewController controller) {
        showAwardViewController = controller;
    }

    public void backToMainPage(MouseEvent event) {
        StaffMainViewController controller = (StaffMainViewController) ViewManager.newWindow("staffMainView.fxml");
        controller.setParentControllerAwardManagement(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        MLSObservableList.clear();
        List<ModelListShow> courses = MLSManager.getInstance().getModelListShows();
        MLSObservableList.addAll(courses);
        tableView.setItems(MLSObservableList);
        idCol.setCellValueFactory(new PropertyValueFactory<ModelListShow, String>("id"));
        contentCol.setCellValueFactory(new PropertyValueFactory<ModelListShow, String>("content"));
        modeCol.setCellValueFactory(new PropertyValueFactory<ModelListShow, String>("mode"));
    }

    @FXML
    public void delAward(MouseEvent event) {
        if (tableView.getSelectionModel().getSelectedItems().size() >= 1) {
            Alert delWarning = new Alert(Alert.AlertType.CONFIRMATION, "确定删除所选奖项吗？");
            delWarning.setHeaderText("点击确认删除奖项");
            delWarning.setTitle("");
            Optional<ButtonType> op = delWarning.showAndWait();
            if (op.get() == ButtonType.OK) {
                for (ModelListShow selectedSingle : tableView.getSelectionModel().getSelectedItems()) {
                    MLSManager.getInstance().removeModelListShow(selectedSingle);
                }
                initialize(null, null);
            }
        } else {
            Alert nullWarning = new Alert(Alert.AlertType.ERROR, "请选中表格中至少一个奖项");
            nullWarning.setHeaderText("未选中任何一个奖项！");
            nullWarning.show();
        }
    }

    @FXML
    public void showAward(MouseEvent event) {
        ShowAwardViewController controller = (ShowAwardViewController) ViewManager.newWindow("showAwardView.fxml");
        controller.setParentController(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }
}
