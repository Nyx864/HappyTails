package com.example.happytails.ui.fragment;

import android.graphics.drawable.Icon;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.happytails.R;
import com.example.happytails.adapter.TabAdapter;
import com.example.happytails.adapter.TipAdapter;
import com.example.happytails.data.model.Article;
import com.example.happytails.databinding.FragmentTipsBinding;

import java.util.Arrays;
import java.util.List;

public class TipsFragment extends Fragment {

    private FragmentTipsBinding binding;
    private static final List<String> tabs = Arrays.asList(
            "dogs",
            "cats",
            "behavior",
            "home",
            "additional",
            "water",
            "food",
            "list",
            "tab",
            "LayoutInflater"
    );
    private String groupFilter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTipsBinding.inflate(inflater, container, false);
        initTabs();
        initTips();

        return binding.getRoot();
    }

    private void initTabs() {
        TabAdapter tabAdapter = new TabAdapter(tabs);
        tabAdapter.setOnStateUpdateListener((v, chosen) -> {
            if (chosen) groupFilter = ((Button) v).getText().toString();
            else groupFilter = null;
        });
        binding.tabsRV.setAdapter(tabAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false);
        binding.tabsRV.setLayoutManager(layoutManager);
    }

    private void initTips() {
        List<Article> list = Arrays.asList(
                new Article(Icon.createWithResource(getContext(), R.drawable.ic_launcher_background), "asdasd", "21312312312adasd", null),
                new Article(Icon.createWithResource(getContext(),R.drawable.ic_launcher_background), "asdasd", "21312312312adasd", null),
                new Article(Icon.createWithResource(getContext(),R.drawable.ic_launcher_background), "asdasd", "21312312312adasd", null),
                new Article(Icon.createWithResource(getContext(),R.drawable.ic_launcher_background), "asdasd", "21312312312adasd", null),
                new Article(Icon.createWithResource(getContext(),R.drawable.ic_launcher_background), "asdasd", "21312312312adasd", null),
                new Article(Icon.createWithResource(getContext(),R.drawable.ic_launcher_background), "asdasd", "21312312312adasd", null),
                new Article(Icon.createWithResource(getContext(),R.drawable.ic_launcher_background), "asdasd", "21312312312adasd", null));

        TipAdapter adapter = new TipAdapter(list);
        binding.tipsRV.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.tipsRV.setLayoutManager(layoutManager);
    }
}