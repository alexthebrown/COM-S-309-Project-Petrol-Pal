package com.example.as1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Future Class for User Profiles. Not implemented yet
 * * @author Alex Brown
 */
public class ProfileActivity extends AppCompatActivity {

    BottomNavigationView nav;
    Button FavButton;
    Intent intent;

    String username;

    Long userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        nav = findViewById(R.id.bottomNavView_BarProfile);
        FavButton = findViewById(R.id.FavBtn);
        intent = getIntent();
        if(intent != null) {
            username = intent.getStringExtra("username");
            userID = intent.getLongExtra("userID", 0);
        }

        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()){
                    case R.id.nb_list:
                        intent = new Intent(ProfileActivity.this, UserMain.class);
                        startActivity(intent);
                        break;
                    case R.id.nb_map:
                        intent = new Intent(ProfileActivity.this, MapActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nb_profile:
                        break;
                }
                return false;
            }
        });

        FavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                intent = new Intent(ProfileActivity.this, FavList.class);
                intent.putExtra("username", username);
                intent.putExtra( "userID", userID);
                startActivity(intent);
            }
        });
    }

}