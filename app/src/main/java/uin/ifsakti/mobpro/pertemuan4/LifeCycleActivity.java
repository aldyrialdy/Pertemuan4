package uin.ifsakti.mobpro.pertemuan4;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LifeCycleActivity extends AppCompatActivity {
    TextView txtToDo;
    EditText txtColorSelect;
    Button btnFinish;
    LinearLayout myScreen;
    String MYPREFSID = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        myScreen = (LinearLayout) findViewById(R.id.myScreen);

        txtToDo = (TextView) findViewById(R.id.txtToDo);
        String msg = "Instructions:                                 \n"
                + "0. New instance (onCreate, onStart, onResume)    \n"
                + "1. Back Arrow\n (onPause, onStop, onDestroy)     \n"
                + "2. Finish (onPause, onStop, onDestroy)    \n"
                + "3. Home (onPause, onStop)    \n"
                + "4. After 3 > App Tab > re-execute current app   \n"
                + "(onRestart, onStart, onResume)   \n"
                + "5. Run DDMS > Receive a phone call or SMS    \n"
                + "(onRestart, onStart, onResume)   \n"
                + "6. Enter some data - repeat steps 1-5  \n";
        txtColorSelect = (EditText) findViewById(R.id.txtColorSelect);
        txtColorSelect.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                changeBackgroundColor(editable.toString());
            }
        });

        btnFinish = (Button) findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Toast.makeText(getApplicationContext(), "OnCreate", 1).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveDataFromCurrentState();
        Toast.makeText(this, "On Pause", 1).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "On Restart", 1).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "On Resume", 1).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateFromSavedState();
        Toast.makeText(this, "onStart", 1).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", 1).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", 1).show();
    }

    protected void saveDataFromCurrentState() {
        SharedPreferences myPrefs = getSharedPreferences(MYPREFSID, Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = myPrefs.edit();
        myEditor.putString("myBkColor", txtColorSelect.getText().toString());
        myEditor.commit();
    }// saveDataFromCurrentState

    protected void updateFromSavedState() {
        SharedPreferences myPrefs = getSharedPreferences(MYPREFSID, Context.MODE_PRIVATE);
        if ((myPrefs != null) && (myPrefs.contains("myBkColor"))) {
            String theChosenColor = myPrefs.getString("myBkColor", "");
            txtColorSelect.setText(theChosenColor);
            changeBackgroundColor(theChosenColor);
        }
    }// UpdateFromSavedState

    protected void clearMyPreferences() {
        SharedPreferences myPrefs = getSharedPreferences(MYPREFSID, Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = myPrefs.edit();
        myEditor.clear();
        myEditor.commit();
    }

    private void changeBackgroundColor(String theChosenColor) {
        // change background color
        if (theChosenColor.contains("red"))
            myScreen.setBackgroundColor(0xffff0000);
        else if (theChosenColor.contains("green"))
            myScreen.setBackgroundColor(0xff00ff00);
        else if (theChosenColor.contains("blue"))
            myScreen.setBackgroundColor(0xff0000ff);
        else {
        //reseting user preferences
            clearMyPreferences();
            myScreen.setBackgroundColor(0xff000000);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getBaseContext(), "onRestoreInstanceState ...BUNDLING", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getBaseContext(), "onSaveInstanceState...BUNDLING", Toast.LENGTH_LONG).show();
    } // onSaveInstanceState

}
