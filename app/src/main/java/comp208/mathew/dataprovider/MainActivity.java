package comp208.mathew.dataprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
//import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

 String TAG="--";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver contentResolver = getContentResolver();
        Uri.Builder builder=new Uri.Builder();
       Uri uri= builder.scheme("content")
                .authority(DataProvider.Contract.AUTHORITY)
               .build();

      Log.i(TAG,"onCreate: "+uri.toString());
       Cursor cursor= contentResolver.query(uri,null,null,null,null);
        if(cursor==null)
            Log.i(TAG,"onCreate: "+"cursor is null");
        else
        {
            while (cursor.moveToNext()) {
                Log.i(TAG, "onCreate: " + cursor.getInt(0)+""+cursor.getString(1));
            }
        }

    }
}