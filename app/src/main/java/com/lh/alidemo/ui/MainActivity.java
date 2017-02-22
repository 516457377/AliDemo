package com.lh.alidemo.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lh.alidemo.R;
import com.lh.alidemo.adapter.RecyAdapter;

public class MainActivity extends AppCompatActivity {

    CollapsingToolbarLayout mCollapsingToolbarLayout;
    AppBarLayout mBarLayout;
    ButtonBarLayout mButtonBarLayout;
    Toolbar mToolbar;
    LinearLayout lin2;
    XRecyclerView mRecyclerView;

    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mRecyclerView.refreshComplete();
        }
    };
    private CollapsingToolbarLayoutState mState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.colllayout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        lin2 = (LinearLayout) findViewById(R.id.lin2);
        mRecyclerView = (XRecyclerView) findViewById(R.id.recy);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new RecyAdapter(this));
        mRecyclerView.setLoadingMoreEnabled(false);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mHandler.sendEmptyMessageDelayed(0, 1500);
            }

            @Override
            public void onLoadMore() {

            }
        });

        mBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                showToast(verticalOffset + "");
                if (verticalOffset == 0) {
                    showToast("1");
                    mState = CollapsingToolbarLayoutState.EXPANDED;
                    lin2.setVisibility(View.VISIBLE);

                } else if (verticalOffset < mBarLayout.getTotalScrollRange()) {
                    showToast("2");
                    mState = CollapsingToolbarLayoutState.COLLAPSED;
                    lin2.setVisibility(View.GONE);
                } else {
                    showToast("3");
                    mState = CollapsingToolbarLayoutState.INTERNEDIATE;
                    lin2.setVisibility(View.GONE);
                }
            }
        });


    }

    Toast mToast = null;//将此参数设成全局

    private void showToast(String str) {
        if (mToast != null) {
            mToast.setText(str);
            mToast.setDuration(Toast.LENGTH_LONG);
        } else
            mToast = Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT);
        mToast.show();
    }

}
