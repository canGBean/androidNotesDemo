package com.example.listviewtest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FruitAdapter extends ArrayAdapter {

    private int resourceId;

    public FruitAdapter(@NonNull Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = (Fruit) getItem(position);
        View view;
        ViewHolder viewHolder;
//        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.fruit_image);
            viewHolder.textView = view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);//将ViewHolder存储到View中
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getName());
        //----
        //测试绑定点击响应
        viewHolder.imageView.setOnClickListener(v -> Log.d("FruitAdapter","FruitAdapter click event"));
        //-----
//        ImageView fruitImage = view.findViewById(R.id.fruit_image);
//        TextView fruitName = view.findViewById(R.id.fruit_name);
//        fruitImage.setImageResource(fruit.getImageId());
//        fruitName.setText(fruit.getName());
        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
