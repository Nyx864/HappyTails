package com.example.happytails.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.happytails.MainActivity;
import com.example.happytails.R;
import com.example.happytails.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {

    private RegisterViewModel registerViewModel;
    private FragmentRegisterBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        binding.registerBtn.setEnabled(false);
        setupToSingInText();

        registerViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(RegisterViewModel.class);

        final EditText usernameEditText = binding.usernameInput;
        final EditText passwordEditText = binding.passwordInput;
        final EditText repeatPasswordEditText = binding.repeatPasswordInput;
        final EditText emailEditText = binding.emailInput;
        final Button registerButton = binding.registerBtn;
        final ImageView loading = binding.loading2;
        final AnimationDrawable loadingAnim = (AnimationDrawable) loading.getDrawable();



        registerViewModel.getRegisterFormState().observe(getViewLifecycleOwner(), loginFormState -> {
            if (loginFormState == null) {
                return;
            }
            registerButton.setEnabled(loginFormState.isDataValid());

            if (loginFormState.getUsernameError() != null) {
                binding.usernameErrorText.setText(getString(loginFormState.getUsernameError()));
                binding.usernameErrorText.setVisibility(View.VISIBLE);
            } else {
                binding.usernameErrorText.setVisibility(View.GONE);
            }

            if (loginFormState.getPasswordError() != null) {
                binding.passwordErrorText2.setText(getString(loginFormState.getPasswordError()));
                binding.passwordErrorText2.setVisibility(View.VISIBLE);
            } else {
                binding.passwordErrorText2.setVisibility(View.GONE);
            }

            if (loginFormState.getRepeatPasswordError() != null) {
                binding.repeatPasswordErrorText.setText(getString(loginFormState.getRepeatPasswordError()));
                binding.repeatPasswordErrorText.setVisibility(View.VISIBLE);
            } else {
                binding.repeatPasswordErrorText.setVisibility(View.GONE);
            }

//            if (loginFormState.getEmailError() != null) {
//                binding.passwordErrorText2.setText(getString(loginFormState.getPasswordError()));
//                binding.passwordErrorText2.setVisibility(View.VISIBLE);
//            } else {
//                binding.passwordErrorText2.setVisibility(View.GONE);
//            }
        });

        registerViewModel.getLoginResult().observe(getViewLifecycleOwner(), loginResult -> {
            if (loginResult == null) {
                return;
            }
            registerButton.setEnabled(true);
            loading.setVisibility(View.GONE);
            loadingAnim.stop();

            if (loginResult.getError() != null) {
            }
            if (loginResult.getSuccess() != null) {
                toMainActivity();
            }

        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                registerViewModel.registerDataChanged(
                        usernameEditText.getText().toString(),
                        passwordEditText.getText().toString(),
                        repeatPasswordEditText.getText().toString(),
                        emailEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        repeatPasswordEditText.addTextChangedListener(afterTextChangedListener);

        registerButton.setOnClickListener(v -> {
            loading.setVisibility(View.VISIBLE);
            loadingAnim.start();
            registerButton.setEnabled(false);
            registerViewModel.register(
                    usernameEditText.getText().toString(),
                    passwordEditText.getText().toString(),
                    emailEditText.getText().toString());
        });

        return binding.getRoot();
    }

    private void setupToSingInText() {
        String haveAccount = getResources().getString(R.string.have_acoount);
        String singIn = getResources().getString(R.string.sing_in);
        String toSingInText = haveAccount + " " + singIn;
        int start = haveAccount.length() + 1;
        int end = start + singIn.length();

        SpannableString toSingIn = new SpannableString(toSingInText);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                navigateToSingInFragment();
            }
        };
        toSingIn.setSpan(clickableSpan, start, end, 0);

        binding.toSingInText.setText(toSingIn);
        binding.toSingInText.setClickable(true);
        binding.toSingInText.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void navigateToSingInFragment() {
        Navigation.findNavController(binding.getRoot())
                .popBackStack();
    }

    private void toMainActivity() {
        Activity currentActivity = getActivity();
        Intent intent = new Intent(currentActivity, MainActivity.class);
        startActivity(intent);
        currentActivity.finish();
    }
}