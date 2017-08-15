package com.example.guyrawsthorn.samplebook;

import java.util.List;
import com.example.guyrawsthorn.samplebook.Note;
import com.example.guyrawsthorn.samplebook.databaseHelper;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button createNote;
    Button viewNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNote = (Button)findViewById(R.id.createNote);
        viewNote = (Button)findViewById(R.id.viewNote);

        createNote.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                loadCreate();
            }
        });
        viewNote.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                loadView();
            }
        });

        Log.d("debug", "this is the main acctivity debugger");

        }


    public void loadCreate(){
        Intent intent = new Intent(this, ActionActivity.class);
        startActivity(intent);
    }

    public void loadView(){
        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}