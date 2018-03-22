package com.example.koncia.pairprograming;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_login_edit)
    EditText loginText;

    @BindView(R.id.main_password_edit)
    EditText passwordText;

    @BindView(R.id.main_login_button)
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    public void login(View view) {
        if (!loginText.getText().toString().equals("") && !passwordText.getText().toString().equals("")){
            Intent intent = new Intent(this, SampleListViewActivity.class);
            startActivity(intent);
        }
    }
}
