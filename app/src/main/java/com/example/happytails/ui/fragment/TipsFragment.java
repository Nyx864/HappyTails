package com.example.happytails.ui.fragment;

import android.graphics.drawable.Icon;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.happytails.R;
import com.example.happytails.adapter.TabAdapter;
import com.example.happytails.adapter.TipAdapter;
import com.example.happytails.data.model.Article;
import com.example.happytails.databinding.FragmentTipsBinding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TipsFragment extends Fragment {

    private FragmentTipsBinding binding;
    private final Set<String> groupFilters = new HashSet<>();

    private static final List<String> TABS = Arrays.asList(
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTipsBinding.inflate(inflater, container, false);

        setupTabs();
        setupTips();

        return binding.getRoot();
    }

    private void setupTabs() {
        TabAdapter tabAdapter = new TabAdapter(TABS);
        tabAdapter.setOnStateUpdateListener(this::updateGroupFilter);

        binding.tabsRV.setAdapter(tabAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        binding.tabsRV.setLayoutManager(layoutManager);
    }

    private void updateGroupFilter(View view, boolean chosen) {
        String filterText = ((Button) view).getText().toString();
        if (chosen) {
            groupFilters.add(filterText);
        } else {
            groupFilters.remove(filterText);
        }
    }

    private void setupTips() {
        List<Article> articles = getArticles();

        TipAdapter tipAdapter = new TipAdapter(articles);
        tipAdapter.setOnItemClickListener((view, data) -> navigateToTipFragment());
        binding.tipsRV.setAdapter(tipAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.tipsRV.setLayoutManager(layoutManager);
    }

    private List<Article> getArticles() {
        Icon defaultIcon = Icon.createWithResource(getContext(), R.drawable.ic_launcher_background);
        return Arrays.asList(
                new Article(defaultIcon, "asdasd", "21312312312adasd", null),
                new Article(defaultIcon, "asdasd", "21312312312adasd", null),
                new Article(defaultIcon, "asdasd", "21312312312adasd", null),
                new Article(defaultIcon, "asdasd", "21312312312adasd", null),
                new Article(defaultIcon, "asdasd", "21312312312adasd", null),
                new Article(defaultIcon, "asdasd", "21312312312adasd", null),
                new Article(defaultIcon, "asdasd", "21312312312adasd", null)
        );
    }

    private void navigateToTipFragment() {
        Navigation.findNavController(binding.getRoot())
                .navigate(R.id.action_tipsFragment_to_tipFragment);
    }
}
