package com.example.happytails.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.happytails.MainActivity;
import com.example.happytails.R;
import com.example.happytails.databinding.FragmentSingInBinding;

public class SingInFragment extends Fragment {

    private SingInViewModel singInViewModel;
    private FragmentSingInBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSingInBinding.inflate(inflater, container, false);
        setupToRegisterText();

        singInViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(SingInViewModel.class);

        final EditText usernameEditText = binding.emailOrUsername;
        final EditText passwordEditText = binding.password;
        final Button singInButton = binding.singInBtn;
        final ImageView loading = binding.loading;
        final AnimationDrawable loadingAnim = (AnimationDrawable) loading.getDrawable();

        singInViewModel.getLoginResult().observe(getViewLifecycleOwner(), loginResult -> {
            if (loginResult == null) {
                return;
            }
            singInButton.setEnabled(true);
            loading.setVisibility(View.GONE);
            loadingAnim.stop();

            if (loginResult.getError() != null) {
                binding.singInErrorText.setVisibility(View.VISIBLE);
                binding.singInErrorText.setText(loginResult.getError());
            }
            if (loginResult.getSuccess() != null) {
                toMainActivity();
            }
        });

        passwordEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                singInViewModel.singIn(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
            return false;
        });

        singInButton.setOnClickListener(v -> {
            singInButton.setEnabled(false);
            loading.setVisibility(View.VISIBLE);
            loadingAnim.start();
            singInViewModel.singIn(usernameEditText.getText().toString(),
                    passwordEditText.getText().toString());
        });

        return binding.getRoot();
    }

    private void setupToRegisterText() {
        String noAccount = getResources().getString(R.string.no_account);
        String register = getResources().getString(R.string.register);
        String toRegistrationText = noAccount + " " + register;
        int start = noAccount.length() + 1;
        int end = start + register.length();

        SpannableString toRegistration = new SpannableString(toRegistrationText);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                navigateToRegisterFragment();
            }
        };
        toRegistration.setSpan(clickableSpan, start, end, 0);

        binding.toRegisterText.setText(toRegistration);
        binding.toRegisterText.setClickable(true);
        binding.toRegisterText.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void toMainActivity() {
        Activity currentActivity = getActivity();
        Intent intent = new Intent(currentActivity, MainActivity.class);
        startActivity(intent);
        currentActivity.finish();
    }

    private void navigateToRegisterFragment() {
        Navigation.findNavController(binding.getRoot())
                .navigate(R.id.register);
    }
}