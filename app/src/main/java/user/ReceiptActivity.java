package user;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mainmenu.R;

public class ReceiptActivity extends AppCompatActivity {

    private BillingDBHelper dbHelper;
    private TextView totalAmountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        // Initialize database helper
        dbHelper = new BillingDBHelper(this);

        // Initialize TextView
        totalAmountTextView = findViewById(R.id.totalAmountTextView);

        // Display retrieved data
        displayData();
    }

    private void displayData() {
        // Get all orders from the database
        Cursor cursor = dbHelper.getAllOrders();

        // Calculate total amount
        double totalAmount = 0;
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int quantityIndex = cursor.getColumnIndex("quantity");
                double unitPriceIndex = cursor.getColumnIndex("unit_price");
                int quantity = cursor.getInt(quantityIndex);
                double unitPrice = cursor.getDouble((int) unitPriceIndex);
                //totalAmount += (quantity * unitPrice);
            } while (cursor.moveToNext());
            cursor.close();
        }

        // Display total amount
        totalAmountTextView.setText(String.format("Total Amount: $%.2f", totalAmount));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the database when the activity is destroyed
        dbHelper.close();
    }
}
