package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mp;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
            //Hallo
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("red", "wetetti", R.drawable.color_red, R.raw.color_red) );
        words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green) );
        words.add(new Word("brown", "takaakki", R.drawable.color_brown, R.raw.color_brown) );
        words.add(new Word("gray", "topoppi", R.drawable.color_gray, R.raw.color_gray) );
        words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black) );
        words.add(new Word("white", "kellelli", R.drawable.color_white, R.raw.color_white) );
        words.add(new Word("dusty yellow", "topisse", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow) );
        words.add(new Word("mustard yellow", "chiwiite", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow) );


        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                releaseMediaPlayer();

                mp = MediaPlayer.create(ColorsActivity.this, words.get(position).getSound_Id() );
                mp.start();

                mp.setOnCompletionListener( mCompletionListener );
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){

        if(mp!=null){
            mp.release();
            mp=null;

            Toast.makeText(ColorsActivity.this, "Finished", Toast.LENGTH_SHORT ).show();
        }
    }
}
