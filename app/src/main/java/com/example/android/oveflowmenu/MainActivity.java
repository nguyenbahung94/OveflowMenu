package com.example.android.oveflowmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnstart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstart=(Button)findViewById(R.id.Btnpopup);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(MainActivity.this,btnstart);
                popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());


                //registering popup with onMenuItemClicklistener
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this,"YOU Clicked:"+item.getTitle(),Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                popupMenu.show();
                //showing popu menu
            }
        }); //closing the setonclicklistener method

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu_main,menu);
        return  true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout main_view=(RelativeLayout)findViewById(R.id.main_viewss);
        switch (item.getItemId()){
            case R.id.menu_red:
                if(item.isChecked()){
                           item.setChecked(false);
                }
                else{
                    item.setChecked(true);
                }
                main_view.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu_green:
                if(item.isChecked()){
                    item.setChecked(false);
                }
                else{
                    item.setChecked(true);
                }
                main_view.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.menu_yellow:
                if(item.isChecked()){
                    item.setChecked(false);
                }
                else{
                    item.setChecked(true);
                }
                main_view.setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
