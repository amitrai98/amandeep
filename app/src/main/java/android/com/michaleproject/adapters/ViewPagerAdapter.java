package android.com.michaleproject.adapters;

import android.com.michaleproject.fragments.Fragment_categories;
import android.com.michaleproject.fragments.Fragment_favourities;
import android.com.michaleproject.fragments.Fragment_home;
import android.com.michaleproject.fragments.Fragment_nearby;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by amitrai on 18/3/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter{

    private String tabTitles[] = new String[] { "Home", "Nearby", "Categories" , "Favourites" };

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }



    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Fragment_home();
            case 1:
                return new Fragment_nearby();
            case 2:
                return new Fragment_categories();
            case 3:
                return new Fragment_favourities();

        }

        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}
