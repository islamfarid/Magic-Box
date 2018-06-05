package com.droidrank.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by "Islam Farid" on 6/5/2018.
 */

public class MainActivity extends AppCompatActivity {
    EditText mNumOfRowsOrColumnsEditText;
    Button mOpenMagicBoxButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumOfRowsOrColumnsEditText = (EditText) findViewById(R.id.et_num_of_rows_or_columns);
        mOpenMagicBoxButton = (Button) findViewById(R.id.btn_open_magic_box);
        mOpenMagicBoxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String numOfColumnsOrRows = mNumOfRowsOrColumnsEditText.getText().toString();
                    if (numOfColumnsOrRows.isEmpty()) {
                        Toast.makeText(MainActivity.this, getString(R.string.please_fill_data), Toast.LENGTH_LONG).show();
                    } else if (Integer.parseInt(numOfColumnsOrRows) <= 2) {
                        Toast.makeText(MainActivity.this, getString(R.string.error_invalid_row_or_column_num), Toast.LENGTH_LONG).show();
                    } else {
                        Intent intent = new Intent(MainActivity.this, MagicBoxActivity.class);
                        intent.putExtra(Constants.NUM_OF_ROWS_AND_COLUMNS, Integer.parseInt(numOfColumnsOrRows));
                        startActivity(intent);
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, getString(R.string.error_data_for_column_or_rows), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
