package uin.ifsakti.mobpro.pertemuan4;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentSecondExchange extends AppCompatActivity implements View.OnClickListener {

    EditText dataReceived;
    Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_second_exchange);

        dataReceived = (EditText) findViewById(R.id.etDataReceived);
        btnDone = (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);

        Intent myLocalIntent = getIntent();

        Bundle myBundle = myLocalIntent.getExtras();
        Double v1 = myBundle.getDouble("val1");
        Double v2 = myBundle.getDouble("val2");

        Double vResult = v1+v2;

        dataReceived.setText("Data received is \n"
                + "val1= " + v1 + "\nval2= " + v2
                + "\n\nresult= " + vResult);

        // add to the bundle the computed result
        myBundle.putDouble("vresult", vResult);

        // attach updated bumble to invoking intent
        myLocalIntent.putExtras(myBundle);

        // return sending an OK signal to calling activity
        setResult(AppCompatActivity.RESULT_OK, myLocalIntent);

    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
