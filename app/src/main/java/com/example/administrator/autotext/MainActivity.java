package com.example.administrator.autotext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.auto);

        db = new database(MainActivity.this);
        db.openDB();

        // Insert a few countries that begin with "C"
        db.insertCountry("america");
        db.insertCountry("barma");
        db.insertCountry("India");
        db.insertCountry("ethiopia");
        db.insertCountry("france");
        db.insertCountry("germany");
        db.insertCountry("hungary");
        db.insertCountry("netharland");
        db.insertCountry("russia");
        db.insertCountry("Cambodia");
        db.insertCountry("Cameroon");
        db.insertCountry("Canada");
        db.insertCountry("Cape Verde");
        db.insertCountry("Cayman Islands");
        db.insertCountry("Chad");
        db.insertCountry("Chile");
        db.insertCountry("China");

        //sqlliteCountryAssistant.removeCountry("Chad");
        //sqlliteCountryAssistant.updateCountry("Canada", "Costa Rica");

        String[] countries = db.getAllCountries();

        // Print out the values to the log
        for(int i = 0; i < countries.length; i++)
        {
            Log.i(this.toString(), countries[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.forautotext, countries);
        textView.setAdapter(adapter);
    }

    public void onDestroy()
    {
        super.onDestroy();
        db.close();
    }
}


