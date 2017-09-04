package com.uziasferreira.randomuser.core.presentation

import io.reactivex.functions.Action

interface BaseView {
    fun getPresenter(): BasePresenter
    fun injectDependencies()
}

interface EmptyStateView {
    fun showEmptyState(): Action
    fun hideEmptyState(): Action
}

interface ErrorStateView {
    fun showErrorState(): Action
    fun hideErrorState(): Action
}

interface LoadingView {
    fun showLoading(): Action
    fun hideLoading(): Action
}

interface ToogleRefreshView {
    fun disableRefresh(): Action
    fun enableRefresh(): Action
}
