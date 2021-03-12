package com.example.examintent_re;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GoObjectActivity extends AppCompatActivity {
    // Member Variable -----------------------------------------------------------
    private final boolean D = true;
    private final String  TAG = "GoObjectActivity";
    private TextView      msgTXT;

    // Member Override -----------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(D) Log.i(TAG, "onCreate()");
        setContentView(R.layout.layout_go);
        init();
    }

    // Member Method - Custom ----------------------------------------------------
    
    /*
    Go With Data까지 했었을 때 init()함수
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
    }*/

    /*Go With Object할 때 다시 만든 init 함수*/
    private void init(){
        // 현재 Activity 실행한 Intent 객체 가져오기
        Intent rxIntent = this.getIntent();
        //String rxData = rxIntent.getStringExtra(AppConstant.KEY_NAME);
        ArrayList<Person> rxData = rxIntent.getParcelableArrayListExtra(AppConstant.KEY_PERSONS); //Parcelable 구현 안되어있으면 빨간 줄 Person.java에서 implements Parcelable
        // View 객체 가져오기
        msgTXT = findViewById(R.id.msgTXT);

        //rxData가 없으면 null이 들어오니 확인하기
        //if(rxData != null) msgTXT.setText(rxData);
        if(rxData != null){
            String data = "";
            for(int i=0; i<rxData.size(); i++){
                data += rxData.get(i).showInfo() + "\n";      //showInfo는 Person에서 만들어준 함수
            }
            msgTXT.setText(data);
        }
    }
}