package com.example.david.virtualix;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class index extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new menu2())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();

    }

    /**
     * Sobreescribir el método de pulsar botón atrás.
     * Utilizar el FragmentManager de la gestión del Activity
     */
    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.index, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Opciones para clicar en el menú desplegable
        int id = item.getItemId();

        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();

        Fragment fragmento = null;

        if (id == R.id.home) {
            fragmento = new menu2();
        } else if (id == R.id.miscursos) {
            fragmento = new menu1();
        } else if (id == R.id.misnotas) {
            fragmento = new menu3();
        } else if (id == R.id.calculadora) {
            fragmento = new menu4();
        } else if (id == R.id.info1) {
            fragmento = new menu_info();
        } else if (id == R.id.info2) {
            fragmento = new menu_info2();
        }
        else if (id == R.id.logout) {
            Intent logout  = new Intent(index.this, loginj.class);
            startActivity(logout);
            finish();
        }

        if (fragmento != null) {
            int count = fragmentManager.getBackStackEntryCount();

            FragmentTransaction fragmentTransaction = fragmentManager
                    .beginTransaction();
            fragmentTransaction.replace(R.id.contenedor, fragmento)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(String.valueOf(count)).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}