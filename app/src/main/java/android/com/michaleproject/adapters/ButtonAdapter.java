package android.com.michaleproject.adapters;

import android.com.michaleproject.R;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

/**
 * Created by amitrai on 18/3/16.
 */
public class ButtonAdapter extends BaseAdapter {
    private Context mContext;
    public String[] filesnames = {
            "File 1",
            "File 2",
            "Roflcopters"
    };

    // Gets the context so it can be used later
    public ButtonAdapter(Context c) {
        mContext = c;
    }

    // Total number of things contained within the adapter
    public int getCount() {
        return filesnames.length;
    }

    // Require for structure, not really used in my code.
    public Object getItem(int position) {
        return null;
    }

    // Require for structure, not really used in my code. Can
    // be used to get the id of an item in the adapter for
    // manual control.
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position,
                        View convertView, ViewGroup parent) {
        Button btn;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            btn = new Button(mContext);
            btn.setLayoutParams(new GridView.LayoutParams(100, 55));
            btn.setPadding(8, 8, 8, 8);
        }
        else {
            btn = (Button) convertView;
        }

        btn.setText(filesnames[position]);
        // filenames is an array of strings
        btn.setTextColor(Color.WHITE);
        btn.setBackgroundResource(R.drawable.armani);
        btn.setId(position);

        return btn;
    }


}
