package com.facelucky.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.facelucky.activity.R;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends Activity implements Button.OnClickListener {

	Handler controlInvoker = new Handler();
	TabHost tab_host;
	Button button_explor;
	ProgressBar progress_explor;
	ListView list_contact;
	ListView list_message;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tab_host = (TabHost) this.findViewById(R.id.tab_host);
		tab_host.setup();

		LayoutInflater inflater_tab1 = LayoutInflater.from(this);
		inflater_tab1.inflate(R.layout.tab_message,
				tab_host.getTabContentView());
		inflater_tab1
				.inflate(R.layout.tab_explor, tab_host.getTabContentView());
		inflater_tab1.inflate(R.layout.tab_contact,
				tab_host.getTabContentView());
		inflater_tab1.inflate(R.layout.tab_setting,
				tab_host.getTabContentView());

		tab_host.addTab(tab_host.newTabSpec("Message").setIndicator("消息")
				.setContent(R.id.layout_message));
		tab_host.addTab(tab_host.newTabSpec("Explor").setIndicator("认识朋友")
				.setContent(R.id.layout_explor));
		tab_host.addTab(tab_host.newTabSpec("Contact").setIndicator("联系人")
				.setContent(R.id.layout_contact));
		tab_host.addTab(tab_host.newTabSpec("Setting").setIndicator("设置")
				.setContent(R.id.layout_setting));

		button_explor = (Button) this.findViewById(R.id.button_explor);
		button_explor.setOnClickListener(this);
		progress_explor = (ProgressBar) this.findViewById(R.id.process_explor);

		setContactControl();
		setMessageControl();
	}

	private void setMessageControl() {
		List<Map<String, Object>> data = getMessageData();
		MessageListViewAdapter adapter = new MessageListViewAdapter(this, data);
		list_message = (ListView) this.findViewById(R.id.list_message);
		list_message.setAdapter(adapter);
	}

	private void setContactControl() {
		List<Map<String, Object>> data = getContactData();
		ContactListViewAdapter adapter = new ContactListViewAdapter(this, data);

		list_contact = (ListView) this.findViewById(R.id.list_contact);
		list_contact.setAdapter(adapter);
	}

	private List<Map<String, Object>> getMessageData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message_photo", R.drawable.photo1);
		map.put("message_nickname", "XXX");
		map.put("message_option", "Hi,在忙吗？");

		list.add(map);

		map = new HashMap<String, Object>();
		map.put("message_photo", R.drawable.photo3);
		map.put("message_nickname", "XXX");
		map.put("message_option", "语音留言");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("message_photo", R.drawable.photo2);
		map.put("message_nickname", "XXX");
		map.put("message_option", "-------xxxx--------------");
		list.add(map);

		return list;
	}
	
	

	private List<Map<String, Object>> getContactData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contact_photo", R.drawable.photo1);
		map.put("contact_info", "XXX");
		map.put("contact_nickname", "asdfasdfasdfsadfasdf");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("contact_photo", R.drawable.photo3);
		map.put("contact_info", "XXX2");
		map.put("contact_nickname", "asdfasdfasdfsadfasdf");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("contact_photo", R.drawable.photo4);
		map.put("contact_info", "XXX3");
		map.put("contact_nickname", "dfgsdfgsdfgdsfgsdfg");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("contact_photo", R.drawable.photo3);
		map.put("contact_info", "签名签名签名签名签名签名！！！");
		map.put("contact_nickname", "YYY");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("contact_photo", R.drawable.photo2);
		map.put("contact_info", "签名签名签名签名签名签名！！！");
		map.put("contact_nickname", "YYY34");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("contact_photo", R.drawable.photo2);
		map.put("contact_info", "签名签名签名签名签名签名！！！");
		map.put("contact_nickname", "YYY");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("contact_photo", R.drawable.photo1);
		map.put("contact_info", "签名签名签名签名签名签名！！！");
		map.put("contact_nickname", "YYY2");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("contact_photo", R.drawable.photo4);
		map.put("contact_info", "签名签名签名签名签名签名！！！");
		map.put("contact_nickname", "XX");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("contact_photo", R.drawable.photo1);
		map.put("contact_info", "签名签名签名签名签名签名！！！");
		map.put("contact_nickname", "XXX2");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("contact_photo", R.drawable.photo4);
		map.put("contact_info", "签名签名签名签名签名签名！！！");
		map.put("contact_nickname", "XXX1");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("contact_photo", R.drawable.photo3);
		map.put("contact_info", "签名签名签名签名签名签名！！！");
		map.put("contact_nickname", "XXX");
		list.add(map);

		return list;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		button_explor.setVisibility(View.GONE);
		progress_explor.setVisibility(View.VISIBLE);

		Toast.makeText(this, "开始匹配", Toast.LENGTH_LONG).show();

		new Thread(new Runnable() {
			int prcoess = 0;

			public void run() {
				while (++prcoess <= 5) {
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				controlInvoker.post(new Runnable() {
					public void run() {
						MainActivity.this.startActivity(new Intent().setClass(
								MainActivity.this, ExplorActivity.class));
						progress_explor.setVisibility(View.GONE);
						button_explor.setVisibility(View.VISIBLE);
					}
				});
			}
		}).start();
	}

}
