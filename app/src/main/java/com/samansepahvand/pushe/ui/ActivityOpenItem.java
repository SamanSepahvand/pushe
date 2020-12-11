package com.samansepahvand.pushe.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.samansepahvand.pushe.R;


public class ActivityOpenItem extends AppCompatActivity {


    TextView txtTitle,txtBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_item);

        initView();

        Bundle bundle=getIntent().getExtras();
        String tempTitle=bundle.getString("title");
        String tempBody=bundle.getString("body");

        Log.e("TAG", "onCreate: "+tempBody);
        Log.e("TAG", "onCreate: "+tempTitle);


        txtTitle.setText(tempTitle);
        txtBody.setText(tempBody);

    }


    private  void initView(){
        txtBody=findViewById(R.id.txt_body);
        txtTitle=findViewById(R.id.txt_title);

    }
}