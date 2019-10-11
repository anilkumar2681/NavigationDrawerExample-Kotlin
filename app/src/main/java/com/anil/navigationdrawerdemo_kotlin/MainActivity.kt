package com.anil.navigationdrawerdemo_kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val actionBar=supportActionBar
        actionBar?.title="Home"

        val drawerToggle:ActionBarDrawerToggle=object :ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close ){

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
            }
        }

        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_view.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.action_cut ->{
                    showToast("You Clocked CUT")
                }
                R.id.action_copy->{
                    showToast("You Clocked COPY")
                }
                R.id.action_paste ->{
                    showToast("You Clocked PASTE")
                }
                R.id.action_new ->{
                    showToast("You Clocked NEW")
                }
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }

    }


    fun showToast(msg:String){

        val toast = Toast(this)
        var textView: TextView?=null
        toast.duration = Toast.LENGTH_LONG
        val inflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_toast_layout, null)
        textView = view.findViewById(R.id.toastMsg)
        textView.text=msg
        toast.view = view
        toast.show()

    }

}
