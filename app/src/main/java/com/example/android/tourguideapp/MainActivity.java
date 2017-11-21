package com.example.android.tourguideapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private String[] mCategoryTitles;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    private int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use the activity_main.xml layout file to display content
        setContentView(R.layout.activity_main);

        // Find the toolbar layout
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        // Set toolbar layout as the action bar
        setSupportActionBar(mToolbar);

        // Find the drawer layout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Open and close drawer
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                mToolbar,               /* Toolbar */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mDrawerTitle);
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        // Find the navigation view layout
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);

        // Open the selected fragment from the navigation view
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int position = menuItem.getItemId();
                setTitle(menuItem.getTitle());
                return selectItem(position);
            }

        });

        // Select the home fragment from the menu at launch
        selectItem(R.id.nav_home);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    private boolean selectItem(int position) {

        if (currentPosition != position) {

            Fragment fragment;
            String fragmentName;

            if (position == R.id.nav_home) {
                fragmentName = HomeFragment.class.getSimpleName();
                fragment = getFragmentManager().findFragmentByTag(fragmentName);
                if (fragment == null) {
                    fragment =  new HomeFragment();
                }

            } else if (position == R.id.nav_shopping) {
                fragmentName = ShoppingFragment.class.getSimpleName();
                fragment = getFragmentManager().findFragmentByTag(fragmentName);
                if (fragment == null) {
                    fragment =  new ShoppingFragment();
                }
            } else if (position == R.id.nav_restaurants) {
                fragmentName = RestaurantsFragment.class.getSimpleName();
                fragment = getFragmentManager().findFragmentByTag(fragmentName);
                if (fragment == null) {
                    fragment =  new RestaurantsFragment();
                }
            } else if (position == R.id.nav_museums) {
                fragmentName = MuseumsFragment.class.getSimpleName();
                fragment = getFragmentManager().findFragmentByTag(fragmentName);
                if (fragment == null) {
                    fragment = new MuseumsFragment();
                }
            } else {
                fragmentName = OtherFragment.class.getSimpleName();
                fragment = getFragmentManager().findFragmentByTag(fragmentName);
                if (fragment == null) {
                    fragment = new OtherFragment();
                }
            }

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getFragmentManager();

            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        }
        currentPosition = position;
        mDrawerLayout.closeDrawers();

        return true;
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

}
