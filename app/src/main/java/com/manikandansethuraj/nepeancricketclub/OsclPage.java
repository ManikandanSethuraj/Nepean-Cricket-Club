package com.manikandansethuraj.nepeancricketclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OsclPage extends AppCompatActivity {

    TextView osclDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oscl_page);

        osclDescription = (TextView) findViewById(R.id.osclDescription);
        String osclDes = "Ottawa Softball Cricket League was started in Ottawa by Nepean Cricket Club. " +
                "In loving memory of late Suravinth Sundralingam, this league was commenced in the summer of 2015, and was" +
                " a big success in the Ottawa Region. Suravinth was one of the senior member of NCC and he represented Canada " +
                "in Under-19 Cricket and he was the first Srilankan Cricketer to play in worldcup stage for Canada.";

        osclDescription.setText(osclDes);
    }
}
