package com.techlearn.todoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class todoAdapter extends RecyclerView.Adapter<todoAdapter.MyViewHolder> {
    Context context;
    ArrayList<todoappModel> todoModel;
    public todoAdapter(Context context, ArrayList<todoappModel> todoModel){
        this.context = context;
        this.todoModel = todoModel;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //here we are going to inflate our layout (we are going to give look to our rows)
        View itemView = LayoutInflater.from(context).
                inflate(R.layout.recycler_view_adapter, parent, false);

        return new todoAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//ASSIGN    values to the views we created in recycler view
        holder.text.setText(todoModel.get(position).getTodo());
    }

    @Override
    public int getItemCount() {

        return todoModel.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing the views from recycler view layout

        TextView text;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text);
        }
    }
}
