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

    private static final String TABLE_NOTES = "notes";

    private databaseHelper mDbHelper;
    private SQLiteDatabase mDd;
//
//    Context mCtx;

    // Notes Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_BODY = "body";

    private static final String[] COLUMNS = {KEY_ID, KEY_TITLE, KEY_BODY};

    // Constuctor
    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_NOTE_TABLE = "CREATE TABLE notes ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, " +
                "body TEXT )";

        // create Note table in DB
        db.execSQL(CREATE_NOTE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE notes");
        db.execSQL("CREATE TABLE IF NOT EXISTS notes ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, " +
                "body TEXT )");
    }
        // create fresh books table

//    public databaseHelper open(){
//        mDbHelper.getReadableDatabase();
//        return this;




    public boolean addNote(Note note) {
        // Log.d("addNote", note.toString());
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
        Cursor mCursor = db.query(TABLE_NOTES, new String[] {KEY_ID,
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

public  Cursor getAllTitles() {

//    ArrayList<String> titles = new ArrayList<String>();

    // 1. build the query


    // 2. get reference to writable DB
//    SQLiteDatabase db = this.getWritableDatabase();
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NOTES, null);
    return cursor;
}

    // 3. go over each row, build book and add it to list
//    if (cursor.moveToFirst()) {
//        do {
//            titles.add(cursor.getString(1));
//        } while (cursor.moveToNext());
//    }
//
//    db.close();
//    return titles;
//    cursor.close();

    // Log.d("getAllNotes()", notes.toString());

    // return books



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
//    // Deleting single book
//    public void deleteBook(Book book) {
//
//        // 1. get reference to writable DB
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        // 2. delete
//        db.delete(TABLE_BOOKS,
//                KEY_ID + " = ?",
//                new String[]{String.valueOf(book.getId())});
//
//        // 3. close
//        db.close();
//
//        Log.d("deleteBook", book.toString());
//
//    }
}

