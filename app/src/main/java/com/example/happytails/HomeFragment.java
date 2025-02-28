package com.example.happytails;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happytails.adapter.EventAdapter;
import com.example.happytails.data.Event;
import com.example.happytails.databinding.FragmentHomeBinding;
import com.google.android.material.carousel.CarouselLayoutManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        List<Event> list = Arrays.asList(new Event[]{
                new Event(null, "asdasd", "21312312312adasd", LocalDateTime.now()),
                new Event(null, "asdasd", "21312312312adasd", LocalDateTime.now()),
                new Event(null, "asdasd", "21312312312adasd", LocalDateTime.now()),
                new Event(null, "asdasd", "21312312312adasd", LocalDateTime.now()),
                new Event(null, "asdasd", "21312312312adasd", LocalDateTime.now()),
                new Event(null, "asdasd", "21312312312adasd", LocalDateTime.now()),
                new Event(null, "asdasd", "21312312312adasd", LocalDateTime.now())
        });
        binding.eventsRV.setAdapter(new EventAdapter(getContext(), list));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.eventsRV.setLayoutManager(layoutManager);
        return binding.getRoot();
    }
}