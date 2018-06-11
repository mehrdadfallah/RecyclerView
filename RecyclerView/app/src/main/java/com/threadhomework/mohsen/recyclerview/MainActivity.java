package com.threadhomework.mohsen.recyclerview;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

                RecyclerView list;

    List<Shortcut> shorcutList;
    private int MY_PREMISSION = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureView();
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            configureList();
        }
        else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this , Manifest.permission.READ_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.READ_EXTERNAL_STORAGE} ,MY_PREMISSION );
                configureList();
            }else {
                ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.READ_EXTERNAL_STORAGE} ,MY_PREMISSION );
                configureList();
            }

        }

    }


    private void configureList() {
        shorcutList = new ArrayList<Shortcut>();

        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
        File[] files = file.listFiles();
        Log.d("TAG" , files.length+"" );
        Shortcut shortcut1 = new Shortcut("Download "
                , Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()
                , R.drawable.downliad);
        Shortcut shortcut2 = new Shortcut("Document "
                , Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath()
                , R.drawable.document);
        Shortcut shortcut3 = new Shortcut("Pictures"
                , Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()
                , R.drawable.image);
        Shortcut shortcut4 = new Shortcut("Movies"
                , Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath()
                , R.drawable.video);
        shorcutList.add(shortcut1);
        shorcutList.add(shortcut2);
        shorcutList.add(shortcut3);
        shorcutList.add(shortcut4);

        ShortcutAdapter shortcutAdapter = new ShortcutAdapter(shorcutList , MainActivity.this);
        list.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        list.setAdapter(shortcutAdapter);
    }

    private void configureView() {
        list = (RecyclerView) findViewById(R.id.list_item);
    }
}
