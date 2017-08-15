package com.example.guyrawsthorn.samplebook;

/**
 * Created by guyrawsthorn on 26/07/2017.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.guyrawsthorn.samplebook.Note;


public class databaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "NoteDB";
    // Table Name
    private static final String TABLE_NOTES = "notes";

    private SQLiteDatabase mDd;
    public Context context;

    // Notes Table Columns names
    public static final String KEY_ID = "_id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_BODY = "body";

    private static final String[] COLUMNS = {KEY_ID, KEY_TITLE, KEY_BODY};

    // Constuctor
    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_NOTE_TABLE = "CREATE TABLE notes ( " +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_TITLE + " TEXT, " +
                KEY_BODY + " TEXT )";

        // create Note table in DB
        db.execSQL(CREATE_NOTE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE notes");
        db.execSQL("CREATE TABLE IF NOT EXISTS notes ( " +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_TITLE + " TEXT, " +
                KEY_BODY + " TEXT )");
    }


    public boolean addNote(Note note) {
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, note.getTitle()); // get title
        values.put(KEY_BODY, note.getBody()); // get

        // 3. insert
        Long result = db.insert(TABLE_NOTES, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor fetchAllNotes() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCursor = db.query(TABLE_NOTES, new String[]{KEY_ID,
                        KEY_TITLE, KEY_BODY},
                null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

//    public Note getNote(int id) {
//
//        // 1. get reference to readable DB
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        // 2. build query
//        Cursor cursor =
//                db.query(TABLE_NOTES, // a. table
//                        COLUMNS, // b. column names
//                        " id = ?", // c. selections
//                        new String[]{String.valueOf(id)}, // d. selections args
//                        null, // e. group by
//                        null, // f. having
//                        null, // g. order by
//                        null); // h. limit
//
//        // 3. if we got results get the first one
//        if (cursor != null)
//            cursor.moveToFirst();
//
//        // 4. build book object
//        Note note = new Note();
//        note.setId(Integer.parseInt(cursor.getString(0)));
//        note.setTitle(cursor.getString(1));
//        note.setBody(cursor.getString(2));
//
//        Log.d("getBook(" + id + ")", note.toString());
//
//        // 5. return book
//        return note;
//    }
// Get All Titles
// Get All Titles

    // ArrayList<String>

    public Cursor getAllTitles() {
        // 1. build the query

        // 2. get reference to writable DB

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NOTES, null);
        return cursor;
    }

    //Get All Books
    public List<Note> getAllNotes() {
        List<Note> notes = new LinkedList<Note>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_NOTES;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        Note note = null;
        if (cursor.moveToFirst()) {
            do {
                note = new Note();
                note.setId(Integer.parseInt(cursor.getString(0)));
                note.setTitle(cursor.getString(1));
                note.setBody(cursor.getString(2));

                // Add book to books
                notes.add(note);
            } while (cursor.moveToNext());
        }

        // Log.d("getAllNotes()", notes.toString());

        // return books
        return notes;
    }
    public void deleteNote(Note note) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_NOTES,
                KEY_ID + " = ?",
                new String[]{String.valueOf(note.getId())});

        // 3. close
        db.close();

       // Log.d("deleteBook", book.toString());

    }
}


//get All Notes

//    public ArrayList<NoteListView> getAllNotes(){
//
//    }

//    // Updating single book
//    public int updateBook(Book book) {
//
//        // 1. get reference to writable DB
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        // 2. create ContentValues to add key "column"/value
//        ContentValues values = new ContentValues();
//        values.put("title", book.getTitle()); // get title
//        values.put("author", book.getAuthor()); // get author
//
//        // 3. updating row
//        int i = db.update(TABLE_BOOKS, //table
//                values, // column/value
//                KEY_ID + " = ?", // selections
//                new String[]{String.valueOf(book.getId())}); //selection args
//
//        // 4. close
//        db.close();
//
//        return i;
//
//    }
//
    // Deleting single book



