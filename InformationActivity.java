package com.example.ucsm.studentrecordmanagement;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.ucsm.studentrecordmanagement.adapter.CUAdapter;
import com.example.ucsm.studentrecordmanagement.model.ComputerUniversity;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nclwin on 10/30/16.
 */

public class InformationActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CUAdapter adapter;
    private List<ComputerUniversity> informationList;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
   // private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        informationList = new ArrayList<>();
        adapter = new CUAdapter(this, informationList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        try {
            Glide.with(this).load(R.drawable.yangon_img).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //status bar color changes
       SystemBarTintManager tintManager = new SystemBarTintManager(this);

        tintManager.setStatusBarTintEnabled(true);

        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#388e3c"));


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
       // client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        Log.i("Output : ", String.valueOf(collapsingToolbar));
        collapsingToolbar.setTitle(" Computer University");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        ComputerUniversity cu = new ComputerUniversity();
        int[] cuimage = new int[]{
                R.drawable.yangon_img,
                R.drawable.mandalay_img,
                R.drawable.kalay_img,
                R.drawable.pakokku_img,
                R.drawable.taunggyi_img,
                R.drawable.myitkyina_img,
                R.drawable.banmaw_img,
                R.drawable.magway_img,
                R.drawable.monywa_img
                , R.drawable.meikhtila_img

        };
        cu = new ComputerUniversity("Computer University (Yangon)",
                cuimage[0]);
        informationList.add(cu);

        cu = new ComputerUniversity("Computer University (Manadalay)",
                cuimage[1]);
        informationList.add(cu);

        cu = new ComputerUniversity("Computer University (Kalay)",
                cuimage[2]);
        informationList.add(cu);

        cu = new ComputerUniversity("Computer University (Pakokku)",
                cuimage[3]);
        informationList.add(cu);

        cu = new ComputerUniversity("Computer University (Taunggyi)",
                cuimage[4]);
        informationList.add(cu);

        cu = new ComputerUniversity("Computer University (Myitkyina)",
                cuimage[5]);
        informationList.add(cu);

        cu = new ComputerUniversity("Computer University (Banmaw)",
                cuimage[6]);
        informationList.add(cu);

        cu = new ComputerUniversity("Computer University (Magway)",
                cuimage[7]);
        informationList.add(cu);

        cu = new ComputerUniversity("Computer University (Monywa)",
                cuimage[8]);
        informationList.add(cu);

        cu = new ComputerUniversity("Computer University (Meikhtila)",
                cuimage[9]);
        informationList.add(cu);

        adapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


}
