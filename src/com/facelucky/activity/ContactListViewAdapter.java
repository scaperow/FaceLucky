package com.facelucky.activity;



import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactListViewAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private List<Map<String, Object>> data;
	private Context context;

	public ContactListViewAdapter(Context context,List<Map<String, Object>> data) {
		this.context = context;
		this.inflater = LayoutInflater.from(context);
		this.data = data;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ContactViewHolder holder = null;
		if (convertView == null) {

			holder = new ContactViewHolder();
			convertView = inflater
					.inflate(R.layout.list_contact_template, null);
			holder.contact_photo = (ImageView) convertView
					.findViewById(R.id.contact_photo);
			holder.contact_nickname = (TextView) convertView
					.findViewById(R.id.contact_nickname);
			holder.contact_info = (TextView) convertView
					.findViewById(R.id.contact_info);
			holder.button_chat = (Button) convertView
					.findViewById(R.id.button_chat);
			convertView.setTag(holder);
		} else {
			holder = (ContactViewHolder) convertView.getTag();
		}

		holder.contact_photo.setBackgroundResource((Integer) data.get(position)
				.get("contact_photo"));
		holder.contact_nickname.setText((String) data.get(position).get(
				"contact_nickname"));
		holder.contact_info.setText((String) data.get(position).get(
				"contact_info"));

		holder.button_chat.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// showInfo();
				context.startActivity(new Intent().setClass(context,
						ChatActivity.class));
			}
		});

		convertView.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				new AlertDialog.Builder(context)
						.setTitle("选项")
						.setItems(new String[] { "详细信息", "对话", "移除" },
								new OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										switch (which) {
										case 0:
											context.startActivity(new Intent()
													.setClass(
															context,
															ExplorActivity.class));
											break;

										case 1:
											context.startActivity(new Intent()
													.setClass(context,
															ChatActivity.class));
											break;

										case 2:
											
											break;
										}
									}
								}).show();
				return false;
			}
		});

		convertView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				context.startActivity(new Intent().setClass(context,
						ExplorActivity.class));
			}
		});

		return convertView;
	}
}

final class ContactViewHolder {
	public ImageView contact_photo;
	public TextView contact_nickname;
	public TextView contact_info;
	public Button button_chat;
}
