package com.example.cimvvm.data.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class FormationPositions extends BaseObservable {
    private int positionNumber;
    private Float x;
    private Float y;

    private String position;

    public FormationPositions(int positionNumber, Float x, Float y, String position) {
        this.positionNumber = positionNumber;
        this.x = x + 380;
        this.y = y;
        this.position = position;
    }

    @Bindable
    public String getPosition() {
        return position;
    }

    @Bindable
    public void setPosition(String position) {
        this.position = position;
    }

    @Bindable
    public int getPositionNumber() {
        return positionNumber;
    }

    @Bindable
    public void setPositionNumber(int positionNumber) {
        this.positionNumber = positionNumber;
    }

    @Bindable
    public Float getX() {
        return x;
    }

    @Bindable
    public void setX(Float x) {
        this.x = x;
    }

    @Bindable
    public Float getY() {
        return y;
    }

    @Bindable
    public void setY(Float y) {
        this.y = y;
    }
}
