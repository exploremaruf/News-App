package com.maruf.newsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    LayoutInflater layoutInflater;

    HashMap<String, String> hashMap = new HashMap<>();

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //*****************************************************************************************
        //*****************************************************************************************
        listView = findViewById(R.id.listview);

        datatable();

        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);

    }
    //*****************************************************************************************
    //*****************************************************************************************
    //*****************************************************************************************

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {

            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {

            return null;
        }

        @Override
        public long getItemId(int position) {

            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myview = layoutInflater.inflate(R.layout.item, parent, false);

            return myview;
        }

    }

    //*****************************************************************************************
    //*****************************************************************************************
    //*****************************************************************************************
    private void datatable() {

        hashMap = new HashMap<>();
        hashMap.put("cat", "");
        hashMap.put("image_url", "");
        hashMap.put("title", "");
        hashMap.put("des", "");
        arrayList.add(hashMap);

    }

}