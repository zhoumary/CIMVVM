package com.example.cimvvm;

import android.app.Application;

import androidx.databinding.DataBindingUtil;

import com.example.cimvvm.data.AppDataBindingComponent;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
    }
}
