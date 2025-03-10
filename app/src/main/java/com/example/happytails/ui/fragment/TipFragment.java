package com.example.happytails.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happytails.databinding.FragmentTipBinding;

public class TipFragment extends Fragment {

    private FragmentTipBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTipBinding.inflate(inflater, container, false);

        binding.tipBackBtn.setOnClickListener(v -> navigateToPrevFragment());

        return binding.getRoot();
    }

    private void navigateToPrevFragment() {
        Navigation.findNavController(binding.getRoot())
                .popBackStack();
    }
}