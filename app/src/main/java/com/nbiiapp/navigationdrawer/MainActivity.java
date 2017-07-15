package com.nbiiapp.navigationdrawer;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initNavigationDrawer();

    }


    public void initNavigationDrawer() {

        // initiate Navigation drawer
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.home:
                        Fragment fragment = new PlusOneFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, fragment).addToBackStack(null).commit();

                        drawerLayout.closeDrawers();
                        break;
                    case R.id.settings:
                        Fragment fragment2 = new BlankFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, fragment2).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.trash:
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.trash2:
                        Fragment fragmentTrash = new BlankFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, fragmentTrash).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.logout:
                        finish();

                }
                return true;
            }
        });
        View header = navigationView.getHeaderView(0);
        TextView tv_email = (TextView) header.findViewById(R.id.tv_email);
        tv_email.setText("NBII Updated Title");
        //comment
        //comment

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

}
