package com.example.gotoappjava;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Hospital extends ListActivity {
    String[] listHospital = new String[]{"RS TNI", "RS Madani", "RS Syafira"};
    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listHospital));
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
            switch (pilih){
                case "RS TNI":
                    intent = new Intent(this, RSTNI.class);
                    break;
                case "RS Madani":
                    intent = new Intent(this, Madani.class);
                    break;
                case "RS Syafira":
                    intent = new Intent(this, Syafira.class);
                    break;
            }

            startActivity(intent);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
