package com.facelucky.activity;

import com.facelucky.activity.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class RegisterStep3Activity extends Activity implements
		Button.OnClickListener {

	Button button_over = null;
	Button button_previous = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_step3);

		button_over = (Button) this.findViewById(R.id.button_over);
		button_previous = (Button) this.findViewById(R.id.button_previous);
		button_over.setOnClickListener(this);
		button_previous.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_register_step3, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == this.button_over.getId()) {
			this.startActivity(new Intent().setClass(this, LoginActivity.class)
					.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
		}

		if (v.getId() == this.button_previous.getId()) {
			this.startActivity(new Intent().setClass(this,
					RegisterStep2Activity.class).setFlags(
					Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
		}
	}
}
