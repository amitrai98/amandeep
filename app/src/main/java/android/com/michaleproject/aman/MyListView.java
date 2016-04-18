package android.com.michaleproject.aman;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * Created by amitrai on 12/4/16.
 */
public class MyListView extends ListView implements AbsListView.OnScrollListener {
    private int minimumHeight = 166; //a
    private int maximumHeight = 540; // b
    public int diffrenceHeight;   //c

    private LinearLayout mTempFooter; //f
    private GestureDetector mGestureDetector;   //i ;
    private boolean valueOfG; //g
    private int valueOfM; //m
    private View mView;   // as per understanding this is footer view
    public boolean k;
    public boolean j;
    private int d;
    int position;
    private OnScrollListener scrollListener;


    public MyListView(Context context) {
        super(context);
        valueOfG = false;
        valueOfM = -1;
        init(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        valueOfG = false;
        valueOfM = -1;
        init(context);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        valueOfG = false;
        valueOfM = -1;
        init(context);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        valueOfG = false;
        valueOfM = -1;
        init(context);
    }

    static boolean init(MyListView ourbestlistview, boolean flag) {
        ourbestlistview.k = flag;
        return flag;
    }

    static boolean b(MyListView ourbestlistview) {
        return ourbestlistview.k;
    }

    static boolean c(MyListView ourbestlistview) {
        return ourbestlistview.j;
    }

    static int d(MyListView ourbestlistview) {
        return ourbestlistview.minimumHeight;
    }

    static int init(MyListView ourbestlistview) {
        return ourbestlistview.position;
    }

    static int init(MyListView ourbestlistview, int i1) {
        ourbestlistview.position = i1;
        return i1;
    }

    private void init() {
        int i1;
        if (mView != null) {
            if (mView.getMeasuredHeight() == 0) {
                mView.measure(0, 0);
            }
            i1 = mView.getMeasuredHeight();
        } else {
            i1 = maximumHeight;
        }
        mTempFooter.getLayoutParams().height = (int) ((double) getMeasuredHeight() - 0.98999999999999999D * (double) i1);
        mTempFooter.setLayoutParams(mTempFooter.getLayoutParams());
        mTempFooter.requestLayout();
        valueOfG = true;
    }

    private void init(Context context) {
        diffrenceHeight = maximumHeight - minimumHeight;
        mTempFooter = new LinearLayout(context);
        LayoutParams layoutparams = new LayoutParams(-1, 0);
        mTempFooter.setLayoutParams(layoutparams);
        super.addFooterView(mTempFooter, null, false);
        super.setOnScrollListener(this);
        mGestureDetector = new GestureDetector(context, new MyGestureListener(this));
        setFriction(0.1F);

    }

    public void addFooterView(View view, Object obj, boolean flag) {
        removeFooterView(mTempFooter);
        super.addFooterView(view, obj, flag);
        super.addFooterView(mTempFooter, null, false);
        mView = view;
        init();
    }

    public int getFirstVisiblePosition() {
        if (valueOfM != -1) {
            int i1 = valueOfM;
            if (super.getFirstVisiblePosition() > 0) {
                i1 = super.getFirstVisiblePosition();
            }
            valueOfM = -1;
            return i1;
        } else {
            return super.getFirstVisiblePosition();

        }
    }

    public int getMaximizedHeight() {
        return maximumHeight;
    }

    public int getMinimizedHeight() {
        return minimumHeight;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent) {
        mGestureDetector.onTouchEvent(motionevent);
        return k || j || super.onInterceptTouchEvent(motionevent);
    }

    protected void onMeasure(int i1, int j1) {
        Log.e("LOGS", "On Measure");
        super.onMeasure(i1, j1);
        i1 = (int) ((float) getMeasuredWidth() * 0.75F);
        if (maximumHeight != i1) {
            maximumHeight = i1;
            diffrenceHeight = maximumHeight - minimumHeight;
            valueOfG = false;
        }
        if (!valueOfG) {
            init();
        }
    }


    public void onScroll(AbsListView abslistview1, int i1, int j1, int k1) {

        changeViewStyle();
//        if(getFirstVisiblePosition()==0)
//        {
//            View view = getChildAt(0);
//
//        }
        Log.e("LOGS", "On Scroll");
//        private int minimumHeight = 166; //a
//        private int maximumHeight = 540; // b
//        public int diffrenceHeight;   //c
//
//        private LinearLayout mTempFooter; //f
//        private GestureDetector mGestureDetector;   //i ;
//        private boolean valueOfG; //g
//        private int valueOfM; //m
//        private View mView;
//        public boolean k = true;
//        public boolean j;
//        private int d;
//        int position;
//        Log.e(" Variables","Diffrent height: - " + diffrenceHeight +"  \n val G = "+ valueOfG + "  \nvalue M = " + valueOfM +  "  \n val k = " + k + " \n j = "+j +"  \n d= " +d);


        if (d != 0 && getChildCount() != 0) {
            View view = getChildAt(0);
            View abslistview = getChildAt(1);
            float f1 = Math.abs((float) view.getTop() / (float) maximumHeight);
            if (getFirstVisiblePosition() < getAdapter().getCount() - getFooterViewsCount()) {
                if (view.getLayoutParams().height != maximumHeight) {
                    view.getLayoutParams().height = maximumHeight;
                    view.setLayoutParams(view.getLayoutParams());
                }
                if (getFirstVisiblePosition() + 1 >= getAdapter().getCount() - getFooterViewsCount()) {
                    abslistview = null;
                }
                if (abslistview != null) {
                    android.view.ViewGroup.LayoutParams layoutparams = abslistview.getLayoutParams();
                    i1 = minimumHeight;
                    layoutparams.height = (int) (f1 * (float) diffrenceHeight) + i1;
                    abslistview.setLayoutParams(abslistview.getLayoutParams());
                }
                if (scrollListener != null) {
                    scrollListener.onScroll(this, getFirstVisiblePosition(), getChildCount(), getAdapter().getCount());
                    return;
                }
            }
        }
    }

    private void changeViewStyle() {

        if (getFirstVisiblePosition() == 0 && getChildCount() != 0) {
            View view = getChildAt(0);
            if (getFirstVisiblePosition() < getAdapter().getCount() - getFooterViewsCount()) {
                if (view.getLayoutParams().height != maximumHeight) {
                    view.getLayoutParams().height = maximumHeight;
                    view.setLayoutParams(view.getLayoutParams());
                }
            }
//        if (getFirstVisiblePosition() < getCount() - 3) {
//            View view = getChildAt(getFirstVisiblePosition()+1);
//            Log.e("Position",getFirstVisiblePosition()+"");
//            View overlay = view.findViewById(R.id.glass_overlay);
//
//            if (overlay.getHeight() < 200) {
//                overlay.getBackground().setAlpha(200);
//            }
//            else if (overlay.getHeight() > 200 && view.getHeight()<300) {
//                overlay.getBackground().setAlpha(150);
//            }
//            else if (overlay.getHeight() > 300 && view.getHeight()<400) {
//                overlay.getBackground().setAlpha(150);
//            }
//        }
//        if (getFirstVisiblePosition() + 1 <= getCount() - 2) {
//            View view2 = getChildAt(getFirstVisiblePosition());
//        }setSelectionFromTop
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i1) {
//        Log.e(" Variables"," \n Diffrent height: - " + diffrenceHeight +"  \n val G = "+ valueOfG + "  \nvalue M = " + valueOfM +  "  \n val k = " + k + " \n j = "+j +"  \n d= " +d);

        Log.e("LOGS", "OnScrollChanged");
        int j1 = 1;
        if (d != 2 && i1 == 2) {
            j = true;
            k = false;
        }
        if (d == 1 && i1 == 0 && !k) {
            float f1 = Math.abs((float) getChildAt(0).getTop() / (float) maximumHeight);
            int k1 = getFirstVisiblePosition();
            if (f1 <= 0.5F) {
                j1 = 0;
            }
            position = j1 + k1;
            post(new Runnable() {

                final MyListView listview;

                public void run() {
                    listview.smoothScrollToPositionFromTop(MyListView.init(listview), 0, 200);
                }

                {
//                    super();
                    listview = MyListView.this;
                }
            });
        }
        if (d == 2 && i1 == 0) {
            j = false;
            if (getFirstVisiblePosition() != position) {
                post(new Runnable() {

                    final MyListView listview;

                    {
//                        super();
                        listview = MyListView.this;

                    }

                    public void run() {
                        listview.setSelectionFromTop(MyListView.init(listview), 0);
                    }
                });
            }
        }
        d = i1;
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
//        Log.e("OnTouch", "Wow OnTouch is Called ");
        mGestureDetector.onTouchEvent(motionevent);
        return k || j || super.onTouchEvent(motionevent);
    }

    public void setOnScrollListener(OnScrollListener onscrolllistener) {
        scrollListener = onscrolllistener;
    }


//    @Override
//    public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//    }
//
//    @Override
//    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//
//    }


//
//    @Override
//    protected void onScrollChanged(int position, int t, int oldl, int oldt) {
//        super.onScrollChanged(position, t, oldl, oldt);
//        Log.e("OnSCroll","OnScroll");
//        RelativeLayout visibleItem  = (RelativeLayout) getChildAt(getFirstVisiblePosition());
//
//        ImageView imageView = (ImageView)visibleItem.findViewById(R.id.iv_background);
//        imageView.getLayoutParams().height = imageView.getLayoutParams().height+100;
////        visibleItem.setLayoutParams(imageView.getLayoutParams());
//
//    }

}
