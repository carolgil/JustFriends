package com.example.justfriends;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Event> Events = new ArrayList<Event>(); //Creating a new arraylist of contacts for the adapter to display
    private Context mContext; //context variable, for use later on
    private StorageReference mStorageRef; //storage to link to firebase, need to import mstorage


    public RecyclerViewAdapter(List<Event> Events, Context mContext){ //RecyclerViewAdapter constructor, what creates the recyclerViewAdapter
        this.Events = Events; //Setting the Contacts arraylist created above to the Contacts list passed in
        this.mContext = mContext; //pass in the context of the activity, which is passed into the constructor
        mStorageRef = FirebaseStorage.getInstance().getReference(); //get the storage reference from firebase
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //determines how each view is created
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_pelistitem, parent, false);
        //Inflate the view, taking from the user_item layout, which is just the specific xml for a single Contact
        //Check out the user_item layout to see what I'm talking about
        ViewHolder viewHolder = new ViewHolder(view); //Create a new viewholder, need this
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewPEeventName.setText(Events.get(position).eventName);
        holder.textViewPEeventDate.setText(Events.get(position).eventDate);
        holder.textViewPEtime.setText(Events.get(position).eventTime);
    }

    @Override
    public int getItemCount() {
        return Events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder { //class to hold each individual view to display to your recyclerview
        //basically holds the user_item

        TextView textViewPEeventName; //imageView from user_item
        TextView textViewPEeventDate; //textView from user_item
        TextView textViewPEtime;
        RelativeLayout parent_layout; //references who the parent is and the specific layout of the parent,
        //so you know where the imageView and textView are contained

        public ViewHolder(@NonNull View itemView){ //ViewHolder constructor
            super(itemView);
            textViewPEeventName = itemView.findViewById(R.id.textViewPEeventName);
            textViewPEeventDate = itemView.findViewById(R.id.textViewPEeventDate);
            textViewPEtime = itemView.findViewById(R.id.textViewPEtime);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }

}
