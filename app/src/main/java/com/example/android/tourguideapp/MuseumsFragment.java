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
        places.add(new Place(getString(R.string.power_plant_name), getString(R.string.power_plant_address)));
        places.add(new Place(getString(R.string.textile_museum_name), getString(R.string.textile_museum_address)));
        places.add(new Place(getString(R.string.mackenzie_house_name), getString(R.string.mackenzie_house_address)));
        places.add(new Place(getString(R.string.railway_museum_name), getString(R.string.railway_museum_address)));
        places.add(new Place(getString(R.string.hockey_hall_name), getString(R.string.hockey_hall_address)));
        places.add(new Place(getString(R.string.royal_ontario_name), getString(R.string.royal_ontario_address)));
        places.add(new Place(getString(R.string.bata_museum_name), getString(R.string.bata_museum_address)));
        places.add(new Place(getString(R.string.spadina_museum_name), getString(R.string.spadina_museum_address)));
        places.add(new Place(getString(R.string.gardiner_museum_name), getString(R.string.gardiner_museum_address)));
        places.add(new Place(getString(R.string.fort_york_name), getString(R.string.fort_york_address)));

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
