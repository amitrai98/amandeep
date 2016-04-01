package android.com.michaleproject.fragments;

import android.com.michaleproject.R;
import android.com.michaleproject.modals.HomeItemModal;
import android.com.michaleproject.rnd.ObservableScrollViewCallbacks;
import android.com.michaleproject.rnd.ScrollState;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_home.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_home extends Fragment implements ObservableScrollViewCallbacks {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private int previtem = -1;

    private List<HomeItemModal> list_homeitem = new ArrayList<>();

    private List<Holder> list_appbar = new ArrayList<>();

    private int collapse_item  = 0;

    ObservableScrollViewCallbacks scrollViewCallbacks = null;

//    private ListView listView_parrent = null;
//    private HomeAdapter adapter = null;

    private int current_postion = 0;

    private DisplayMetrics metrics_;

    private int scroll_height = 500;

    private int inital_height = 100;

    private int final_height = 600;

    private float current_height = 0;

    private float prev_y = 0;

//    private NestedScrollView nested_scroll = null;
//    private LinearLayout layout_parent = null;

//    private ListView listView_parrent = null;


    private OnFragmentInteractionListener mListener;
    private String TAG = getClass().getSimpleName();
    private NestedScrollView nested_scroll;
    //    private AppBarLayout appBar = null;
    private AppBarLayout.OnOffsetChangedListener listener;
    public AppBarLayout.Behavior behavior;

    private LinearLayout layout_parrent = null;

    public Fragment_home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_home.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_home newInstance(String param1, String param2) {
        Fragment_home fragment = new Fragment_home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_fragment_home, container, false);
        init(view);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        Log.e(TAG, ""+scrollY);

    }

    @Override
    public void onDownMotionEvent() {
        Log.e(TAG, "down motion");
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        Log.e(TAG, ""+scrollState);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    /**
     * initalizing view elements
     * @param view
     */
    private void init(final View view){


//        listView_parrent  = (ListView) view.findViewById(R.id.listview_parrent);
//        nested_scroll = (NestedScrollView) view.findViewById(R.id.layout_parrent);
//        layout_parent = (LinearLayout) view.findViewById(R.id.layout_parrent);



        nested_scroll = (NestedScrollView) view.findViewById(R.id.nested_scroll);
//        nested_scroll.setScrollViewCallbacks(this);
        layout_parrent = (LinearLayout) view.findViewById(R.id.layout_parrent);
        ViewHelper holper = null;

//        nested_scroll.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                float val = event.getY();
//                Log.e(TAG, ""+val);
//
//                if(event.getAction()== MotionEvent.ACTION_DOWN){
//                    current_height = 0;
//                }else if (event.getAction()== MotionEvent.ACTION_UP){
//                    current_height = 0;
//                }
//                if(prev_y > event.getY()){
//                    Log.e(TAG, "moved up");
//                    if(current_height < final_height){
//                        current_height += 10;
//                        try {
//                            ViewHelper.setTranslationY(list_appbar.get(current_postion).appBarLayout, ScrollUtils.getFloat(current_height, final_height, 0));
//                        }catch (Exception e){
//                            e.printStackTrace();
//                        }
//
//                    }
//                    else {
//                        current_height =0;
//
//                    }
//                }else{
//                    Log.e(TAG, "moved down");
//                    if(current_height-10>inital_height){
//                        current_height -= current_height;
//
//                    }else {
//                        current_height = 0;
//                    }
//
//                }
//
//                prev_y = event.getY();
//
//
//                return false;
//            }
//        });
//        collapsing_toolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
//        appBar = (AppBarLayout) view.findViewById(R.id.appBar);
//        coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.main_content);
////        nested_scroll.setEnableScrolling(false);
//
//        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams();
//        behavior = (AppBarLayout.Behavior) params.getBehavior();
//
////        nested_scroll.setOnTouchListener(new View.OnTouchListener() {
////            @Override
////            public boolean onTouch(View v, MotionEvent event) {
////
////                Log.e("event received is " , ""+event);
////
////                return false;
////            }
////        });
//
//
//        ImageView img_view = (ImageView)view.findViewById(R.id.view_below);
//        img_view.setOnClickListener(new View.OnClickListener() {
//
//
//            @Override
//            public void onClick(View v) {
//
//                    if(behavior!=null) {
//                        behavior.setTopAndBottomOffset(20);
//                        behavior.onNestedScroll(coordinatorLayout,appBar, null,0, 0, 0,500);
//                    }
//
//            }
//        });
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//            nested_scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//                @Override
//                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                    if(scrollY != previtem){
//                        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams();
//                        behavior = (AppBarLayout.Behavior) params.getBehavior();
//                        if(behavior!=null) {
//                            behavior.setTopAndBottomOffset(0);
//                            Log.e(TAG, "y is" +scrollY);
//                            behavior.onNestedScroll(coordinatorLayout,appBar, null,0, 0, 0,scrollY);
//                            previtem = scrollY;
//                            appBar.setExpanded(false);
//                        }
//                    }
//                }
//            });
//        }


//        listener = new AppBarLayout.OnOffsetChangedListener() {
//            public AppBarLayout.Behavior behavior;
//
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if(collapsing_toolbar.getHeight() + verticalOffset < 2 * ViewCompat.getMinimumHeight(collapsing_toolbar)) {
//                    CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams();
//                    behavior = (AppBarLayout.Behavior) params.getBehavior();
//                    if(behavior!=null) {
//                        behavior.setTopAndBottomOffset(0);
//                        behavior.onNestedPreScroll((CoordinatorLayout) view.findViewById(R.id.main_content), appBar, null, 0, 1, new int[2]);
//                    }
//                } else {
//                    nested_scroll.setEnableScrolling(false);
//                }
//            }
//        };

//        collapsing_toolbar.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.e(TAG, "PARENT TOUCH");
//
//                view.findViewById(R.id.nested_scroll).getParent()
//                        .requestDisallowInterceptTouchEvent(false);
//                return false;
//            }
//        });

//        nested_scroll.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.e(TAG, "CHILD TOUCH");
//
//                // Disallow the touch request for parent scroll on touch of  child view
//                v.getParent().requestDisallowInterceptTouchEvent(true);
//                return false;
//            }
//        });
//        appBar.addOnOffsetChangedListener(listener);

        list_homeitem.clear();
        list_appbar.clear();

//        nested_scroll = (LockableScrollView) view.findViewById(R.id.nested_scroll);
//        nested_scroll.setScrollingEnabled(false);

        list_homeitem.add(new HomeItemModal("Mash", "20% off $40+", "" + R.drawable.mash, "" + R.drawable.large_mash));
        list_homeitem.add(new HomeItemModal("Lego", "50% Off Sale", ""+R.drawable.lego, ""+R.drawable.large_lego));
        list_homeitem.add(new HomeItemModal("99p Store", "Instant 5% Off", ""+R.drawable.store, ""+R.drawable.large_stores));
        list_homeitem.add(new HomeItemModal("The Toy Store", "Summer Off Upto 80%", "" + R.drawable.toy, "" + R.drawable.large_toystore));
        list_homeitem.add(new HomeItemModal("Mash", "20% off $40+", "" + R.drawable.mash, "" + R.drawable.large_mash));
        list_homeitem.add(new HomeItemModal("Lego", "50% Off Sale", ""+R.drawable.lego, ""+R.drawable.large_lego));
        list_homeitem.add(new HomeItemModal("99p Store", "Instant 5% Off", ""+R.drawable.store, ""+R.drawable.large_stores));
        list_homeitem.add(new HomeItemModal("The Toy Store", "Summer Off Upto 80%", "" + R.drawable.toy, ""+R.drawable.large_toystore));
        list_homeitem.add(new HomeItemModal("Mash", "20% off $40+", "" + R.drawable.mash, "" + R.drawable.large_mash));
        list_homeitem.add(new HomeItemModal("Lego", "50% Off Sale", ""+R.drawable.lego, ""+R.drawable.large_lego));
        list_homeitem.add(new HomeItemModal("99p Store", "Instant 5% Off", ""+R.drawable.store, ""+R.drawable.large_stores));
        list_homeitem.add(new HomeItemModal("The Toy Store", "Summer Off Upto 80%", "" + R.drawable.toy, ""+R.drawable.large_toystore));
        list_homeitem.add(new HomeItemModal("Mash", "20% off $40+", "" + R.drawable.mash, "" + R.drawable.large_mash));
        list_homeitem.add(new HomeItemModal("Lego", "50% Off Sale", ""+R.drawable.lego, ""+R.drawable.large_lego));
        list_homeitem.add(new HomeItemModal("99p Store", "Instant 5% Off", ""+R.drawable.store, ""+R.drawable.large_stores));
        list_homeitem.add(new HomeItemModal("The Toy Store", "Summer Off Upto 80%", "" + R.drawable.toy, ""+R.drawable.large_toystore));

        LayoutInflater inflater =
                (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (int i= 0; i < 20 ; i++){

            View menuLayout = inflater.inflate(R.layout.design_home, null, true);

            if(menuLayout != null){
                Log.e(TAG, "view is not null");
                layout_parrent.addView(menuLayout);
                Holder holder = new Holder();
                holder.appBarLayout = (AppBarLayout) menuLayout.findViewById(R.id.appBar);
                holder.collapsing_toolbar = (CollapsingToolbarLayout) menuLayout.findViewById(R.id.collapsing_toolbar);
                holder.layout_collapseitem = (RelativeLayout) menuLayout.findViewById(R.id.layout_collapseitem);
                holder.layout_parrent = (RelativeLayout) menuLayout.findViewById(R.id.layout_parrent);
                holder.img_view= (ImageView) menuLayout.findViewById(R.id.img_view);
                holder.coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.main_content);
                try{
                    int imgres = Integer.parseInt(list_homeitem.get(i).getImg_largeurl());
                    holder.img_view.setImageResource(imgres);
                }catch (Exception e){
                    e.printStackTrace();
                }



                list_appbar.add(holder);

                if(Build.VERSION.SDK_INT >= 21 && i != 0 && holder.appBarLayout != null){
                    holder.appBarLayout.setExpanded(false);
                    holder.appBarLayout.setTag(holder);
                    holder.collapsing_toolbar.getLayoutParams().height = 0;
                    holder.layout_collapseitem.setVisibility(View.VISIBLE);

                }

                if(Build.VERSION.SDK_INT >= 21 && i == 0 && holder.appBarLayout != null){
                    holder.appBarLayout.setExpanded(true);
                    holder.img_view.setVisibility(View.VISIBLE);
//                    scroll_height = holder.img_view.getLayoutParams().height;
                    Log.e(TAG, ""+scroll_height);
                }

            }

        }




        nested_scroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                Display display = getActivity().getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int height = size.y;
                int check_height = (int)(height/2);
                ImageView layout_check = list_appbar.get(collapse_item).img_view;
                int[] coords = {0,0};
                layout_check.getLocationOnScreen(coords);
                int absoluteTop = coords[1];
                int absoluteBottom = coords[1] + layout_check.getHeight();


                if(scrollY< prev_y){
                    prev_y = scrollY;
                    try {
                        if(absoluteTop > check_height){
                            {
                                Log.e(TAG, "moved down");
                                AppBarLayout appBar = list_appbar.get(collapse_item).appBarLayout;
                                CoordinatorLayout coordinator_layout = list_appbar.get(collapse_item).coordinatorLayout;

//                                    appBar.setExpanded(false);

                                CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams();
                                behavior = (AppBarLayout.Behavior) params.getBehavior();
                                if(behavior!=null) {
                                    behavior.setTopAndBottomOffset(0);
                                    Log.e(TAG, "y is" +scrollY);
                                    list_appbar.get(collapse_item).layout_collapseitem.setVisibility(View.VISIBLE);
//                                        behavior.onNestedScroll(coordinator_layout,appBar, null,0, 200, 0,0);
//                                        previtem = scrollY;
                                    appBar.setExpanded(false);

                                    list_appbar.get(collapse_item).collapsing_toolbar.getLayoutParams().height = 0;
//                                    list_appbar.get(collapse_item).laffsetCyout_collapseitem.setVisibility(View.VISIBLE);
//                                        list_appbar.get(collapse_item).layout_collapseitem.setVisibility(View.VISIBLE);
//                                        list_appbar.get(collapse_item).collapsing_toolbar.setVisibility(View.GONE);
//                                        params.height = list_appbar.get(collapse_item).layout_collapseitem.getHeight();
                                }


//                                    list_appbar.get(collapse_item).layout_collapseitem.setVisibility(View.GONE);
//                                    list_appbar.get(collapse_item).layout_collapseitem.setVisibility(View.GONE);


                                if(collapse_item >0 )
                                    collapse_item -- ;

                                previtem = scrollY;
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }


                    Log.e(TAG, "scrol down");

                }else {
                    prev_y =scrollY;
                    Log.e(TAG, "scrol up");

                    if(absoluteTop < check_height || (list_appbar.size() - current_postion) <= 4){
                        CoordinatorLayout.LayoutParams params_ = (CoordinatorLayout.LayoutParams) list_appbar.get(collapse_item).appBarLayout.getLayoutParams();
                        behavior = (AppBarLayout.Behavior) params_.getBehavior();
                        if(behavior!=null) {
                            behavior.setTopAndBottomOffset(0);
                            Log.e(TAG, "y is" +scrollY);
//                        behavior.onNestedScroll(list_appbar.get(collapse_item).coordinatorLayout,list_appbar.get(collapse_item).appBarLayout, null,0, 0, 0,1000);
                        }

//                    if(scrollY != previtem){
//                        int diff = scrollY - previtem;


                        if(scrollY>previtem){
                            try {
                                if(scrollY > previtem){
                                    Log.e(TAG, "moved up");
                                    AppBarLayout appBar = list_appbar.get(collapse_item).appBarLayout;
                                    CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams();
                                    behavior = (AppBarLayout.Behavior) params.getBehavior();
                                    if(behavior!=null) {

//                                    list_appbar.get(collapse_item).layout_collapseitem.setVisibility(View.GONE);
                                        list_appbar.get(collapse_item).collapsing_toolbar.getLayoutParams().height = 600;
                                        list_appbar.get(collapse_item).layout_collapseitem.setVisibility(View.GONE);

//                                        if((list_appbar.size() - current_postion) <= 4){
//                                            for(int i = current_postion; i< list_appbar.size(); i++){
//                                                current_postion = i;
//                                                list_appbar.get(collapse_item).collapsing_toolbar.getLayoutParams().height = 1000;
//                                                list_appbar.get(collapse_item).layout_collapseitem.setVisibility(View.GONE);
//                                            }
//                                        }

                                        appBar.setExpanded(true);


//                                    list_appbar.get(collapse_item).layout_collapseitem.setVisibility(View.GONE);
//                                    params.height = list_appbar.get(collapse_item).img_view.getLayoutParams().height;
                                    }


//                                list_appbar.get(collapse_item).layout_collapseitem.setVisibility(View.VISIBLE);


                                    if(collapse_item < list_appbar.size()-1)
                                        collapse_item ++;
                                    previtem = scrollY;
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }

                        }

                    }
                }

            }
        });




//        LayoutInflater layoutInflater =
//                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        try {
//            View view1 = LayoutInflater.from(getContext()).inflate(R.layout.design_home, null);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

//        for(HomeItemModal modal : list_homeitem){
//            View view1 = getLayoutInflater(getActivity()).inflate(R.layout.design_home, null);
//            layout_parent.addView(view);
//        }

//        adapter = new HomeAdapter(getActivity(), list_homeitem);
//
//        listView_parrent.setAdapter(adapter);


//        listView_parrent.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                try {
//                    if(firstVisibleItem != previtem){
//                        previtem = firstVisibleItem;
//                        HomeAdapter.ViewHolder holder = (HomeAdapter.ViewHolder) view.getTag();
//
//                        holder.layout_parrent.getLayoutParams().height = 800;
//                        holder.img_large.setVisibility(View.VISIBLE);
//                        holder.img_shopping_bag.setVisibility(View.VISIBLE);
//                        holder.layout_footer_parent.setBackgroundColor(getResources().getColor(R.color.blue));
//                        holder.txt_item_name.setTextColor(getResources().getColor(R.color.white));
//                        holder.txt_item_detail.setTextColor(getResources().getColor(R.color.white));
//
//                    }
//
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        metrics_ = new DisplayMetrics();
//        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics_);
//
//
//
//        listView_parrent.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//
//                if (firstVisibleItem != current_postion) {
//                    current_postion = firstVisibleItem;
//                    Log.e(TAG, " total item count" + totalItemCount);
//                    View view1 = listView_parrent.getChildAt(firstVisibleItem - 1);
//                    if (view1 != null){
//                        view1.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, 600));
//                        Animation animation = null;
//                        animation = new TranslateAnimation(0, 0,
//                                metrics_.heightPixels, 0);
//                        animation.setDuration(500);
//                        view1.startAnimation(animation);
//                    }
//
//                }
//            }
//        });

    }


    class Holder{
        private CoordinatorLayout coordinatorLayout = null;
        CollapsingToolbarLayout collapsing_toolbar;
        AppBarLayout appBarLayout ;
        RelativeLayout layout_collapseitem ;
        RelativeLayout layout_parrent ;
        ImageView img_view;
    }



    //    public static void expand(final View v) {
//        v.measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        final int targetHeight = v.getMeasuredHeight();
//
//        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
//        v.getLayoutParams().height = 1;
//        v.setVisibility(View.VISIBLE);
//        Animation a = new Animation()
//        {
//            @Override
//            protected void applyTransformation(float interpolatedTime, Transformation t) {
//                v.getLayoutParams().height = interpolatedTime == 1
//                        ? LayoutParams.WRAP_CONTENT
//                        : (int)(targetHeight * interpolatedTime);
//                v.requestLayout();
//            }
//
//            @Override
//            public boolean willChangeBounds() {
//                return true;
//            }
//        };
//
//        // 1dp/ms
//        a.setDuration((int)(targetHeight / v.getContext().getResources().getDisplayMetrics().density));
//        v.startAnimation(a);
//    }
//
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
