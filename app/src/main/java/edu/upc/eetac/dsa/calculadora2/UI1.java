package edu.upc.eetac.dsa.calculadora2;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UI1 extends AppCompatActivity {
    String tag = "Events";
    String op;
    double result;
    List<String> history = new ArrayList<>();
    int cont = 1;
    String lane = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui1);
        Log.d(tag, "event onCreate()");

        history = getIntent().getStringArrayListExtra("history");

        lane = getIntent().getExtras().getString("lane");

        if (lane != null){

            String[] words = lane.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                // You may want to check for a non-word character before blindly
                // performing a replacement
                // It may also be necessary to adjust the character class
                words[i] = words[i].replaceAll("[^\\w]", "");
            }
            int n1 = Integer.parseInt(words[0]);
            int n2 = Integer.parseInt(words[3]);
            String op = words[2];

            EditText numberOne = (EditText) findViewById(R.id.n1);
            EditText numberTwo = (EditText) findViewById(R.id.n2);
            numberOne.setText(n1);
            numberTwo.setText(n2);
            if (op.equals("+")){
                RadioButton radio = (RadioButton) findViewById(R.id.suma);
                radio.setChecked(true);
            }
            if (op.equals("-")){
                RadioButton radio = (RadioButton) findViewById(R.id.resta);
                radio.setChecked(true);
            }
            if (op.equals("x")){
                RadioButton radio = (RadioButton) findViewById(R.id.multiplicacion);
                radio.setChecked(true);
            }
            if (op.equals("/")){
                RadioButton radio = (RadioButton) findViewById(R.id.division);
                radio.setChecked(true);
            }

        }


    }

    protected void onStart() {
        super.onStart();
        Log.d(tag, "event onStart()");
    }

    protected void onResume() {

        super.onResume();
        Log.d(tag, "event onResume()");
    }

    protected void onPause() {
        super.onPause();
        Log.d(tag, "event onPause()");
    }

    protected void onStop() {
        super.onStop();
        Log.d(tag, "event onStop()");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "event onDestroy()");
    }

    public void getOp(View v) {
        boolean checked = ((RadioButton) v).isChecked();
        op = null;

        switch (v.getId()) {
            case R.id.suma:
                if (checked) op = "suma";
                break;
            case R.id.resta:
                if (checked) op = "resta";
                break;
            case R.id.multiplicacion:
                if (checked) op = "multiplicacion";
                break;
            case R.id.division:
                if (checked) op = "division";
                break;

        }

        if (op==null){
            Context c = getApplicationContext();
            CharSequence t = "Els valors ha de ser valors numèrics enters";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(c, t, duration);
            toast.show();
        }

    }

    public void erase(View v) {
        EditText numberOne = (EditText) findViewById(R.id.n1);
        EditText numberTwo = (EditText) findViewById(R.id.n2);
        TextView res = (TextView) findViewById(R.id.result);

        numberOne.setText("0");
        numberTwo.setText("0");
        res.setText("0");
    }

    public void calculate(View v) {

        try {
            EditText numberOne = (EditText) findViewById(R.id.n1);
            EditText numberTwo = (EditText) findViewById(R.id.n2);
            int n1 = Integer.parseInt(numberOne.getText().toString());
            int n2 = Integer.parseInt(numberTwo.getText().toString());

            if (op == "suma") {
                result = n1 + n2;
                history.add(cont,n1 + " + " + n2 + " = " + result );
                cont++;
            }
            if (op == "resta") {
                result = n1 - n2;
                history.add(cont,n1 + " - " + n2 + " = " + result );
                cont++;
            }
            if (op == "multiplicacion") {
                result = n1 * n2;
                history.add(cont,n1 + " x " + n2 + " = " + result );
                cont++;
            }
            if (op == "division") {
                result = n1 / n2;
                history.add(cont,n1 + " / " + n2 + " = " + result );
                cont++;
            }

            TextView res = (TextView) findViewById(R.id.result);
            res.setText("" + result);

        } catch (Exception e) {

            Context c = getApplicationContext();
            CharSequence t = "Cal indicar els dos\n" +
                    "valors numèrics";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(c, t, duration);
            toast.show();

        }

    }

    public void history(View view){
        Intent inb1 = new Intent(UI1.this, UI2.class);
        Intent.putStringArrayListExtra("history", (ArrayList<String>) history);
        startActivity(inb1);


    }
}
