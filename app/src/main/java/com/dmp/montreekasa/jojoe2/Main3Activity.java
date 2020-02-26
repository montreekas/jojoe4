package com.dmp.montreekasa.jojoe2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final ImageView mImage = (ImageView)findViewById(R.id.imgView);

        findViewById(R.id.bt_rotate).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText textAngle = (EditText)findViewById(R.id.text_angle);
                        if(isNumeric(textAngle.getText().toString())){
                            int angle = Integer.valueOf(textAngle.getText().toString());
                            mImage.animate().rotationBy(angle).setDuration(2000).start();
                        }
                        else{
                            System.out.println("textAngle is Null");
                        }
                    }
                }
        );

        findViewById(R.id.bt_flip_vert).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mImage.animate().rotationXBy(180).setDuration(2000).start();
                    }
                }
        );

        findViewById(R.id.bt_flip_horz).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mImage.animate().rotationYBy(180).setDuration(2000).start();
                    }
                }
        );

        findViewById(R.id.bt_zoomin).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mImage.animate().scaleX(1f).scaleY(1f).setDuration(1000).start();
                    }
                }
        );

        findViewById(R.id.bt_zoomout).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mImage.animate().scaleX(0.3f).scaleY(0.3f).setDuration(1000).start();
                    }
                }
        );

        findViewById(R.id.bt_fadein).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mImage.animate().alpha(1f).setDuration(1000).start();
                    }
                }
        );

        findViewById(R.id.bt_fadeout).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mImage.animate().alpha(0.1f).setDuration(1000).start();
                    }
                }
        );

        
    }

    public static boolean isNumeric(final String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        try {

            Integer.parseInt(str);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }

    }

}
