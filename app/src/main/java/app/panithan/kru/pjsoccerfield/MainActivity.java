package app.panithan.kru.pjsoccerfield;

import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // Explicit
    private MyManage myManage;
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bindwidget
        bindwiget();

        // Request SQLite
        myManage = new MyManage(this);

        // Test Add Value
        //testAddValue();

        //Delete SQLite
        deleteSQLite();
        synJSONtoSQLite();

    }  // Main Method

    private void bindwiget() {
        userEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText2);
    }

    public void clickSignInMain(View view) {

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        // Check Space
        if (userString.equals("") || passwordString.equals("")) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(MainActivity.this, "กรุณากรอกข้อมูลให้ครบนะคะ");
        }

    } // Click SiginIn

    private void synJSONtoSQLite() {

        //  Connected Http
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                .Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);


        int intTimes = 0;
        while (intTimes <=1) {

            // 1 Create InputStream
            InputStream inputStream = null;
            String[] urlStrings = {"http://swiftcodingthai.com/pj/php_get_user_popcorn.php",
                    "http://swiftcodingthai.com/pj/php_get_soccerfield_popcorn.php"};

            try {

                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(urlStrings[intTimes]);
                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                inputStream = httpEntity.getContent();



            } catch (Exception e) {
                Log.d("pj", "InputStream ==>" + e.toString());
            }

            // 2 Create JSON String
            String strJSON = null;

            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                StringBuilder stringBuilder = new StringBuilder();
                String strLine = null;
                while ((strLine = bufferedReader.readLine() ) != null) {
                    stringBuilder.append(strLine);
                }
                inputStream.close();
                strJSON = stringBuilder.toString();
            } catch (Exception e) {

                Log.d("pj", "JSON String ==>" + e.toString());

            }
            // 3 Update to SQLite
            try {

                JSONArray jsonArray = new JSONArray(strJSON);
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(intTimes);
                    switch (intTimes) {
                        case 0:

                            String strUser = jsonObject.getString(MyManage.column_User);
                            String strPassword = jsonObject.getString(MyManage.column_Password);
                            String strName = jsonObject.getString(MyManage.column_Name);
                            String strAddress = jsonObject.getString(MyManage.column_Address);
                            String strPhone = jsonObject.getString(MyManage.column_Phone);

                            myManage.addUser(strUser, strPassword, strName, strAddress, strPhone);
                            break;
                        case 1:

                            String strSoccerfield = jsonObject.getString(MyManage.column_Soccerfield);
                            String strDescrip = jsonObject.getString(MyManage.column_Description);
                            String strPrice = jsonObject.getString(MyManage.column_Price);
                            String strURLicon = jsonObject.getString(MyManage.column_URLicon);
                            String strURLimage = jsonObject.getString(MyManage.column_URLimage);
                            String strURLimage1 = jsonObject.getString(MyManage.column_URLimage1);
                            String strURLimage2 = jsonObject.getString(MyManage.column_URLimage2);
                            String strURLimage3 = jsonObject.getString(MyManage.column_URLimage3);
                            String strURLimage4 = jsonObject.getString(MyManage.column_URLimage4);
                            String strURLimage5 = jsonObject.getString(MyManage.column_URLimage5);

                            myManage.addSoccerfield(strSoccerfield, strDescrip, strPrice, strURLicon, strURLimage, strURLimage1, strURLimage2, strURLimage3, strURLimage4, strURLimage5);
                            break;

                    }
                }

            } catch (Exception e) {
                Log.d("pj", "Update SQLite ==>" + e.toString());
            }


            intTimes += 1;
        }   // while
    }   // synJSON

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
