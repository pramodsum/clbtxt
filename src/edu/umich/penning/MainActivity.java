package edu.umich.penning;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	public static Context context;
	public static EditText et;
	private CollabEditTextListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if (listener == null)
        	listener = new CollabEditTextListener(et);
        
        setContentView(R.layout.activity_main);
        context = this;
        et = (EditText) findViewById(R.id.collabEditText1);
        et.addTextChangedListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.undo_button:
            	Toast.makeText(this, "Undo Pressed" , Toast.LENGTH_SHORT).show();
            	listener.undo();
                return true;
            case R.id.redo_button:
            	Toast.makeText(this, "Redo Pressed" , Toast.LENGTH_SHORT).show();
            	listener.redo();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
