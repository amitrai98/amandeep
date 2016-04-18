package android.com.michaleproject.aman;

import android.com.michaleproject.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by aman deep singh on 8/4/16.
 */
public class MyAdapter extends BaseAdapter {

    private final Context mContext;
    private final MyListView mListView;
    private final int[] images = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.nike,R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.nike};
    private int currentImage = 0;

    public MyAdapter(Context context, MyListView listView) {
        mListView = listView;
        mContext = context;
    }

    @Override
    public int getCount() {
        return 10;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater vi = LayoutInflater.from(mContext);
        View view =null;
        ViewHolder holder = null;
//        if (view == null) {
            holder = new ViewHolder();
            view = vi.inflate(R.layout.item_view, null);
            holder.layout = (FrameLayout) view.findViewById(R.id.frame_layout);
            holder.backgroundImage = (ImageView) view.findViewById(R.id.imageview);
            holder.glassOverlay=view.findViewById(R.id.glass_overlay);



       view.setTag(holder);
//        } else {
//            holder = (ViewHolder) view.getTag();
//        }

//        if (position % 2 == 0) {
            holder.backgroundImage.setImageResource(images[position]);
//            currentImage++;
//        if(currentImage>4)
//        {
//            currentImage=0;
//        }
//        } else {
//            holder.backgroundImage.setImageResource(R.drawable.nike);
//
//        }


//
//        ViewTreeObserver observer = holder.layout.getViewTreeObserver();
//        final ViewHolder finalHolder = holder;
//        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                Log.e("HEIGHT", "View Tree Observer");
//                if(mListView.getCount()==mListView.getFirstVisiblePosition()-2)
//                {
//                    int viewPosition = mListView.getFirstVisiblePosition()+1;
//                    int height =  mListView.getChildAt(viewPosition).getHeight();
//                    Log.e("HEIGHT", height + "");
//                    if(height>=170&& height <550)
//                    {
//                        finalHolder.glassOverlay.getBackground().setAlpha(80);
//                    }
////                    else  if(height>=220 && height <300)
////                    {
////                        finalHolder.glassOverlay.getBackground().setAlpha(40);
////                    }
////                    else  if(height>=300 && height <350)
////                    {
////                        finalHolder.glassOverlay.getBackground().setAlpha(60);
////                    }
//                }
//
//            }
//        });


        if (position == 0 && mListView.getFirstVisiblePosition()==0) {
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 540);
            holder.layout.setLayoutParams(params);
        } else {
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 166);
            holder.layout.setLayoutParams(params);
        }

        return view;
    }

    static class ViewHolder {
        ImageView backgroundImage;
        FrameLayout layout;
        View glassOverlay;

    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 500;
    }


}
