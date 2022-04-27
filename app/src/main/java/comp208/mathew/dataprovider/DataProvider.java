package comp208.mathew.dataprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

public class DataProvider extends ContentProvider {
    public DataProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        //to send a GET request to jsonPlaceHolder and package result as a matrix Cursor
        String[]columnNames=Contract.columnNames;
        MatrixCursor mc=new MatrixCursor(columnNames);
        MatrixCursor.RowBuilder rb;
        for (int i = 1; i <= 10; i++) {
            rb=mc.newRow();
            rb.add("_id",i);
            rb.add("data","This is item #"+ i);
        }
        return mc;
    }
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
   public static class Contract
    {
        public static String AUTHORITY="comp208.mathew.dataprovider.provider";
        public static String[]columnNames={"_id","data" };
    }
}