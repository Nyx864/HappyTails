package com.example.happytails;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.happytails.ui.fragment.HomeFragment;
import com.example.happytails.ui.fragment.PetsFragment;
import com.example.happytails.ui.fragment.TipsFragment;
import com.example.happytails.databinding.ActivityMainBinding;
import com.example.happytails.ui.transition.FragmentTransactionHelper;
import com.example.happytails.ui.transition.FragmentTransactionManager;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private Fragment homePageFragment;
    private Fragment tipsPageFragment;
    private Fragment petsPageFragment;
    private Fragment profilePageFragment;

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
        if (homePageFragment == null) {
            homePageFragment = new HomeFragment();
        }

        setNavUnselected();
        binding.homeImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.home_image_chosen));
        binding.homeText.setTextColor(getColor(R.color.nav_selected));

        setFragment(homePageFragment);
    }

    private void openTipsPage() {
        if (tipsPageFragment == null) {
            tipsPageFragment = new TipsFragment();
        }

        setNavUnselected();
        binding.tipsImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.tips_image_chosen));
        binding.tipsText.setTextColor(getColor(R.color.nav_selected));
        setFragment(tipsPageFragment);
    }

    private void openPetsPage() {
        if (petsPageFragment == null) {
            petsPageFragment = new PetsFragment();
        }

        setNavUnselected();
        binding.petsImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.pets_image_chosen));
        binding.petsText.setTextColor(getColor(R.color.nav_selected));
        setFragment(petsPageFragment);
    }

    private void openProfilePage() {
        setNavUnselected();
        binding.profileImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.profile_image_chosen));
        binding.profileText.setTextColor(getColor(R.color.nav_selected));
    }

    private void setFragment(Fragment fragment) {
        FragmentTransactionHelper transactionHelper =
                FragmentTransactionManager.getTransactionHelper(
                        R.id.mainFrameLayout,
                        this);
        transactionHelper.open(fragment);
    }
}