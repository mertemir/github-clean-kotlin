package com.moovel.android.coding.challenge.framework.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.moovel.android.coding.challenge.R
import com.moovel.android.coding.challenge.domain.pagination.PaginationState
import kotlinx.android.synthetic.main.user_list_footer.view.*

class ListFooterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        fun create(parent: ViewGroup): ListFooterViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.user_list_footer, parent, false)
            return ListFooterViewHolder(view)
        }
    }

    fun bind(status: PaginationState?) {
        itemView.progress_bar.visibility = if (status == PaginationState.LOADING) VISIBLE else View.INVISIBLE
    }
}