package com.example.cimvvm.ui.view;
import com.example.cimvvm.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatDialogFragment;



public class LoginDialog extends AppCompatDialogFragment {
    private static final String TAG = "LoginDialog";

    private EditText editTextUrl;
    public String url;
    private String defaultUrl;
    private EditText editTextUserName;
    public String userName;
    private String defaultUserName;
    private EditText editTextPassword;
    public String password;
    private String defaultPassword;
    private Boolean isFirstOpen;

    public LoginDialog(String urlStr, String usernameStr, String passwordStr) {
        defaultUrl = urlStr;
        defaultUserName = usernameStr;
        defaultPassword = passwordStr;
        isFirstOpen = true;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_login, null);

        builder.setView(view)
                .setTitle("");

        editTextUrl = view.findViewById(R.id.edit_url);
        editTextUrl.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                url = editTextUrl != null ? editTextUrl.getText().toString() : "";
            }
        });

        editTextUserName = view.findViewById(R.id.edit_username);
        editTextUserName.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userName = editTextUserName != null ? editTextUserName.getText().toString() : "";
            }
        });

        editTextPassword = view.findViewById(R.id.edit_password);
        editTextPassword.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password = editTextPassword != null ? editTextPassword.getText().toString() : "";
            }
        });


        if (isFirstOpen) {
            editTextUrl.setText(defaultUrl);
            editTextUserName.setText(defaultUserName);
            editTextPassword.setText(defaultPassword);
            isFirstOpen = false;
        }

        return builder.create();
    }
}
