package com.test.listviewposition;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
/**
 * 
 * @author liyakun
 * 创建时间：2014年9月18日
 */
public class ListViewDemo2Activity extends Activity {

	private SelectedAdapter selectedAdapter;
	private ArrayList<String> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		list = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			list.add("你 " + i);
			list.add("我" + i);
			list.add("他" + i);
		}

		selectedAdapter = new SelectedAdapter(this,list);
		

		ListView listview = (ListView) findViewById(R.id.listExample);
		listview.setAdapter(selectedAdapter);

		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView arg0, View view, int position, long id) {
				selectedAdapter.setSelectedPosition(position);
			}
		});
	}
}