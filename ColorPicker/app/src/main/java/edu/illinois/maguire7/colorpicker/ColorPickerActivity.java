package edu.illinois.maguire7.colorpicker;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;


public class ColorPickerActivity extends Activity {

    private LinearLayout mContainer;

    private String mAlphaComponent;
    private String mRedComponent;
    private String mGreenComponent;
    private String mBlueComponent;

    private TextView mHexValueTextView;
    private TextView mAlphaTextView;
    private TextView mRedTextView;
    private TextView mGreenTextView;
    private TextView mBlueTextView;

    private SeekBar mAlphaSeekBar;
    private SeekBar mRedSeekBar;
    private SeekBar mGreenSeekBar;
    private SeekBar mBlueSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        mContainer = (LinearLayout) findViewById(R.id.activityContainer);

        mHexValueTextView = (TextView) findViewById(R.id.hex_value_textView);
        mAlphaTextView = (TextView) findViewById(R.id.alpha_textView);
        mRedTextView = (TextView) findViewById(R.id.red_textView);
        mGreenTextView = (TextView) findViewById(R.id.green_textView);
        mBlueTextView = (TextView) findViewById(R.id.blue_textView);

        mAlphaSeekBar = (SeekBar) findViewById(R.id.alpha_seekBar);
        mRedSeekBar = (SeekBar) findViewById(R.id.red_seekBar);
        mGreenSeekBar = (SeekBar) findViewById(R.id.green_seekBar);
        mBlueSeekBar = (SeekBar) findViewById(R.id.blue_seekBar);

        mAlphaTextView.setText(Integer.toHexString(mAlphaSeekBar.getProgress()));
        mRedTextView.setText(Integer.toHexString(mRedSeekBar.getProgress()));
        mGreenTextView.setText(Integer.toHexString(mGreenSeekBar.getProgress()));
        mBlueTextView.setText(Integer.toHexString(mBlueSeekBar.getProgress()));

        mAlphaComponent = Integer.toHexString(mAlphaSeekBar.getProgress());
        mRedComponent = Integer.toHexString(mRedSeekBar.getProgress());
        mGreenComponent = Integer.toHexString(mGreenSeekBar.getProgress());
        mBlueComponent = Integer.toHexString(mBlueSeekBar.getProgress());

        String backgroundHexValue = mAlphaTextView.getText().toString() + mRedTextView.getText().toString() + mGreenTextView.getText().toString() + mBlueTextView.getText().toString();
        mHexValueTextView.setText("#" + backgroundHexValue);
        mContainer.setBackground(new ColorDrawable(Color.parseColor("#" + backgroundHexValue)));




        mAlphaSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                mAlphaComponent = Integer.toHexString(progress);
                if(mAlphaComponent.length()!=2)
                    mAlphaComponent = "0"+mAlphaComponent;
                mAlphaTextView.setText("m: " + mAlphaComponent);
                String backgroundHexValue = mAlphaComponent + mRedComponent + mGreenComponent + mBlueComponent;
                mHexValueTextView.setText("#" + backgroundHexValue);
                mContainer.setBackground(new ColorDrawable(Color.parseColor("#" + backgroundHexValue)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mRedSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                mRedComponent = Integer.toHexString(progress);
                if(mRedComponent.length()!=2)
                    mRedComponent = "0"+mRedComponent;
                mRedTextView.setText("R: " + mRedComponent);
                String backgroundHexValue = mAlphaComponent + mRedComponent + mGreenComponent + mBlueComponent;
                mHexValueTextView.setText("#" + backgroundHexValue);
                mContainer.setBackground(new ColorDrawable(Color.parseColor("#" + backgroundHexValue)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mGreenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                mGreenComponent = Integer.toHexString(progress);
                if(mGreenComponent.length()!=2)
                    mGreenComponent = "0"+mGreenComponent;
                mGreenTextView.setText("G: " + mGreenComponent);
                String backgroundHexValue = mAlphaComponent + mRedComponent + mGreenComponent + mBlueComponent;
                mHexValueTextView.setText("#" + backgroundHexValue);
                mContainer.setBackground(new ColorDrawable(Color.parseColor("#" + backgroundHexValue)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mBlueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                mBlueComponent = Integer.toHexString(progress);
                if(mBlueComponent.length()!=2)
                    mBlueComponent = "0"+mBlueComponent;
                mBlueTextView.setText("B: " + mBlueComponent);
                String backgroundHexValue = mAlphaComponent + mRedComponent + mGreenComponent + mBlueComponent;
                mHexValueTextView.setText("#" + backgroundHexValue);
                mContainer.setBackground(new ColorDrawable(Color.parseColor("#" + backgroundHexValue)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.color_picker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
