package com.example.cimvvm.data.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.ArrayList;

public class MatchFormation extends BaseObservable {
    private String formationID;
    private String formationTitle;
    private ArrayList<FormationPositions> positions;

    public MatchFormation(String formationID, String formationTitle, ArrayList<FormationPositions> positions) {
        this.formationID = formationID;
        this.formationTitle = formationTitle;
        this.positions = positions;
    }

    @Bindable
    public String getFormationID() {
        return formationID;
    }

    @Bindable
    public void setFormationID(String formationID) {
        this.formationID = formationID;
    }

    @Bindable
    public String getFormationTitle() {
        return formationTitle;
    }

    @Bindable
    public void setFormationTitle(String formationTitle) {
        this.formationTitle = formationTitle;
    }

    @Bindable
    public void setPositions(ArrayList<FormationPositions> positions) {
        this.positions = positions;
    }

    @Bindable
    public ArrayList<FormationPositions> getPositions() {
        return positions;
    }
}
