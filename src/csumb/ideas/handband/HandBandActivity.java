package csumb.ideas.handband;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.util.*;

public class HandBandActivity extends Activity implements OnTouchListener{
    /** Called when the activity is first created. */
	StringBuilder builder = new StringBuilder();
	TextView textview;

	//onCreate method sets the window to fullscreen and creates an onTouchListener
    @Override
	public void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		textview = new TextView(this);
		textview.setText("Touch anywhere!"); 
		textview.setOnTouchListener(this); //registers our activity to with the textview so it recieves MotionEvents
		setContentView(textview);
    }
	
    //onTouch 
	public boolean onTouch(View v, MotionEvent event) {
		builder.setLength(0);
		switch (event.getAction()){
		case MotionEvent.ACTION_DOWN:
			builder.append("down, ");
			break;
		case MotionEvent.ACTION_MOVE:
			builder.append("move, ");
			break;
		case MotionEvent.ACTION_CANCEL:
			builder.append("cancel, ");
			break;
		case MotionEvent.ACTION_UP:
			builder.append("up, ");
			break;
		}
		
		builder.append(event.getX());
		builder.append(", ");
		builder.append(event.getY());
		String text = builder.toString();
		Log.d("Touch Test", text);
		textview.setText(text);
		
		return true;
	}
}