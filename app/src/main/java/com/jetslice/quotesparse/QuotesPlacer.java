package com.jetslice.quotesparse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QuotesPlacer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_placer);
        TextView quotes_placer=(TextView) findViewById(R.id.quote_placer_text);
        String passedArg = getIntent().getExtras().getString("arg");
        quotes_placer.setText(passedArg);
    }
}
