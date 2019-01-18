package com.example.rickb.week2day4;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserInput.OnFragmentInteractionListener{
    UserInput userInput;
    DisplayOutput displayUserFragment;
    TextView tvAsync;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput = new UserInput();
        displayUserFragment = new DisplayOutput();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.flFlagPlaceholderOne, userInput).commit();
        fm.beginTransaction().replace(R.id.flFlagPlaceholderTwo, displayUserFragment).commit();
    }

    @Override
    public void SendtoOutput(String name, String email, String password) {
        displayUserFragment.setDisplay(name, email, password);
        //System.out.println(name + email + password);
    }
    @SuppressWarnings("unused")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(TaskEvent event){
        if(event != null){
            String passedStringEvent = event.getMessage();
            tvAsync.setText(passedStringEvent);
        }


    }

}
