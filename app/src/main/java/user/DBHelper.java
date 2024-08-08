package user;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBName = "register.db";

    public DBHelper(@Nullable Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase SQLiteDatabase) {
        SQLiteDatabase.execSQL("create table users(username Text primary key, password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {


    }

    public boolean InsertData(String username, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = myDB.insert("users", null, contentValues);
        if (result == -1)
            return false;
        else return true;
    }


    public boolean checkUser(String username, String password) {
        SQLiteDatabase myDB = this.getReadableDatabase(); // Use getReadableDatabase for querying data
        Cursor cursor = myDB.rawQuery("select * from users where username=? and password=?",
                new String[]{username, password});
        if(cursor.getCount() > 0) {
            cursor.close(); // Close the cursor to release resources
            return true; // Return true if user is found
        } else {
            cursor.close(); // Close the cursor to release resources
            return false; // Return false if no user is found
        }
    }

}


