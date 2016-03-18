package app.panithan.kru.pjsoccerfield;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by u on 18/3/2559.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    // Explicit
    public static final String database_name = "PJ db";
    private static final int database_version = 1;

    private static final String create_user_table = "create table userTABLE (" +
            "_id integer primary key, " +
            "User text, " +
            "Password text, " +
            "Name text, " +
            "Address text, " +
            "Phone text);";

    private static final String create_soccerfield_table = "create table soccerfieldTABLE (" +
            "_id integer priary key, " +
            "Namesoccerfield text, " +
            "Description text, " +
            "Price text, " +
            "URLicon text, " +
            "URLimage text, " +
            "URLimage1 text, " +
            "URLimage2 text, " +
            "URLimage3 text, " +
            "URLimage4 text, " +
            "URLimage5 text);";


    private static final String create_order_table = "create table orderTABLE (" +
            "_id integer primary key, " +
            "Date text, " +
            "NameOrder text, " +
            "Address text, " +
            "Phone text, " +
            "Soccerfield text, " +
            "Amount text, " +
            "Total text);";



    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_version);
    }   // Constructor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(create_user_table);
        sqLiteDatabase.execSQL(create_soccerfield_table);
        sqLiteDatabase.execSQL(create_order_table);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}   // Main Class
