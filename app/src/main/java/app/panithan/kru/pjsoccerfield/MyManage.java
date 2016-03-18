package app.panithan.kru.pjsoccerfield;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by u on 18/3/2559.
 */
public class MyManage {

    // Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String user_table = "userTABLE";
    public static final String column_id = "_id";
    public static final String column_User = "User";
    public static final String column_Password = "Password";
    public static final String column_Name = "Name";
    public static final String column_Address = "Address";
    public static final String column_Phone = "Phone";

    public static final String soccerfield_table = "soccerfieldTABLE";
    public static final String column_Soccerfield = "Soccerfield";
    public static final String column_Description = "Description";
    public static final String column_Price = "Price";
    public static final String column_URLicon = "URLicon";
    public static final String column_URLimage = "URLimage";
    public static final String column_URLimage1 = "URLimage1";
    public static final String column_URLimage2 = "URLimage2";
    public static final String column_URLimage3 = "URLimage3";
    public static final String column_URLimage4 = "URLimage4";
    public static final String column_URLimage5 = "URLimage5";


    public static final String order_table = "orderTABLE";
    public static final String column_Date = "Date";
    public static final String column_NameOrder = "NameOrder";
    public static final String column_Amount = "Amount";
    public static final String column_Total = "Total";


    public MyManage(Context context) {

        // Create & Connected
        myOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = myOpenHelper.getWritableDatabase();
        readSqLiteDatabase = myOpenHelper.getReadableDatabase();


    }   // Constructor

    public long addOrder(String strDate,
                         String strNameOrder,
                         String strAddress,
                         String strPhone,
                         String strSocerfield,
                         String strAmount,
                         String strTotal) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_Date, strDate);
        contentValues.put(column_NameOrder, strNameOrder);
        contentValues.put(column_Address, strAddress);
        contentValues.put(column_Phone, strPhone);
        contentValues.put(column_Soccerfield, strSocerfield);
        contentValues.put(column_Amount, strAmount);
        contentValues.put(column_Total, strTotal);

        return writeSqLiteDatabase.insert(order_table, null, contentValues );
    }

    public long addSoccerfield(String strSoccerfield,
                               String strDescrip,
                               String strPrice,
                               String strURLicon,
                               String strURLimage,
                               String strURLimage1,
                               String strURLimage2,
                               String strURLimage3,
                               String strURLimage4,
                               String strURLimage5) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_Soccerfield, strSoccerfield);
        contentValues.put(column_Description, strDescrip);
        contentValues.put(column_Price, strPrice);
        contentValues.put(column_URLicon, strURLicon);
        contentValues.put(column_URLimage, strURLimage);
        contentValues.put(column_URLimage1, strURLimage1);
        contentValues.put(column_URLimage2, strURLimage2);
        contentValues.put(column_URLimage3, strURLimage3);
        contentValues.put(column_URLimage4, strURLimage4);
        contentValues.put(column_URLimage5, strURLimage5);


        return writeSqLiteDatabase.insert(soccerfield_table, null, contentValues);
    }


    public long addUser(String strUser,
                        String strPassword,
                        String strName,
                        String strAddress,
                        String strPhone) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_User, strUser);
        contentValues.put(column_Password, strPassword);
        contentValues.put(column_Name, strName);
        contentValues.put(column_Address, strAddress);
        contentValues.put(column_Phone, strPhone);

        return writeSqLiteDatabase.insert(user_table, null, contentValues);
    }


}   // Main Class
