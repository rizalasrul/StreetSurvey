package dishub.streetsurvey;

/**
 * Created by Dzulkarnain on 08/10/2017.
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import dishub.streetsurvey.classumum.config;
import dishub.streetsurvey.fragment.Default;
import dishub.streetsurvey.fragment.Syncronize;
import dishub.streetsurvey.fragment.formA.Menu;

public class MenuDrawer extends FragmentActivity implements AppCompatCallback, SearchView.OnQueryTextListener {
    private String[] mDrawernamaBtn;
    private String[] mDrawerketBtns;
    ArrayList<String> listall;
    private TypedArray mDrawerIcons;
    private ArrayList<Items> drawerItems;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerketBtn;
    private CharSequence mTitle;
    private int mSelectedFragment;
    private BaseFragment mBaseFragment;
    private int mCurrentTitle = R.string.app_name;
    ArrayList<String> partialNames = new ArrayList<String>();
    DrawerAdapter aAdapter;
    private static String BUNDLE_SELECTEDFRAGMENT = "BDL_SELFRG";
    private AppCompatDelegate delegate;

    private SearchView mSearchView;

    private Bundle _Param;

    @Override
    public void onSupportActionModeStarted(ActionMode mode) {
    }

    @Override
    public void onSupportActionModeFinished(ActionMode mode) {
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        delegate = AppCompatDelegate.create(this, this);
        delegate.onCreate(savedInstanceState);
        delegate.setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        delegate.setSupportActionBar(toolbar);

        drawerItems = new ArrayList<Items>();
        listall = new ArrayList<String>();
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        //mendapatkan list nama button dari string resources
        config.btnMenu = getResources().getStringArray(R.array.drawer_namaBtn);
        config.btnKetMenu = getResources().getStringArray(R.array.drawer_ketBtn);
        for (int i = 0; i < config.btnMenu.length; i++) {
            drawerItems.add(new Items(config.btnMenu[i], config.btnKetMenu[i]));
            listall.add(config.btnKetMenu[i]);
        }

        mTitle = mDrawerketBtn = getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        ) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                delegate.getSupportActionBar().setTitle(mTitle); //set title when nav drawer
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                delegate.getSupportActionBar().setTitle(mTitle);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerList.setAdapter(new DrawerAdapter(getApplicationContext(), drawerItems));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        DrawerLayout.LayoutParams lp = (DrawerLayout.LayoutParams) mDrawerList.getLayoutParams();
        lp.width = calculateDrawerWidth();
        mDrawerList.setLayoutParams(lp);

        delegate.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        delegate.getSupportActionBar().setHomeButtonEnabled(true);

        if (savedInstanceState != null) {
            mSelectedFragment = savedInstanceState.getInt(BUNDLE_SELECTEDFRAGMENT);

            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if (fragmentManager.findFragmentById(R.id.act_main_content_frame) == null)
                mBaseFragment = selectFragment(mSelectedFragment);
        } else {
            openFragment(mBaseFragment);
        }
    }

    private void openFragment(BaseFragment baseFragment) {
        if (baseFragment != null) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.act_main_content_frame, baseFragment);
            fragmentTransaction.commit();
            if (baseFragment.getTitleResourceId() > 0)
                mCurrentTitle = baseFragment.getTitleResourceId();
        }
    }

    private BaseFragment selectFragment(int position) {
        BaseFragment baseFragment = null;
        switch (position) {
            default:
                break;
        }
        return baseFragment;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onPrepareOptionsMenu(android.view.Menu menu) {
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        return super.onPrepareOptionsMenu(menu);
    }

    private void selectItem(int position) {
        Fragment fragment = null;
        String menu = config.btnMenu[position];
        switch (menu) {
            //harus ditambahakan di btn menu dan btn ket menu
            case "sinkronisasi":
                fragment = new Syncronize();
                break;
            case "btform_a":
                _Param = new Bundle();
                _Param.putString("url_code", "A");
                fragment = new Menu();
                fragment.setArguments(_Param);
                break;
            case "btform_b":
                _Param = new Bundle();
                _Param.putString("url_code", "B");
                fragment = new Menu();
                fragment.setArguments(_Param);
                break;
            case "btform_c":
                _Param = new Bundle();
                _Param.putString("url_code", "C");
                fragment = new Menu();
                fragment.setArguments(_Param);
                break;
            case "btform_d":
                _Param = new Bundle();
                _Param.putString("url_code", "D");
                fragment = new Menu();
                fragment.setArguments(_Param);
                break;
            case "btform_e":
                _Param = new Bundle();
                _Param.putString("url_code", "E");
                fragment = new Menu();
                fragment.setArguments(_Param);
                break;
            case "btform_f":
                _Param = new Bundle();
                _Param.putString("url_code", "F");
                fragment = new Menu();
                fragment.setArguments(_Param);
                break;
            case "btform_g":
                _Param = new Bundle();
                _Param.putString("url_code", "G");
                fragment = new Menu();
                fragment.setArguments(_Param);
                break;
            case "btform_h":
                _Param = new Bundle();
                _Param.putString("url_code", "H");
                fragment = new Menu();
                fragment.setArguments(_Param);
                break;
            case "btform_i":
                _Param = new Bundle();
                _Param.putString("url_code", "I");
                fragment = new Menu();
                fragment.setArguments(_Param);
                break;
            case "btform_j":
                _Param = new Bundle();
                _Param.putString("url_code", "J");
                fragment = new Menu();
                fragment.setArguments(_Param);
                break;
            case "btform_k":
                _Param = new Bundle();
                _Param.putString("url_code", "K");
                fragment = new Menu();
                fragment.setArguments(_Param);
                break;
            case "btform_l":
                _Param = new Bundle();
                _Param.putString("url_code", "L");
                fragment = new Menu();
                fragment.setArguments(_Param);
                break;
            case "btform_m":
                _Param = new Bundle();
                _Param.putString("url_code", "M");
                fragment = new Menu();
                fragment.setArguments(_Param);
                break;
            case "btform_n":
                _Param = new Bundle();
                _Param.putString("url_code", "N");
                fragment = new Menu();
                fragment.setArguments(_Param);
                break;
            case "btform_o":
                _Param = new Bundle();
                _Param.putString("url_code", "O");
                fragment = new Menu();
                fragment.setArguments(_Param);
                break;
            default:
                fragment = new Default();
        }

        if (fragment != null) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.act_main_content_frame, fragment);
            fragmentTransaction.commit();
        }

        mDrawerList.setItemChecked(position, true);
        setTitle(listall.get(position));
        mDrawerLayout.closeDrawer(mDrawerList);

        updateView(position, position, true);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        delegate.getSupportActionBar().setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public boolean onQueryTextChange(String newText) {
        newText = newText.isEmpty() ? "" : "Query so far: " + newText;
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        if (query.isEmpty()) {
            partialNames.clear();
            for (int i = 0; i < drawerItems.size(); i++) {
                partialNames.add(drawerItems.get(i).toString());
            }
        } else {
            partialNames.clear();
            for (int i = 0; i < drawerItems.size(); i++) {
                if (drawerItems.get(i).toString().toUpperCase().contains(query.toUpperCase())) {
                    partialNames.add(drawerItems.get(i).toString());
                }
                aAdapter.notifyDataSetChanged();
            }
        }
        return true;
    }

    public int calculateDrawerWidth() {
        TypedValue tv = new TypedValue();
        int actionBarHeight = 0;
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        }

        Display display = getWindowManager().getDefaultDisplay();
        int width;
        int height;
        if (android.os.Build.VERSION.SDK_INT >= 13) {
            Point size = new Point();
            display.getSize(size);
            width = size.x;
            height = size.y;
        } else {
            width = display.getWidth();  // deprecated
            height = display.getHeight();  // deprecated
        }
        return width - actionBarHeight;
    }

    private void updateView(int position, int counter, boolean visible) {

        View v = mDrawerList.getChildAt(position -
                mDrawerList.getFirstVisiblePosition());
        TextView someText = (TextView) v.findViewById(R.id.item_new);
        Resources res = getResources();
        String articlesFound = "";

        switch (position) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("")
                .setMessage("Apakah anda ingin logoff?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MenuDrawer.super.onBackPressed();
                    }
                }).create().show();
    }

    ///////////////////////Fungsi pendukung u/ clas CameraTaken///////////////////////////////////////

    // Storage for camera image URI components
    private final static String CAPTURED_PHOTO_PATH_KEY = "mCurrentPhotoPath";
    private final static String CAPTURED_PHOTO_URI_KEY = "mCapturedImageURI";

    // Required for camera operations in order to save the image file on resume.
    private String mCurrentPhotoPath = null;
    private Uri mCapturedImageURI = null;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        if (mCurrentPhotoPath != null) {
            savedInstanceState.putString(CAPTURED_PHOTO_PATH_KEY, mCurrentPhotoPath);
        }
        if (mCapturedImageURI != null) {
            savedInstanceState.putString(CAPTURED_PHOTO_URI_KEY, mCapturedImageURI.toString());
        }
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(CAPTURED_PHOTO_PATH_KEY)) {
            mCurrentPhotoPath = savedInstanceState.getString(CAPTURED_PHOTO_PATH_KEY);
        }
        if (savedInstanceState.containsKey(CAPTURED_PHOTO_URI_KEY)) {
            mCapturedImageURI = Uri.parse(savedInstanceState.getString(CAPTURED_PHOTO_URI_KEY));
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

/////////////////////////////////end-function////////////////////////

}
