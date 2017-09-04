package com.uziasferreira.randomuser.core.presentation

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import io.reactivex.functions.Action

abstract class BaseActivity : AppCompatActivity(), BaseView, LifecycleRegistryOwner {

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun getLifecycle(): LifecycleRegistry {
        return LifecycleRegistry(this)
    }

    override fun showLoading(): Action {
        return Action { Toast.makeText(this, "show loading", Toast.LENGTH_SHORT).show() }
    }

    override fun hideLoading(): Action {
        return Action { Toast.makeText(this, "hide loading", Toast.LENGTH_SHORT).show() }
    }

}