package com.gertrietveld.memorygame;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import android.content.SharedPreferences;


public class Settings extends Activity {
	
	private CheckBox ch_sound_correct, ch_sound_incorrect;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		ch_sound_correct = (CheckBox) findViewById(R.id.ch_sound_correct);
		ch_sound_incorrect = (CheckBox) findViewById(R.id.ch_sound_incorrect);
		
		
		Button saveButtonMenu = (Button) findViewById(R.id.save_prefs);
		saveButtonMenu.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent launchMenu = new Intent(getBaseContext(), MenuScreen.class);
				setPreferences(launchMenu);
			}
		});
		
		Button saveButtonGame = (Button) findViewById(R.id.save_game);
		saveButtonGame.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent launchGame = new Intent(getBaseContext(), PlayGame.class);
				launchGame.putExtra("SENDER","Settings");	
				setPreferences(launchGame);
			}
		});
		
		getPreferences();
	}
	
	private void getPreferences()
	{
	
		SharedPreferences settings = getSharedPreferences("memoryPrefs", 0);
		ch_sound_correct.setChecked(settings.getBoolean("play_sound_when_correct", true));
		ch_sound_incorrect.setChecked(settings.getBoolean("play_sound_when_incorrect", true));
		
	}
	
	private void setPreferences(Intent theIntent)
	{
		SharedPreferences settings = getSharedPreferences("memoryPrefs", 0);
		SharedPreferences.Editor prefeditor = settings.edit();
		prefeditor.putBoolean("play_sound_when_correct", ch_sound_correct.isChecked());
		prefeditor.putBoolean("play_sound_when_incorrect", ch_sound_incorrect.isChecked());
		prefeditor.commit();
		
		//Toast.makeText(this, "setPreferences",Toast.LENGTH_LONG);

		startActivity(theIntent);
		
	}
	

}
