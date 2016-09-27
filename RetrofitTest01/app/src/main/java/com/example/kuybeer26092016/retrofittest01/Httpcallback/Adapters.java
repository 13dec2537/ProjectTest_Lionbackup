package com.example.kuybeer26092016.retrofittest01.Httpcallback;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kuybeer26092016.retrofittest01.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peerapong on 20/9/2559.
 */
public class Adapters extends RecyclerView.Adapter<Adapters.Holder> {
    private static final String TAG = Adapters.class.getSimpleName();
    private List<Mis_mclist> mListMc= new ArrayList<>();
    public Adapters(){
        mListMc = new ArrayList<>();
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tower2,null,false);
            return new Holder(row);
    }

    @Override
    public void onBindViewHolder(final Holder holders, int position) {
        Mis_mclist setList = mListMc.get(position);
        holders.mc_name.setText(setList.getMc_name());
        holders.Act.setText(setList.getMo_act().act_1);
    }
    public void addTower2(List<Mis_mclist> misMclist) {
        mListMc.clear();
        mListMc.addAll(misMclist);
        this.notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return mListMc.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        protected ImageView mPhoto;
        private RelativeLayout mRelativeLayout;
        private TextView mc_name,Act;
        public Holder(View itemView){
            super(itemView);
            mRelativeLayout = (RelativeLayout)itemView.findViewById(R.id.RelativeLayout_Tower2);
            mc_name = (TextView)itemView.findViewById(R.id.name_mc);
            Act = (TextView)itemView.findViewById(R.id.Act);
        }
    }
}