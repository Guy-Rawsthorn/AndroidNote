//package com.example.guyrawsthorn.samplebook;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.CursorAdapter;
//import android.widget.TextView;
//
//
///**
// * Created by guyrawsthorn on 08/08/2017.
// */
//
//public class TodoCursorAdapter extends CursorAdapter {
//    public TodoCursorAdapter(Context context, Cursor cursor) {
//        super(context, cursor, 0);
//    }
//    @Override
//    public View newView(Context context, Cursor cursor, ViewGroup parent) {
//        return LayoutInflater.from(context).inflate(R.layout.activity_note, parent, false);
//    }
//
//    // The bindView method is used to bind all data to a given view
//    // such as setting the text on a TextView.
//    @Override
//    public void bindView(View view, Context context, Cursor cursor) {
//        // Find fields to populate in inflated template
//        TextView tvTitle = (TextView) view.findViewById(R.id.lvTitle);
//        TextView tvBody = (TextView) view.findViewById(R.id.lvBody);
//        // Extract properties from cursor
//        String title = cursor.getString(cursor.getColumnIndexOrThrow("KEY_TITLE"));
//        String body = cursor.getString(cursor.getColumnIndexOrThrow("KEY_BODY"));
//        // Populate fields with extracted properties
//        tvTitle.setText(title);
//        tvBody.setText(body);
//        //tvPriority.setText(String.valueOf(priority));
//    }
//
//}
