package app.panithan.kru.pjsoccerfield;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by u on 18/3/2559.
 */
public class MyAlert {

    public void myDialog(Context context, String strMessage) {
        Toast.makeText(context, strMessage, Toast.LENGTH_LONG).show();
    }

}   // Main Class
