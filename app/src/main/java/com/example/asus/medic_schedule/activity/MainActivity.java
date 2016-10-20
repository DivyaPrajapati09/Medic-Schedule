package com.example.asus.medic_schedule.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;

import com.example.asus.medic_schedule.R;

import br.liveo.interfaces.OnItemClickListener;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import br.liveo.model.HelpLiveo;
import br.liveo.navigationliveo.NavigationLiveo;

public class MainActivity extends NavigationLiveo implements OnItemClickListener {

    private HelpLiveo mHelpLiveo;

    @Override
    public void onItemClick(int position) {
        Fragment mFragment = null;
        FragmentManager mFragmentManager = getSupportFragmentManager();

        switch (position) {
            case 1:
                mFragment = new Medicine();
                break;
            case 2:
                mFragment = new BloodPressure();
                break;
            case 3:
                mFragment = new BloodPressure();
                break;
            case 4:
                closeDrawer();
                Intent intent4 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent4);
                break;
            default:
                mFragment = FragmentMain.newInstance(mHelpLiveo.get(position).getName());
                break;

        }
        if (mFragment != null) {
            mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
        }
    }

    @Override
    public void onInt(Bundle savedInstanceState) {
        // User Information
        this.userName.setText("Rudson Lima");
        this.userEmail.setText("rudsonlive@gmail.com");
        this.userPhoto.setImageResource(R.drawable.photo);
        this.userBackground.setImageResource(R.drawable.image);

        // Creating items navigation
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(R.string.home), R.drawable.ic_action_home, 7);
        mHelpLiveo.add(getString(R.string.Medicines), R.drawable.ic_action_add_black, 7);
        mHelpLiveo.add(getString(R.string.blood_pressure_data), R.drawable.ic_action_add_black);
        mHelpLiveo.add(getString(R.string.sugar_data), R.drawable.ic_action_add_black);
        mHelpLiveo.add(getString(R.string.search), R.drawable.ic_action_search);
        mHelpLiveo.addSeparator();

        with(this)
                .startingPosition(2)
                .addAllHelpItem(mHelpLiveo.getHelp())
                .footerItem(R.string.settings, R.drawable.ic_action_settings)
                .setOnClickUser(onClickPhoto)
                .setOnPrepareOptionsMenu(onPrepare)
                .setOnClickFooter(onClickFooter)
                .build();

    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
        }
    };

    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            closeDrawer();
        }
    };

    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            closeDrawer();
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }
    };
}
