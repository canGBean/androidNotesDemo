package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
    }
}
