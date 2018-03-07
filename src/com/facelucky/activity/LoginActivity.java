package com.facelucky.activity;

import com.facelucky.activity.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

public class LoginActivity extends Activity implements Button.OnClickListener {

	Button button_register = null;
	Button button_login = null;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		button_register = (Button) this.findViewById(R.id.button_register);
		button_login = (Button) this.findViewById(R.id.button_login);
		button_register.setOnClickListener(this);
		button_login.setOnClickListener(this);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == this.button_register.getId()) {
			this.startActivity(new Intent().setClass(this,
					RegisterStep1Activity.class).setFlags(
					Intent.FLAG_ACTIVITY_NEW_TASK));
			return;
		}

		if (v.getId() == this.button_login.getId()) {
			this.startActivity(new Intent().setClass(this, MainActivity.class)
					.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
			return;
		}
	}
}
