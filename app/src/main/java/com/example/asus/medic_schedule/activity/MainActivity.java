package com.example.asus.medic_schedule.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;

import com.example.asus.medic_schedule.R;
import com.example.asus.medic_schedule.fragment.AddBloodSugarFragment;
import com.example.asus.medic_schedule.fragment.FragmentMain;
import com.example.asus.medic_schedule.fragment.HomeScreenFragment;
import com.example.asus.medic_schedule.fragment.ListOfBloodPressureFragment;
import com.example.asus.medic_schedule.fragment.MedicineListFragment;

import br.liveo.interfaces.OnItemClickListener;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import br.liveo.model.HelpLiveo;
import br.liveo.navigationliveo.NavigationLiveo;

public class MainActivity extends NavigationLiveo implements OnItemClickListener {

    private HelpLiveo mHelpLiveo;
    private Fragment mFragment = null;
    private FragmentManager mFragmentManager;

    @Override
    public void onItemClick(int position) {
        mFragmentManager = getSupportFragmentManager();

        switch (position) {
            case 0:
                mFragment = new HomeScreenFragment();
                break;
            case 1:
                mFragment = new MedicineListFragment();
                break;
            case 2:
                mFragment = new ListOfBloodPressureFragment();
                break;
            case 3:
                mFragment = new AddBloodSugarFragment();
                break;
            case 4:
                closeDrawer();
                mFragment = new HomeScreenFragment();
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
                .startingPosition(0)
                .addAllHelpItem(mHelpLiveo.getHelp())
                .footerItem(R.string.settings, R.drawable.ic_action_settings)
                .setOnClickUser(onClickPhoto)
                .setOnPrepareOptionsMenu(onPrepare)
                //.setOnClickFooter(onClickFooter)
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

//    private View.OnClickListener onClickFooter = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            closeDrawer();
//            mFragment = new SettingsFragment();
//            mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
//        }
//    };
}
