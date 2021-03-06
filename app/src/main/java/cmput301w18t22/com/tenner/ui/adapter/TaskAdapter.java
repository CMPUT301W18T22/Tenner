package cmput301w18t22.com.tenner.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cmput301w18t22.com.tenner.helpers.PhotoConverterHelper;
import cmput301w18t22.com.tenner.R;
import cmput301w18t22.com.tenner.classes.Task;

/**
 * Custom Adapter provides the adapter to add a specified taskList to a ListView object
 * <p>
 * Needs to define all 4 overidden methods to function properly, as well as have layout defined in XML
 * <p>
 * <p>
 * Based on https://guides.codepath.com/android/Using-a-BaseAdapter-with-ListView
 * Retrieved 2018-02-05
 */
public class TaskAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Task> taskList;

    //public constructor
    public TaskAdapter(Context context, ArrayList<Task> taskList) {
        this.context = context;
        this.taskList = taskList;
    }

    @Override
    public int getCount() {
        return taskList.size(); //returns number of tasks in taskList
    }

    @Override
    public Task getItem(int position) {
        return taskList.get(position); //returns subscription at specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    } // This needs a better approach -- what's our plan for primary keys from ElasticSearch??

    /**
     * Get the view for the listView object.
     *
     * @param position    integer representing position in ListView
     * @param convertView current View
     * @param parent      parent ViewGroup
     * @return View
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.taskadapter_item, parent, false);
        }

        // get current item to be displayed
        Task currentTask = getItem(position);

        // get TextView objects
        ImageView imgView = (ImageView) convertView.findViewById(R.id.imageView);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.task_title);
        TextView requesterNameTextView = (TextView) convertView.findViewById(R.id.requester_name);
        TextView lowestBidTextView = (TextView) convertView.findViewById(R.id.bid_amt);
        View coloredBar = (View) convertView.findViewById(R.id.colored_bar);
        TextView dolla = (TextView) convertView.findViewById(R.id.dolla);


        // get Subscription information and display in textViews
        nameTextView.setText(currentTask.getTitle());
        requesterNameTextView.setText(currentTask.getRequester().toDisplayName());
        if (currentTask.getBidList().size() == 0) {
            lowestBidTextView.setText("");
            dolla.setVisibility(View.GONE);

        } else {
            lowestBidTextView.setText(currentTask.getLowestBid().toString());
        }

        // Set correct colored bar color based on task status
        String taskStatus = currentTask.getStatus();
        switch (taskStatus) {
            case "requested":
                convertView.setBackgroundResource(R.drawable.task_adapter_requested);
                break;
            case "bidded":
                convertView.setBackgroundResource(R.drawable.task_adapter_bidded);
                break;
            case "assigned":
                convertView.setBackgroundResource(R.drawable.task_adapter_assigned);
                break;
            case "done":
                convertView.setBackgroundResource(R.drawable.task_adapter_done);
                break;
        }

        //Add photo
        PhotoConverterHelper photoConverterHelper = new PhotoConverterHelper();
        Bitmap bitmap = null;
        if (currentTask.getPhotos().size() == 0) {
            imgView.setImageResource(R.drawable.task);
        } else {
            bitmap = photoConverterHelper.convertStringToBM(currentTask.getPhotos().get(0));
            imgView.setImageBitmap(bitmap);
        }

        // returns the view for the current row
        return convertView;
    }
}



