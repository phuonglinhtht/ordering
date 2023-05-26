package com.example.ordering;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.apporder.R;
import com.google.android.material.navigation.NavigationView;

public class MainAdminActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration1;

    @Override
    protected void onCreate(Bundle saveInstanceState){

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_mainadmin);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view_admin);
        mAppBarConfiguration1 = new AppBarConfiguration.Builder(R.id.nav_home,R.id.nav_order).setDrawerLayout(drawer).build();
        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment_admin);
        NavigationUI.setupActionBarWithNavController(this,navController,mAppBarConfiguration1);
        NavigationUI.setupWithNavController(navigationView,navController);
    }

    public void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer_admin, menu);
        return true;
    }


}
