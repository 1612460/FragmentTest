package com.example.minhcuong.fragmenttest;

import android.app.Fragment;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.*;
import android.widget.*;

public class FragmentBlue extends Fragment implements FragmentCallBacks {
    private int selectedRow = -1;
    MainActivity mainActivity;
    Context context = null;
    //Gia lap nguon du lieu cho vao list
    private String items[] = {"Tran Van A", "Tran Van B", "Tran Van C", "Nguyen Van D", "Nguyen Thi E", "Pham Van F"};

    public static FragmentBlue newInstance(String strArg) {
        FragmentBlue fragment = new FragmentBlue();
        Bundle args = new Bundle();
        args.putString("strArg1", strArg);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            context = getActivity(); // use this reference to invoke main callbacks
            mainActivity = (MainActivity) getActivity();
        } catch (IllegalStateException e) {
            throw new IllegalStateException(
                    "MainActivity must implement callbacks");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout layout_blue = (LinearLayout) inflater.inflate(R.layout.layout_blue, null);
        final TextView txtBlue = (TextView) layout_blue.findViewById(R.id.txtBlue);
        final ListView listView = (ListView) layout_blue.findViewById(R.id.listViewBlue);
        listView.setBackgroundColor(Color.parseColor("#ffccddff"));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setSelection(0);
        listView.smoothScrollToPosition(0);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                mainActivity.onMsgFromFragToMain("BLUE-FRAG", "Blue selected row = " + position);
                txtBlue.setText("Blue selected row = " + position);
                selectedRow = position;
                for (int i = 0; i < listView.getChildCount(); i++) {
                    if(position == i ){
                        listView.getChildAt(i).setBackgroundColor(Color.GRAY);
                    }else{
                        listView.getChildAt(i).setBackgroundColor(listView.getDrawingCacheBackgroundColor());
                    }
                }
            }
        });
        return layout_blue;
    }

    @Override
    public void onMsgFromMainToFragment(String strValue) {
        //Chua thuc hien gi ca
    }
}
