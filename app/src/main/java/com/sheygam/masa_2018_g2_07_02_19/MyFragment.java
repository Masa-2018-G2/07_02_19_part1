package com.sheygam.masa_2018_g2_07_02_19;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.BufferedWriter;
import java.io.PrintStream;
import java.util.Random;

public class MyFragment  extends Fragment {

    private static final String TAG = "MY_TAG";
    private float scale;
    private int color;

    public static MyFragment of(int color, float scale){
        MyFragment fragment = new MyFragment();
        fragment.color = color;
        fragment.scale = scale;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.my_fragment,container,false);
        view.setBackgroundColor(color);
        view.setScaleX(scale);
        view.setScaleY(scale);
        return view;
    }


    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView: ");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();

    }
}
