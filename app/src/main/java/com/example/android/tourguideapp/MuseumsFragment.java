package com.example.android.tourguideapp;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class MuseumsFragment extends Fragment {

    public MuseumsFragment() {
        // Empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of locations
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("The Power Plant", "231 Queens Quay W."));
        places.add(new Place("Textile Museum of Canada", "55 Centre Ave."));
        places.add(new Place("Mackenzie House", "82 Bond St."));
        places.add(new Place("Toronto Railway Museum", "255 Bremner Blvd"));
        places.add(new Place("Hockey Hall of Fame", "30 Yonge St."));
        places.add(new Place("Royal Ontario Museum", "100 Queen's Pk"));
        places.add(new Place("Bata Shoe Museum", "327 Bloor St. W."));
        places.add(new Place("Spadina Museum", "285 Spadina Rd"));
        places.add(new Place("Gardiner Museum", "111 Queen's Pk"));
        places.add(new Place("Fort York National Historic Site", "250 Fort York Blvd"));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. This adapter
        // creates the list items for each item in the list.
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places, R.color.category_museums);

        // Find the {@link ListView} with the view ID list in the place_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaceAdapter} to display the list items for
        // each {@link Place} in the list.
        listView.setAdapter(placeAdapter);

        return rootView;
    }

}
