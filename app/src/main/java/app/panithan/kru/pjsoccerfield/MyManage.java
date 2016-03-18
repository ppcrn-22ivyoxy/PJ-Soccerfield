package app.panithan.kru.pjsoccerfield;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by u on 18/3/2559.
 */
public class MyManage {

    // Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase , readSqLiteDatabase;


    public MyManage(Context context) {

        // Create & Connected
        myOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = myOpenHelper.getWritableDatabase();
        readSqLiteDatabase = myOpenHelper.getReadableDatabase();



    }   // Constructor

}   // Main Class
