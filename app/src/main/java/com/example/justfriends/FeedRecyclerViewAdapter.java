package com.example.justfriends;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.View_Feed_Name.setText(events.get(position).eventName);
        holder.View_Feed_Location.setText(events.get(position).eventLocation);
        holder.View_Feed_Time.setText(events.get(position).eventTime);
        holder.View_Feed_Date.setText(events.get(position).eventDate);
        holder.edit_Interest_Tag.setText(events.get(position).eventInterest);
        holder.View_Feed_Creator.setText(events.get(position).eventCreator);

        if (holder.switchEDGoing != null) {
            holder.switchEDGoing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b) {
                        //do stuff when Switch is ON
                        //Pulling all the info + Reading from the database
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        final DatabaseReference myRef = database.getReference("Events");

                        final String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();

                        String name = events.get(position).eventName;

                        myRef.orderByChild("eventName").equalTo(name).addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                                String findKey = dataSnapshot.getKey();
                                Event foundEvent = dataSnapshot.getValue(Event.class);
                                ArrayList<String> going = foundEvent.going;
                                going.add(userEmail);

                                myRef.child(findKey).child("going").setValue(going);

                            }

                            @Override
                            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                            }

                            @Override
                            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                            }

                            @Override
                            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    } else {
                        //do stuff when Switch if OFF
                        // do nothing
                    }
                }
            });
        }


        holder.Button_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                String eventName = events.get(position).eventName;
                String eventTime = events.get(position).eventTime;
                String eventLocation = events.get(position).eventLocation;
                String eventTag = events.get(position).eventInterest;
                String eventDate = events.get(position).eventDate;
                String eventDetails = events.get(position).eventDescription;
                String evenCreator = events.get(position).eventCreator;


                Intent intent = new Intent(context, EventDetailsActivity.class);
                intent.putExtra("event name",eventName);
                intent.putExtra("event time",eventTime);
                intent.putExtra("event date",eventDate);
                intent.putExtra("event location",eventLocation);
                intent.putExtra("event tag",eventTag);
                intent.putExtra("event details", eventDetails);
                intent.putExtra("event creator", evenCreator);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView View_Feed_Name, View_Feed_Date, View_Feed_Time, View_Feed_Location, View_Feed_Att, View_Event_Filter, edit_Interest_Tag, View_Feed_Creator;
        Button Event_Details;
        RelativeLayout Feed_Relative;
        public LinearLayout LinearLayout;
        Switch switchEDGoing;
        Button Button_details;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            View_Feed_Name = itemView.findViewById(R.id.View_Feed_Name);
            View_Feed_Date = itemView.findViewById(R.id.View_Feed_Date);
            View_Feed_Time = itemView.findViewById(R.id.View_Feed_Time);
            View_Feed_Location = itemView.findViewById(R.id.View_Feed_Location);
            Feed_Relative = itemView.findViewById(R.id.Feed_Relative);
            LinearLayout = itemView.findViewById(R.id.LinearLayout);
            edit_Interest_Tag = itemView.findViewById(R.id.edit_Interest_Tag);
            View_Feed_Creator = itemView.findViewById(R.id.View_Feed_Creator);
            switchEDGoing = itemView.findViewById(R.id.switchEDGoing);
            Button_details = itemView.findViewById(R.id.Button_details);

        }

    }
}
