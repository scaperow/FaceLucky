package com.facelucky.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ContactActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_contact, menu);
        return true;
    }
}
