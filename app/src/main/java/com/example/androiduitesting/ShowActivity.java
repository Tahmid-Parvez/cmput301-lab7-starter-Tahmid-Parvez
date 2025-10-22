package com.example.androiduitesting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class ShowActivity extends Fragment {

    /**
     * This takes the city that's passed to the ShowActivity instance and creates a fragment
     * with the aforementioned city as the arguments by placing it in a bundle first.
     * @param city
     * @return
     */
    public static ShowActivity newInstance(String city){

        Bundle args = new Bundle();
        args.putSerializable("City", city);

        ShowActivity fragment = new ShowActivity();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout here
        View view = inflater.inflate(R.layout.show_activity, container, false);

        TextView cityName = view.findViewById(R.id.cityName);
        Button backButton = view.findViewById(R.id.backButton);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String city = (String) bundle.getSerializable("City");
            if (city != null) {
                cityName.setText(city);
            }
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view; // Don't forget to return the view!
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        View view = getLayoutInflater().inflate(R.layout.show_activity, null);

        TextView cityName = view.findViewById(R.id.cityName);
        Button backButton = view.findViewById(R.id.backButton);

        Bundle bundle = getArguments();

        String city;
        city = (String) bundle.getSerializable("City");

        cityName.setText(city);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });



    }

}
