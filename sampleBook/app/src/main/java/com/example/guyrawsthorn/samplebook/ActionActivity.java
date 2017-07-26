package com.example.guyrawsthorn.samplebook;

import java.util.List;
import com.example.guyrawsthorn.samplebook.Note;
import com.example.guyrawsthorn.samplebook.databaseHelper;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

    public class ActionActivity extends AppCompatActivity {

        databaseHelper db = new databaseHelper(this);

        EditText editTitle, editNote;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button btn;
            Button backButton;

            // add Books

            // get all books
            List<Note> list = db.getAllNotes();

//        // delete one book
//        db.deleteBook(list.get(0));
//
//        // get all books
//        db.getAllBooks();

            btn = (Button)findViewById(R.id.saveNote);
            editTitle = (EditText)findViewById(R.id.etTitle) ;
            editNote = (EditText)findViewById(R.id.etNote);
            backButton = (Button)findViewById(R.id.home);

            // add a note
            btn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    AddData();
                }
            });

            backButton.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View v){
                    home();
            }
        });
    }

        public void AddData() {

            boolean isInserted = db.addNote(new Note (editTitle.getText().toString(),
                    editNote.getText().toString()));

            if(isInserted ==true)
                Toast.makeText(ActionActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(ActionActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();

        }

        public void home() {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

}
