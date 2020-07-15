package com.example.uibestpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText inputText;
    private Button sendButton;
    private MsgAdapter msgAdapter;
    private List<Msg> msgList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.msg_recycler_view);
        inputText = findViewById(R.id.input_text);
        sendButton = findViewById(R.id.send);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        msgAdapter = new MsgAdapter(msgList);
        recyclerView.setAdapter(msgAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, getRandomType());
                    msgList.add(msg);
//                    当有新消息时刷新ListView中的显示
                    msgAdapter.notifyItemInserted(msgList.size() - 1);
//                    将ListView定位到最后一行
                    recyclerView.scrollToPosition(msgList.size() - 1);
                    inputText.setText("");
                }
            }
        });
    }
    //随机获取消息类型
    private int getRandomType() {
        Random random = new Random();
        if (random.nextInt(10) > 5) {
            return Msg.TYPE_SEND;
        } else {
            return Msg.TYPE_RECEIVED;
        }
    }
}
