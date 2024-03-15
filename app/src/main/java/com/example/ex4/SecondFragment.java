package com.example.ex4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.ex4.databinding.FragmentSecondBinding;

import java.util.ArrayList;


public class SecondFragment extends Fragment {
    private ArrayList<Car> cars = new ArrayList<>();
    FragmentSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(getLayoutInflater());

        getData();
        AdapterListView adapter = new AdapterListView(getContext(), R.layout.item, cars);
        binding.listViewCars.setAdapter(adapter);
        binding.listViewCars.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), cars.get(position).getModel(), Toast.LENGTH_SHORT).show();
                Log.i("carOnClick", cars.get(position).getModel());
            }
        });
        return binding.getRoot();

    }
    private void getData(){
        for (int i = 1; i <= 200; ++i)
            cars.add(new Car("Car № " + i));
    }
}