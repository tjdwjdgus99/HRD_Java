package com.example.sharedpreferenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.sharedpreferenceapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  화면의 버튼, 텍스트등 아이디값 자동으로 전부 가져옴
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //  Mode가 0이면 읽고 쓰기가 다 가능
        //  MODE_WORLD_READABLE 읽기 공유
        //  MODE_WORLD_WRITERBLE 쓰기 공유
        //  첫번째 문자열은 파일명인데 생략시 액티비티 이름으로 만들어짐
        SharedPreferences spref = getSharedPreferences("SPREF",0);
    }

    @Override
    protected void onPause() {  //  라이프 사이클 중에서 백그라운드로 앱이 빠졌을 경우
        super.onPause();
        SharedPreferences spref = getSharedPreferences("SPREF", 0);
        SharedPreferences.Editor editor = spref.edit();

        String name = binding.edtName.getText().toString();
        int age = Integer.parseInt(binding.edtAge.getText().toString());

        editor.putString("Name", name);
        editor.putInt("Age", age);

        editor.commit();
    }
}