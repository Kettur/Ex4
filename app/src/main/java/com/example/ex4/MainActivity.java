package com.example.ex4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import android.os.Bundle;
import android.renderscript.ScriptGroup;

import com.example.ex4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().
                    setReorderingAllowed(true).
                    add(R.id.fragment, FirstFragment.class, null).commit();
        }
        setContentView(binding.getRoot());
    }
}