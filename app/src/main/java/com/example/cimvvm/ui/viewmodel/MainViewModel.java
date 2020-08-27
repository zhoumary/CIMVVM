package com.example.cimvvm.ui.viewmodel;

import android.database.Cursor;
import android.view.View;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.fragment.app.FragmentActivity;

import com.example.cimvvm.BR;
import com.example.cimvvm.data.adapter.MatchAdapter;
import com.example.cimvvm.data.bean.Match;
import com.example.cimvvm.ui.view.LoginDialog;
import com.example.cimvvm.ui.view.MainActivity;
import com.example.cimvvm.util.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends BaseObservable {
    private static final String TAG = "MainViewModel";
    private MatchAdapter matchAdapter;
    private List<Match> matches;
    private DatabaseHelper databaseHelper;
    private LoginDialog loginDialog;
    private MainActivity activity;

    public MainViewModel(DatabaseHelper mDatabaseHelper, MainActivity mainActivity) {
        matches = new ArrayList<>();
        matchAdapter = new MatchAdapter();
        databaseHelper = mDatabaseHelper;
        activity = mainActivity;
    }

    public void setUp(DatabaseHelper mDatabaseHelper) {
        // perform set up tasks, such as adding listeners, data population, etc.
        populateData(mDatabaseHelper);
    }

    public void tearDown() {
        // perform tear down tasks, such as removing listeners
    }

    @Bindable
    public List<Match> getData() {
        return this.matches;
    }

    @Bindable
    public MatchAdapter getAdapter() {
        return this.matchAdapter;
    }

    private void populateData(DatabaseHelper mDatabaseHelper) {
        // 加载下载的数据
        Match match = new Match();
        // get downloaded match data from "match_table"
        Cursor matchCursor = mDatabaseHelper.getMatchData();

        if (matchCursor != null) {
            List<Match> matchesList = new ArrayList<>();
            while (matchCursor.moveToNext()) {
                String matchID = matchCursor.getString(1);
                String matchName = matchCursor.getString(2);
                String matchScore = matchCursor.getString(3);
                Match oneMatch = new Match(matchName, matchID, matchScore);
                matchesList.add(oneMatch);
            }
            matches = matchesList;
            notifyPropertyChanged(BR.data);
        } else {

        }
    }

    public void onOpenDownloadDialog(View view) {
        // 获取login_table最后一条登录数据
        Cursor loginCursor = databaseHelper.getData();

        if (loginCursor != null) {
            String urlStringBuilder = "";
            String userNameStringBuilder = "";
            String passwordStringBuilder = "";

            while (loginCursor.moveToNext()) {
                if (loginCursor.moveToLast()) {
                    urlStringBuilder = loginCursor.getString(1);
                    userNameStringBuilder = loginCursor.getString(2);
                    passwordStringBuilder = loginCursor.getString(3);
                }
            }

            loginDialog = new LoginDialog(urlStringBuilder, userNameStringBuilder, passwordStringBuilder);
            loginDialog.show(activity.getSupportFragmentManager(), "login dialog");
        }
    }
}
