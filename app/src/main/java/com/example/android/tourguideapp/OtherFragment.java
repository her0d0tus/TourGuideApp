package com.example.android.tourguideapp;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class OtherFragment extends Fragment {

    public OtherFragment() {
        // Empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of locations
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Allan Garden", "19 Horticultural Ave.", R.drawable.allans_garden));
        // Source: https://commons.wikimedia.org/wiki/Toronto#/media/File:Allan_Gardens_looking_west.jpg

        places.add(new Place("Canada's Wonderland", "1 Canada's Wonderland Dr.", R.drawable.canadas_wonderland));
        // Source: https://commons.wikimedia.org/wiki/Category:Canada%27s_Wonderland#/media/File:Canada%27s_Wonderland_Main_Square.jpg

        places.add(new Place("Casa Loma", "1 Austin Terrace", R.drawable.casa_loma));
        // Source: https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Casa_Loma%2C_Toronto_%286264979572%29.jpg/1024px-Casa_Loma%2C_Toronto_%286264979572%29.jpg

        places.add(new Place("Art Gallery of Ontario", "317 Dundas St. W.", R.drawable.art_gallery_of_ontario));
        // Source: http://vmetal.com/wp-content/uploads/2017/01/art-gallery-of-ontario-dusk.jpg

        places.add(new Place("CN Tower", "301 Front St. W.", R.drawable.cn_tower));
        // Source: https://commons.wikimedia.org/wiki/File:Toronto_at_Dusk_-a.jpg

        places.add(new Place("Harbourfront", "235 Queens Quay W.", R.drawable.harbourfront));
        // Source: http://www.getwhatyouwant.ca/wp-content/uploads/2015/01/Harbourfront-Toronto-Amsterdam-Bridge.jpg

        places.add(new Place("Ontario Science Centre", "770 Don Mills Rd", R.drawable.ontario_science_centre));
        // Source: https://commons.wikimedia.org/wiki/Toronto#/media/File:Ontario_Science_Centre_(249019835).jpg

        places.add(new Place("Ripley's Aquarium", "288 Bremner Blvd", R.drawable.ripleys_aquarium));
        // Source: http://www.bestoftoronto.net/wp-content/uploads/2013/10/Ripleys-Aquarium-BestofToronto-2013-022.jpg

        places.add(new Place("Royal Ontario Museum", "100 Queens Park", R.drawable.royal_ontario_museum));
        // Source: https://commons.wikimedia.org/wiki/Toronto#/media/File:ROMCrystal4.jpg

        places.add(new Place("Toronto Zoo", "2000 Meadowvale Rd", R.drawable.toronto_zoo));
        // Source: https://www.flickr.com/photos/bensonkua/14430920822/

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. This adapter
        // creates the list items for each item in the list.
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places, R.color.category_other);

        // Find the {@link ListView} with the view ID list in the place_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaceAdapter} to display the list items for
        // each {@link Place} in the list.
        listView.setAdapter(placeAdapter);

        return rootView;
    }
}