package com.popup.window;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import android.content.Context;
import android.content.Intent;
import android.view.Gravity;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;


public class MainActivity extends ActionBarActivity {
	 Button btnClosePopup;
	 Button btnCreatePopup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnCreatePopup = (Button) findViewById(R.id.button1);
		btnCreatePopup.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
		// TODO Auto-generated method stub
		initiatePopupWindow();
		}
		});

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	//___________________________________________________________________________________
	private PopupWindow pwindo;

	private void initiatePopupWindow() {
	try {
	// We need to get the instance of the LayoutInflater
	LayoutInflater inflater = (LayoutInflater) MainActivity.this
	.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	View layout = inflater.inflate(R.layout.screen_popup,
	(ViewGroup) findViewById(R.id.popup_element));
	pwindo = new PopupWindow(layout, 300, 370, true);
	pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);

	btnClosePopup = (Button) layout.findViewById(R.id.btn_close_popup);
	btnClosePopup.setOnClickListener(cancel_button_click_listener);

	} catch (Exception e) {
	e.printStackTrace();
	}
	}

	protected void onStop(){
	    super.onStop();
	    Intent intent = new Intent(this, MainActivity.class);
	    startActivity(intent);
	}
	private OnClickListener cancel_button_click_listener = new OnClickListener() {
	public void onClick(View v) {
	pwindo.dismiss();

	}
	};
	
}
