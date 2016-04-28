package events;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.octane.skyris.R;
import com.example.octane.skyris.SkyrisApplication;

import java.util.ArrayList;

import object.Event;


public class AddEventFragment extends Fragment implements View.OnClickListener {


    private View thisView;
    private RelativeLayout addEventButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        thisView = (View) inflater.inflate(R.layout.add_event_layout, container, false);

        return thisView;
    }



    @Override
    public void onClick(View v) {

        if (v == addEventButton) {




        }

    }
}
