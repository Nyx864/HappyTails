package com.example.happytails.ui.fragment;

import android.graphics.drawable.Icon;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happytails.R;
import com.example.happytails.ui.adapter.PetListAdapter;
import com.example.happytails.data.dto.Pet;
import com.example.happytails.databinding.FragmentPetsBinding;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.Arrays;
import java.util.List;

public class PetsFragment extends Fragment {

    private FragmentPetsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPetsBinding.inflate(inflater, container, false);

        setupPetsList();

        return binding.getRoot();
    }

    private void setupPetsList() {
        List<Pet> pets = getPets();

        PetListAdapter adapter = new PetListAdapter(pets);
        adapter.setOnItemClickListener((view, data) -> navigateToPetFragment());
        binding.petsRecyclerView.setAdapter(adapter);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);
        binding.petsRecyclerView.setLayoutManager(layoutManager);
    }

    private List<Pet> getPets() {
        Icon defaultIcon = Icon.createWithResource(getContext(), R.drawable.settings);
        return Arrays.asList(
                new Pet("Bob", defaultIcon, null, null, null),
                new Pet("Anna", defaultIcon, null, null, null),
                new Pet("Yarik", defaultIcon, null, null, null),
                new Pet("Angelica", defaultIcon, null, null, null),
                new Pet("Huston", defaultIcon, null, null, null),
                new Pet("Ai", defaultIcon, null, null, null),
                new Pet("Koneko", defaultIcon, null, null, null),
                new Pet("Regulus Corneas", defaultIcon, null, null, null)
        );
    }

    private void navigateToPetFragment() {
        Navigation.findNavController(binding.getRoot())
                .navigate(R.id.action_petsFragment_to_petFragment);
    }
}
