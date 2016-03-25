package android.com.michaleproject.fragments;

import android.com.michaleproject.adapters.CategoriesAdapter;
import android.com.michaleproject.modals.CategoryModal;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.com.michaleproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_categories.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_categories#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_categories extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView recyclerView = null;

    private CategoriesAdapter adapter = null;
    private List<CategoryModal> list_category = new ArrayList<>();


    public Fragment_categories() {
        // Required empty public constructor
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_categories.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_categories newInstance(String param1, String param2) {
        Fragment_categories fragment = new Fragment_categories();
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
        View view = inflater.inflate(R.layout.fragment_fragment_categories, container, false);

        initView(view);
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
    private void initView(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        list_category.clear();
        list_category.add(new CategoryModal("Accessories", R.drawable.accessories));
        list_category.add(new CategoryModal("Automotve", R.drawable.automotive));
        list_category.add(new CategoryModal("Beauty", R.drawable.beauty));
        list_category.add(new CategoryModal("Books", R.drawable.books));
        list_category.add(new CategoryModal("Clothing", R.drawable.clothing));
        list_category.add(new CategoryModal("Electronics", R.drawable.electronics));
        list_category.add(new CategoryModal("Flowers", R.drawable.flowers));
        list_category.add(new CategoryModal("Food", R.drawable.food));

        adapter = new CategoriesAdapter(list_category);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
}
