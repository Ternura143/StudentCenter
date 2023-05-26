package com.studyCenter.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.studyCenter.entity.AwardShow;
import com.studyCenter.service.AwardShowManager;
import com.studyCenter.view.ViewManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller for new award show window
 */
public class NewAwardViewController implements Initializable {
    @FXML
    private TextField idField;
    @FXML
    private TextField contentField;
    @FXML
    private TextField modeField;
    @FXML
    private JFXButton clearBtn;
    @FXML
    private JFXButton saveBtn;
    @FXML
    private Label exitLabel;
    @FXML
    private JFXCheckBox checkBox;

    private ShowAwardViewController showAwardViewController;

    /**
     * set parent controller
     * @param controller ShowAwardViewController
     */
    public void setParentController(ShowAwardViewController controller) {
        showAwardViewController = controller;
    }

    /**
     * initialize the controller
     * @param location  URL location
     * @param resources ResourceBundle resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * close the window
     */
    @FXML
    void close() {
        ShowAwardViewController controller = (ShowAwardViewController) ViewManager.newWindow("ShowAwardView.fxml");
        controller.setParentControllerNewAward(this);
        Stage currentStage = (Stage) exitLabel.getScene().getWindow();
        currentStage.close();
    }

    /**
     * clear the text
     * @param event MouseEvent event
     */
    @FXML
    void clearText(MouseEvent event) {
        idField.setText("");
        contentField.setText("");
        modeField.setText("");
    }

    /**
     * save the new award show
     * @param event MouseEvent event
     */
    @FXML
    void registHandled(MouseEvent event) {
        String id = idField.getText();
        String content = contentField.getText();
        String mode = modeField.getText();

        if (id.equals("") && content.equals("") && mode.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Check and try again");
            alert.setHeaderText("No null values for message input");
            alert.show();
        }

        if (checkBox.isSelected()) {
            AwardShow awardShow = new AwardShow(id, content, mode);
            if (AwardShowManager.getInstance().addAwardShow(awardShow)) {
                Alert regSuccess = new Alert(Alert.AlertType.INFORMATION, "New events have been added");
                regSuccess.setHeaderText("Added successfully");
                regSuccess.showAndWait();
                showAwardViewController.initialize(null, null);
                close();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please check the agreement");
            alert.setHeaderText("");
            alert.show();
        }
    }

}
