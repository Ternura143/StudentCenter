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
/*
 * @Author DengYimo
 * @Date  5:01
 * @Description 这是员工新建员工界面的控制器类
 * @Since version-1.0
 */
public class   NewAwardViewController implements Initializable {
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
/*
 * @Author DengYimo
 * @Date  5:01
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentController(ShowAwardViewController controller) {
        showAwardViewController = controller;
    }
/*
 * @Author DengYimo
 * @Date  5:01
 * @Description This is description of method
 * @Param [location, resources]
 * @Return void
 * @Since version-1.0
 */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
/*
 * @Author DengYimo
 * @Date  5:01
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    @FXML
    void close() {
        ShowAwardViewController controller = (ShowAwardViewController) ViewManager.newWindow("ShowAwardView.fxml");
        controller.setParentControllerNewAward(this);
        Stage currentStage = (Stage) exitLabel.getScene().getWindow();
        currentStage.close();
    }
/*
 * @Author DengYimo
 * @Date  5:01
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    void clearText(MouseEvent event) {
        idField.setText("");
        contentField.setText("");
        modeField.setText("");
    }
/*
 * @Author DengYimo
 * @Date  5:08
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    void registHandled(MouseEvent event) {
        String id = idField.getText();
        String content = contentField.getText();
        String mode = modeField.getText();

        if (id.equals("") && content.equals("") && mode.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "核对一下再试试吧");
            alert.setHeaderText("信息输入不能有空值");
            alert.show();
        }

        if (checkBox.isSelected()) {
            AwardShow awardShow = new AwardShow(id, content, mode);
            if (AwardShowManager.getInstance().addAwardShow(awardShow)) {
                Alert regSuccess = new Alert(Alert.AlertType.INFORMATION, "新的问题已添加");
                regSuccess.setHeaderText("添加成功");
                regSuccess.showAndWait();
                showAwardViewController.initialize(null, null);
                close();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "请勾选同意协议");
            alert.setHeaderText("");
            alert.show();
        }
    }

}
