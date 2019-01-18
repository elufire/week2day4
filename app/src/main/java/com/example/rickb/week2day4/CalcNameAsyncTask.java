package com.example.rickb.week2day4;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

public class CalcNameAsyncTask extends AsyncTask<String, String, String> {
    String name;
    View view;
    int nameLength;
    public CalcNameAsyncTask(String name, View view) {
        this.name = name;
        this.view = view;

//        this.tvPassedTextView = tvPassedTextView;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(String... strings) {

        nameLength = name.length();
        return name;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Toast.makeText(view.getContext(), "The length of the name is: " + nameLength, Toast.LENGTH_SHORT).show();
    }
}