package com.example.cimvvm.ui.viewmodel;

import android.text.TextUtils;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.cimvvm.data.bean.Match;

public class MainItemVeiwModel extends BaseObservable {
    private Match match;

    public MainItemVeiwModel(Match matchModel) {
        match = matchModel;
    }

    public void setUp() {
        // perform set up tasks, such as adding listeners
    }

    public void tearDown() {
        // perform tear down tasks, such as removing listeners
    }

    @Bindable
    public String getID() {
        return !TextUtils.isEmpty(match.getItem_id()) ? match.getItem_id() : "";
    }

    @Bindable
    public String getTitle() {
        return !TextUtils.isEmpty(match.getTitle()) ? match.getTitle() : "";
    }

    @Bindable
    public String getScore() {
        return !TextUtils.isEmpty(match.getSource()) ? match.getSource() : "";
    }
}
