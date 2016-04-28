package events;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.octane.skyris.R;
import com.example.octane.skyris.SkyrisApplication;
import com.example.octane.skyris.SkyrisFragmentActivity;

import java.util.ArrayList;
import java.util.List;

import object.Event;


public class ActiveEventsFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    private View thisView;

    private LinearLayout archiveButton, eventButton, profileButton;

    private boolean isEventSelected;
    private SkyrisFragmentActivity activity;
    private List<Event> listOfActiveEvents;
    private EventListAdapter listAdapter;
    private RelativeLayout event_holder, addEventButton;
    private ListView eventListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        thisView = (View) inflater.inflate(R.layout.active_events_fragment, container, false);
        listOfActiveEvents = new ArrayList<Event>();
        event_holder = (RelativeLayout)thisView.findViewById(R.id.event_holder);
        addEventButton = (RelativeLayout)thisView.findViewById(R.id.add_event_button);
        addEventButton.setOnClickListener(this);
        activity = (SkyrisFragmentActivity)this.getActivity();

        listOfActiveEvents = SkyrisApplication.getContext().getEvents();

        populateActiveEvents();


        return thisView;
    }



    @Override
    public void onClick(View v) {

        if (v == addEventButton) {

            TransitionManager.beginDelayedTransition((ViewGroup)thisView, new Fade());
            toggleVisibility(thisView);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);

                        FragmentManager fragmentManager = activity.getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.content_holder, new AddEventFragment());
                        fragmentTransaction.commit();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }).start();


        }


    }


    public void populateActiveEvents() {

        listAdapter = new EventListAdapter(this.getContext(), listOfActiveEvents);

        eventListView = (ListView)thisView.findViewById(R.id.listView);
        eventListView.setAdapter(listAdapter);
        eventListView.setOnItemClickListener(this);

    }

    private static void toggleVisibility(View... views) {
        for (View view : views) {
            boolean isVisible = view.getVisibility() == View.VISIBLE;
            view.setVisibility(isVisible ? View.INVISIBLE : View.VISIBLE);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        TransitionManager.beginDelayedTransition((ViewGroup)thisView, new Fade());
        toggleVisibility(thisView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content_holder, new LiveEventFragment());
                    fragmentTransaction.commit();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();



    }
}
