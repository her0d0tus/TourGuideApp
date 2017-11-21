package com.example.android.tourguideapp;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    /** Resource ID for the background colour of the list of places*/
    private int mColorResourceId;

    public PlaceAdapter(Activity context, ArrayList<Place> places, int colorResourceId) {
        super(context, 0, places);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, else inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Place} object located at this position on the list
        Place currentPlace = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID place_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.place_name);

        // Get the name from the current Place object and set this text in the name TextView
        nameTextView.setText(currentPlace.getName());

        // Find the TextView in the list_item.xml layout with the ID place_address
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.place_address);

        // Get the address from the current Place object and set this text in the address TextView
        addressTextView.setText(currentPlace.getAddress());

        // Find the ImageView in the list_item.xml layout with the ID imgMain
        ImageView imgView = (ImageView) listItemView.findViewById(R.id.imgMain);

        if (currentPlace.hasImage()) {
            // If an image is available, display the provided made based on the resource ID
            imgView.setImageResource(currentPlace.getImageResourceId());

            imgView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the IconView (set visibility to GONE)
            imgView.setVisibility(View.GONE);
        }

        // Find the View in the list_item.xml layout with the ID text_container
        View textContainer = listItemView.findViewById(R.id.text_container);

        // Find the colour that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        // Set the background colour of the the text container view
        textContainer.setBackgroundColor(color);

        // Return the list item layout
        return listItemView;
    }
}
