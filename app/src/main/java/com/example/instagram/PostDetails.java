package com.example.instagram;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class PostDetails extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_details);

        TextView tvUsernamePost;
        ImageView ivImagePost;
        TextView tvDescriptionPost;
        TextView tvRelativeTimePost;

        String username = "";
        String description = "";
        String timeAgo = "";
        String imageUrl = "";
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                username = extras.getString("username");
                description = extras.getString("description");
                timeAgo = extras.getString("timeAgo");
                imageUrl = extras.getString("imageUrl");
            }
        } else {
            username = (String) savedInstanceState.getSerializable("username");
            description = (String) savedInstanceState.getSerializable("description");
            timeAgo = (String) savedInstanceState.getSerializable("timeAgo");
            imageUrl = (String) savedInstanceState.getSerializable("imageUrl");
        }

        tvUsernamePost = (TextView) findViewById(R.id.tvUsernamePost);
        tvDescriptionPost = (TextView) findViewById(R.id.tvDescriptionPost);
        tvRelativeTimePost = (TextView) findViewById(R.id.tvRelativeTimePost);
        ivImagePost = (ImageView) findViewById(R.id.ivImagePost);

        if (!imageUrl.equals("")) {
            Glide.with(this).load(imageUrl).into(ivImagePost);
        }
        tvUsernamePost.setText(username);
        tvDescriptionPost.setText(description);
        tvRelativeTimePost.setText(timeAgo);
    }
}
