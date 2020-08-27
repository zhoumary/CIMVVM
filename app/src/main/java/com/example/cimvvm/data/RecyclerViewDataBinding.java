package com.example.cimvvm.data;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cimvvm.data.adapter.MatchAdapter;
import com.example.cimvvm.data.bean.Match;

import java.util.List;

public class RecyclerViewDataBinding {

    /**
     * Binds the data to the {@link}, sets the
     * recycler view on the adapter, and performs some other recycler view initialization.
     *
     * @param recyclerView passed in automatically with the data binding
     * @param adapter      must be explicitly passed in
     * @param data         must be explicitly passed in
     */
    @BindingAdapter({"app:adapter", "app:data"})
    public void bind(RecyclerView recyclerView, MatchAdapter adapter, List<Match> data) {
        recyclerView.setAdapter(adapter);
        adapter.updateData(data);
    }
}
