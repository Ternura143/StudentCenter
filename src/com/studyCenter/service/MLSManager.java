package com.studyCenter.service;

import com.studyCenter.entity.ModelListShow;
import com.studyCenter.util.FileOperator;

import java.util.List;

/**
 * MLSManager is a singleton class that manages the ModelListShow objects.
 * It implements the AbstractTSM interface.
 * It has a list of ModelListShow objects.
 * It has a private constructor and a public static method getInstance() to get the singleton instance.
 * It has a method addModelListShow() to add an ModelListShow object to the list.
 * It has a method removeModelListShow() to remove an ModelListShow object from the list.
 * It has a method getModelListShows() to get the list of ModelListShow objects.
 */
public class MLSManager {
    private List<ModelListShow> modelListShowList;
    private static MLSManager singletonInstance;

    private MLSManager() {
        modelListShowList = FileOperator.loadData("ModelListShows.json", ModelListShow.class);
    }

    //Singleton Pattern
    public static MLSManager getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new MLSManager();
        }
        return singletonInstance;
    }
    //Add
    public boolean addModelListShow(ModelListShow modelListShow) {
        modelListShowList.add(modelListShow);
        FileOperator.writeData(modelListShow, "ModelListShows.json");
        return true;
    }
    //Delete
    public void removeModelListShow(ModelListShow modelListShow) {
        modelListShowList.remove(modelListShow);
        FileOperator.writeData(modelListShowList, "ModelListShows.json");
    }

    public List<ModelListShow> getModelListShows() {
        return modelListShowList;
    }
}
