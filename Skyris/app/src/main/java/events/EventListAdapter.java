package events;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.octane.skyris.R;

import java.util.ArrayList;
import java.util.List;

import object.Event;


public class EventListAdapter extends ArrayAdapter<Event> {

    private Context context;
    private List<Event> eventObjects;

    public EventListAdapter(Context context,  List<Event> objects) {
        super(context, 0, objects);
        eventObjects = new ArrayList<Event>();
        eventObjects = objects;
        this.context = context;

    }


    static class ViewHolder {
        TextView nameText;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        ViewHolder holder; // to reference the child views for later actions

        if (v == null) {
            LayoutInflater vi =
                    (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.main_screen_tile, null);
            holder = new ViewHolder();
            holder.nameText = (TextView) v.findViewById(R.id.textView2);
            v.setTag(holder);
        }
        else {

            holder = (ViewHolder) v.getTag();

        }

        holder.nameText.setText(eventObjects.get(position).getName());

        return v;
    }

}



