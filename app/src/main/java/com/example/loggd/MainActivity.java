package com.example.loggd;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            ActionBar actionBar = getSupportActionBar();
            switch (item.getItemId()) {

                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    fragment.getFragmentManager().beginTransaction().replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName()).commit();
                    actionBar.setTitle("Home");
                    return true;
                case R.id.navigation_bookmark:
                    fragment = new BookmarkFragment();
                    fragment.getFragmentManager().beginTransaction().replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName()).commit();
                    actionBar.setTitle("Bookmark");
                    return true;
                case R.id.navigation_history:
                    fragment = new HistoryFragment();
                    fragment.getFragmentManager().beginTransaction().replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName()).commit();
                    actionBar.setTitle("History");
                    return true;
                case R.id.navigation_settings:
                    fragment = new SettingsFragment();
                    fragment.getFragmentManager().beginTransaction().replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName()).commit();
                    actionBar.setTitle("Settings");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
    }

}
