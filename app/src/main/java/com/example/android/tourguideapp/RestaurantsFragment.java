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
        places.add(new Place("Scaramouche Restaurant", "1 Benvenuto Pl."));
        places.add(new Place("Alo Restaurant", "163 Spadina Ave."));
        places.add(new Place("Byblos", "11 Duncan St."));
        places.add(new Place("Canoe Restaurant & Bar", "66 Wellington St. W."));
        places.add(new Place("Richmond Station", "1 Richmond St. W."));
        places.add(new Place("The Keg Steakhouse + Bar", "165 York St."));
        places.add(new Place("LaVinia Restaurant", "2350 Lake Shore Blvd W."));
        places.add(new Place("Pai Northern Thai Kitchen", "18 Duncan St."));
        places.add(new Place("Rodney's Oyster House", "469 King St. W."));
        places.add(new Place("Estiatorio VOLOS", "133 Richmond St. W."));

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
