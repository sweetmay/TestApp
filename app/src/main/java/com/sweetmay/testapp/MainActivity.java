package com.sweetmay.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sweetmay.testapp.data.GetData;
import com.sweetmay.testapp.data.OnResultListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private GetData getData;
    private ListView listView;
    private List<String> employeesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
    }

    private void initListView() {
        listView = findViewById(R.id.list_view_employees);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, employeesList);
        listView.setAdapter(adapter);
    }

    private void getData() {
        getData = new GetData();
        getData.request(new OnResultListener() {
            @Override
            public void onResult(Response<com.sweetmay.testapp.DataRequest> response) {
                fillList(response.body().getCompany().getEmployees());
                Collections.sort(employeesList);
                initListView();
            }
        });
    }

    private void fillList(List<com.sweetmay.testapp.Employee> employees) {
        for (com.sweetmay.testapp.Employee e:employees) {
            employeesList.add(e.getName());

        }
    }
}