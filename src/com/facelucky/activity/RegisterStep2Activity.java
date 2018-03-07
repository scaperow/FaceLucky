package com.facelucky.activity;

import java.nio.channels.FileChannel.MapMode;

import com.facelucky.activity.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class RegisterStep2Activity extends Activity implements
		Button.OnClickListener {

	Spinner spinner_region = null;
	Spinner spinner_city = null;
	Button button_continue = null;
	Button button_previous = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_step2);
		spinner_region = (Spinner) this.findViewById(R.id.spinner_region);
		spinner_city = (Spinner) this.findViewById(R.id.spinner_city);
		button_continue = (Button) this.findViewById(R.id.button_continue);
		button_continue.setOnClickListener(this);
		button_previous = (Button)this.findViewById(R.id.button_previous);
		button_previous.setOnClickListener(this);
	}

	private void setSpinnerSource() {
		{
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item);

			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			adapter.add("陕西");
			adapter.add("北京");
			adapter.add("深圳");
			adapter.add("苏州");
			spinner_region.setAdapter(adapter);
			spinner_region
					.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
						@Override
						public void onItemSelected(AdapterView<?> adapterView,
								View view, int position, long id) {
							Spinner spinner = (Spinner) adapterView;
							String itemContent = (String) adapterView
									.getItemAtPosition(position);
						}

						@Override
						public void onNothingSelected(AdapterView<?> view) {
						}
					});
		}

		{
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item);

			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			adapter.add("西安");
			adapter.add("咸阳");
			spinner_region.setAdapter(adapter);
			spinner_region
					.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
						@Override
						public void onItemSelected(AdapterView<?> adapterView,
								View view, int position, long id) {
							Spinner spinner = (Spinner) adapterView;
							String itemContent = (String) adapterView
									.getItemAtPosition(position);
						}

						@Override
						public void onNothingSelected(AdapterView<?> view) {
						}
					});
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_register_step2, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == this.button_continue.getId()) {
			this.startActivity(new Intent().setClass(this,
					RegisterStep3Activity.class));
		}
		
		if(v.getId() == this.button_previous.getId()){
			this.startActivity(new Intent().setClass(this,RegisterStep1Activity.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
		}
	}
}
