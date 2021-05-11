package com.dimas.projectakhirku.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dimas.projectakhirku.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView (@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                    ViewModelProviders.of(this).get(HomeViewModel.class);
            View root = inflater.inflate(R.layout.fragment_home, container, false);
            final TextView textView = root.findViewById(R.id.text_home);
            final Button sweet = root.findViewById(R.id.sweetcharlie);
            final Button oso = root.findViewById(R.id.osogrande);
            final Button tristan = root.findViewById(R.id.tristan);
            final Button rosalinda = root.findViewById(R.id.rosalinda);
            final Button nyoho = root.findViewById(R.id.nyoho);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
                @Override
                public void onChanged(@Nullable String s) {
                    textView.setText(s);
                }

        });
        sweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getActivity(), sweet_desc.class);
                startActivity(I);
            }
        });
        oso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getActivity(), oso_desc.class);
                startActivity(I);
            }
        });
        tristan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getActivity(), tristan_desc.class);
                startActivity(I);
            }
        });
        rosalinda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getActivity(), rosa_desc.class);
                startActivity(I);
            }
        });
        nyoho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getActivity(), nyoho_desc.class);
                startActivity(I);
            }
        });
        return root;
    }



}
