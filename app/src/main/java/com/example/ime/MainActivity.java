package com.example.ime;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private NavigationView mNv;
    private TabLayout mTab;
    private ArrayList<Fragment> fragments;
    private ViewPager mVp;
    private ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTab();
        initFra();

        initAda();
    }

    private void initAda() {
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments,strings);
        mVp.setAdapter(vpAdapter);
        mTab.setupWithViewPager(mVp);

    }

    private void initTab() {
        strings = new ArrayList<>();
        strings.add("消息");
        strings.add("联系");
        strings.add("动态");
    }

    private void initFra() {
        fragments = new ArrayList<>();
        fragments.add(new DongTaiFra());
        fragments.add(new LianXiFra());
        fragments.add(new DongTaiFra());

    }


    private void initView() {

        mNv = (NavigationView) findViewById(R.id.nv);
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
    }
}
