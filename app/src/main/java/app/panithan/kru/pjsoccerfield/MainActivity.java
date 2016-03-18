package app.panithan.kru.pjsoccerfield;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Explicit
    private MyManage myManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Request SQLite
        myManage = new MyManage(this);

        // Test Add Value
        //testAddValue();

        //Delete SQLite
        deleteSQLite();

    }  // Main Method

    private void deleteSQLite() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        sqLiteDatabase.delete(MyManage.user_table, null, null);
        sqLiteDatabase.delete(MyManage.soccerfield_table, null, null);
        sqLiteDatabase.delete(MyManage.order_table, null, null);

    }

    private void testAddValue() {
        myManage.addUser("user", "pass", "name", "address", "phone");
        myManage.addSoccerfield("soccer", "descrip", "price", "icon", "image", "image1", "image2", "image3", "image4", "image5");
        myManage.addOrder("date", "name", "address", "phone", "soccer", "amount", "Total");
    }
} // Main Class
