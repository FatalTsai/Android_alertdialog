package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get reference of widgets from XML layout
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
        final TextView tv_message = (TextView) findViewById(R.id.tv_message);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Build an AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.alertdialog_custom_view,null);
                // Set the custom layout as alert dialog view
                builder.setView(dialogView);
                // Get the custom alert dialog view widgets reference
                Button btn_positive = (Button) dialogView.findViewById(R.id.dialog_positive_btn);
                Button btn_negative = (Button) dialogView.findViewById(R.id.dialog_negative_btn);
                Button btn_neutral = (Button) dialogView.findViewById(R.id.dialog_neutral_btn);
                // Create the alert dialog
                final AlertDialog dialog = builder.create();
                // Set positive/yes button click listener
                btn_positive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Dismiss the alert dialog
                        dialog.cancel();
                        tv_message.setText("Yes button clicked");
                        // Set the TextView text color red
                        tv_message.setTextColor(Color.RED);
                    }
                });
                // Set negative/no button click listener
                btn_negative.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Dismiss the alert dialog
                        dialog.cancel();
                        tv_message.setText("No button clicked");
                    }
                });
                // Set cancel/neutral button click listener
                btn_neutral.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Dismiss/cancel the alert dialog
                        dialog.cancel();
                        tv_message.setText("Cancel button clicked");
                    }
                });
                // Display the custom alert dialog on interface
                dialog.show();
            }
        });
    }
}
