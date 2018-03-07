package com.facelucky.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

public class ExplorActivity extends Activity implements Button.OnClickListener {

	ExpandableListView expand_details = null;
	Button button_start = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_explor);
		setExpandList();
		button_start = (Button) this.findViewById(R.id.button_start_chat);
		button_start.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_explor, menu);
		return true;
	}

	public void setExpandList() {
		expand_details = (ExpandableListView) this
				.findViewById(R.id.expand_details);
		ExpandableAdapter adapter = new ExpandableAdapter(ExplorActivity.this);
		expand_details.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == button_start.getId()) {
			this.startActivity(new Intent().setClass(this, ChatActivity.class));
		}
	}
}
