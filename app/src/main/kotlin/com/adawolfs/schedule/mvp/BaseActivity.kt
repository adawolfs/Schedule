package com.adawolfs.schedule.mvp

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.toast


abstract class BaseActivity : AppCompatActivity(), BaseView {

    companion object{
        val REQUEST_PERMISSIONS = 666
    }

    lateinit var onRequestPermissionsResult : () -> Unit?

    override fun getContext(): Context {
        return this;
    }

    override fun showError(error: String) {
        toast(error)
    }

    override fun showError(@StringRes error: Int) {
        toast(getString(error))
    }

    override fun showMessage(message: String) {
        toast(message)
    }

    override fun showMessage(@StringRes message: Int) {
        toast(getString(message))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun isActive(): Boolean {
        return true
    }

    fun checkPermission(permission: String, listener: () -> Unit){
        onRequestPermissionsResult = listener
        if (ContextCompat.checkSelfPermission(this, permission)
                != PackageManager.PERMISSION_GRANTED) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(arrayOf<String>(permission), 666)
            }

        } else {
            listener.invoke()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        // If request is cancelled, the result arrays are empty.
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            onRequestPermissionsResult.invoke()
        } else {

            // permission denied, boo! Disable the
            // functionality that depends on this permission.
        }
        return

    }
}
