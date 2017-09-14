package com.uziasferreira.randomuser.users.presentation.view

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import com.uziasferreira.randomuser.R
import com.uziasferreira.randomuser.core.presentation.BaseActivity
import com.uziasferreira.randomuser.core.presentation.BasePresenter
import com.uziasferreira.randomuser.core.presentation.ToogleRefreshView
import com.uziasferreira.randomuser.users.presentation.adapter.UserAdapterImpl
import com.uziasferreira.randomuser.users.presentation.model.PresentationUser
import com.uziasferreira.randomuser.users.presentation.presenter.UsersPresenter
import dagger.android.AndroidInjection
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class UsersActivity : BaseActivity(), UsersView, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var presenter: UsersPresenter

    @Inject
    lateinit var userAdapter: UserAdapterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun setupView() {
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = userAdapter
        swiperefreshlayout.setOnRefreshListener(this)
    }

    override fun onResume() {
        super.onResume()
        setupView()
        onRefresh()
    }

    override fun getPresenter(): BasePresenter = presenter

    override fun injectDependencies() {
        AndroidInjection.inject(this)
    }

    override fun subscribeInto(flow: Flowable<List<PresentationUser>>): Disposable {
        userAdapter.clear()
        return flow.observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onError = {
                            it.printStackTrace()
                        },
                        onNext = {
                            userAdapter.setUsers(it)
                        },
                        onComplete = {}
                )
    }

    override fun onRefresh() {
        swiperefreshlayout.isRefreshing = false
        presenter.getUsers()
    }

    override fun enableRefresh(): Action = Action { swiperefreshlayout.isEnabled = true }

    override fun disableRefresh(): Action = Action { swiperefreshlayout.isEnabled = false }

}
