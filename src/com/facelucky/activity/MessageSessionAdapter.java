package com.facelucky.activity;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageSessionAdapter extends BaseAdapter {

	Context context;
	List<Map<String, Object>> data;
	LayoutInflater inflater;

	public MessageSessionAdapter(Context context, List<Map<String, Object>> data) {
		this.context = context;
		this.data = data;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		MessageSessionHolder holder = null;

		if (convertView == null) {
			holder = new MessageSessionHolder();
			if (position % 2 == 0) {
				convertView = inflater.inflate(
						R.layout.list_message_left_template, null);
			} else {
				convertView = inflater.inflate(
						R.layout.list_message_right_template, null);
			}

			holder.message_photo = (ImageView) convertView
					.findViewById(R.id.session_message_photo_right);
			holder.message_nickname = (TextView) convertView
					.findViewById(R.id.session_message_nickname_right);
			holder.message_message = (TextView) convertView
					.findViewById(R.id.session_message_message_right);
		} else {
			holder = (MessageSessionHolder) convertView.getTag();
		}

		holder.message_photo.setBackgroundResource((Integer) data.get(position)
				.get("message_photo"));
		holder.message_nickname.setText((String) data.get(position).get(
				"message_nickname"));
		holder.message_message.setText((String) data.get(position).get(
				"message_message"));

		return convertView;
	}

}

class MessageSessionHolder {
	public ImageView message_photo;
	public TextView message_nickname;
	public TextView message_message;
}
