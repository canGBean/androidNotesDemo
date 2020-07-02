package com.example.uiwidgettest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ProgressDialogBack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog_back);
        Intent intent1  = new Intent();
        intent1.putExtra("data_return","data is ok");
        setResult(RESULT_OK,intent1);
        finish();
    }
}
