package com.cv.simons.simonborgstromcv;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String qualifier = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        String timeString = "";
        String title = "";
        String descript = "";
        qualifier = getIntent().getStringExtra("qualifier");
        switch (qualifier) {
            case "work":
                timeString = getIntent().getStringExtra("workTime");
                title = getIntent().getStringExtra("workTitle");
                descript = getIntent().getStringExtra("workdescription");
                break;
            case "education":
                timeString = getIntent().getStringExtra("educationTime");
                title = getIntent().getStringExtra("educationTitle");
                descript = getIntent().getStringExtra("educationDescription");
                break;
            case "qualification":
                timeString = getIntent().getStringExtra("qualificationId");
                title = getIntent().getStringExtra("qualificationTitle");
                break;
            default:
                timeString = "cant find";
                title = "cant find";
        }
        TextView time = (TextView) findViewById(R.id.detailsTime);
        time.setText(timeString);
        TextView head = (TextView) findViewById(R.id.detailsHeader);
        head.setText(title);
        TextView description = (TextView) findViewById(R.id.detailsDescription);
        description.setText(descript);


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent returnIntent;
            switch (qualifier) {
                case "work":
                    returnIntent = new Intent(this, WorkActivity.class);
                    setResult(RESULT_OK, returnIntent);
                    finish();
                    //break;
                case "education":
                    returnIntent = new Intent(this, EducationActivity.class);
                    setResult(RESULT_OK, returnIntent);
                    finish();
                    //break;
                case "qualification":
                    returnIntent = new Intent(this, QualificationsActivity.class);
                    setResult(RESULT_OK, returnIntent);
                    finish();
                    //break;
            }

            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
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

        if (id == R.id.nav_start) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_about) {
            Intent i = new Intent(this, AboutActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_work) {
            Intent i = new Intent(this, WorkActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_education) {
            Intent i = new Intent(this, EducationActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_qualifications) {
            Intent i = new Intent(this, QualificationsActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_git) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.github.com/Valmorbus"));
            startActivity(browserIntent);

        } else if (id == R.id.nav_call) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
            phoneIntent.setData(Uri.parse("tel:0705566544"));
            startActivity(phoneIntent);

        } else if (id == R.id.nav_email) {
            Intent sendMail = new Intent(Intent.ACTION_SEND);
            sendMail.setType("text/mail");
            sendMail.putExtra(Intent.EXTRA_EMAIL, new String[]{"borgstrom.simon@gmail.com"});
            sendMail.putExtra(Intent.EXTRA_SUBJECT, "Mitt subject");
            sendMail.putExtra(Intent.EXTRA_TEXT, "Hej Simon");
            startActivity(Intent.createChooser(sendMail, "Välj epostprogram:"));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
