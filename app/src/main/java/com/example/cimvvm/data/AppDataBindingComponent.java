package com.example.cimvvm.data;

import androidx.databinding.DataBindingComponent;

public class AppDataBindingComponent implements DataBindingComponent {

    @Override
    public RecyclerViewDataBinding getRecyclerViewDataBinding() {
        return new RecyclerViewDataBinding();
    }
}
