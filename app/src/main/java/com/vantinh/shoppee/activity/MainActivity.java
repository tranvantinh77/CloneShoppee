package com.vantinh.shoppee.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vantinh.shoppee.R;
import com.vantinh.shoppee.fragment.Home;
import com.vantinh.shoppee.fragment.Notification;
import com.vantinh.shoppee.fragment.ShopeeFeed;
import com.vantinh.shoppee.fragment.ShopeeLive;
import com.vantinh.shoppee.fragment.User;

public class MainActivity extends AppCompatActivity {

    public static BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentActivity,
                new Home()).commit();
        getSupportParentActivityIntent();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.itemGoiY:
                            selectedFragment = new Home();
                            break;
                        case R.id.itemShopeeFeed:
                            selectedFragment = new ShopeeFeed();
                            break;
                        case R.id.itemShopeeLive:
                            selectedFragment = new ShopeeLive();
                            break;
                        case R.id.itemNotiffication:
                            selectedFragment = new Notification();
                            break;
                        case R.id.itemAccount:
                            selectedFragment = new User();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentActivity,
                            selectedFragment).commit();

                    return true;
                }
            };
}