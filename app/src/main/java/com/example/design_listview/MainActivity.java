package com.example.design_listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Facebook", "Instagram"};
    String mDecription[] = {"Nguyen Tri", "Xpekexoan"};
    int img[] = {R.drawable.fb, R.drawable.ig};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_item);
        Myadapter adapter = new Myadapter(this, mTitle, mDecription, img);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(MainActivity.this, "Facebook DE", Toast.LENGTH_SHORT).show();
                }
                if (position == 1) {
                    Toast.makeText(MainActivity.this, "Instagram DE", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class Myadapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDecription[];
        int rimg[];

        Myadapter(Context c, String title[], String decription[], int imgs[]) {
            super(c, R.layout.row, R.id.text1, title);
            this.context = c;
            this.rTitle = title;
            this.rDecription = decription;
            this.rimg = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            super.getView(position, convertView, parent);
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.img);
            TextView txt1 = row.findViewById(R.id.text1);
            TextView txt2 = row.findViewById(R.id.text2);
            images.setImageResource(rimg[position]);
            txt1.setText(rTitle[position]);
            txt2.setText(rDecription[position]);
            return row;
        }

    }

}