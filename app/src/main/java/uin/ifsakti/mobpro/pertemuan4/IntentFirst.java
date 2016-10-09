package uin.ifsakti.mobpro.pertemuan4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IntentFirst extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_first);

        //Inisialisasi Button dengan id Button yang ada di XML
        Button kontak = (Button) findViewById(R.id.button_kontak_telepon);
        Button internet = (Button) findViewById(R.id.button_internet);
        Button dial_numb = (Button) findViewById(R.id.button_dial_numb);
        Button messages = (Button) findViewById(R.id.button_message);
        Button mapsarea = (Button) findViewById(R.id.button_maps);

        Button exit = (Button) findViewById(R.id.button_exit);

        //Set Action Click untuk id Button kontak
        kontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity_kontak = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
                startActivity(activity_kontak);
            }
        });

        //set Action Click untuk id Button Internet
        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity_internet = new Intent(Intent.ACTION_VIEW, Uri
                        .parse("http://www.google.com"));
                startActivity(activity_internet);
            }
        });

        //set Action Click untuk id Button dial_numb
        dial_numb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity_dial = new Intent(Intent.ACTION_DIAL, Uri
                        .parse("tel:081573819104"));
                startActivity(activity_dial);
            }
        });

        //set Action Click untuk id Button message
        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms://"));
                intent.putExtra("address", "555-1234");
                intent.putExtra("sms_body", "remember to buy bread and milk");
                startActivity(intent);
            }
        });

        //set Action Click untuk id Button message
        mapsarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoCode ="geo:41.5020952,-81.6789717";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoCode));
                startActivity(intent);

            }
        });

        //set Action Click untuk id Button exit
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //untuk keluar dari activity
            }
        });
    }
}
