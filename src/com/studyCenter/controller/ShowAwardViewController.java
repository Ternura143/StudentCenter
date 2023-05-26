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

/**
 * controller of the showAwardView.fxml
 */
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

    /**
     * set the parent controller of the new window
     * @param controller the controller of the new window
     */
    public void setParentController(AwardManagementViewController controller) {
        awardManagementViewController = controller;
    }

    /**
     * set the parent controller of the new window
     * @param controller the controller of the new window
     */
    public void setParentControllerNewAward(NewAwardViewController controller) {
        newAwardViewController = controller;
    }

    /**
     * open a new window to create a new award show and close the current window
     * @param event mouse event of the button clicked 
     */
    @FXML
    public void newAward(MouseEvent event) {
        NewAwardViewController controller = (NewAwardViewController) ViewManager.newWindow("newAwardView.fxml");
        controller.setParentController(this);
        Stage currentStage = (Stage) exitLabel.getScene().getWindow();
        currentStage.close();
    }

    /**
     * delete the selected award show from the database and refresh the table view
     * @param event mouse event of the button clicked
     */
    @FXML
    public void close(MouseEvent event) {
        AwardManagementViewController controller = (AwardManagementViewController) ViewManager.newWindow("awardManagementView.fxml");
        controller.setParentControllerShow(this);
        Stage currentStage = (Stage) exitLabel.getScene().getWindow();
        currentStage.close();
    }


    /**
     * initialize the table view
     * @param location location of the .fxml file  to be loaded by FXMLLoader
     * @param resources resources to be used by FXMLLoader
     */
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
