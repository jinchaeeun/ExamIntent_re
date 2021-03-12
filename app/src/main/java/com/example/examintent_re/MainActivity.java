package com.example.examintent_re;

import androidx.annotation.Nullable;
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

import java.util.ArrayList;

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
        if(D) Log.i(TAG, "onItemClick() OK");
        Intent intent;
        switch (position) {
            case AppConstant.ITEM_GO:
                //GoActivity 전환
                intent = new Intent(MainActivity.this, GoActivity.class);
                startActivity(intent);
                break;
            case AppConstant.ITEM_GO_WITH_DATA:
                // Primitive Data와 함께 전달
                intent = new Intent(MainActivity.this, GoActivity.class);
                intent.putExtra(AppConstant.KEY_NAME, "KIM"); //Key값 설정하기 위해 AppConstant.java에서 문자열 선언
                intent.putExtra(AppConstant.KEY_PHONE,"010-1111-2222");

                // 데이터 대량으로 보내기
                // Primitive Data List 함께 전달
                ArrayList<String>   names = new ArrayList<String>();
                names.add("Hong");
                names.add("Choi");
                names.add("Park");
                names.add("Kwon");

                intent.putExtra(AppConstant.KEY_NAMES, names);      //가져오는 것 GoActivity
                startActivity(intent);
                break;

            case AppConstant.ITEM_GO_WITH_OBJECT:
                ArrayList<Person> persons = new ArrayList<Person>();
                persons.add(new Person("Tom", "F", 10));
                persons.add(new Person("Lee", "F", 35));
                persons.add(new Person("Choi", "M", 14));

                intent = new Intent(MainActivity.this, GoObjectActivity.class);
                intent.putExtra(AppConstant.KEY_PERSONS, persons);
                startActivity(intent);
                break;

            case AppConstant.ITEM_GO_BACK:
                // 다른 Activity로 전환 후 결과 받아오기
                intent = new Intent(MainActivity.this, GoBackActivity.class);
                //intent.putExtra(AppConstant.KEY_PERSONS, intent);
                startActivityForResult(intent, AppConstant.REQ_DATA_COD); //화면 되돌리기 뒤에 int 값은 개발자가 구분하기 위해 지정한 값
                //결과를 받아주는 함수는 오버라이딩 메서드 onActivityResult


                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case AppConstant.REQ_DATA_COD:
                if(resultCode == RESULT_OK) { //RESULT_OK가 왔다면 제대로 온 것
                    Log.i(TAG, " RESULT DATA = " + data.getStringExtra(AppConstant.KEY_PHONE));
                }else{
                    Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}