package com.studyCenter.controller;

import com.jfoenix.controls.JFXButton;
import com.studyCenter.entity.Database;
import com.studyCenter.entity.Course;
import com.studyCenter.service.CourseManager;
import com.studyCenter.entity.building.Building;
import com.studyCenter.entity.building.Level;
import com.studyCenter.entity.building.StudyRoomApplication;
import com.studyCenter.entity.building.Room;
import com.studyCenter.view.ViewManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class StudyRoomManagementViewController implements Initializable {
    private ObservableList<Room> studyRoomList = FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<Course> studyAplicationCourseChoice;
    @FXML
    private TextField studyApplicationTimeField;
    @FXML
    private TextField studySearchField;
    @FXML
    private TableView<Room> studyTableView;
    @FXML
    private JFXButton backToMain;

    private StudentMainViewController studentMainViewController;

    public void setParentController(StudentMainViewController controller) {
        studentMainViewController = controller;
    }

    @FXML
    public void backToMainPage(MouseEvent event) {
        StudentMainViewController controller = (StudentMainViewController) ViewManager.newWindow("studentMainView.fxml");
        controller.setParentControllerStudyRoom(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    private void studySearchFieldKeyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            studyRoomSearchButtonFired();
        }
    }

    @FXML
    private void studyRoomSearchButtonFired() {
        if(studySearchField.getText().equals("")) {
            Course course = studyAplicationCourseChoice.getSelectionModel().getSelectedItem();
            String s = studyApplicationTimeField.getText();
            initialize(null,null);
            studyAplicationCourseChoice.getSelectionModel().select(course);
            studyApplicationTimeField.setText(s);
            return ;
        }
        ArrayList<Room> rooms = new ArrayList<Room>();
        for(Building buidling : Database.getInstance().getBuildings()) {
            for(Level level : buidling.getLevels()) {
                for(Room room : level.getRooms()) {
                    room.refreshApplicationTime();
                    if( room.isStudyRoom() && room.getStudyType() == room.getTypeByChinese(studySearchField.getText()) ) {
                        rooms.add(room);
                    }
                }
            }
        }
        studyRoomList.setAll(rooms);
    }
    @FXML
    private void studyRoomRefresh() {
        initialize(null,null);
    }
    @FXML
    private void studyRoomApplicationButtonFired() {
        if(studyTableView.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please select the room");
            alert.show();
            return ;
        }
        if(studyAplicationCourseChoice.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a course");
            alert.show();
            return ;
        }
        if(studyApplicationTimeField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter the application time(hour)");
            alert.show();
            return ;
        }
        Room room = studyTableView.getSelectionModel().getSelectedItem();
        Course course = studyAplicationCourseChoice.getSelectionModel().getSelectedItem();
        long time = Long.parseLong(studyApplicationTimeField.getText()) * StudyRoomApplication.TIMESCALE;
//    	room.getApplicationList().add(e);
//    	if(room)
        room.refreshApplicationTime();
        if(room.getApplicationList().size() >= room.getMaxCapacity()) {
            long mintime = Long.MAX_VALUE;
            long nowtime = new Date().getTime();
            for(StudyRoomApplication application : room.getApplicationList())
                mintime = Math.min(mintime, application.getStartTime().getTime() + application.getDurationTime());
            String s = "";
            if(mintime - nowtime < 60 * 1000) s = String.valueOf((mintime - nowtime) / 1000) + "s";
            else if(mintime - nowtime < 60 * 60 * 1000) s = String.valueOf((mintime - nowtime) / 60 / 1000) + "min"
                    +  String.valueOf((mintime - nowtime) / 1000 % 60) + "s";

            else if(mintime - nowtime < 60 * 60 * 60 * 1000) s = String.valueOf((mintime - nowtime) / 60 / 60 / 1000) + "hour"
                    + String.valueOf((mintime - nowtime) % (60 * 60 * 1000) / 60 / 1000) + "min"
                    +  String.valueOf((mintime - nowtime) % (60 * 1000) / 1000 % 60) + "s";
            Alert alert = new Alert(Alert.AlertType.ERROR, "The current number of applications is full, still need" + s);
            alert.show();
            return ;
        }
        room.getApplicationList().add(new StudyRoomApplication(new Date(), time, course, room));
        room.refreshApplicationTime();
        initialize(null,null);
        Database.saveToFile();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //初始化表格
        //[start]
        studySearchField.setText("");
        studyApplicationTimeField.setText("");
        studyRoomList.clear();
        for(Building buidling : Database.getInstance().getBuildings()) {
            for(Level level : buidling.getLevels()) {
                for(Room room : level.getRooms()) {
                    room.refreshApplicationTime();
                    if(room.isStudyRoom()) {
                        studyRoomList.add(room);
                    }
                }
            }
        }
        studyTableView.setItems(studyRoomList);
        studyTableView.getColumns().clear();
        TableColumn<Room, String> roomTypeColumn = new TableColumn<Room, String>("Room Type");
        TableColumn<Room, String> roomPositionColumn = new TableColumn<Room, String>("Location");
        TableColumn<Room, String> maxCapacityColumn = new TableColumn<Room, String>("Maximum Capacity");
        TableColumn<Room, String> resCapacityColumn = new TableColumn<Room, String>("Residual Capacity");
        roomTypeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Room,String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Room, String> param) {
                // TODO Auto-generated method stub
                SimpleStringProperty str = new SimpleStringProperty();
                str.setValue(param.getValue().getType(param.getValue().getStudyType()));
                return str;
            }
        });
        roomPositionColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Room,String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Room, String> param) {
                // TODO Auto-generated method stub
                SimpleStringProperty str = new SimpleStringProperty();
                Room room = param.getValue();
                Level level = room.getFather();
                Building building = level.getFather();
                str.setValue(building.getName() + "->"
                        + level.getName() + "->"
                        + room.getName());
                return str;
            }
        });
        maxCapacityColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Room,String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Room, String> param) {
                // TODO Auto-generated method stub

                return new SimpleStringProperty(String.valueOf(param.getValue().getMaxCapacity()));
            }
        });
        resCapacityColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Room,String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Room, String> param) {
                // TODO Auto-generated method stub

                return new SimpleStringProperty(String.valueOf(param.getValue().getResCapacity()));
            }
        });
        studyTableView.getColumns().add(roomTypeColumn);
        studyTableView.getColumns().add(roomPositionColumn);
        studyTableView.getColumns().add(maxCapacityColumn);
        studyTableView.getColumns().add(resCapacityColumn);
        studyTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //[end]
        studyAplicationCourseChoice.setConverter(new StringConverter<Course>() {
            @Override
            public String toString(Course object) {
                return object.getCourseName();
            }

            @Override
            public Course fromString(String string) {
                return null;
            }
        });
        //初始化choicebox
        studyAplicationCourseChoice.getItems().setAll(CourseManager.getInstance().getCourses());
        //输入框监听器
//    	studyAplicationCourseChoice.set
        studyApplicationTimeField.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // TODO Auto-generated method stub
                if(newValue == null) return ;
                if(!Pattern.matches("[0-9]{0,6}", newValue)) {
                    studyApplicationTimeField.setText(oldValue);
                }
            }
        });
    }
}
