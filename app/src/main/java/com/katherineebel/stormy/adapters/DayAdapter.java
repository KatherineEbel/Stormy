package com.katherineebel.stormy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.katherineebel.stormy.R;
import com.katherineebel.stormy.model.Day;


public class DayAdapter extends BaseAdapter {
    private Context mContext;
    private Day[] mDays;

    public DayAdapter(Context context, Day[] days) {
        mContext = context;
        mDays = days;
    }

    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int i) {
        return mDays[i];
    }

    @Override
    public long getItemId(int i) {
        return 0; // we aren't going to use this. Tag items for easy reference
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            // brand new
            view = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.circleImageView = (ImageView) view.findViewById(R.id.circleImageView);
            holder.mIconImageView = (ImageView) view.findViewById(R.id.iconImageView);
            holder.mTemperatureLabel = (TextView) view.findViewById(R.id.temperatureLabel);
            holder.mDayLabel = (TextView) view.findViewById(R.id.dayNameLabel);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Day day = mDays[i];
        holder.circleImageView.setImageResource(R.drawable.bg_temperature);
        holder.mIconImageView.setImageResource(day.getIconId());
        holder.mTemperatureLabel.setText(day.getTemperatureMax() + "");
        if (i == 0) {
            holder.mDayLabel.setText(R.string.today_label);
        } else {
            holder.mDayLabel.setText(day.getDayOfTheWeek());
        }
        return view;
    }

    private static class ViewHolder {
        ImageView mIconImageView;
        ImageView circleImageView;
        TextView mTemperatureLabel;
        TextView mDayLabel;
    }
}
