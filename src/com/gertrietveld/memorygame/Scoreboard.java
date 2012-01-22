package com.gertrietveld.memorygame;

import android.app.Activity;
import android.content.Intent;
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
		Intent launchGame = new Intent(this, PlayGame.class);
		startActivity(launchGame);
	}

}
