package com.example.fetchrewards.tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter4 extends RecyclerView.Adapter<RecyclerAdapter4.ViewHolder> {
    private List<Employee> data;
    private Context context;
    private LayoutInflater layoutInflater;

    public RecyclerAdapter4(List<Employee> data, Context context) {
        this.context = context;
        this.data=data;
        this.layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=layoutInflater.inflate(R.layout.recycler_layout,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //Log.i("creation2", "just before 2nd for loop");
        viewHolder.idView.setText("ID: " + data.get(i).getId());
        viewHolder.listIDView.setText("List ID: " + data.get(i).getListId());
        viewHolder.nameView.setText("Name: " + data.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idView, listIDView, nameView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView=itemView.findViewById(R.id.name);
            idView=itemView.findViewById(R.id.id);
            listIDView=itemView.findViewById(R.id.listID);
        }
    }
}
