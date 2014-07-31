package com.example.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends ActionBarActivity {

	private ListView listView;
	private final static String[] urls = {
		"http://www.google.com/doodles/moon-festival-mid-autumn-festival-2012",
		"http://www.google.com/doodles/anton-bernolaks-250th-birthday",
		"http://www.google.com/doodles/niels-bohrs-127th-birthday",
		"http://www.google.com/doodles/brazilian-elections-2012",
		"http://www.google.com/doodles/chuseok-2012",
		"http://www.google.com/doodles/david-unaipons-140th-birthday",
		"http://www.google.com/doodles/francisco-gabilondo-solers-105th-birthday",
		"http://www.google.com/doodles/brian-o-nuallains-101st-birthday",
		"http://www.google.com/doodles/german-reunification-day-2012",
		"http://www.google.com/doodles/janusz-korczaks-year"
};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.listView1);
		// String[] data = { "1", "2", "3", "4", "5", "6", "7", "8" };
		// ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1, data);
		// listView.setAdapter(arrayAdapter);

		int[] imgSrc = { R.drawable.g0, R.drawable.g1, R.drawable.g2,
				R.drawable.g3, R.drawable.g4, R.drawable.g5, R.drawable.g6,
				R.drawable.g7, R.drawable.g8, R.drawable.g9 };

		String[] text = { "image0", "image1", "image2", "image3", "image4",
				"image5", "image6", "image7", "image8", "image9" };
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < imgSrc.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("image", imgSrc[i]);
			item.put("text", text[i]);
			data.add(item);
		}

		SimpleAdapter simpleAdapter = new SimpleAdapter(this, data,
				R.layout.listitem, new String[] { "image", "text" }, new int[] {
						R.id.imageView1, R.id.textView1 });
		listView.setAdapter(simpleAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String url = urls[position];
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, WebActivity.class);
				intent.putExtra("url", url);
				MainActivity.this.startActivity(intent);
				
			}
		});

		// 1: only text
		// 1: array 1 ~ 8
		// 1: style item1

		// 2: image + text
		// 2: customize item view
		// 2: list of map string & object

		// 3: image + text + web
		// 3: init web activity
		// 3: set manifest
		// 3: webview
		// 3: on item click

		// 4: image + 2 lines text
		// 4: item view
		// 4: hash map string & object

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
}
