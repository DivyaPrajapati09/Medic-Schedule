package com.example.asus.medic_schedule;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.liveo.interfaces.NavigationLiveoListener;
import br.liveo.navigationliveo.NavigationLiveo;


public class MainActivity extends NavigationLiveo implements NavigationLiveoListener {

    public List<String> mListNameItem;

    @Override
    public void onUserInformation() {
        //User information here
        this.mUserName.setText("Yash Sharma");
        this.mUserEmail.setText("yashsharma@gmail.com");
        this.mUserPhoto.setImageResource(R.drawable.photo);
        this.mUserBackground.setImageResource(R.drawable.meds);

    }

    @Override
    public void onInt(Bundle savedInstanceState) {
        //Creation of the list items is here

        // set listener {required}
        this.setNavigationListener(this);

        // name of the list items
        mListNameItem = new ArrayList<>();
        mListNameItem.add(0, "Medicines");
        mListNameItem.add(1, "Omega-3");
        mListNameItem.add(2, "Cardinol Plus");
        mListNameItem.add(3, "Other Data");
        mListNameItem.add(4, "Blood Preure Data"); //This item will be a subHeader
        mListNameItem.add(5, "Sugar Data");
        mListNameItem.add(6,"Search");

        // icons list items
        List<Integer> mListIconItem = new ArrayList<>();
        mListIconItem.add(0, 0);
        mListIconItem.add(1, 0); //Item no icon set 0
        mListIconItem.add(2, 0); //Item no icon set 0
        mListIconItem.add(3, 0);
        mListIconItem.add(4, 0); //When the item is a subHeader the value of the icon 0
        mListIconItem.add(5, 0);
        mListIconItem.add(6,0);

        //{optional} - Among the names there is some subheader, you must indicate it here
        List<Integer> mListHeaderItem = new ArrayList<>();
        mListHeaderItem.add(0);
        mListHeaderItem.add(3);

        //{optional} - Among the names there is any item counter, you must indicate it (position) and the value here
        SparseIntArray mSparseCounterItem = new SparseIntArray(); //indicate all items that have a counter
        mSparseCounterItem.put(1, 7);
        mSparseCounterItem.put(2, 12);

        //If not please use the FooterDrawer use the setFooterVisible(boolean visible) method with value false
        this.setFooterInformationDrawer("Settings", R.drawable.ic_settings_black_24dp);

        this.setNavigationAdapter(mListNameItem, mListIconItem, mListHeaderItem, mSparseCounterItem);



    }

    @Override
    public void onItemClickNavigation(int position, int layoutContainerId) {
        if(position==4)
        {
            Intent b=new Intent(getBaseContext(),DataList_bp.class);
            startActivity(b);

        }
        else if(position==5)
        {
            Intent c=new Intent(getBaseContext(),DataList_su.class);
            //startActivity(c);
        }
        else if(position==6)
        {
            Intent d=new Intent(getBaseContext(),Places.class);
            startActivity(d);
        }

    }

    @Override
    public void onPrepareOptionsMenuNavigation(Menu menu, int position, boolean visible) {




    }

    @Override
    public void onClickFooterItemNavigation(View v) {
        Intent a = new Intent(getBaseContext(), com.example.asus.medic_schedule.SettingsActivity.class);
        startActivity(a);

    }

    @Override
    public void onClickUserPhotoNavigation(View v) {

    }



   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.patient:
                Intent a = new Intent(getBaseContext(), Patient.class);
                startActivity(a);
                return true;

            case R.id.doctor:
                Intent b = new Intent(getBaseContext(), Doctor.class);
                startActivity(b);
                return true;

            case R.id.medicine:
                Intent c = new Intent(getBaseContext(), Medicine.class);
                startActivity(c);
                return true;


            default:
                return true;

        }


        //noinspection SimplifiableIfStatement


    }*/
}
