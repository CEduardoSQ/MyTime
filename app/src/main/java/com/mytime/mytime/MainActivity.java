package com.mytime.mytime;

import android.support.v4.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mytime.mytime.Fragment.AboutFragment;
import com.mytime.mytime.Fragment.AgendaFragment;
import com.mytime.mytime.Fragment.BugFragment;
import com.mytime.mytime.Fragment.ClassFragment;
import com.mytime.mytime.Fragment.SettingsFragment;
import com.mytime.mytime.Fragment.TasksFragment;

import java.lang.*;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content, new AgendaFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.Agenda) {
            fragmentManager.beginTransaction().replace(R.id.content, new AgendaFragment()).commit();
        } else if (id == R.id.Class) {
            fragmentManager.beginTransaction().replace(R.id.content, new ClassFragment()).commit();
        } else if (id == R.id.Tasks) {
            fragmentManager.beginTransaction().replace(R.id.content, new TasksFragment()).commit();
        } else if (id == R.id.Settings) {
            fragmentManager.beginTransaction().replace(R.id.content, new SettingsFragment()).commit();
        } else if (id == R.id.About) {
            fragmentManager.beginTransaction().replace(R.id.content, new AboutFragment()).commit();
        } else if (id == R.id.Bug) {
            fragmentManager.beginTransaction().replace(R.id.content, new BugFragment()).commit();

        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}

