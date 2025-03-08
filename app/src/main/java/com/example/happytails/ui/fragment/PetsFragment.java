package com.example.happytails.ui.fragment;

import android.graphics.drawable.Icon;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happytails.R;
import com.example.happytails.adapter.PetListAdapter;
import com.example.happytails.data.Pet;
import com.example.happytails.databinding.FragmentPetsBinding;

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
        adapter.setOnItemClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.mainFrameLayout, new PetFragment());
            fragmentTransaction.commit();
        });
        binding.petsRecyclerView.setAdapter(adapter);
        binding.petsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        return binding.getRoot();
    }
}