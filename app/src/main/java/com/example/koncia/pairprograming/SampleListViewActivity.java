package com.example.koncia.pairprograming;


import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SampleListViewActivity extends AppCompatActivity{

    @BindView(R.id.android_list)
    ListView positions;

    private List<String> positionsList = new ArrayList<>();
    private String[] list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_list_view);
        ButterKnife.bind(this);

        list = getResources().getStringArray(R.array.sample_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.image_layout, R.id.itemname, list);
        positions.setAdapter(adapter);

        fillList();

        positions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String address = positionsList.get(i);

                Intent intent = new Intent(SampleListViewActivity.this, DetailsActivity.class);
                intent.putExtra("name", address);

                startActivity(intent);
            }
        });

//        adapter.setListAdapter(new ArrayAdapter<String>(
//                this, R.layout.image_layout,
//                R.id.Itemname,list));
    }

    public void app_info(View view) {

        Intent intent = new Intent(this,CredentialsActivity.class);
        startActivity(intent);
    }

    private void fillList(){
        for (int i = 0; i<list.length;i++){
            positionsList.add(list[i]);
        }
    }
}
