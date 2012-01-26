package com.gertrietveld.memorygame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Scoreboard extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scoreboard);

		
		Intent i = getIntent();
	    Bundle b = i.getExtras();
	    int score = b.getInt("com.gertrietveld.memorygame.SCORE");
		TextView t = (TextView) findViewById(R.id.scoreboard_text);
		t.setText("Youre finished the game in " + score + " tries!");
		
		
		Button startButton = (Button) findViewById(R.id.play_again);
		startButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startGame();
			}
		});
		
		

	}
	
	private void startGame() {
		SharedPreferences settings = getSharedPreferences("memoryPrefs", 0);
		SharedPreferences.Editor prefeditor = settings.edit();
		prefeditor.putBoolean("new_game", true);
		prefeditor.commit();
		Intent launchGame = new Intent(this, PlayGame.class);
		startActivity(launchGame);
	}

}
