package com.example.kuybeer26092016.retrofittest01;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.kuybeer26092016.retrofittest01.Control.Manager_Retrofit;
import com.example.kuybeer26092016.retrofittest01.Httpcallback.Adapters;
import com.example.kuybeer26092016.retrofittest01.Httpcallback.Mis_mclist;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private Manager_Retrofit mManager;
    private Adapters mAdapter;
    private String instanct_station_name;
    //--------------------//
    MyThread myThread;
    MyHandler myHandler;
    private boolean running;
    int cnt;
    //----------------------//

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onStart() {
        super.onStart();
        mManager = new Manager_Retrofit();
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        mAdapter  = new Adapters();
        mRecyclerView.setAdapter(mAdapter);
        ShowListMc();

        myHandler = new MyHandler(this);
        running = true;
        cnt = 0;
        if(myThread != null){
            setRunning(false);
        }
        myThread = new MyThread(myHandler);
        myThread.start();
    }

    private void ShowListMc(){
        Call<List<Mis_mclist>> call = mManager.getmService().CallbackTest();
        call.enqueue(new Callback<List<Mis_mclist>>() {
            @Override
            public void onResponse(Call<List<Mis_mclist>> call, Response<List<Mis_mclist>> response) {
                if(response.isSuccessful()){
                    List<Mis_mclist> tower2List = response.body();
                    mAdapter.addTower2(tower2List);
                }
                else{
                    int sc = response.code();
                    switch (sc){

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Mis_mclist>> call, Throwable t) {

            }
        });
    }
    public class MyThread extends  Thread {
        private int cnt;
        private boolean running;
        MyHandler mainHandler;

        public MyThread(MyHandler myHandler) {
            super();
        }

        @Override
        public void run() {
            cnt = 0;
            running = true;
            while (running){
                try {
                    Thread.sleep(1000);
                    cnt++;
                    ShowListMc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class MyHandler extends Handler {
        public static final int UPDATE_CNT = 0;
        private MainActivity parent;

        public MyHandler(MainActivity parent) {
            super();
            this.parent = parent;
        }

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case UPDATE_CNT:
                    int c = (int)msg.obj;
                    Log.d("TEST",String.valueOf(c) );

                    break;
                default:
                    super.handleMessage(msg);
            }

        }
    }
    public void setRunning(boolean running){
        this.running = running;
    }
}
