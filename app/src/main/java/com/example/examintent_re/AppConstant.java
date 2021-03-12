package com.example.examintent_re;

//Activity들에서 공통으로 사용되는 변수, 상수 저장
public class AppConstant {
    //List Item row index
    public static final int ITEM_GO = 0;
    public static final int ITEM_GO_WITH_DATA = 1;
    public static final int ITEM_GO_WITH_OBJECT = 2;
    public static final int ITEM_GO_BACK = 3;

    //Request Code
    public static final int REQ_DATA_COD = 1000; //아무 값이나 쓰면 된다

    // Data Key
    public static final String KEY_NAME = "NAME";
    public static final String KEY_PHONE = "PHONE";
    public static final String KEY_NAMES = "NAMES"; // 대량의 데이터

    //case AppConstant.ITEM_GO_WITH_OBJECT:
    public static final String KEY_PERSON = "PERSON";
    public static final String KEY_PERSONS = "PERSONS";

}
