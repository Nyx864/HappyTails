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
import com.example.happytails.adapter.PetListAdapter;
import com.example.happytails.data.model.Pet;
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPetsBinding.inflate(inflater, container, false);


        List<Pet> pets = Arrays.asList(
                new Pet("Bob", Icon.createWithResource(getContext(), R.drawable.settings), null, null ,null),
                new Pet("Anna", Icon.createWithResource(getContext(), R.drawable.settings), null, null ,null),
                new Pet("Yarik", Icon.createWithResource(getContext(), R.drawable.settings), null, null ,null),
                new Pet("Angelica", Icon.createWithResource(getContext(), R.drawable.settings), null, null ,null),
                new Pet("Huston", Icon.createWithResource(getContext(), R.drawable.settings), null, null ,null),
                new Pet("Ai", Icon.createWithResource(getContext(), R.drawable.settings), null, null ,null),
                new Pet("Koneko", Icon.createWithResource(getContext(), R.drawable.settings), null, null ,null),
                new Pet("Regulus Corneas", Icon.createWithResource(getContext(), R.drawable.settings), null, null ,null)
                );
        PetListAdapter adapter = new PetListAdapter(pets);
        adapter.setOnItemClickListener(v -> Navigation.findNavController(binding.getRoot()).navigate(R.id.action_petsFragment_to_petFragment));
        binding.petsRecyclerView.setAdapter(adapter);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);
        binding.petsRecyclerView.setLayoutManager(layoutManager);

        return binding.getRoot();
    }
}