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
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.octane.skyris.R;
import com.example.octane.skyris.SkyrisApplication;
import com.example.octane.skyris.SkyrisFragmentActivity;


public class EventsMainPageFragment extends Fragment implements View.OnClickListener {

    private View thisView;

    private LinearLayout archiveButton, eventButton, profileButton;

    private boolean isEventSelected;
    private SkyrisFragmentActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        thisView = (View) inflater.inflate(R.layout.events_main_page_layout, container, false);

        archiveButton = (LinearLayout)thisView.findViewById(R.id.archive_button);
        archiveButton.setOnClickListener(this);
        eventButton = (LinearLayout)thisView.findViewById(R.id.event_button);
        eventButton.setOnClickListener(this);
        profileButton = (LinearLayout)thisView.findViewById(R.id.profile_button);
        profileButton.setOnClickListener(this);

        TextView archiveText = (TextView)archiveButton.findViewById(R.id.textView2);
        archiveText.setText("ARCHIVE");
        TextView eventText = (TextView)eventButton.findViewById(R.id.textView2);
        eventText.setText("EVENT");
        TextView profileText = (TextView)profileButton.findViewById(R.id.textView2);
        profileText.setText("PROFILE");

        activity = (SkyrisFragmentActivity)this.getActivity();

        return thisView;
    }



    @Override
    public void onClick(View v) {


        if (v == eventButton) {

            TransitionManager.beginDelayedTransition((ViewGroup)thisView.findViewById(R.id.main_holder), new Fade());
            toggleVisibility(eventButton, archiveButton, profileButton);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);

                        FragmentManager fragmentManager = activity.getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.content_holder, new ActiveEventsFragment());
                        fragmentTransaction.commit();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }).start();
        }

    }

    private static void toggleVisibility(View... views) {
        for (View view : views) {
            boolean isVisible = view.getVisibility() == View.VISIBLE;
            view.setVisibility(isVisible ? View.INVISIBLE : View.VISIBLE);
        }
    }


}
