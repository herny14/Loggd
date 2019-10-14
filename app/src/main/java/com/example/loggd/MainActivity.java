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

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName()).commit();
                    ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("Home");
                    return true;
                case R.id.navigation_bookmark:
                    fragment = new BookmarkFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_layout,fragment,fragment.getClass().getSimpleName()).commit();
                    ActionBar actionBar1 = getSupportActionBar();
                    actionBar1.setTitle("Bookmark");
                    return true;
                case R.id.navigation_history:
                    fragment = new HistoryFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_layout,fragment,fragment.getClass().getSimpleName()).commit();
                    ActionBar actionBar2 = getSupportActionBar();
                    actionBar2.setTitle("History");
                    return true;
                case R.id.navigation_settings:
                    fragment = new SettingsFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_layout,fragment,fragment.getClass().getSimpleName()).commit();
                    ActionBar actionBar3 = getSupportActionBar();
                    actionBar3.setTitle("Settings");
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

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if(savedInstanceState == null){
            navView.setSelectedItemId(R.id.navigation_home);
        }
    }

}
