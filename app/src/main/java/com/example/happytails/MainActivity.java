package com.example.happytails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.happytails.data.repository.LoginRepository;
import com.example.happytails.data.source.DataSourceFactory;
import com.example.happytails.data.source.LoginDataSource;
import com.example.happytails.databinding.ActivityMainBinding;
import com.example.happytails.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginDataSource dataSource = DataSourceFactory.create(LoginDataSource.class, this);
        LoginRepository repository = LoginRepository.getInstance(dataSource);
        if (!repository.isLoggedIn()) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setupNavigationUI();
    }

    private void setupNavigationUI() {
        NavHostFragment navHostFragment = (NavHostFragment)
                getSupportFragmentManager().findFragmentById(R.id.mainContainerView);

        if (navHostFragment == null) return;

        NavController controller = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.mainBottomNavigationView, controller);
        customizeCenterBottomNavigationItem();
    }

    private void customizeCenterBottomNavigationItem() {
        View centerBottomNavigationItem = binding.mainBottomNavigationView
                .findViewById(R.id.nav_graph_post);

        centerBottomNavigationItem.setTranslationY(25);
        centerBottomNavigationItem.setScaleX(1.5f);
        centerBottomNavigationItem.setScaleY(1.5f);
    }
}