package com.uziasferreira.randomuser.core.presentation

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import io.reactivex.functions.Action
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), BaseView, LifecycleRegistryOwner {

    @Inject
    lateinit var placeHolder: PlaceholderViewsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        injectDependencies()
        placeHolder.hideAll()
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

    override fun showLoading(): Action = Action { placeHolder.showLoading() }

    override fun hideLoading(): Action = Action { placeHolder.hideLoading() }

    override fun hideEmptyState(): Action = Action { placeHolder.hideEmpty() }

    override fun showEmptyState(): Action = Action { placeHolder.showEmpty() }

    override fun showErrorState(): Action = Action { placeHolder.showError() }

    override fun hideErrorState(): Action = Action { placeHolder.hideError() }

    override fun disableRefresh(): Action {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun enableRefresh(): Action {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}