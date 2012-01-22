package com.gertrietveld.memorygame;

import com.gertrietveld.memorygame.R;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MenuScreen extends ListActivity {
	public static final String NEW_GAME = "new_game";

	/** Called when the activity is first created. */


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		final String[] ACTIVITY_CHOICES = new String[] {
			getString(R.string.menu_new_game),
			getString(R.string.menu_prefs)
		};
		
		setContentView(R.layout.menu);
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ACTIVITY_CHOICES));
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		getListView().setTextFilterEnabled(true);
		OnItemClickListener myOnItemClickListener = new OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
				switch(arg2) {
				case 0:
					startGame();
					break;
				case 1:
					startPrefs();
					break;
				default: break;
				}
				
			}
		};
		getListView().setOnItemClickListener(myOnItemClickListener);
	


	}

	private void startGame() {
		Intent launchGame = new Intent(this, PlayGame.class);
		launchGame.putExtra("SENDER", "MenuScreen");
		startActivity(launchGame);
	}
	
	private void startPrefs() {
		Intent launchPrefs = new Intent(this, Settings.class);
		startActivity(launchPrefs);
	}


}