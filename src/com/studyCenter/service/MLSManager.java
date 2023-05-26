package com.studyCenter.service;

import com.studyCenter.entity.ModelListShow;
import com.studyCenter.util.FileOperator;

import java.util.List;

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
