package com.mertemir.android.coding.challenge.framework.adapter

import android.arch.paging.PagedListAdapter
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.mertemir.android.coding.challenge.domain.entity.User
import com.mertemir.android.coding.challenge.domain.pagination.PaginationState

class UserListAdapter : PagedListAdapter<User, RecyclerView.ViewHolder>(UserDiffUtilCallback()) {

    private val USER_VIEW_TYPE = 1
    private val FOOTER_VIEW_TYPE = 2

    private var state = PaginationState.LOADING

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == USER_VIEW_TYPE) UserViewHolder.create(parent) else ListFooterViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == USER_VIEW_TYPE)
            (holder as UserViewHolder).bind(getItem(position))
        else (holder as ListFooterViewHolder).bind(state)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < super.getItemCount()) USER_VIEW_TYPE else FOOTER_VIEW_TYPE
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasFooter()) 1 else 0
    }

    private fun hasFooter(): Boolean {
        return super.getItemCount() != 0 && (state == PaginationState.LOADING || state == PaginationState.ERROR)
    }

    fun setState(state: PaginationState) {
        this.state = state
        notifyItemChanged(super.getItemCount())
    }

}

