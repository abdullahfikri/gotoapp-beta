package com.example.gotoappjava.police;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gotoappjava.Madani;
import com.example.gotoappjava.RSTNI;
import com.example.gotoappjava.Syafira;
import com.example.gotoappjava.police.listpolice.PoldaRiau;
import com.example.gotoappjava.police.listpolice.PolresPekanbaru;
import com.example.gotoappjava.police.listpolice.RSDC;

public class Police extends ListActivity {
    String[] listPolice = new String[]{"Polda Riau", "Polres Pekanbaru", "Riau Safety Driving Centre"};
    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listPolice));
    }

    protected void onListItemClick(ListView list, View view, int position, long id){
        super.onListItemClick(list, view, position, id);
        Object object = this.getListAdapter().getItem(position);
        String pilih = object.toString();

        getPilihan(pilih);
    }

    private void getPilihan(String pilih) {
        try {
            Intent intent= null;
            if (pilih.equals(listPolice[0])){
                intent = new Intent(this, PoldaRiau.class);
            } else if (pilih.equals(listPolice[1])){
                intent = new Intent(this, PolresPekanbaru.class);
            } else if (pilih.equals(listPolice[2])){
                intent = new Intent(this, RSDC.class);
            }

            startActivity(intent);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}