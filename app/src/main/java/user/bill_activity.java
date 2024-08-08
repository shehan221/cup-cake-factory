package user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mainmenu.R;

import java.util.HashMap;

public class bill_activity extends AppCompatActivity {

    private int quantity = 0;
    private int totalAmount = 0;
    private TextView quantityTextView;
    private TextView totalTextView;
    private Spinner cupcakeSpinner;
    private HashMap<String, Integer> flavorPrices;
    private BillingDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        // Initialize TextViews
        quantityTextView = findViewById(R.id.vanilla_quantity);
        totalTextView = findViewById(R.id.total_text);

        // Initialize cupcakeSpinner
        cupcakeSpinner = findViewById(R.id.cupcake_spinner);

        // Initialize DatabaseHelper
        dbHelper = new BillingDBHelper(this);

        // Define cupcake types and their prices
        flavorPrices = new HashMap<>();
        flavorPrices.put("Vanilla (Rs.2)", 2);
        flavorPrices.put("Chocolate (Rs.3)", 3);
        flavorPrices.put("Strawberry (Rs.4)", 4);

        // Set up the adapter for the spinner
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, flavorPrices.keySet().toArray(new String[0]));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cupcakeSpinner.setAdapter(adapter);

        // Set click listeners for buttons
        Button minusButton = findViewById(R.id.vanilla_minus_button);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementQuantity();
                updateTotalAmount();
            }
        });

        Button plusButton = findViewById(R.id.vanilla_plus_button);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementQuantity();
                updateTotalAmount();
            }
        });

        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTotalAmount();
            }
        });

        // Set up listeners for checkbox changes
        CheckBox vanillaCheckbox = findViewById(R.id.vanilla_checkbox);
        CheckBox chocolateCheckbox = findViewById(R.id.chocolate_checkbox);
        CheckBox strawberryCheckbox = findViewById(R.id.strawberry_checkbox);

        vanillaCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTotalAmount();
            }
        });

        chocolateCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTotalAmount();
            }
        });

        strawberryCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTotalAmount();
            }
        });

        // Set click listener for decrease button
        Button decreaseButton = findViewById(R.id.decrease_button);
        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementQuantity();
                updateTotalAmount();
            }
        });

        // Set click listener for clear button
        Button clearButton = findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearSelections();
            }
        });

        // Set click listener for confirm payment button
        Button confirmButton = findViewById(R.id.confirm_button);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmPayment();
            }
        });
    }

    // Function to increment cupcake quantity
    private void incrementQuantity() {
        quantity++;
        quantityTextView.setText(String.valueOf(quantity));
    }

    // Function to decrement cupcake quantity
    private void decrementQuantity() {
        if (quantity > 0) {
            quantity--;
            quantityTextView.setText(String.valueOf(quantity));
        }
    }

    // Function to update the total amount
    private void updateTotalAmount() {
        // Initialize total amount
        totalAmount = 0;

        // Check each checkbox and calculate total amount
        if (((CheckBox) findViewById(R.id.vanilla_checkbox)).isChecked()) {
            totalAmount += flavorPrices.get("Vanilla (Rs.2)") * quantity;
        }
        if (((CheckBox) findViewById(R.id.chocolate_checkbox)).isChecked()) {
            totalAmount += flavorPrices.get("Chocolate (Rs.3)") * quantity;
        }
        if (((CheckBox) findViewById(R.id.strawberry_checkbox)).isChecked()) {
            totalAmount += flavorPrices.get("Strawberry (Rs.4)") * quantity;
        }

        // Get the selected flavor from the spinner
        String selectedFlavor = cupcakeSpinner.getSelectedItem().toString();
        totalAmount += flavorPrices.get(selectedFlavor) * quantity;

        // Update totalTextView
        totalTextView.setText("Total: Rs" + totalAmount);
    }

    // Function to clear selections
    private void clearSelections() {
        // Uncheck checkboxes
        ((CheckBox) findViewById(R.id.vanilla_checkbox)).setChecked(false);
        ((CheckBox) findViewById(R.id.chocolate_checkbox)).setChecked(false);
        ((CheckBox) findViewById(R.id.strawberry_checkbox)).setChecked(false);
        ((CheckBox) findViewById(R.id.strawberry_checkbox)).setChecked(false);
        ((CheckBox) findViewById(R.id.strawberry_checkbox)).setChecked(false);

        // Reset quantity
        quantity = 0;
        quantityTextView.setText(String.valueOf(quantity));

        // Reset total amount
        totalAmount = 0;
        totalTextView.setText("Total: Rs" + totalAmount);
    }

    // Function to confirm payment and save the order to the database
    private void confirmPayment() {
        String selectedFlavor = cupcakeSpinner.getSelectedItem().toString();
        int totalAmount = this.totalAmount; // Use the totalAmount field of the activity
        int quantity = this.quantity; // Use the quantity field of the activity

        // Save the order to the database
        long newRowId = dbHelper.addOrder(selectedFlavor, quantity, totalAmount);
        if (newRowId != -1) {
            // Order saved successfully
            Toast.makeText(this, "Order saved successfully!", Toast.LENGTH_SHORT).show();

            // Pass data to ReceiptActivity
            Intent intent = new Intent(this, ReceiptActivity.class);
            intent.putExtra("selectedFlavor", selectedFlavor);
            intent.putExtra("quantity", quantity);
            intent.putExtra("totalAmount", totalAmount);
            startActivity(intent);
        } else {
            // Error saving order
            Toast.makeText(this, "Error saving order!", Toast.LENGTH_SHORT).show();
        }
    }
}
