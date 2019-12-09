package com.example.justfriends;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;

import java.util.ArrayList;

public class FeedRecyclerViewAdapter extends RecyclerView.Adapter<FeedRecyclerViewAdapter .ViewHolder> {

    private ArrayList<Event> events;
    private Context mContext;

    FeedRecyclerViewAdapter(ArrayList<Event> events, Context mContext) {
        this.events = events;
        this.mContext = mContext;
        //      this.mOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_layoutlist, parent, false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.View_Feed_Name.setText(events.get(position).eventName);
        holder.View_Feed_Location.setText(events.get(position).eventLocation);
        holder.View_Feed_Time.setText(events.get(position).eventTime);
        holder.View_Feed_Date.setText(events.get(position).eventDate);
        holder.LinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, EventDetailsActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView View_Feed_Name, View_Feed_Date, View_Feed_Time, View_Feed_Location,
                View_Feed_Att, View_Event_Filter;
        Button Event_Button_Favourite, Event_Details;
        RelativeLayout Feed_Relative;
        public LinearLayout LinearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            View_Feed_Name = itemView.findViewById(R.id.View_Feed_Name);
            View_Feed_Date = itemView.findViewById(R.id.View_Feed_Date);
            View_Feed_Time = itemView.findViewById(R.id.View_Feed_Time);
            View_Feed_Location = itemView.findViewById(R.id.View_Feed_Location);
            Event_Button_Favourite = itemView.findViewById(R.id.Event_Button_Favourite);
            Feed_Relative = itemView.findViewById(R.id.Feed_Relative);
            LinearLayout = itemView.findViewById(R.id.LinearLayout);

        }

    }
}