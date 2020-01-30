package com.dmp.montreekasa.jojoe2;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        findViewById(R.id.button).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(
                                MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    }
                }
        );

        findViewById(R.id.button_x).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finishAffinity();
                        System.exit(0);
                    }
                }
        );

        /* -------- */
        EditText editText = (EditText)findViewById(R.id.txtUser);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);
        editText.setImeOptions(EditorInfo.IME_ACTION_GO);
        editText.setImeActionLabel("ไป", EditorInfo.IME_NULL);

        AutoCompleteTextView autoComplete = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        String[] item = {"Jojoe","Jojoe2","Jojoe3"};
        ArrayAdapter<String>adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,item);
        autoComplete.setAdapter(adapter);
        autoComplete.setThreshold(2);

        /* -------- */
//        TextView textView = (TextView)findViewById(R.id.textView);
//        Typeface typeface = Typeface.createFromAsset(getAssets(),"font/dsnwtn.ttf");
//        textView.setTypeface(typeface);
//        textView.setText("Jojoe");
//        textView.setTextSize(54);


        //textView.setTypeface(DS);

        MsgBox.show(MainActivity.this,"Jojoe");

    }

    @Override
    public void onBackPressed(){
        System.out.println("Jojoe");
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
}
