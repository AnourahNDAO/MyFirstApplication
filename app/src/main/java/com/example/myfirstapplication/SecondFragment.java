package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.Person;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Random;

public class SecondFragment extends Fragment {

    Integer myArg = SecondFragment.fromBundle(getArguments()).getMyArg();
    public SecondFragment() {
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
                Integer count = myArg;
                Random random = new java.util.Random();
                Integer randomNumber = 0;
                if (count > 0) {
                    randomNumber = random.nextInt(count + 1);
                }
                TextView randomView = view.getRootView().findViewById(R.id.textview_random);
                randomView.setText(randomNumber.toString());
            }
        });
    }
}
