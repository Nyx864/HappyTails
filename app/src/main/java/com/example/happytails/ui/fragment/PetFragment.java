package com.example.happytails.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happytails.adapter.PetListAdapter;
import com.example.happytails.adapter.PostAdapter;
import com.example.happytails.data.model.Pet;
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

        binding.petDescription.setText(pet.getDescription());
        binding.petBarName.setText(pet.getName());
        binding.petName.setText(pet.getName());
        binding.petImage.setImageIcon(pet.getPfp());
        binding.petFriendsList.setAdapter(new PetListAdapter(pet.getFriends()));
        binding.petFriendsList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.petPosts.setAdapter(new PostAdapter(pet.getPosts()));
        binding.petPosts.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.back.setOnClickListener(v ->
                Navigation.findNavController(binding.getRoot())
                        .popBackStack());

        return binding.getRoot();
    }
}