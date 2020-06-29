package com.example.demofirstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
//        final Button button = findViewById(R.id.button3);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ActivityCollector.finishAll();
//                Log.d("ThirdActivity", String.format("Process exit %s", android.os.Process.myPid()));
//                android.os.Process.killProcess(android.os.Process.myPid());
//            }
//        });
        Button button = findViewById(R.id.button3);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button3:
                ActivityCollector.finishAll();
                Log.d("ThirdActivity", String.format("Process exit %s", android.os.Process.myPid()));
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
            default:
                break;
        }
    }
}
