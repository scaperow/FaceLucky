package com.facelucky.activity;

import com.facelucky.activity.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class RegisterStep1Activity extends Activity implements
		Button.OnClickListener {

	Button button_continue = null;
	Button button_back = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_step1);

		button_continue = (Button) this.findViewById(R.id.button_continue);
		button_continue.setOnClickListener(this);
		button_back = (Button)this.findViewById(R.id.button_back);
		button_back.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_register_step1, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == button_continue.getId()) {
			this.startActivity(new Intent().setClass(this,
					RegisterStep2Activity.class).setFlags(
					Intent.FLAG_ACTIVITY_NEW_TASK));
		}
		
		if(v.getId() == button_back.getId()){
			this.finish();
		}
	}
}
