package com.example.happytails.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happytails.ui.adapter.PetListAdapter;
import com.example.happytails.ui.adapter.PostAdapter;
import com.example.happytails.data.dto.Pet;
import com.example.happytails.databinding.FragmentPetBinding;

import java.util.ArrayList;

public class PetFragment extends Fragment {

    private FragmentPetBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPetBinding.inflate(inflater, container, false);

        Pet pet = new Pet("bob", null, "sajd;alsda;ld\n" +
                "sadasdasdasd\n" +
                "sadasdsad\n", new ArrayList<>(), new ArrayList<>());

        setupPetDetails(pet);
        setupFriendsList(pet);
        setupPostsList(pet);

        binding.petBackBtn.setOnClickListener(v -> navigateBack());

        return binding.getRoot();
    }

    private void setupPetDetails(Pet pet) {
        binding.petDescription.setText(pet.getDescription());
        binding.petBarName.setText(pet.getName());
        binding.petName.setText(pet.getName());
        binding.petImage.setImageIcon(pet.getPfp());
    }

    private void setupFriendsList(Pet pet) {
        binding.petFriendsList.setAdapter(new PetListAdapter(pet.getFriends()));
        binding.petFriendsList.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false)
        );
    }

    private void setupPostsList(Pet pet) {
        binding.petPosts.setAdapter(new PostAdapter(pet.getPosts()));
        binding.petPosts.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void navigateBack() {
        Navigation.findNavController(binding.getRoot()).popBackStack();
    }
}