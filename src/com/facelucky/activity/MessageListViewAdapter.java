package com.facelucky.activity;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageListViewAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private List<Map<String, Object>> data;
	private Context context;

	public MessageListViewAdapter(Context context,
			List<Map<String, Object>> data) {
		this.inflater = LayoutInflater.from(context);
		this.data = data;
		this.context = context;
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

		MessageViewHolder holder = null;
		if (convertView == null) {

			holder = new MessageViewHolder();

			convertView = inflater
					.inflate(R.layout.list_message_template, null);
			holder.message_photo = (ImageView) convertView
					.findViewById(R.id.message_photo);
			holder.message_nickname = (TextView) convertView
					.findViewById(R.id.message_nickname);
			holder.message_option = (TextView) convertView
					.findViewById(R.id.message_option);
			convertView.setTag(holder);

		} else {
			holder = (MessageViewHolder) convertView.getTag();
		}
															
		MessageClass mc = (MessageClass) data.get(position)
				.get("message_class");
										
		if (mc == MessageClass.Picture) {

		} else if (mc == MessageClass.Text) {

		} else if (mc == MessageClass.Video) {
			
		}

		holder.message_photo.setBackgroundResource((Integer) data.get(position)
				.get("message_photo"));
		holder.message_nickname.setText((String) data.get(position).get(
				"message_nickname"));
		holder.message_option.setText((String) data.get(position).get(
				"message_option"));

		convertView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				context.startActivity(new Intent().setClass(context,
						MessageSessionActivity.class));
			}

		});

		return convertView;
	}
}

final class MessageViewHolder {
	public ImageView message_photo;
	public TextView message_nickname;
	public TextView message_option;
}

enum MessageClass {
	Text, Picture, Video, Location
}
