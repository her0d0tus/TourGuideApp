package com.example.android.tourguideapp;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.scaramouche_name), getString(R.string.scaramouche_address)));
        places.add(new Place(getString(R.string.alo_name), getString(R.string.alo_address)));
        places.add(new Place(getString(R.string.byblos_name), getString(R.string.byblos_address)));
        places.add(new Place(getString(R.string.canoe_name), getString(R.string.canoe_address)));
        places.add(new Place(getString(R.string.richmond_name), getString(R.string.richmond_address)));
        places.add(new Place(getString(R.string.keg_name), getString(R.string.keg_address)));
        places.add(new Place(getString(R.string.lavinia_name), getString(R.string.lavinia_address)));
        places.add(new Place(getString(R.string.pai_name), getString(R.string.pai_address)));
        places.add(new Place(getString(R.string.rodneys_name), getString(R.string.rodneys_address)));
        places.add(new Place(getString(R.string.estiatorio_name), getString(R.string.estiatorio_address)));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. This adapter
        // creates the list items for each item in the list.
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places, R.color.category_restaurants);

        // Find the {@link ListView} with the view ID list in the place_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaceAdapter} to display the list items for
        // each {@link Place} in the list.
        listView.setAdapter(placeAdapter);

        return rootView;
    }

}
