package com.samansepahvand.pushe.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.samansepahvand.pushe.R;
import com.samansepahvand.pushe.adapter.NotifAdapter;
import com.samansepahvand.pushe.model.ModelNotification;
import com.samansepahvand.pushe.room.AppDatabase;
import com.samansepahvand.pushe.room.NoteDatabase;
import com.samansepahvand.pushe.room.dao.RoomDAO;


import java.util.ArrayList;
import java.util.List;

public class ActivityShowNotification extends AppCompatActivity {


    RecyclerView recyclerView;
    NotifAdapter adapter;
    List<ModelNotification> models;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notification);


    initView();

       intRecyclerView();
       initGetData();

        String currentDBPath = getDatabasePath("users").getAbsolutePath();
        Log.e("TAG", "onCreate: "+currentDBPath );


    }


    private  void initView(){
        recyclerView=findViewById(R.id.recyclerview);

    }
    private  void intRecyclerView(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    private  void initGetData(){

        //

//        AppDatabase appDatabase = AppDatabase.geAppdatabase(getApplicationContext());
//        RoomDAO dao = appDatabase.getRoomDAO();

       NoteDatabase  appDatabase = NoteDatabase.getInstance(this);
        RoomDAO dao = appDatabase.getNoteDao();


        models = dao.orderThetable();
        if (models.size() > 0) {
            //recyclerView.setVisibility(View.VISIBLE);

        }
        adapter = new NotifAdapter(models,this);
        recyclerView.setAdapter(adapter);


    }



  private void   showDatainData(){
//      AppDatabase   appDatabase = AppDatabase.geAppdatabase(getApplicationContext());
//      RoomDAO dao = appDatabase.getRoomDAO();

      NoteDatabase  appDatabase = NoteDatabase.getInstance(this);
      RoomDAO dao = appDatabase.getNoteDao();


      models = dao.getAll();
        for (ModelNotification model:models){

            Log.e("TAG", "  getId :"+model.getId() );
            Log.e("TAG", "  getNotifTitle:"+model.getNotifTitle() );
            Log.e("TAG", "  getNotifBody :"+model.getNotifBody() );

            Log.e("TAG", "  getDataTitle :"+model.getDataTitle() );
            Log.e("TAG", "  getDataBody:"+model.getDataBody() );
            Log.e("TAG", "  getDataKey1:"+model.getDataKey1() );
            Log.e("TAG", "  getDataKey2 :"+model.getDataKey2() );

            Log.e("TAG", "  getNotifDate:"+model.getNotifDate() );




        }


    }


}