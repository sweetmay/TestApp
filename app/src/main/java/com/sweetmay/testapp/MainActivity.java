package com.sweetmay.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sweetmay.testapp.data.GetData;
import com.sweetmay.testapp.data.OnResultListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private GetData getData;
    private RecyclerView RV;
    private AdapterRV adapter;
    private ArrayList<String> employeesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRV();
        getData();
    }

    private void initRV() {
        RV = findViewById(R.id.rv_employees);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        RV.setLayoutManager(layoutManager);
        adapter = new AdapterRV();
        RV.setAdapter(adapter);
    }

    private void getData() {
        getData = new GetData();
        getData.request(new OnResultListener() {
            @Override
            public void onResult(Response<com.sweetmay.testapp.data.DataRequest> response) {
                fillList(response.body().getCompany().getEmployees());
                adapter.invalidateData(employeesList);
            }
        });
    }

    private void fillList(List<com.sweetmay.testapp.data.Employee> employees) {
        for (com.sweetmay.testapp.data.Employee e:employees) {
            if(e.getName() != null){
                employeesList.add(e.getName());
            }
        }
        Collections.sort(employeesList);
    }
}