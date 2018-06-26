package com.example.medina.stomatologdiplomski;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.medina.stomatologdiplomski.Api.TerminApi;
import com.example.medina.stomatologdiplomski.Helper.F;
import com.example.medina.stomatologdiplomski.Helper.MyRunnable;
import com.example.medina.stomatologdiplomski.Model.TrenutnaDatumiVM;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

public class Tab2Activity extends AppCompatActivity {
    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);

        mPager=(ViewPager)findViewById(R.id.mojnextTab);
        TerminApi.datumiNaredne(Tab2Activity.this, new MyRunnable<TrenutnaDatumiVM>() {
            @Override
            public void run(TrenutnaDatumiVM trenutnaDatumiVM) {
                pripremi_ViewPager(trenutnaDatumiVM);
            }
        });

    }

    private void pripremi_ViewPager(TrenutnaDatumiVM dt) {
        final FragmentManager fm=getSupportFragmentManager();
        mPager.setAdapter(new FragmentPagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Fragment f=null;

                if(position==0)
                {
                    f=new NaredniPonFragment();

                }
                if(position==1){
                    f=new NaredniUtorakFragment();
                }
                if(position==2){
                    f=new NarednaSrijedaFragment();
                }if(position==3){
                    f=new NaredniCetFragment();
                }if(position==4){
                    f=new NaredniPetakFragment();
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
        actionBar.setTitle("Termini za sedmicu: "+F.Date_ddMMyyyy(dt.Pon)+" / "+F.Date_ddMMyyyy(dt.Ned));
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

        ActionBar.Tab tab1=actionBar.newTab().setText("PONEDJELJAK"+"\n"+F.Date_ddMMyyyy(dt.Pon)).setTabListener(nesto);
        actionBar.addTab(tab1);
        ActionBar.Tab tab2=actionBar.newTab().setText("UTORAK"+"\n"+F.Date_ddMMyyyy(dt.Uto)).setTabListener(nesto);
        actionBar.addTab(tab2);
        ActionBar.Tab tab3=actionBar.newTab().setText("SRIJEDA"+"\n"+F.Date_ddMMyyyy(dt.Sri)).setTabListener(nesto);
        actionBar.addTab(tab3);
        ActionBar.Tab tab4=actionBar.newTab().setText("ČETVRTAK"+"\n"+F.Date_ddMMyyyy(dt.Cet)).setTabListener(nesto);
        actionBar.addTab(tab4);
        ActionBar.Tab tab5=actionBar.newTab().setText("PETAK"+"\n"+F.Date_ddMMyyyy(dt.Pet)).setTabListener(nesto);
        actionBar.addTab(tab5);
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });
    }
}
