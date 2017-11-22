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
        places.add(new Place(getString(R.string.the_path_name), getString(R.string.the_path_address)));
        places.add(new Place(getString(R.string.sherway_gardens_name), getString(R.string.sherway_gardens_address)));
        places.add(new Place(getString(R.string.town_centre_name), getString(R.string.town_centre_address)));
        places.add(new Place(getString(R.string.brick_works_name), getString(R.string.brick_works_address)));
        places.add(new Place(getString(R.string.yorkdale_centre_name), getString(R.string.yorkdale_centre_address)));
        places.add(new Place(getString(R.string.eaton_centre_name), getString(R.string.eaton_centre_address)));
        places.add(new Place(getString(R.string.lawrence_market_name), getString(R.string.lawrence_market_address)));
        places.add(new Place(getString(R.string.brookfield_place_name), getString(R.string.brookfield_place_address)));
        places.add(new Place(getString(R.string.market_gallery_name), getString(R.string.market_gallery_address)));
        places.add(new Place(getString(R.string.fairview_name), getString(R.string.fairview_address)));

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
