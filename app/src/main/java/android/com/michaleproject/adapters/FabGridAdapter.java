package android.com.michaleproject.adapters;

import android.com.michaleproject.R;
import android.com.michaleproject.modals.FabGridModal;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amitrai on 18/3/16.
 */
public class FabGridAdapter extends BaseAdapter {

    private Context context = null;
    private List<FabGridModal> list_grid = new ArrayList();
    private LayoutInflater inflater = null;
    private ViewHolder holder = null;

    public FabGridAdapter(List<FabGridModal> list_grid, Context context){
        this.list_grid = list_grid;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list_grid.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.design_grid, null);
            holder.img_item_image = (ImageView) view.findViewById(R.id.img_item_logo);
            holder.txt_item_name = (TextView) view.findViewById(R.id.txt_item_name);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        setData(holder, position);
        return view;
    }

    class ViewHolder{
        TextView txt_item_name;
        ImageView img_item_image;
    }


    private void setData(ViewHolder holder, int position){
        FabGridModal modal = list_grid.get(position);

        if(modal.getItem_image_resource() != null){
            int id = Integer.parseInt(modal.getItem_image_resource());
            holder.img_item_image.setImageResource(id);
        }
        if(modal.getItem_name() != null)
            holder.txt_item_name.setText(modal.getItem_name());
    }
}
