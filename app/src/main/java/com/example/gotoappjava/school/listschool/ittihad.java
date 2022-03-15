package com.example.gotoappjava.school.listschool;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gotoappjava.MainActivity;

public class ittihad extends ListActivity {
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
                    String nomorTelp = "tel:0461 946314";
                    intent = new Intent(Intent.ACTION_DIAL, Uri.parse(nomorTelp));
                    break;
                case "SMS Center":
                    String smsText = "Halo SMA Ittihad, saya ";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("sms:0823-3213-3213"));
                    intent.putExtra("sms_body",smsText);
                    break;
                case "Driving Direction":
                    String lokasi = "google.navigation:q=0.5763, 101.4346";
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasi));
                    break;
                case "Website":
                    String linkWeb = "https://al-ittihad.org/profile-smait-al-ittihad/";
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkWeb));
                    break;
                case "Info Google":
                    intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, "SMA IT Al-Ittihad");
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
