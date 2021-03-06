package com.example.test.listview;

import android.content.Context;
import android.content.res.Resources;
import android.provider.ContactsContract;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    String[] memeTitles;
    String[] memeDescription;
    int[] images = {R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4,R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4};
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        memeTitles = res.getStringArray(R.array.titles);
        memeDescription = res.getStringArray(R.array.descriptions);
        l = (ListView) findViewById(R.id.listview);
        milAdapter adapter = new milAdapter(this, memeTitles, images, memeDescription);
        l.setAdapter(adapter);

    }


}

class milAdapter extends ArrayAdapter<String> {
    Context context;
    int[] images;
    String[] titleArray;
    String[] descriptionArray;

    milAdapter(Context c, String[] titles, int imgs[], String[] desc) {
        super(c, R.layout.single_row, R.id.textView, titles);
        this.context = c;
        this.images = imgs;
        this.titleArray = titles;
        this.descriptionArray = desc;
    }

    class MyViewHolder {
        ImageView myImage;
        TextView myText, myDescription;

        MyViewHolder(View v) {
            myImage = (ImageView) v.findViewById(R.id.imageView);
            myText = (TextView) v.findViewById(R.id.textView);
            myDescription = (TextView) v.findViewById(R.id.textView2);
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        MyViewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, parent, false);
            holder = new MyViewHolder(row);
            row.setTag(holder);
            Log.d("Mil","Creating a new row");
        } else {
            holder = (MyViewHolder) row.getTag();
            Log.d("Mil","Recycling Stuff");


            holder.myImage.setImageResource(images[position]);
            holder.myText.setText(titleArray[position]);
            holder.myDescription.setText(descriptionArray[position]);
        }
        return row;
    }
}
