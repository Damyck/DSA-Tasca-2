package edu.upc.eetac.dsa.calculadora2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Marc on 9/12/2016.
 */

public class UI2 extends AppCompatActivity {

    String tag = "Events";
    ArrayList<String> history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui2);
        Log.d(tag, "event onCreate()");
        history = getIntent().getStringArrayListExtra("history");
        TextView hist = (TextView) findViewById(R.id.historialgordo);
        int size=history.size();
        for(int x=0;x<history.size();x++) {
            hist.setText(x+":"+history.get(x) + "/n");

        }
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

    public void retrn(View view){

        EditText ret = (EditText) findViewById(R.id.repeat);
        int rt = Integer.parseInt(ret.getText().toString());

        String s = history.get(rt);


        Intent inb1 = new Intent(UI2.this, UI1.class);
        Intent.putExtra("lane", s);
        startActivity(inb1);



    }

    public void borra(View view){
        Intent inb1 = new Intent(UI2.this, UI3.class);
        Intent.putStringArrayListExtra("history", (ArrayList<String>) history);
        startActivity(inb1);
    }

}
