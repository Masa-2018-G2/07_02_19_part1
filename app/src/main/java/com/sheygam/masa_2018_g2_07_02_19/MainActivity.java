package com.sheygam.masa_2018_g2_07_02_19;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addBtn, removeBtn, replaceBtn, attachBtn, detachBtn;
    private float scale = 1.0F;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn = findViewById(R.id.add_btn);
        removeBtn = findViewById(R.id.remove_btn);
        replaceBtn = findViewById(R.id.replace_btn);
        attachBtn = findViewById(R.id.attach_btn);
        detachBtn = findViewById(R.id.detach_btn);

        addBtn.setOnClickListener(this);
        removeBtn.setOnClickListener(this);
        replaceBtn.setOnClickListener(this);
        attachBtn.setOnClickListener(this);
        detachBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_btn:
                Random rnd = new Random();
                int r = rnd.nextInt(256);
                int g = rnd.nextInt(256);
                int b = rnd.nextInt(256);
                int color = Color.rgb(r,g,b);
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                if(count == 2){
                    transaction.add(R.id.container,MyFragment.of(color,scale),"MY_FRAG");
                }else {
                    transaction.add(R.id.container, MyFragment.of(color, scale));
                }
                transaction.addToBackStack(null);
                transaction.commit();
                scale -= 0.1;
                count++;
                break;
            case R.id.remove_btn:
                Fragment f = getSupportFragmentManager().findFragmentByTag("MY_FRAG");
                if(f != null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .remove(f)
                            .commit();
                }
                break;
            case R.id.replace_btn:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,MyFragment.of(Color.rgb(0,0,0), scale))
                        .addToBackStack(null)
                        .commit();
                scale -= 0.1;
                break;
            case R.id.attach_btn:
                Fragment f2 = getSupportFragmentManager().findFragmentByTag("MY_FRAG");
                if(f2 != null){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .attach(f2)
                            .commit();
                }
                break;
            case R.id.detach_btn:
                Fragment f1 = getSupportFragmentManager().findFragmentByTag("MY_FRAG");
                if (f1 != null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .detach(f1)
                            .commit();
                }
                break;
        }
    }
}
