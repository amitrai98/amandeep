package android.com.michaleproject.fragments;

import android.com.michaleproject.R;
import android.com.michaleproject.modals.HomeItemModal;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class Fragment_home extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private int previtem = -1;

    private List<HomeItemModal> list_homeitem = new ArrayList<>();

//    private ListView listView_parrent = null;
//    private HomeAdapter adapter = null;

    private int current_postion = -1;

    private DisplayMetrics metrics_;

//    private NestedScrollView nested_scroll = null;
//    private LinearLayout layout_parent = null;

//    private ListView listView_parrent = null;


    private OnFragmentInteractionListener mListener;
    private String TAG = getClass().getSimpleName();
    private CustomScrollView nested_scroll;
    CollapsingToolbarLayout collapsing_toolbar = null;
    private AppBarLayout appBar = null;
    private AppBarLayout.OnOffsetChangedListener listener;

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
    private void init(View view){
//        listView_parrent  = (ListView) view.findViewById(R.id.listview_parrent);
//        nested_scroll = (NestedScrollView) view.findViewById(R.id.layout_parrent);
//        layout_parent = (LinearLayout) view.findViewById(R.id.layout_parrent);

        nested_scroll = (CustomScrollView) view.findViewById(R.id.nested_scroll);
        collapsing_toolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        appBar = (AppBarLayout) view.findViewById(R.id.appBar);
        nested_scroll.setEnableScrolling(false);


        listener = new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(collapsing_toolbar.getHeight() + verticalOffset < 2 * ViewCompat.getMinimumHeight(collapsing_toolbar)) {
                    nested_scroll.setEnableScrolling(true);
                } else {
                    nested_scroll.setEnableScrolling(false);
                }
            }
        };

        appBar.addOnOffsetChangedListener(listener);

        list_homeitem.clear();

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
}
