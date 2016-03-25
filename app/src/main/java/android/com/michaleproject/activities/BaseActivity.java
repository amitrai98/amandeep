package android.com.michaleproject.activities;

import android.com.michaleproject.R;
import android.com.michaleproject.adapters.HeaderAdapter;
import android.com.michaleproject.adapters.ViewPagerAdapter;
import android.com.michaleproject.fragments.Fragment_categories;
import android.com.michaleproject.fragments.Fragment_favourities;
import android.com.michaleproject.fragments.Fragment_home;
import android.com.michaleproject.fragments.Fragment_nearby;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity implements
        Fragment_categories.OnFragmentInteractionListener,
        Fragment_favourities.OnFragmentInteractionListener,
        Fragment_home.OnFragmentInteractionListener,
        Fragment_nearby.OnFragmentInteractionListener,
        View.OnClickListener{

    private TabHost layout_tab = null;
    private FrameLayout tabcontent = null;

    private ImageView img_hamburger = null;

    private RecyclerView navigation_recyclerView = null;

    private Toolbar toolbar = null;

    private DrawerLayout drawer_layout = null;

    private List<String> list_navoptions = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
    }

    /**
     * initalizes all view ids
     */
    private void init(){
//        layout_tab = (TabHost) findViewById(R.id.layout_tab);

//        LayoutInflater inflater = getLayoutInflater();
//        Fragment fragment = new Fragment_categories();
//        replaceFragment(fragment);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigation_recyclerView = (RecyclerView) findViewById(R.id.navigation_recyclerView);
        img_hamburger = (ImageView) findViewById(R.id.img_hamburger);
        toolbar = (Toolbar) findViewById(R.id.toolbar_top);

        img_hamburger.setOnClickListener(this);

        list_navoptions.add(getResources().getString(R.string.nav_home));
        list_navoptions.add(getResources().getString(R.string.nav_nearby));
        list_navoptions.add(getResources().getString(R.string.nav_fab));
        list_navoptions.add(getResources().getString(R.string.nav_categories));
        list_navoptions.add(getResources().getString(R.string.nav_logout));



        HeaderAdapter adpter = new HeaderAdapter(list_navoptions);
        navigation_recyclerView.setAdapter(adpter);
        navigation_recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));



//            PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs_layout);
////            // Attach the view pager to the tab strip
//            tabsStrip.setViewPager(pager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(pager);

        // Bind the tabs to the ViewPager

//        createTabIndicator(inflater, layout_tab, R.string.home, R.drawable.home_hover);




        // Tab for Photos
//        TabHost.TabSpec photospec = layout_tab.newTabSpec("Photos");
//        // setting Title and Icon for the Tab
//        photospec.setIndicator("Photos", getResources().getDrawable(R.drawable.categories_hover));
////        Intent photosIntent = new Intent(this, PhotosActivity.class);
////        photospec.setContent(photosIntent);
//
//        // Tab for Songs
//        TabHost.TabSpec songspec = layout_tab.newTabSpec("Songs");
//        songspec.setIndicator("Songs", getResources().getDrawable(R.drawable.favourites_hover));
////        Intent songsIntent = new Intent(this, SongsActivity.class);
////        songspec.setContent(songsIntent);
//
//        // Tab for Videos
//        TabHost.TabSpec videospec = layout_tab.newTabSpec("Videos");
//        videospec.setIndicator("Videos", getResources().getDrawable(R.drawable.home_normal));
////        Intent videosIntent = new Intent(this, VideosActivity.class);
////        videospec.setContent(videosIntent);
//
//        // Adding all TabSpec to TabHost
//        layout_tab.addTab(photospec); // Adding photos tab
//        layout_tab.addTab(songspec); // Adding songs tab
//        layout_tab.addTab(videospec); // Adding videos tab
    }


    /**
     *
     * @param fragment
     */
    private void replaceFragment (Fragment fragment){
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0);

//        if (!fragmentPopped){ //fragment not in back stack, create it.
//            FragmentTransaction ft = manager.beginTransaction();
//            ft.replace(R.id.container, fragment);
//            ft.addToBackStack(backStateName);
//            ft.commit();
//        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_hamburger:
                openCloseNavBar();
                break;
        }
    }

    /**
     * opens and closes the navigation bar
     */
    private void openCloseNavBar(){
        if(drawer_layout.isDrawerOpen(GravityCompat.START))
            drawer_layout.closeDrawer(GravityCompat.START);
        else
            drawer_layout.openDrawer(GravityCompat.START);

    }
}
