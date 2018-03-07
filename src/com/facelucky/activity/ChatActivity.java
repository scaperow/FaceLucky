package com.facelucky.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.VideoView;

public class ChatActivity extends Activity {
	
	VideoView video_preview = null;
	VideoView video_remote = null;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        
        this.video_preview = (VideoView)this.findViewById(R.id.video_preview);
        this.video_remote = (VideoView)this.findViewById(R.id.video_remote);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_chat, menu);
		return true;
	}
}
