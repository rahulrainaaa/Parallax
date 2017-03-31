package app.demo.parallax.adapterviewflipper;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class CustomAdapter extends ArrayAdapter<Integer> {

    private Integer[] list = null;
    private Activity activity = null;
    private LayoutInflater inflater = null;
    private int resourceId;

    private static class Holder {
        ImageView img = null;
        Integer i = null;

    }

    public CustomAdapter(@NonNull Activity activity, @LayoutRes int resource, Integer[] list) {
        super(activity, resource, list);
        this.list = list;
        resourceId = resource;
        this.activity = activity;
        this.inflater = activity.getLayoutInflater();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Holder holder = null;
        View v = convertView;
        ImageView view = null;
        if (v == null) {
            v = inflater.inflate(resourceId, null);
            view = (ImageView) v;
            holder = new Holder();
            holder.i = list[position];
            holder.img = view;
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
            view = holder.img;
            if (holder.i != list[position]) {
                view.setImageResource(list[position]);
                holder.i = list[position];
                view.setTag(holder);
            }
        }

        view.setImageResource(list[position]);
        Log.d("---------", "" + position);
        return view;
    }
}
