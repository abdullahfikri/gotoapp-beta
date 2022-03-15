package com.example.gotoappjava.market.listmarket;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gotoappjava.MainActivity;

public class hawaiiSwalayan extends ListActivity {
    String[] listAction = new String[]{"Call Center", "SMS Center", "Driving Direction", "Website", "Info Google", "Exit"};
    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listAction));
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
                case "Call Center":
                    String nomorTelp = "tel:0761-77777";
                    intent = new Intent(Intent.ACTION_DIAL, Uri.parse(nomorTelp));
                    break;
                case "SMS Center":
                    String smsText = "Halo Pasar Hawai Swalayan, saya ";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("sms:0821-32132122"));
                    intent.putExtra("sms_body",smsText);
                    break;
                case "Driving Direction":
                    String lokasi = "google.navigation:q=0.5593, 101.4330";
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasi));
                    break;
                case "Website":
                    String linkWeb = "https://www.instagram.com/hawaiiswalayanpku/?hl=id";
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkWeb));
                    break;
                case "Info Google":
                    intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, "Hawaii Swalayan Pekanbaru");
                    break;
                case "Exit":
                    intent = new Intent(this, MainActivity.class);
                    break;
            }

            startActivity(intent);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
