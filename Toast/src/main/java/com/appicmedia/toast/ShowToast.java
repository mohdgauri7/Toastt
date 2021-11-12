package com.appicmedia.toast;

import android.content.Context;
import android.widget.Toast;

public class ShowToast {

    public void ToastShow(Context context,String msg){
        Toast.makeText(context, ""+msg, Toast.LENGTH_SHORT).show();
    }

}
