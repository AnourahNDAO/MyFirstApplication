package com.example.myfirstapplication;

import android.app.Notification;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    TextView showCountTextView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_first, container, false);
        // Inflate the layout for this fragment
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        // Get the count text view
        showCountTextView = fragmentFirstLayout.findViewById(R.id.textView);

        return fragmentFirstLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView showCountTextView = view.getRootView().findViewById(R.id.textview_first);
                int currentCount = Integer.parseInt(showCountTextView.getText().toString());
                FirstFragment.action_FirstFragment_to_SecondFragment action = FirstFragment.action_FirstFragment_to_SecondFragment(currentCount);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(action);
            }
        });

        view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(getActivity(), R.string.toast_button_text, Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        view.findViewById(R.id.textview_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countMe(view);
            }
        });
    }
}
