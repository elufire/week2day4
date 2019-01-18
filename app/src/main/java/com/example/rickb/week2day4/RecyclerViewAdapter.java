package com.example.rickb.week2day4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<User> usersArrayList;
    String TAG;

    public RecyclerViewAdapter(ArrayList<User> usersArrayList) {
        this.usersArrayList = usersArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
       // usersArrayList = new ArrayList<>();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position) {
        User user = usersArrayList.get(position);

        if (user != null) {
            String name = user.getName();
            String email = user.getEmail();
            String password = user.getPassword();
            viewHolder.setUser(user);
            viewHolder.name.setText(name);
            viewHolder.email.setText(email);
            viewHolder.password.setText(password);
        }
    }

    @Override
    public int getItemCount() {
        return usersArrayList != null ? usersArrayList.size() : 0;
    }

//    @Override
//    public boolean onItemMove(int fromPosition, int toPosition) {
//        if (fromPosition < toPosition) {
//            for (int i = fromPosition; i < toPosition; i++) {
//                Collections.swap(usersArrayList, i, i + 1);
//            }
//        } else {
//            for (int i = fromPosition; i > toPosition; i--) {
//                Collections.swap(usersArrayList, i, i - 1);
//            }
//        }
//        notifyItemMoved(fromPosition, toPosition);
//        return true;
//    }
//
//    @Override
//    public void onItemDismiss(int position) {
//
//    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView email;
        TextView password;
        User user;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.rvName);
            email = itemView.findViewById(R.id.rvEmail);
            password = itemView.findViewById(R.id.rvPassword);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("Button Pressed" + getAdapterPosition());
                    CalcNameAsyncTask CalcNameAsyncTask = new CalcNameAsyncTask(user.getName(), v);
                    CalcNameAsyncTask.execute();
                }
            });

        }

        public void setUser(User user){ this.user = user;}
    }

    public void addUser(User user){
        //System.out.println(name);
        usersArrayList.add(user);
        notifyDataSetChanged();
    }
}