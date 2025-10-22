package com.example.androiduitesting;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class ShowActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        View view = getLayoutInflater().inflate(R.layout.show_activity, null);
        setContentView(view);

        TextView cityName = view.findViewById(R.id.cityName);
        Button backButton = view.findViewById(R.id.backButton);

        Intent intent = getIntent();

        String city;
        city = (String) intent.getSerializableExtra("City");

        cityName.setText(city);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

}
