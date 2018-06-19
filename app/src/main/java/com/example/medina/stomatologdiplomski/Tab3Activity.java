package com.example.medina.stomatologdiplomski;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Tab3Activity extends AppCompatActivity {
    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);
        mPager=(ViewPager)findViewById(R.id.moj3Tab);

        pripremi_ViewPager();
    }

    private void pripremi_ViewPager() {
        final FragmentManager fm=getSupportFragmentManager();
        mPager.setAdapter(new FragmentPagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Fragment f=null;

                if(position==0)
                {
                    f=new ProsliPonFragment();

                }
                if(position==1){
                    f=new ProsliUtorakFragment();
                }
                if(position==2){
                    f=new ProslaSrijedaFragment();
                }if(position==3){
                    f=new ProsliCetvrtakFragment();
                }if(position==4){
                    f=new ProsliPetakFragment();
                }

                return f;

            }

            @Override
            public int getCount() {
                return 5;
            }
        });

        final ActionBar actionBar=getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener nesto= new ActionBar.TabListener(){


            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                int pozicija=tab.getPosition();
                mPager.setCurrentItem(pozicija);
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };

        ActionBar.Tab tab1=actionBar.newTab().setText("PONEDJELJAK").setTabListener(nesto);
        actionBar.addTab(tab1);
        ActionBar.Tab tab2=actionBar.newTab().setText("UTORAK").setTabListener(nesto);
        actionBar.addTab(tab2);
        ActionBar.Tab tab3=actionBar.newTab().setText("SRIJEDA").setTabListener(nesto);
        actionBar.addTab(tab3);
        ActionBar.Tab tab4=actionBar.newTab().setText("ČETVRTAK").setTabListener(nesto);
        actionBar.addTab(tab4);
        ActionBar.Tab tab5=actionBar.newTab().setText("PETAK").setTabListener(nesto);
        actionBar.addTab(tab5);
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });
    }
}
