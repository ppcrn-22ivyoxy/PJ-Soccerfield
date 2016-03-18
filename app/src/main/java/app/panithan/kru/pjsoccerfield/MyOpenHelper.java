package app.panithan.kru.pjsoccerfield;

import android.content.Context;

/**
 * Created by u on 18/3/2559.
 */
public class MyOpenHelper {

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
            "_id integer primary key, " +
            "namesoccerfield text, " +
            "Description text, " +
            "Price text, " +
            "URLicon text, " +
            "URLimage text, " +
            "URLimage1 text, " +
            "URLimage2 text, " +
            "URLimage3 text, " +
            "URLimage4 text, " +
            "URLimage5 text);";

    private static final String create_order_table = "create tableTABLE (" +
            "_id integer primary key, " +
            "Date text, " +
            "NameOrder text, " +
            "Address  text, " +
            "Phone text, " +
            "Soccerfield, " +
            "Amount text, " +
            "Total text);";



    public MyOpenHelper(Context context) {
    }   // Constructor

}   // Main Class
