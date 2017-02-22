package com.lh.alidemo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CollapsingToolbarLayout mCollapsingToolbarLayout;
    AppBarLayout mBarLayout;
    ButtonBarLayout mButtonBarLayout;
    Toolbar mToolbar;
    LinearLayout lin2;

    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }

    private CollapsingToolbarLayoutState mState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.colllayout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        lin2 = (LinearLayout) findViewById(R.id.lin2);

        mBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                showToast(verticalOffset+"");
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


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
