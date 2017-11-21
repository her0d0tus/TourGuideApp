package com.example.android.tourguideapp;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ShoppingFragment extends Fragment {

    public ShoppingFragment() {
        // Obligatory empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of locations
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("The Path", "31 Adelaide St. E."));
        places.add(new Place("Sherway Gardens", "25 The West Mall"));
        places.add(new Place("Scarborough Town Centre", "300 Borough Dr."));
        places.add(new Place("Evergreen Brick Works", "550 Bayview Ave."));
        places.add(new Place("Yorkdale Shopping Centre", "3401 Dufferin St."));
        places.add(new Place("CF Toronto Eaton Centre", "220 Yonge St."));
        places.add(new Place("St. Lawrence Market", "92-95 Front St. E."));
        places.add(new Place("Brookfield Place", "181 Bay St."));
        places.add(new Place("The Market Gallery", "95 Front St. E."));
        places.add(new Place("Fairview", "1800 Sheppard Ave. E."));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. This adapter
        // creates the list items for each item in the list.
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places, R.color.category_shopping);

        // Find the {@link ListView} with the view ID list in the place_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaceAdapter} to display the list items for
        // each {@link Place} in the list.
        listView.setAdapter(placeAdapter);

        return rootView;
    }

}
