package cmput301w18t22.com.tenner.ui.fragment;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;

import cmput301w18t22.com.tenner.R;
import cmput301w18t22.com.tenner.classes.Location;
import cmput301w18t22.com.tenner.classes.Task;
import cmput301w18t22.com.tenner.classes.User;
import cmput301w18t22.com.tenner.ui.adapter.TaskAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskListFragment extends Fragment {

    //public static final String TAG = TaskListFragment.class.getSimpleName();

    public static final String EXTRA_TEXT = "extra_text";

    private static final int MOCK_LOAD_DATA_DELAYED_TIME = 500;

    private static Handler sHandler = new Handler(Looper.getMainLooper());

    private TaskListFragment.WeakRunnable mRunnable = new TaskListFragment.WeakRunnable(this);

    private String mText;

    private ProgressBar progressBar;

    private ArrayList<Task> taskList;
    private TaskAdapter myAdapter;
    private SwipeMenuListView displayList;
    private int tab;

    public TaskListFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(int position) {
        Fragment fragment = new TaskListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Tab", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tab = getArguments().getInt("tab");
        taskList = new ArrayList<Task>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        // Setup list display
        displayList = (SwipeMenuListView) view.findViewById(R.id.tasksList);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState == null) {
            loadData();
        } else {
            bindData();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(EXTRA_TEXT, mText);
    }

    @Override
    public void onDestroyView() {
        sHandler.removeCallbacks(mRunnable);
        progressBar = null;
        super.onDestroyView();
    }

    private void showProgressBar(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    private void bindData() { // Attach to listview
        Log.i("debug", "Binding");

        myAdapter = new TaskAdapter(getContext(), taskList);
        displayList.setAdapter(myAdapter);

        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        float dp = 80f;
        float fpixels = metrics.density * dp;
        final int pixels = (int) (fpixels + 0.5f);

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(pixels);
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete_black_24dp);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        displayList.setMenuCreator(creator);

        displayList.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // open
                        break;
                    case 1:
                        // delete
                        break;
                }
                return false;
            }
        });

    }

    /**
     * mock load data
     */
    private void loadData() { // Server Call
        Log.i("debug", "Loading");
        showProgressBar(true);

        Task test = new Task("My Task", "Best Task Ever", new Location(1f, 1f, "New York"),
                new Date(), new User("me@google.com", "John", "Doe", "555-5556"));

        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);
        taskList.add(test);

        sHandler.postDelayed(mRunnable, 500);
        Log.i("debug", "Loaded");
    }

    private static class WeakRunnable implements Runnable {

        WeakReference<TaskListFragment> mTaskListFragmentReference;

        public WeakRunnable(TaskListFragment taskListFragment) {
            this.mTaskListFragmentReference = new WeakReference<TaskListFragment>(taskListFragment);
        }

        @Override
        public void run() {
            TaskListFragment taskListFragment = mTaskListFragmentReference.get();
            if (taskListFragment != null && !taskListFragment.isDetached()) {
                taskListFragment.showProgressBar(false);
                taskListFragment.bindData();
            }
        }
    }

}
