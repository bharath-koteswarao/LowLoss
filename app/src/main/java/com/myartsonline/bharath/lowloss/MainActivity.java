package com.myartsonline.bharath.lowloss;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.myartsonline.bharath.lowloss.RewardsRecyclerView.Data;
import com.myartsonline.bharath.lowloss.RewardsRecyclerView.MyAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout home,calendar,rewards,help;
    CalendarView calendarView;
    RecyclerView rewardsRecView;
    ProgressBar bar1,bar2,bar3,bar4;
    Data d;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        home=(LinearLayout)findViewById(R.id.homeLayout);
        calendar=(LinearLayout)findViewById(R.id.calendarLayout);
        rewards=(LinearLayout)findViewById(R.id.rewardsLayout);
        help=(LinearLayout)findViewById(R.id.helpLayout);
        calendarView=(CalendarView)findViewById(R.id.calendarView);
        rewardsRecView=(RecyclerView)findViewById(R.id.rewardsRecView);
        bar1 =(ProgressBar)findViewById(R.id.firstBar);
        bar2 =(ProgressBar)findViewById(R.id.secondBar);
        bar3 =(ProgressBar)findViewById(R.id.thirdBar);
        bar4 =(ProgressBar)findViewById(R.id.fourthBar);
        bar1.setScaleY(7f);
        bar1.setProgress(70);
        bar2 =(ProgressBar)findViewById(R.id.secondBar);
        bar2.setScaleY(7f);
        bar2.setProgress(70);
        bar3 =(ProgressBar)findViewById(R.id.thirdBar);
        bar3.setScaleY(7f);
        bar3.setProgress(70);
        bar4 =(ProgressBar)findViewById(R.id.fourthBar);
        bar4.setScaleY(7f);
        bar4.setProgress(70);
        d=new Data(this);
        adapter=new MyAdapter(d.getList(),this);
        rewardsRecView.setLayoutManager(new LinearLayoutManager(rewardsRecView.getContext()));
        rewardsRecView.setAdapter(adapter);
        Data d=new Data(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "fab", Toast.LENGTH_SHORT).show();
            }
        });
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this, i2+"", Toast.LENGTH_SHORT).show();
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar1 if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            calendar.setVisibility(View.GONE);
            rewards.setVisibility(View.GONE);
            help.setVisibility(View.GONE);
            home.setVisibility(View.VISIBLE);
        } else if (id == R.id.nav_calendar) {
            calendar.setVisibility(View.VISIBLE);
            rewards.setVisibility(View.GONE);
            help.setVisibility(View.GONE);
            home.setVisibility(View.GONE);
        } else if (id == R.id.nav_rewards) {
            calendar.setVisibility(View.GONE);
            rewards.setVisibility(View.VISIBLE);
            help.setVisibility(View.GONE);
            home.setVisibility(View.GONE);
        } else if (id == R.id.nav_about) {
            calendar.setVisibility(View.GONE);
            rewards.setVisibility(View.GONE);
            help.setVisibility(View.VISIBLE);
            home.setVisibility(View.GONE);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
