package com.example.ex4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ex4.databinding.FragmentThirdBinding;

import java.util.ArrayList;


public class ThirdFragment extends Fragment implements SelectedItem{
    private ArrayList<Boat> boats = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentThirdBinding binding = FragmentThirdBinding.inflate(getLayoutInflater());
        getData();
        AdapterRecyclerView adapter = new AdapterRecyclerView(getContext(), boats, this);
        binding.listViewBoats.setAdapter(adapter);
        return binding.getRoot();
    }
    public void getData(){
        for (int i = 1; i <= 200; ++i)
            boats.add(new Boat("Boat №" + i));
    }

    @Override
    public void onItemClicked(Boat boat) {
        Toast.makeText(getContext(), boat.getModel(), Toast.LENGTH_SHORT).show();
        Log.i("boatOnClick", boat.getModel());
    }
}