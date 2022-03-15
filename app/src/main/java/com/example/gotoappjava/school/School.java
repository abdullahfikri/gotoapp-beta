package com.example.gotoappjava.school;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gotoappjava.market.listmarket.giantPanam;
import com.example.gotoappjava.market.listmarket.hawaiiSwalayan;
import com.example.gotoappjava.market.listmarket.pasarBuah;
import com.example.gotoappjava.school.listschool.asShofa;
import com.example.gotoappjava.school.listschool.ittihad;
import com.example.gotoappjava.school.listschool.uinsuska;

public class School extends ListActivity {
    String[] listPolice = new String[]{"Sekolah As-Shofa", "SMA IT Al-Ittihad", "UIN Suska Riau"};
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
                intent = new Intent(this, asShofa.class);
            } else if (pilih.equals(listPolice[1])){
                intent = new Intent(this, ittihad.class);
            } else if (pilih.equals(listPolice[2])){
                intent = new Intent(this, uinsuska.class);
            }

            startActivity(intent);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}