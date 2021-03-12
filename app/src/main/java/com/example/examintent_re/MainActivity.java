package com.example.examintent_re;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examintent_re.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    // Member Variable
    private final boolean D = true;
    private final String TAG = "MainActivity";

    private ListView dataLST;

    //private String[] arrDatas = {"Go", "Go With Data", "Go With Object", "Go Back"};
    private ArrayAdapter<String> adapter;

    //Member Method = Activity's Override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        //List 생성
        dataLST = findViewById(R.id.dataLST);


        String[] datas = this.getResources().getStringArray(R.array.items);
        dataLST.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas));
        dataLST.setOnItemClickListener(this::onItemClick);


        //ListView 에 List 설정
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        dataLST.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG, "onCreate() OK");

        switch (position) {
            case 0:
                Intent intent = new Intent(MainActivity.this, GoActivity.class);
                startActivity(intent);
                break;
        }




    }
}