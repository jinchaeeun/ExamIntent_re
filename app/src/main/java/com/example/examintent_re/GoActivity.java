package com.example.examintent_re;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class GoActivity extends AppCompatActivity {
    // Member Variable -----------------------------------------------------------
    private final boolean D = true;
    private final String TAG = "GoActivity";
    private TextView                msgTXT;

    // Member Override -----------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(D) Log.i(TAG, "onCreate()");
        setContentView(R.layout.layout_go);
        init();
    }

    // Member Method - Custom ----------------------------------------------------
    private void init(){
        // 현재 Activity 실행한 Intent 객체 가져오기
        Intent rxIntent = this.getIntent();
        //String rxData = rxIntent.getStringExtra(AppConstant.KEY_NAME);
        ArrayList<String> rxData = (ArrayList<String>) rxIntent.getSerializableExtra(AppConstant.KEY_NAMES); //getSerializableExtra객체로 준 걸 객체로 그대로 받아오겠다.
        // View 객체 가져오기
        msgTXT = findViewById(R.id.msgTXT);

        //rxData가 없으면 null이 들어오니 확인하기
        //if(rxData != null) msgTXT.setText(rxData);

        if(rxData != null){
            String data = "";
            for(int i=0; i<rxData.size(); i++){
                data += rxData.get(i) + "\n";
            }
            msgTXT.setText(data);
        }
    }
}