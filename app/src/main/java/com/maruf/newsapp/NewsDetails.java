package com.maruf.newsapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewsDetails extends AppCompatActivity {
    ImageView newscover;
    TextView newstitle;
    TextView newsdes;
    FloatingActionButton floatingbtn;

    public  static String TITLE;
    public  static  String DESCRIPTION;

    public static Bitmap MY_BITMAP =null;

    TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        newscover =findViewById(R.id.newscover);
        newstitle =findViewById(R.id.newstitle);
        newsdes =findViewById(R.id.newsdes);
        floatingbtn=findViewById(R.id.floatingbtn);

        newstitle.setText(TITLE);
        newsdes.setText(DESCRIPTION);

        if (MY_BITMAP!=null) newscover.setImageBitmap(MY_BITMAP);

        textToSpeech= new TextToSpeech(NewsDetails.this, new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {

            }
        });


        floatingbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text = newsdes.getText().toString();
                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH,null,null);

            }
        });


    }

}