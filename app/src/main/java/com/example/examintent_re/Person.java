package com.example.examintent_re;

import android.os.Parcel;
import android.os.Parcelable;

//Data 저장 클래스
public class Person implements Parcelable {
    private String  name;
    private String  gender;
    private int     age;

    //Constructor Method ------------------------------------
    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

// implement 구현 후 에러 표시 해결 자동 추가
    protected Person(Parcel in) {
        name = in.readString();
        gender = in.readString();
        age = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(gender);
        dest.writeInt(age);
    }
    
    // 만들어줌
    public String showInfo(){
        return "[" +this.name + " , " + this.gender + ", " + this.age + " ]";
    }
}
