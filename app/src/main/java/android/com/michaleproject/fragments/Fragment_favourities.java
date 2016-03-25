package android.com.michaleproject.fragments;

import android.com.michaleproject.R;
import android.com.michaleproject.adapters.FabGridAdapter;
import android.com.michaleproject.modals.FabGridModal;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_favourities.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_favourities#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_favourities extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    private GridView view_grid = null;
    private FabGridAdapter adapter = null;
    private List<FabGridModal> list_grid_modals = new ArrayList<>();

    private OnFragmentInteractionListener mListener;

    private LinearLayout layout_liniear_parrent = null;

    public Fragment_favourities() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_favourities.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_favourities newInstance(String param1, String param2) {
        Fragment_favourities fragment = new Fragment_favourities();
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

        View view = inflater.inflate(R.layout.fragment_fragment_favourities, container, false);
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
     */
    private void init(View view){
//        view_grid = (GridView) view.findViewById(R.id.view_grid);
        list_grid_modals.add(new FabGridModal("Armani", ""+R.drawable.armani));
        list_grid_modals.add(new FabGridModal("Gucci", ""+R.drawable.gucci));
        list_grid_modals.add(new FabGridModal("LG", ""+R.drawable.lg));
        list_grid_modals.add(new FabGridModal("Armani", ""+R.drawable.armani));
        list_grid_modals.add(new FabGridModal("Gucci", ""+R.drawable.gucci));
        list_grid_modals.add(new FabGridModal("LG", ""+R.drawable.lg));
        list_grid_modals.add(new FabGridModal("Armani", ""+R.drawable.armani));
        list_grid_modals.add(new FabGridModal("Gucci", ""+R.drawable.gucci));
        list_grid_modals.add(new FabGridModal("LG", ""+R.drawable.lg));
        layout_liniear_parrent = (LinearLayout) view.findViewById(R.id.layout_liniear_parrent);

                adapter = new FabGridAdapter(list_grid_modals, getActivity());


        for (int i = 0; i<5; i++){
            View v = getActivity().getLayoutInflater().inflate(R.layout.design_linear_item, null);
            layout_liniear_parrent.addView(v);

        }
//        view_grid.setAdapter(adapter);

//        view_grid.setAdapter(new ButtonAdapter(getActivity()));
    }
}
