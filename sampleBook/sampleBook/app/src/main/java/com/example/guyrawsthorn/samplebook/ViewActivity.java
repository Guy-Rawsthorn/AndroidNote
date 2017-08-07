package com.example.guyrawsthorn.samplebook;

import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewActivity extends ListActivity {

    SimpleCursorAdapter dataAdapter;
    databaseHelper dbHelper = new databaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        //ListView listView;
        databaseHelper db = new databaseHelper(this);

        //istView = (ListView) findViewById(R.id.list);
        DisplayList();

    }

    public void DisplayList() {

        Cursor cursor = dbHelper.getAllTitles();

        String[] from = new String[]{
                dbHelper.KEY_TITLE,
                dbHelper.KEY_BODY};


        int[] to = new int[]{
                R.id.lvTitle,
                R.id.lvBody
        };

        dataAdapter = new SimpleCursorAdapter(this, R.layout.activity_note, cursor, from, to, 0);
        dbHelper.close();

        ListView listView = getListView();
        listView.setAdapter(dataAdapter);
    }
}

//      public void ArrayListView(){

 //       ArrayList<String> list = dbHelper.getAllTitles();
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_note, list);
//        list_view = (ListView) findViewById(R.id.list);
//        list_view.setAdapter( adapter );





//         ArrayAdapter<Note> listAdapter ;
//        listAdapter = new ArrayAdapter<Note>(this, R.layout.activity_view, list);
//        list_view.setAdapter( listAdapter );


        //populateListView();



//    private void populateListView(){
//
//        Cursor cursor = dbHelper.fetchAllNotes();
//
//        String[] from = new String [] {
//                dbHelper.KEY_TITLE,
//                dbHelper.KEY_BODY};
//
////      define the xml views
//
//        int [] to = new int[]{
//                R.id.lvTitle,
//                R.id.lvBody
//        };
//        SimpleCursorAdapter dataAdapter;
//        dataAdapter = new SimpleCursorAdapter(
//                getBaseContext(), R.layout.activity_view, cursor, from, to, 0
//        );
//        list_view = (ListView) findViewById(R.id.list);
//        list_view.setAdapter(dataAdapter);
//
//    }

