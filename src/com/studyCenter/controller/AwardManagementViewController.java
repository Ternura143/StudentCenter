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

/**
 * the controller of the award management page of the student
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

    private StudentMainViewController studentMainViewController;
    private ShowAwardViewController showAwardViewController;

    private ObservableList<ModelListShow> MLSObservableList = FXCollections.observableArrayList();


    /**
     * set the parent controller of the award management page
     * @param controller the controller of the main page
     */
    public void setParentController(StudentMainViewController controller) {
        studentMainViewController = controller;
    }

    /**
     * set the parent controller of the show award page
     * @param controller the controller of the show award page
     */
    public void setParentControllerShow(ShowAwardViewController controller) {
        showAwardViewController = controller;
    }

    /**
     * back to the main page
     * @param event the mouse event
     */
    public void backToMainPage(MouseEvent event) {
        StudentMainViewController controller = (StudentMainViewController) ViewManager.newWindow("studentMainView.fxml");
        controller.setParentControllerAwardManagement(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }

    /**
     * initialize the table view of the award management page
     * @param location the location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resources resources used to localize the root object, or null if the root object was not localized.
     */
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

    /**
     * delete the selected award
     * @param event the mouse event
     */
    @FXML
    public void delAward(MouseEvent event) {
        if (tableView.getSelectionModel().getSelectedItems().size() >= 1) {
            Alert delWarning = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete the selected award?");
            delWarning.setHeaderText("Confirm to delete award");
            delWarning.setTitle("");
            Optional<ButtonType> op = delWarning.showAndWait();
            if (op.get() == ButtonType.OK) {
                for (ModelListShow selectedSingle : tableView.getSelectionModel().getSelectedItems()) {
                    MLSManager.getInstance().removeModelListShow(selectedSingle);
                }
                initialize(null, null);
            }
        } else {
            Alert nullWarning = new Alert(Alert.AlertType.ERROR, "Please select at least one award in the form!");
            nullWarning.setHeaderText("None of the awards selected");
            nullWarning.show();
        }
    }

    /**
     * show the selected award
     * @param event the mouse event
     */
    @FXML
    public void showAward(MouseEvent event) {
        ShowAwardViewController controller = (ShowAwardViewController) ViewManager.newWindow("showAwardView.fxml");
        controller.setParentController(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }
}
