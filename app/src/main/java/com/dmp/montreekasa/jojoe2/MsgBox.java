package com.dmp.montreekasa.jojoe2;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.dmp.montreekasa.jojoe2.R;

public class MsgBox {
    public static void show(Activity activity, String msg){
        LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.msgbox_layout,null);

        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        ImageView imageView = (ImageView)view.findViewById(R.id.image_close);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        TextView tv = (TextView)view.findViewById(R.id.text_msg);
        tv.setText(msg);

        View root = activity.getWindow().getDecorView().getRootView();
        popupWindow.showAtLocation(root, Gravity.CENTER,0,0);



    }
}
