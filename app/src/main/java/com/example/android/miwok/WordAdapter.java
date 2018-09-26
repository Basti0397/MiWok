package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private Integer color;

    public WordAdapter(Activity context, ArrayList<Word> wordList, Integer color) {
        super(context, 0, wordList);
        this.color = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Word currentWord = getItem(position);

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.vocabs_layout, parent, false);
        }

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation() );

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation() );

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        if(currentWord.getImageResourceId() != null ) {
            imageView.setImageResource( currentWord.getImageResourceId() );
        }else{
            imageView.setVisibility(View.GONE);
        }

//        final MediaPlayer sound = MediaPlayer.create(this.getContext(), currentWord.getSound_Id() );
//
//        listItemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });

        listItemView.findViewById(R.id.text_container).setBackgroundColor(ContextCompat.getColor(getContext(), color) );


        return  listItemView;
    }
}
