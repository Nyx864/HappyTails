package com.example.happytails;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.happytails.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        binding.homeGroup.setOnClickListener(v -> {
           setNavUnselected();
            binding.homeImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.home_image_chosen));
            binding.homeText.setTextColor(getColor(R.color.nav_selected));
        });

        binding.tipsGroup.setOnClickListener(v -> {
            setNavUnselected();
            binding.tipsImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.tips_image_chosen));
            binding.tipsText.setTextColor(getColor(R.color.nav_selected));
        });

        binding.petsGroup.setOnClickListener(v -> {
            setNavUnselected();
            binding.petsImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.pets_image_chosen));
            binding.petsText.setTextColor(getColor(R.color.nav_selected));
        });

        binding.otherGroup.setOnClickListener(v -> {
            setNavUnselected();
            binding.otherImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.other_image_chosen));
            binding.otherText.setTextColor(getColor(R.color.nav_selected));
        });

    }

    private void setNavUnselected() {
        binding.tipsImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.tips_image_unchosen));
        binding.otherImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.other_image_unchosen));
        binding.petsImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.pets_image_unchosen));
        binding.homeImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.home_image_unchosen));
        binding.tipsText.setTextColor(getColor(R.color.nav_unselected));
        binding.otherText.setTextColor(getColor(R.color.nav_unselected));
        binding.petsText.setTextColor(getColor(R.color.nav_unselected));
        binding.homeText.setTextColor(getColor(R.color.nav_unselected));
    }

    private void init() {
        binding.tipsImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.tips_image_unchosen));
        binding.otherImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.other_image_unchosen));
        binding.petsImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.pets_image_unchosen));
        binding.homeImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.home_image_chosen));
        binding.tipsText.setTextColor(getColor(R.color.nav_unselected));
        binding.otherText.setTextColor(getColor(R.color.nav_unselected));
        binding.petsText.setTextColor(getColor(R.color.nav_unselected));
        binding.homeText.setTextColor(getColor(R.color.nav_selected));
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFrameLayout, fragment);
        fragmentTransaction.commit();
    }
}