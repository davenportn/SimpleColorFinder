package com.mobile.natalie.colorfinder;
/***
 * Simple Color Finder
 *  Program displays selected color with NumberPickers.
 *  @date 9/21/15
 *  @author Natalie Davenport
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumberPicker redPicker = (NumberPicker) findViewById(R.id.redPicker);
        redPicker.setMinValue(0);
        redPicker.setMaxValue(255);
        redPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                changeValue();
            }
        });
        NumberPicker greenPicker = (NumberPicker) findViewById(R.id.greenPicker);
        greenPicker.setMinValue(0);
        greenPicker.setMaxValue(255);
        greenPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                changeValue();
            }
        });
        NumberPicker bluePicker = (NumberPicker) findViewById(R.id.bluePicker);
        bluePicker.setMinValue(0);
        bluePicker.setMaxValue(255);
        bluePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                changeValue();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Updates the color display at the bottom and changes the background color
     */
    private void changeValue()
    {
        NumberPicker redPicker = (NumberPicker) findViewById(R.id.redPicker);
        NumberPicker greenPicker = (NumberPicker) findViewById(R.id.greenPicker);
        NumberPicker bluePicker = (NumberPicker) findViewById(R.id.bluePicker);
        TextView colorDisplay = (TextView) findViewById(R.id.colorDisplay);

        String color = String.format("(%d, %d, %d)", redPicker.getValue(), greenPicker.getValue(), bluePicker.getValue());

        displayColor(redPicker.getValue(), greenPicker.getValue(), bluePicker.getValue());
        colorDisplay.setText(color);
    }

    /**
     * Displays background color
     * @param r
     * @param g
     * @param b
     */
    private void displayColor(int r, int g, int b)
    {
        int rgb = android.graphics.Color.rgb(r,g,b);
        getWindow().getDecorView().setBackgroundColor(rgb);
    }
}
