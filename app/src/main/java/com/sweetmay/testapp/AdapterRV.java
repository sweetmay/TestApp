package com.sweetmay.testapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRV extends RecyclerView.Adapter<AdapterRV.ViewHolder> {

    private ArrayList<String> employees;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setEmployee(employees.get(position));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if(employees == null || employees.size() == 0){
            return 0;
        }else {
            return employees.size();
        }

    }

    public void invalidateData(ArrayList<String> strings) {
        employees = strings;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView employee;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            employee = itemView.findViewById(R.id.employee);
        }

        public void setEmployee(String employee) {
            this.employee.setText(employee);
        }
    }
}
