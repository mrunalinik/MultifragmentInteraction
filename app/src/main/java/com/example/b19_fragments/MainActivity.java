package com.example.b19_fragments;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.b19_fragments.fragments.Fragment1;
import com.example.b19_fragments.fragments.Fragment2;
import com.example.b19_fragments.fragments.Fragment3;
import com.example.b19_fragments.interfaces.FragmentCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Load the UI
        setContentView(R.layout.activity_main);


        //Attach fragment1
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment1 fragment1 = new Fragment1();
        fragment1.setFragmentCallback(fragmentCallback1);
        transaction.replace(R.id.mainContainer, fragment1);
transaction.commit();


    }


    FragmentCallback fragmentCallback1=new FragmentCallback() {
        @Override
        public void buttonIsClicked1() {

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            Fragment2 fragment2 = new Fragment2();
            fragment2.setFragmentCallback(fragmentCallback1);
            transaction.replace(R.id.mainContainer, fragment2);
            transaction.addToBackStack("abcd");//Fragment tag.not requried in our usecase because both visible fragments.
            transaction.commit();
        }

        @Override
        public void buttonIsClicked2() {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            Fragment3 fragment3 = new Fragment3();

            transaction.replace(R.id.mainContainer, fragment3);
            transaction.addToBackStack("gef");//Fragment tag.not requried in our usecase because both visible fragments.
            transaction.commit();
        }
    };
}
