package com.samansepahvand.pushe.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.samansepahvand.pushe.R;
import com.samansepahvand.pushe.room.AppDatabase;
import com.samansepahvand.pushe.room.NoteDatabase;
import com.samansepahvand.pushe.room.dao.RoomDAO;


public class MainActivity extends AppCompatActivity {

    private  static final String TAG="firebase";



    TextView txtInfo;
    TextView txtToken;

    Button btnShowNotification;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        initView();
        getToken();

        FirebaseMessaging.getInstance().subscribeToTopic("topicName");



        btnShowNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ActivityShowNotification.class));
            }
        });


        btnShowNotification.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DeleteAllNotification();
                return false;
            }
        });
    }

    private void DeleteAllNotification() {
//        AppDatabase appDatabase = AppDatabase.geAppdatabase(getApplicationContext());
//        RoomDAO dao = appDatabase.getRoomDAO();
//
        NoteDatabase appDatabase = NoteDatabase.getInstance(this);
        RoomDAO dao = appDatabase.getNoteDao();

        dao.DeleteAll();
        Toast.makeText(this, "All Data Deleted Success!", Toast.LENGTH_SHORT).show();
    }





    private void initView(){
        txtInfo=findViewById(R.id.txt_info);
        txtToken=findViewById(R.id.txt_token);
        btnShowNotification=findViewById(R.id.btn_show_notif);
    }
    private void getToken(){

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this, instanceIdResult -> {
            String newToken = instanceIdResult.getToken();
            Log.e(TAG, newToken);

            txtToken.setText(newToken);
        });

    }
}