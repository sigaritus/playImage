package com.sigaritus.swu.playimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;


public class ColorActivity extends ActionBarActivity implements SeekBar.OnSeekBarChangeListener{

    ImageView imageView;
    SeekBar hue_bar,sat_bar,lum_bar;
    public static final int MAX=255;
    public static final int MID=127;
    float hue,sat,lum;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        imageView = (ImageView)findViewById(R.id.img);
        hue_bar = (SeekBar)findViewById(R.id.hue_bar);
        sat_bar = (SeekBar)findViewById(R.id.sat_bar);
        lum_bar =(SeekBar) findViewById(R.id.lum_bar);

        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.m);
        imageView.setImageBitmap(bitmap);

        hue_bar.setOnSeekBarChangeListener(this);
        sat_bar.setOnSeekBarChangeListener(this);
        lum_bar.setOnSeekBarChangeListener(this);

        hue_bar.setMax(MAX);
        sat_bar.setMax(MAX);
        lum_bar.setMax(MAX);

        hue_bar.setProgress(MID);
        sat_bar.setProgress(MID);
        lum_bar.setProgress(MID);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_color, menu);
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

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.hue_bar:
                hue=(progress-MID)*1.0f/MID*180;
                break;
            case R.id.sat_bar:
                sat=progress*1.0f/MID;
                break;
            case R.id.lum_bar:
                lum=progress*1.0f/MID;
                break;
        }

        imageView.setImageBitmap(ImageHelper.handleImage(bitmap,hue,sat,lum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
