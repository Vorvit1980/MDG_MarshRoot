package dev.barmaglot.com.mdg_marshroot.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dev.barmaglot.com.mdg_marshroot.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentWidthText extends Fragment {

    private String text;

    public FragmentWidthText(){

    }


    public FragmentWidthText(String text) {
        // Required empty public constructor
        this.text = text;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_with_text, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.textFragment);
        textView.setText(text);


        return rootView;
    }
}
