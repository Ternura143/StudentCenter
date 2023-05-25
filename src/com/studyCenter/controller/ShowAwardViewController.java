package com.studyCenter.controller;

import com.studyCenter.entity.AwardShow;
import com.studyCenter.service.AwardShowManager;
import com.studyCenter.view.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShowAwardViewController implements Initializable {
    @FXML
    private TableView<AwardShow> tableView;
    @FXML
    private TableColumn<AwardShow, String> idCol;
    @FXML
    private TableColumn<AwardShow, String> contentCol;
    @FXML
    private TableColumn<AwardShow, String> modeCol;
    @FXML
    private Label exitLabel;

    private ObservableList<AwardShow> awardShowObservableList = FXCollections.observableArrayList();

    private AwardManagementViewController awardManagementViewController;

    private NewAwardViewController newAwardViewController;

    public void setParentController(AwardManagementViewController controller) {
        awardManagementViewController = controller;
    }

    public void setParentControllerNewAward(NewAwardViewController controller) {
        newAwardViewController = controller;
    }

    @FXML
    public void newProblem(MouseEvent event) {
        NewAwardViewController controller = (NewAwardViewController) ViewManager.newWindow("newAwardView.fxml");
        controller.setParentController(this);
        Stage currentStage = (Stage) exitLabel.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    public void close(MouseEvent event) {
        AwardManagementViewController controller = (AwardManagementViewController) ViewManager.newWindow("awardManagementView.fxml");
        controller.setParentControllerShow(this);
        Stage currentStage = (Stage) exitLabel.getScene().getWindow();
        currentStage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        awardShowObservableList.clear();
        List<AwardShow> awardShows = AwardShowManager.getInstance().getAwardShows();
        awardShowObservableList.addAll(awardShows);
        tableView.setItems(awardShowObservableList);
        idCol.setCellValueFactory(new PropertyValueFactory<AwardShow, String>("id"));
        contentCol.setCellValueFactory(new PropertyValueFactory<AwardShow, String>("content"));
        modeCol.setCellValueFactory(new PropertyValueFactory<AwardShow, String>("mode"));
    }
}
