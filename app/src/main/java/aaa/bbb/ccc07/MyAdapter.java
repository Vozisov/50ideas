package aaa.bbb.ccc07;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<Item> data = new ArrayList<>();
    private Context context;
    private int[] bgs = new int[]{R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5, R.drawable.b6,
            R.drawable.b7, R.drawable.b8, R.drawable.b9, R.drawable.b10};

    MyAdapter(Context context, ArrayList<Item> arr) {
        if (arr != null) {
            data = arr;
        }
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int num) {
        return data.get(num);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int i, View someView, ViewGroup arg2) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (someView == null) {
            someView = inflater.inflate(R.layout.list_view_item, arg2, false);
        }
        LinearLayout ll = someView.findViewById(R.id.ll);
        TextView header = someView.findViewById(R.id.item_num);
        TextView subHeader = someView.findViewById(R.id.item_text);

        int pos;
        if (i < 10) {
            pos = i;
        } else {
            pos = i % 10;
        }

        ll.setBackgroundResource(bgs[pos]);
        header.setText(data.get(i).num);
        subHeader.setText(data.get(i).itemText);

        return someView;
    }
}
