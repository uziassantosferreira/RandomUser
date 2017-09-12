package com.uziasferreira.randomuser.users.presentation.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.uziasferreira.randomuser.R
import com.uziasferreira.randomuser.core.presentation.BaseActivity
import com.uziasferreira.randomuser.core.presentation.BasePresenter
import com.uziasferreira.randomuser.core.presentation.EmptyStateView
import com.uziasferreira.randomuser.users.presentation.adapter.UserAdapterImpl
import com.uziasferreira.randomuser.users.presentation.adapter.UsersAdapter
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

class UsersActivity : BaseActivity(), UsersView {

    @Inject
    lateinit var presenter: UsersPresenter

    @Inject
    lateinit var userAdapter: UserAdapterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun setupView() {
        recyclerview.adapter = userAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = userAdapter
    }

    override fun onResume() {
        super.onResume()
        setupView()
        presenter.getUsers()
    }

    override fun getPresenter(): BasePresenter = presenter

    override fun injectDependencies() {
        AndroidInjection.inject(this)
    }

    override fun subscribeInto(flow: Flowable<List<PresentationUser>>): Disposable {
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
}
