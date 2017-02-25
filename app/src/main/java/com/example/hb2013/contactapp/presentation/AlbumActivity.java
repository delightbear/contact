package com.example.hb2013.contactapp.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.hb2013.contactapp.R;
import com.example.hb2013.contactapp.util.AlbumAdapter;

public class AlbumActivity extends AppCompatActivity {
    GridView gridView;
    public static String[] photos() {
        String[] photos =new String[12];
        for(int i=0;i<photos.length;i++){
              photos[i]=(i+1<10)?"mov0"+(i+1):"mov"+(i+1);
        }
        return photos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        gridView= (GridView) findViewById(R.id.gvAlbum);
        gridView.setAdapter(new AlbumAdapter(this,photos()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AlbumActivity.this,"사진클릭",Toast.LENGTH_LONG).show();
            }
        });


    }
}
