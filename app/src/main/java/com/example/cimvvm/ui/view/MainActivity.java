package com.example.cimvvm.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.cimvvm.R;
import com.example.cimvvm.databinding.ActivityMainBinding;
import com.example.cimvvm.ui.viewmodel.MainViewModel;
import com.example.cimvvm.util.DatabaseHelper;

import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;


public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;

    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 设置navigation bar和action bar为透明
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // 配置SQLite数据库
        mDatabaseHelper = new DatabaseHelper(this);

        View view = bind();
        initRecyclerView(view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainViewModel.setUp(mDatabaseHelper);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainViewModel.tearDown();
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.data_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), VERTICAL));
    }

    private View bind() {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel(mDatabaseHelper, this);
        binding.setViewModel(mainViewModel);
        return binding.getRoot();
    }
}