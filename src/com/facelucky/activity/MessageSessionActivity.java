package com.facelucky.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MessageSessionActivity extends Activity {

	ListView list_message = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		setListControl();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_message, menu);
		return true;
	}

	public void setListControl() {
		List<Map<String, Object>> data = getMessageData();
		MessageSessionAdapter adapter = new MessageSessionAdapter(this, data);

		list_message = (ListView) this.findViewById(R.id.list_message_session);
		list_message.setAdapter(adapter);
	}

	public List<Map<String, Object>> getMessageData() {
		List<Map<String, Object>> message = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message_photo", R.drawable.photo1);
		map.put("message_message", "Hi£¬ÔÚÃ¦Âð£¿");
		map.put("message_nickname", "XXx");
		message.add(map);

		map = new HashMap<String, Object>();
		map.put("message_photo", R.drawable.photo1);
		map.put("message_message", "ÔõÃ´ÁË£¿");
		map.put("message_nickname", "XXx");
		message.add(map);

		map = new HashMap<String, Object>();
		map.put("message_photo", R.drawable.photo1);
		map.put("message_message", "Äã²Â£¿");
		map.put("message_nickname", "XXx");
		message.add(map);

		map = new HashMap<String, Object>();
		map.put("message_photo", R.drawable.photo1);
		map.put("message_message", "¹ö£¡");
		map.put("message_nickname", "XXx");
		message.add(map);

		map = new HashMap<String, Object>();
		map.put("message_photo", R.drawable.photo1);
		map.put("message_message", "...");
		map.put("message_nickname", "XXx");
		message.add(map);

		return message;
	}
}
