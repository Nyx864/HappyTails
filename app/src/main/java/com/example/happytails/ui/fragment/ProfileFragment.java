package com.example.happytails.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happytails.R;
import com.example.happytails.ui.adapter.PetListAdapter;
import com.example.happytails.data.dto.User;
import com.example.happytails.databinding.FragmentProfileBinding;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);

        setupUserProfile();
        setupPetsList();

        binding.settings.setOnClickListener(v -> navigateToSettingsFragment());

        return binding.getRoot();
    }

    private void setupUserProfile() {
        User user = new User("Anna", null, "i love my dogs!!!", null, null, null);
        binding.userName.setText(user.getName());
        binding.userDescription.setText(user.getDescription());
        binding.userPFP.setImageIcon(user.getPfp());
    }

    private void setupPetsList() {
        binding.userPetsRv.setAdapter(new PetListAdapter(new ArrayList<>()));

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);
        binding.userPetsRv.setLayoutManager(layoutManager);
    }

    private void navigateToSettingsFragment() {
        Navigation.findNavController(binding.getRoot())
                .navigate(R.id.action_profileFragment_to_settingsFragment);
    }
}
