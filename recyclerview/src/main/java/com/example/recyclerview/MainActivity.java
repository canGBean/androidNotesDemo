package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>(20);

    private  String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }
    /**
     * 自定义子布局初始化数据
     */
    private void initFruits(){
        Fruit fruit =null;
        String nameStr = "Cherry%s";
        StringBuilder drawableName = new StringBuilder("shuzi");
        for (int i = 1; i < 21; i++) {
            int resID = getResources().getIdentifier(drawableName.append(i).toString() , "drawable", getPackageName());
            fruit = new Fruit(getRandomLengthName(String.format(nameStr,i)),resID);
            fruitList.add(fruit);
            drawableName.setLength(5);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,4);
        recyclerView.setLayoutManager(gridLayoutManager);
        FruitAdapter fruitAdapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(fruitAdapter);
    }
}
