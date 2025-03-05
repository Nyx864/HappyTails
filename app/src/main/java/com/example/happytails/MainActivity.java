package com.example.happytails;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.happytails.UI.HomeFragment;
import com.example.happytails.UI.PetsFragment;
import com.example.happytails.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private static Fragment homePageFragment;
    private static Fragment tipsPageFragment;
    private static Fragment petsPageFragment;
    private static Fragment profilePageFragment;

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

        init();

        binding.homeGroup.setOnClickListener(v -> {
            openHomePage();
        });

        binding.tipsGroup.setOnClickListener(v -> {
            openTipsPage();
        });

        binding.petsGroup.setOnClickListener(v -> {
            openPetsPage();
        });

        binding.profileGroup.setOnClickListener(v -> {
            openProfilePage();
        });

    }

    private void setNavUnselected() {
        binding.tipsImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.tips_image_unchosen));
        binding.profileImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.profile_image_unchosen));
        binding.petsImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.pets_image_unchosen));
        binding.homeImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.home_image_unchosen));
        binding.tipsText.setTextColor(getColor(R.color.nav_unselected));
        binding.profileText.setTextColor(getColor(R.color.nav_unselected));
        binding.petsText.setTextColor(getColor(R.color.nav_unselected));
        binding.homeText.setTextColor(getColor(R.color.nav_unselected));
    }

    private void init() {
        homePageFragment = new HomeFragment();
        petsPageFragment = new PetsFragment();
        openHomePage();
    }
    
    private void openHomePage() {
        if(homePageFragment.isHidden()) {
            homePageFragment = new HomeFragment();
        } else {
            setNavUnselected();
            binding.homeImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.home_image_chosen));
            binding.homeText.setTextColor(getColor(R.color.nav_selected));
        }

        binding.homeImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_anim));
        setFragment(homePageFragment);
    }

    private void openTipsPage() {

        setNavUnselected();
        binding.tipsImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.tips_image_chosen));
        binding.tipsText.setTextColor(getColor(R.color.nav_selected));
        binding.tipsImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_anim));
    }

    private void openPetsPage() {
        if(petsPageFragment.isHidden()) {
            petsPageFragment = new PetsFragment();
        } else {
            setNavUnselected();
            binding.petsImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.pets_image_chosen));
            binding.petsText.setTextColor(getColor(R.color.nav_selected));
        }

        binding.petsImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_anim));
        setFragment(new PetsFragment());
    }

    private void openProfilePage() {
        setNavUnselected();
        binding.profileImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.profile_image_chosen));
        binding.profileText.setTextColor(getColor(R.color.nav_selected));
        binding.profileImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_anim));
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFrameLayout, fragment);
        fragmentTransaction.commit();
    }
}