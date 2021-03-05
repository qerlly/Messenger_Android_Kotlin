package com.dzmitry.lisouski250906.messengerkotlin

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.dzmitry.lisouski250906.messengerkotlin.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mDrawer: Drawer
    private lateinit var mDrawerHeader: AccountHeader
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFields() {
        mToolbar = mBinding.toolbar
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .withActionBarDrawerToggleAnimated(true)
                .withSelectedItem(-1)
                .withAccountHeader(mDrawerHeader)
                .addDrawerItems(
                        createDrawerItem(100, "Create group", R.drawable.ic_baseline_adb_24),
                        createDrawerItem(101, "Create secret chat", R.drawable.ic_baseline_adb_24),
                        createDrawerItem(103, "Create a chanel", R.drawable.ic_baseline_adb_24),
                        createDrawerItem(104, "Contacts", R.drawable.ic_baseline_adb_24),
                        createDrawerItem(105, "Calls", R.drawable.ic_baseline_adb_24),
                        createDrawerItem(106, "Favorite", R.drawable.ic_baseline_adb_24),
                        createDrawerItem(107, "Settings", R.drawable.ic_baseline_adb_24),
                        DividerDrawerItem(),
                        createDrawerItem(108, "Invite friends", R.drawable.ic_baseline_adb_24),
                        createDrawerItem(109, "About", R.drawable.ic_baseline_adb_24)
                ).build()
    }

    private fun createDrawerItem(pId: Long, pName: String, pIcon: Int): PrimaryDrawerItem {
        return PrimaryDrawerItem().withIdentifier(pId)
                .withIconTintingEnabled(true)
                .withName(pName)
                .withSelectable(false)
                .withIcon(pIcon)
    }

    private fun createHeader() {
        mDrawerHeader = AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(ProfileDrawerItem()
                        .withName("Dzmitry Lisouski")
                        .withEmail("eqm@gmail.com"))
                .build()
    }

    private fun initFunc() {
        setSupportActionBar(mToolbar)
        createHeader()
        createDrawer()
    }
}