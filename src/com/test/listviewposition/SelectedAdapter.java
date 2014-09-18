package com.test.listviewposition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;





import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * adapter 的部分
 * @author liyakun
 * 创建时间：2014年9月18日
 */
public class SelectedAdapter extends BaseAdapter {
	ArrayList<String> list;
	Context context;
	int selectedPos=0;


	public SelectedAdapter(Context context, ArrayList<String> objects) {
		super();
		this.list = objects;
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}
    /**
     * 用于获得位置
     * @param pos
     */
	public void setSelectedPosition(int pos) {
		selectedPos = pos;
		// inform the view of this change
		notifyDataSetChanged();
	}

	public int getSelectedPosition() {
		return selectedPos;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		if (v == null) {
			v = (TextView) View.inflate(context,R.layout.selected_row, null);
			
		}

		// get text view
		TextView label = (TextView) v.findViewById(R.id.txtExample);

		// change the row color based on selected state
		if (selectedPos == position) {
			label.setBackgroundColor(Color.RED);
		} else {
			label.setBackgroundColor(Color.WHITE);
		}

		label.setText(this.getItem(position).toString());
		return (v);
	}

	
}