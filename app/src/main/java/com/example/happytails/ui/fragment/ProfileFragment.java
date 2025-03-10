package com.example.happytails.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happytails.adapter.PetListAdapter;
import com.example.happytails.data.model.User;
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
}
