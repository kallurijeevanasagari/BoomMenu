package com.example.hp.boommenu;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class MainActivity extends AppCompatActivity {
    CircleMenu circleMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleMenu = (CircleMenu) findViewById(R.id.boommenu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.mipmap.menu, R.mipmap.cancel);
        circleMenu.addSubMenu(Color.parseColor("#250CFF"), R.mipmap.home)
                .addSubMenu(Color.parseColor("#30A400"), R.mipmap.search)
                .addSubMenu(Color.parseColor("#FF4B32"), R.mipmap.notification)
                .addSubMenu(Color.parseColor("#8A39FF"), R.mipmap.settings)
                .addSubMenu(Color.parseColor("#FF6A00"),R.mipmap.navigation);

         circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {

             public void onMenuSelected(int i) {
                 switch (i){
                     case 0:
                         Toast.makeText(MainActivity.this,"Home Button Clicked",Toast.LENGTH_LONG).show();

                         startActivity(new Intent(MainActivity.this,Main2Activity.class));
                         break;
                     case 1:
                         Toast.makeText(MainActivity.this,"Search Button Clicked",Toast.LENGTH_LONG).show();
                         break;
                     case 2:
                         Toast.makeText(MainActivity.this,"Notify Button Clicked",Toast.LENGTH_LONG).show();
                         break;
                     case 3:
                         Toast.makeText(MainActivity.this,"Settings Button Clicked",Toast.LENGTH_LONG).show();
                         break;
                     case 4:
                         Toast.makeText(MainActivity.this,"GPS Button Clicked",Toast.LENGTH_LONG).show();
                         break;
                 }
             }
         });
        circleMenu.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            public void onMenuOpened() {
                Toast.makeText(MainActivity.this,"Menu Opened",Toast.LENGTH_LONG).show();
            }


            public void onMenuClosed() {
                Toast.makeText(MainActivity.this,"Menu Closed",Toast.LENGTH_LONG).show();

            }
        });

    }
    @Override
    public void onBackPressed() {
       if(circleMenu.isOpened())
           circleMenu.closeMenu();
        else
           finish();
    }
}
