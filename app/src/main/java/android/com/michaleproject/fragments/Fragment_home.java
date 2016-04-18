package android.com.michaleproject.fragments;

import android.com.michaleproject.R;
import android.com.michaleproject.aman.MyAdapter;
import android.com.michaleproject.aman.MyListView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {.} interface
 * to handle interaction events.
 * Use the {@link Fragment_home#} factory method to
 * create an instance of this fragment.
 */
public class Fragment_home extends Fragment {

    private String TAG = getClass().getSimpleName();

    public Fragment_home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_home, null, false);
        init(view);
        return view;
    }

    private void init(View view) {

        MyListView listView = (MyListView) view.findViewById(R.id.listview);
        LayoutInflater vi = LayoutInflater.from(getActivity());
        View footer = LayoutInflater.from(getActivity()).inflate(R.layout.footer, null);
        listView.addFooterView(footer, 0, false);
        MyAdapter adapter = new MyAdapter(getActivity(),listView);
        listView.setAdapter(adapter);
    }


}
