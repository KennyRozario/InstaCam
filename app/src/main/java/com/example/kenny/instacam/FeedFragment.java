package com.example.kenny.instacam;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {

    private static final String TAG = "FeedFragment";

    private List<Photo> mPhotos;
    private FeedAdapter mAdapter;

    public FeedFragment() {
        mPhotos = new ArrayList<Photo>();
        mAdapter = new FeedAdapter(getActivity(), mPhotos);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView called");

        View v = inflater.inflate(R.layout.fragment_feed, container, false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.feed_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);

        return v;
    }

    public void addPhoto(Photo photo){
        mPhotos.add(0, photo);
        mAdapter.notifyDataSetChanged();
    }


}
