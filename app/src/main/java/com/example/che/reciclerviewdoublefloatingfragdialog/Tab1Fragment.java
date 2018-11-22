package com.example.che.reciclerviewdoublefloatingfragdialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Tab1Fragment extends Fragment implements MyCustomDialog.OnInputSelected {

    private static final String TAG = "MainFragment";

    @Override
    public void sendInput(int position) {
        Log.d(TAG, "sendInput: found incoming input: " + position);

        mExampleList.add(position, new ExampleIetm(R.drawable.globus, "New Item at position" + position, "This is Line 2", true));
        mAdapter.notifyItemInserted(position);

        //mInputDisplay.setInteger(input);
    }


    private ArrayList<ExampleIetm> mExampleList;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
    private FloatingActionButton fab;
    private EditText editTextInsert;
    private EditText editTextRemove;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);

        createExampleList();
        buildRecyclerView();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        buttonInsert = view.findViewById(R.id.button_insert);
        buttonRemove = view.findViewById(R.id.button_remove);
        fab = view.findViewById(R.id.floating_action_button);
        editTextInsert = view.findViewById(R.id.edittext_insert);
        editTextRemove = view.findViewById(R.id.edittext_remove);


        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 2",Toast.LENGTH_SHORT).show();
                int position = Integer.parseInt(editTextInsert.getText().toString());
                sendInput(position);
            }
        });
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Floating Button",Toast.LENGTH_SHORT).show();
                MyCustomDialog dialog = new MyCustomDialog();
                dialog.setTargetFragment(Tab1Fragment.this, 1);
                dialog.show(getFragmentManager(), "MyCustomDialog");
            }
        });


        return view;
    }
    public void insertItem(int position) {
        mExampleList.add(position, new ExampleIetm(R.drawable.globus, "New Item at position" + position, "This is Line 2", true));
        mAdapter.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public  void createExampleList() {

        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleIetm(R.drawable.globus, "Line 1", "Line 2", true));
        mExampleList.add(new ExampleIetm(R.drawable.globus, "Line 3", "Line 4",true));
        mExampleList.add(new ExampleIetm(R.drawable.globus, "Line 5", "Line 6",true));}

    public void buildRecyclerView() {


    }

}