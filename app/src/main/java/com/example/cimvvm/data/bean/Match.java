package com.example.cimvvm.data.bean;

import android.database.Cursor;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.cimvvm.util.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class Match extends BaseObservable {
    private String title;
    private String item_id;
    private String score;
    private ArrayList<MatchFormation> matchFormations;

    public Match(String title, String item_id, String score, ArrayList<MatchFormation> formations) {
        this.title = title;
        this.item_id = item_id;
        this.score = score;
        this.matchFormations = formations;
    }

    public Match(String matchName, String matchID, String matchScore) {
        this.title = matchName;
        this.item_id = matchID;
        this.score = matchScore;
    }

    public Match() {

    }

    @Bindable
    public void setTitle(String title) {
        this.title = title;
    }

    @Bindable
    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    @Bindable
    public void setSource(String score) {
        this.score = score;
    }

    @Bindable
    public void setMatchFormations(ArrayList<MatchFormation> matchFormations) {
        this.matchFormations = matchFormations;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    @Bindable
    public String getItem_id() {
        return item_id;
    }

    @Bindable
    public String getSource() {
        return score;
    }

    @Bindable
    public ArrayList<MatchFormation> getMatchFormations() {
        return matchFormations;
    }
}
