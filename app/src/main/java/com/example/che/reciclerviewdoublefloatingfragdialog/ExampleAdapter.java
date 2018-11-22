package com.example.che.reciclerviewdoublefloatingfragdialog;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleviewHolder> {
    private ArrayList<ExampleIetm> mExampleList;
    private static final String TAG = "myLogs";


    public ExampleAdapter(ArrayList<ExampleIetm> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public ExampleviewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleviewHolder evh = new ExampleviewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleviewHolder holder, int position) {
        ExampleIetm currentItem = mExampleList.get(position);

        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView1.setText(currentItem.getmText1());
        holder.mTextView2.setText(currentItem.getmText2());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }






    public class ExampleviewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public CheckBox mCheckBox;


        public ExampleviewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textSmall);

            mCheckBox = (CheckBox) itemView.findViewById(R.id.checkbox);

            mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        Log.d(TAG, "checked");
                        mImageView.setImageResource(R.drawable.ocean);
                    } else {
                        Log.d(TAG, "unChecked");
                        mImageView.setImageResource(R.drawable.globus);
                    }
                }
            });
        }
    }
}

