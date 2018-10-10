package com.example.minhcuong.fragmenttest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class FragmentRed extends Fragment implements FragmentCallBacks {
    MainActivity main;
    TextView txtRed;
    Button btnLast, btnFirst, btnPrev, btnNext;

    public static FragmentRed newInstance(String strArg1) {
        FragmentRed fragment = new FragmentRed();
        Bundle args = new Bundle();
        args.putString("arg1", strArg1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!(getActivity() instanceof MainCallBacks)) {
            throw new IllegalStateException(" Activity must implement MainCallbacks");
        }
        main = (MainActivity) getActivity(); // use this reference to invoke main callbacks
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout view_layout_red = (LinearLayout) inflater.inflate(R.layout.layout_red, null);
        txtRed = (TextView) view_layout_red.findViewById(R.id.textView);
        btnFirst = (Button) view_layout_red.findViewById(R.id.btnFirst);
        btnNext = (Button) view_layout_red.findViewById(R.id.btnNext);
        btnPrev = (Button) view_layout_red.findViewById(R.id.btnPrev);
        btnLast = (Button) view_layout_red.findViewById(R.id.btnLast);


        return view_layout_red;
    }

    @Override
    public void onMsgFromMainToFragment(String strValue) {

    }
}
