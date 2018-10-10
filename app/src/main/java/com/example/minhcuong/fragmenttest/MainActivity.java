package com.example.minhcuong.fragmenttest;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity implements MainCallBacks {
    FragmentTransaction ft;
    FragmentRed redFragment;
    FragmentBlue blueFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //blue
        ft = getFragmentManager().beginTransaction();
        blueFragment = FragmentBlue.newInstance("first-blue");
        ft.replace(R.id.main_holder_blue, blueFragment);
        ft.commit();
        //red
        ft = getFragmentManager().beginTransaction();
        redFragment = FragmentRed.newInstance("first-red");
        ft.replace(R.id.main_holder_red, redFragment);
        ft.commit();

    }

    @Override
    public void onMsgFromFragToMain(String sender, String strValue) {
        Toast.makeText(getApplication(), "MAIN GOT >>" +sender+"\n"+strValue, Toast.LENGTH_SHORT).show();
        if (sender.equals("RED-FRAG")){
            //Chua xu ly
        }
        if (sender.equals("BLUE-FRAG")){
            try {
                redFragment.onMsgFromMainToFragment("\nSender: "+sender+"\n" + "Msg: "+strValue);
            }catch (Exception e){
                Log.e("Error", "onStrFromFragToMain" + e.getMessage());
            }
        }
    }
}
