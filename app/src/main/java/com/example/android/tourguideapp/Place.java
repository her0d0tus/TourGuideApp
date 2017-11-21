package com.example.android.tourguideapp;

public class Place {

    /** Name of the place */
    private String mName;

    /** Place's address */
    private String mAddress;

    /** Image resource ID for the place */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value to represent that no image was provided */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Place object.
     *
     * @param name is the name of the place
     * @param address is the address
     */
    public Place(String name, String address) {
        mName = name;
        mAddress = address;
    }

    /**
     * Create a new Place object.
     *
     * @param name is the name of the place.
     * @param address is the address.
     * @param imageResourceId is the drawable resource ID for the image of the place.
     */
    public Place(String name, String address, int imageResourceId) {
        mName = name;
        mAddress = address;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the place.
     * @return String
     */
    public String getName() {
        return mName;
    }

    /**
     * Get the place's address.
     * @return String
     */
    public String getAddress() {
        return mAddress;
    }

    /**
     * Get the image resource ID of the word.
     * @return int
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Check weather or not an image is associated with a Place object. Return boolean
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
