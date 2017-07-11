package com.webephase.www.codechat;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by ai on 7/6/17.
 */

public class ChatAdapter extends ArrayAdapter<CodeChat> {
    public ChatAdapter(Context context, int resource, List<CodeChat> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_chat, parent, false);

        }
        ImageView photoImageView = (ImageView) convertView.findViewById(R.id.imageImageView);
        TextView chatTextView = (TextView) convertView.findViewById(R.id.chatTextView);
        TextView authorTextView = (TextView) convertView.findViewById(R.id.namechatTextView);

        CodeChat chat = getItem(position);

        boolean isPhoto = chat.getImageUrl() != null;
        if (isPhoto) {
            chatTextView.setVisibility(View.GONE);
            photoImageView.setVisibility(View.VISIBLE);
            Glide.with(photoImageView.getContext())
                    .load(chat.getImageUrl())
                    .into(photoImageView);

        } else {
            chatTextView.setVisibility(View.VISIBLE);
            photoImageView.setVisibility(View.GONE);
            chatTextView.setText(chat.getText());
        }
        authorTextView.setText(chat.getName());
        return convertView;
    }
}
