package user;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BillingDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "billing.db";

    public BillingDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the orders table
        db.execSQL("CREATE TABLE orders (order_id INTEGER PRIMARY KEY AUTOINCREMENT, flavor TEXT, quantity INTEGER, total_amount INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the orders table if it exists
        db.execSQL("DROP TABLE IF EXISTS orders");
        // Recreate the orders table
        onCreate(db);
    }

    public long addOrder(String flavor, int quantity, int totalAmount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("flavor", flavor);
        values.put("quantity", quantity);
        values.put("total_amount", totalAmount);
        long newRowId = db.insert("orders", null, values);
        db.close();
        return newRowId;
    }

    public Cursor getAllOrders() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query("orders", null, null, null, null, null, null);
    }
}
