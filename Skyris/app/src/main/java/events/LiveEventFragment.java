package events;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.octane.skyris.R;

import camera.CameraActivity;

public class LiveEventFragment extends Fragment implements View.OnClickListener {

    private View thisView;
    private RelativeLayout take_photo_button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        thisView = (View) inflater.inflate(R.layout.live_events_fragment, container, false);
        take_photo_button = (RelativeLayout)thisView.findViewById(R.id.add_photo_button);
        take_photo_button.setOnClickListener(this);

        return thisView;
    }



    @Override
    public void onClick(View v) {

        if (v == take_photo_button) {
            Intent intent = new Intent(LiveEventFragment.this.getActivity(), CameraActivity.class);
            startActivity(intent);

        }

    }
}
