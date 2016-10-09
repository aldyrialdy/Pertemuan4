package uin.ifsakti.mobpro.pertemuan4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IntentSecond extends AppCompatActivity {

    EditText txtVal1;
    EditText txtVal2;
    TextView lblResult;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_second);

        txtVal1 = (EditText) findViewById(R.id.EditText01);
        txtVal2 = (EditText) findViewById(R.id.EditText02);
        lblResult = (TextView) findViewById(R.id.TextView01);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get values from the UI
                Double v1 = Double.parseDouble(txtVal1.getText().toString());
                Double v2 = Double.parseDouble(txtVal2.getText().toString());

                // create intent to call Activity2
                Intent myIntentA1A2 = new Intent(IntentSecond.this, IntentSecondExchange.class);

                // create a container to ship data
                Bundle myData = new Bundle();

                // add <key,value> data items to the container
                myData.putDouble("val1", v1);
                myData.putDouble("val2", v2);

                // attach the container to the intent
                myIntentA1A2.putExtras(myData);

                // call Activity2, tell your local listener to wait response
                startActivityForResult(myIntentA1A2, 101);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try{
            if ((requestCode == 101 ) && (resultCode == AppCompatActivity.RESULT_OK)){
                Bundle myResults = data.getExtras();
                Double vresult = myResults.getDouble("vresult");
                lblResult.setText("Sum is " + vresult);
            }
        }
        catch (Exception e) {
            lblResult.setText("Oops! - " + requestCode + " " + resultCode);
        }
    }//onActivityResult
}
