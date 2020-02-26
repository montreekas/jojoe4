package com.dmp.montreekasa.jojoe2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main4Activity extends AppCompatActivity {
    private int mSceenWidth;
    private ImageView mCar;
    private ImageView mTrees;
    private int mTreesWidth;
    private int mCarWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
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

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        mSceenWidth = displayMetrics.widthPixels;

        mCar = (ImageView)findViewById(R.id.img_car);
        mTrees = (ImageView)findViewById(R.id.img_trees);

        mCar.post(new Runnable() {
            @Override
            public void run() {
                mCarWidth = mCar.getWidth();
                setCarStartPoint();
            }
        });

        mTrees.post(new Runnable() {
            @Override
            public void run() {
                mTreesWidth = mTrees.getWidth();
                setTreeStartPoint();
            }
        });

        final Runnable runCar = new Runnable() {
            @Override
            public void run() {
                setCarStartPoint();
                mCar.animate().translationX(mSceenWidth).setDuration(5000).withEndAction(this).start();
            }
        };

        final Runnable runTrees = new Runnable() {
            @Override
            public void run() {
                setTreeStartPoint();
                mTrees.animate().translationX(-mTreesWidth).setDuration(5000).withEndAction(this).start();
            }
        };

        final Button button = (Button)findViewById(R.id.bt_click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button.getText().equals("Animate")){
                    mCar.animate().translationX(mSceenWidth).setDuration(5000).withEndAction(runCar).start();
                    mTrees.animate().translationX(-mTreesWidth-mTreesWidth).setDuration(5000).withEndAction(runTrees).start();
                    button.setText("Cancel");
                }
                else if(button.getText().equals("Cancel")) {
                    mCar.animate().cancel();
                    mTrees.animate().cancel();
                    setCarStartPoint();
                    setTreeStartPoint();
                    button.setText("Animate");
                }
            }
        });
    }

    private void setCarStartPoint(){
        mCar.setX(-mCarWidth);
        mCar.setY(450);
    }

    private void setTreeStartPoint(){
        mTrees.setX(mSceenWidth);
        mTrees.setY(300);
    }

}
