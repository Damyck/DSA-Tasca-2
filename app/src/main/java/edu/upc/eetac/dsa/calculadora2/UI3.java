package edu.upc.eetac.dsa.calculadora2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Marc on 9/12/2016.
 */

public class UI3 extends AppCompatActivity {

    String tag = "Events";
    ArrayList<String> history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui3);
        Log.d(tag, "event onCreate()");

        history = getIntent().getStringArrayListExtra("history");
    }

    protected void onStart(){
        super.onStart();
        Log.d(tag, "event onStart()");
    }

    protected void onResume(){

        super.onResume();
        Log.d(tag, "event onResume()");
    }

    protected void onPause(){
        super.onPause();
        Log.d(tag, "event onPause()");
    }

    protected void onStop(){
        super.onStop();
        Log.d(tag, "event onStop()");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d(tag, "event onDestroy()");
    }

    public void si(View view){
        Intent inb1 = new Intent(UI3.this, UI1.class);
        history.clear();
        Intent.putStringArrayListExtra("history", (ArrayList<String>) history);
        startActivity(inb1);


    }

    public void no(View view){
        Intent inb1 = new Intent(UI3.this, UI2.class);
        Intent.putStringArrayListExtra("history", (ArrayList<String>) history);
        startActivity(inb1);
    }

}
