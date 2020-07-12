package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] data = new String[20];
    private List<Fruit> fruitList = new ArrayList<Fruit>(20);

    private void initData() {
        StringBuilder stringBuilder = new StringBuilder("Cherry");
        for (int i = 0; i < 20; i++) {
            data[i] = stringBuilder.append(i).toString();
            stringBuilder.setLength(6);
        }
    }

    /**
     * 自定义子布局初始化数据
     */
    private void initFruit(){
        Fruit fruit =null;
        StringBuilder stringBuilder = new StringBuilder("Cherry");
        StringBuilder drawableName = new StringBuilder("shuzi");
        for (int i = 1; i < 21; i++) {
            int resID = getResources().getIdentifier(drawableName.append(i).toString() , "drawable", getPackageName());
            fruit = new Fruit(stringBuilder.append(i).toString(),resID);
            fruitList.add(fruit);
            stringBuilder.setLength(6);
            drawableName.setLength(5);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initData();
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                MainActivity.this, android.R.layout.simple_list_item_1, data);
//        ListView listView = findViewById(R.id.list_view);
//        listView.setAdapter(adapter);

        initFruit();
        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listview = findViewById(R.id.list_view);
        listview.setAdapter(fruitAdapter);
//        子布局的点击事件
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String imgMessage = String.format("Click img %s", position+1);
                Fruit fruit = fruitList.get(position);

                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
                Log.d("MainActivity",fruit.getName());
                //---
                //测试获取子组件绑定点击事件
//              ImageView imageView =  view.findViewById(R.id.fruit_image);
                ImageView imageView = (ImageView) ((LinearLayout)view).getChildAt(0);
                imageView.setOnClickListener(v -> {
                    Log.d("MainActivity",imgMessage);
                    Toast.makeText(MainActivity.this,imgMessage,Toast.LENGTH_SHORT).show();
                });
                //-----
            }
        });
    }
}
