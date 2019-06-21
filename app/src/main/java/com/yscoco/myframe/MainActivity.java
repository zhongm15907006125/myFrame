package com.yscoco.myframe;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yscoco.myframe.helper.ResHelper;
import com.yscoco.myframe.ui.fragment.home.view.FocusFragment;
import com.yscoco.myframe.ui.fragment.home.view.FoundFragment;
import com.yscoco.myframe.ui.fragment.home.view.MainFragment;
import com.yscoco.myframe.ui.fragment.home.view.MyFragment;
import com.yscoco.myframe.util.StatusBarUtil;
import com.yscoco.myframe.widget.MyViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.vp_main)
    MyViewPager vpMain;
    @BindView(R.id.tl_main)
    TabLayout tlMain;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        StatusBarUtil.setTranslucentForImageView(this, 0, null);

        /**
         * 加上这两行代码将侧滑出来的部分顶上状态栏灰色去除
         */
        drawerLayout.setFitsSystemWindows(true);
        drawerLayout.setClipToPadding(false);
//
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        getWindow().setStatusBarColor(Color.TRANSPARENT);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        setupVp();
//        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openLeft() {
        if (!drawerLayout.isDrawerOpen(navView))
        drawerLayout.openDrawer(navView);
    }

    //底部菜单栏
    private void setupVp() {
        vpMain.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return getFragmentByPos(i);
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
        tlMain.setupWithViewPager(vpMain);
        int[] strArray = ResHelper.getIdArray(R.array.array_home_tab_str);
        int[] icArray = ResHelper.getIdArray(R.array.array_home_tab_ic);
        for (int i = 0; i < strArray.length; i++) {
            View tabView = View.inflate(this, R.layout.item_home_tab, null);
            ((ImageView) tabView.findViewById(R.id.iv_home_tab)).setImageResource(icArray[i]);
            ((TextView) tabView.findViewById(R.id.tv_home_tab)).setText(strArray[i]);
            TabLayout.Tab tab = tlMain.getTabAt(i);
            if (null != tab) {
                tab.setCustomView(tabView);
            }
        }
        vpMain.setOffscreenPageLimit(3);
    }

    private Fragment getFragmentByPos(int i) {
        switch (i) {
            case 0:
                return new MainFragment();
            case 1:
                return new FocusFragment();
            case 2:
                return new FoundFragment();
            case 3:
                return new MyFragment();
            default:
        }
        throw new RuntimeException(String.valueOf(i));
    }
}
