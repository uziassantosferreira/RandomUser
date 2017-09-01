package com.uziasferreira.randomuser.core.behaviours.emptystate

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.uziasferreira.randomuser.core.errors.ContentNotFoundError
import com.uziasferreira.randomuser.core.presentation.EmptyStateView
import com.uziasferreira.randomuser.helper.MockitoHelpers
import io.reactivex.Flowable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test

class AssignEmptyStateTest{
    private val uiScheduler = Schedulers.trampoline()
    private lateinit var assignEmptyness: AssignEmptyState<Int>
    private val showEmtpyState: Action = mock()
    private val hideEmtpyState: Action = mock()

    @Before
    fun beforeEachTest() {
        val view = object : EmptyStateView {
            override fun showEmptyState(): Action = showEmtpyState
            override fun hideEmptyState(): Action = hideEmtpyState
        }
        assignEmptyness = AssignEmptyState(view, uiScheduler)
    }

    @Test
    fun should_hide_and_never_show_empty_state_when_emit_itens() {
        Flowable.just(10, 20, 30)
                .compose(assignEmptyness)
                .subscribe()

        verify(hideEmtpyState, MockitoHelpers.oneTimeOnly()).run()
        verify(showEmtpyState, never()).run()
    }

    @Test
    fun should_hide_and_never_show_empty_state_when_emit_empty() {
        Flowable.empty<Int>()
                .compose(assignEmptyness)
                .subscribe()

        verify(hideEmtpyState, MockitoHelpers.oneTimeOnly()).run()
        verify(showEmtpyState, never()).run()
    }

    @Test
    fun should_hide_and_never_show_empty_state_when_emit_not_target_error() {
        Flowable.error<Int>(RuntimeException("Error not target"))
                .compose(assignEmptyness)
                .subscribe({}, {}, {})

        verify(hideEmtpyState, MockitoHelpers.oneTimeOnly()).run()
        verify(showEmtpyState, never()).run()
    }

    @Test
    fun should_hide_and_show_empty_state_when_emit_content_not_found_error() {
        Flowable.error<Int>(ContentNotFoundError())
                .compose(assignEmptyness)
                .subscribe({}, {}, {})

        verify(hideEmtpyState, MockitoHelpers.oneTimeOnly()).run()
        verify(showEmtpyState, MockitoHelpers.oneTimeOnly()).run()
    }
}