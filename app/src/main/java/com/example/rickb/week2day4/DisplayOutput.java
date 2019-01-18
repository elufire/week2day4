package com.example.rickb.week2day4;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 interface
 * to handle interaction events.
 */
public class DisplayOutput extends Fragment {
    RecyclerView rvView;
    RecyclerViewAdapter rvAdapter;
    ArrayList<User> userArrayList;


    public DisplayOutput() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userArrayList= new ArrayList<>();
        rvView = view.findViewById(R.id.onlyRecyclerView);
        rvAdapter = new RecyclerViewAdapter(userArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvView.setLayoutManager(layoutManager);
        rvView.setAdapter(rvAdapter);
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void setDisplay(String name, String email, String password){
        User user = new User(name, email, password);
        System.out.println(user.getName()+ user.getEmail()+ user.getPassword());
//        if(userArrayList == null || rvAdapter == null){
//            System.out.println("User array list is null.");
//        }else
        rvAdapter.addUser(user);
    }


}