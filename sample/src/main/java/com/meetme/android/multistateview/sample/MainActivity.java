package com.meetme.android.multistateview.sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.meetme.android.multistateview.MultiStateView;

public class MainActivity extends AppCompatActivity {

    private MultiStateView mMultiStateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mMultiStateView = (MultiStateView) findViewById(R.id.multistateview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_network_error:
                mMultiStateView.setState(MultiStateView.ContentState.ERROR_NETWORK);
                return true;
            case R.id.action_general_error:
                mMultiStateView.setState(MultiStateView.ContentState.ERROR_GENERAL);
                return true;
            case R.id.action_loading:
                mMultiStateView.setState(MultiStateView.ContentState.LOADING);
                return true;
            case R.id.action_content:
                mMultiStateView.setState(MultiStateView.ContentState.CONTENT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
