package rienierpatron.reminders;

import static rienierpatron.reminders.Constants.EVENT_ID;
import static rienierpatron.reminders.Constants.EVENT_NAME;
import static rienierpatron.reminders.Constants.EVENT_DATE;
import static rienierpatron.reminders.Constants.EVENT_TIME;
import static rienierpatron.reminders.Constants.EVENT_NOTE;
import static rienierpatron.reminders.Constants.EVENT_STATUS;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tag2 on 16/02/2016.
 */
public class ListViewAdapter extends BaseAdapter {
    public ArrayList<HashMap<String, String>> list;
    Activity activity;
    TextView eventName, eventDate, eventTime, eventNote, eventStatus;

    public ListViewAdapter(Activity activity, ArrayList<HashMap<String, String>> list) {
        super();
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();

        if(view == null){

            view=inflater.inflate(R.layout.reminders, null);

            eventName=(TextView) view.findViewById(R.id.eventName);
            eventDate=(TextView) view.findViewById(R.id.eventDate);
           //eventTime=(TextView) view.findViewById(R.id.eventTime);
           //eventNote=(TextView) view.findViewById(R.id.eventNote);

        }

        HashMap<String, String> map=list.get(position);
        eventName.setText(map.get(EVENT_NAME));
        eventDate.setText(map.get(EVENT_DATE));

        return view;
    }

}
