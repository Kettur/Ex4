package com.example.ex4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ex4.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    FragmentFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(getLayoutInflater());

        binding.to2ndFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().
                        add(R.id.fragment, new SecondFragment()).commit();
            }
        });

        binding.to3rdFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                        .add(R.id.fragment, new ThirdFragment()).commit();
            }
        });

        return binding.getRoot();
    }
}