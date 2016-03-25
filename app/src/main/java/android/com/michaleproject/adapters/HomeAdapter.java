package android.com.michaleproject.adapters;

import android.com.michaleproject.R;
import android.com.michaleproject.modals.HomeItemModal;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amitrai on 22/3/16.
 */
public class HomeAdapter extends BaseAdapter{

    private List<HomeItemModal> list_home = new ArrayList<>();
    private LayoutInflater inflater = null;
    private Context context = null;
    private HomeAdapter.ViewHolder holder = null;
    private int lastPosition = -1;


    public HomeAdapter(Context context, List<HomeItemModal> list_home){
        this.context = context;
        this.list_home = list_home;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list_home.size();
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
            view = inflater.inflate(R.layout.design_home, null);
//            holder = new ViewHolder();
//            holder.img_item = (ImageView) view.findViewById(R.id.img_itemlogo);
//            holder.img_large = (ImageView) view.findViewById(R.id.img_large);
//            holder.txt_item_name = (TextView) view.findViewById(R.id.txt_itemname);
//            holder.txt_item_detail = (TextView) view.findViewById(R.id.txt_itedetail);
//            holder.layout_parrent = (RelativeLayout) view.findViewById(R.id.layout_parrent);
//            holder.img_shopping_bag = (ImageView) view.findViewById(R.id.img_shopping_bag);
//            holder.layout_footer_parent = (FrameLayout) view.findViewById(R.id.layout_footer_parent);
            view.setTag(holder);
        }else
            holder = (ViewHolder) view.getTag();

            setData(position, holder);

        if(position > lastPosition){

            holder.layout_parrent.getLayoutParams().height = 400;
            holder.img_large.setVisibility(View.VISIBLE);
            holder.img_shopping_bag.setVisibility(View.VISIBLE);
            holder.layout_footer_parent.setBackgroundColor(context.getResources().getColor(R.color.blue));
            holder.txt_item_name.setTextColor(context.getResources().getColor(R.color.white));
            holder.txt_item_detail.setTextColor(context.getResources().getColor(R.color.white));
        }else {
            holder.layout_parrent.getLayoutParams().height = 160;
            holder.txt_item_name.setTextColor(context.getResources().getColor(R.color.blue));
            holder.txt_item_detail.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            holder.layout_footer_parent.setBackgroundColor(context.getResources().getColor(R.color.gray));
            holder.img_large.setVisibility(View.GONE);
            holder.img_shopping_bag.setVisibility(View.GONE);
        }

        Animation animation = AnimationUtils.loadAnimation(context, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        view.startAnimation(animation);
        lastPosition = position;


        return view;
    }


    public class ViewHolder{
        TextView txt_item_name, txt_item_detail;
        ImageView img_item = null, img_large = null, img_shopping_bag = null;
        RelativeLayout layout_parrent = null;
         FrameLayout layout_footer_parent = null;

    }


    /**
     * sets data into cell
     * @param position
     * @param holder
     */
    private void setData(int position, ViewHolder holder){
        HomeItemModal item = list_home.get(position);
        holder.txt_item_name.setText(item.getItemName());
        holder.txt_item_detail.setText(item.getItemDetail());

//        if(item.getItemurl() != null){
//            int img_res = Integer.parseInt(item.getItemurl());
//            holder.img_item.setImageResource(img_res);
//        }
        if(item.getImg_largeurl() != null){
            int img_res = Integer.parseInt(item.getImg_largeurl());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                holder.img_large.setBackground(context.getResources().getDrawable(img_res));
            }
        }

    }



    public static void expand(final View v) {
        v.measure(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? RelativeLayout.LayoutParams.WRAP_CONTENT
                        : (int)(targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int)(targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if(interpolatedTime == 1){
                    v.setVisibility(View.GONE);
                }else{
                    v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int)(initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

}
