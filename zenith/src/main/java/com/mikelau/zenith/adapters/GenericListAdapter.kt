package com.mikelau.zenith.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

import java.util.ArrayList

/** Abstract class to be extended by adapters to Adapt a certain Model (POJO / POKO) **/
abstract class GenericListAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var mAddCount = 0
    var items = ArrayList<T>()

    fun addItems(items: ArrayList<T>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItems(items: Set<T>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun insertItems(items: ArrayList<T>) {
        val pastIndex = this.items.size
        this.items.addAll(items)
        notifyItemInserted(pastIndex - 1)
    }

    fun addItem(item: T) {
        this.items.add(item)
        notifyDataSetChanged()
    }

    fun addItem(i: Int, item: T?) {
        item?.let { this.items.add(i, it) }
        notifyDataSetChanged()
    }

    fun addItemsOnTop(items: ArrayList<T>) {
        this.items.addAll(0, items)
        notifyDataSetChanged()
    }

    fun addItemOnTop(item: T) {
        this.items.add(0, item)
        notifyDataSetChanged()
    }

    fun modifyItem(t: T, position: Int) {
        this.items[position] = t
        notifyDataSetChanged()
    }

    fun refresh(items: ArrayList<T>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun refresh() {
        notifyDataSetChanged()
    }

    fun removeItem(index: Int) {
        this.items.removeAt(index)
        notifyDataSetChanged()
    }

    fun clear() {
        this.items.clear()
        notifyDataSetChanged()
    }

    fun addSection(position: Int) {
        addItem(position, null)
    }

    protected fun fillItems(items: ArrayList<T>) {
        this.items = items
    }

    protected fun fillItems(items: List<T>) {
        this.items = items as ArrayList<T>
    }

    protected abstract fun setOnCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    private fun setGetItemViewType(item: T?, position: Int): Int {
        return -1
    }

    protected abstract fun setOnBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, item: T?)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return setOnCreateViewHolder(parent, viewType)

    }

    override fun getItemViewType(position: Int): Int {
        return try {
            val t = items[position]
            setGetItemViewType(t, position)
        } catch (e: Exception) {
            setGetItemViewType(null, position)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        try {
            val t = items[position]
            setOnBindViewHolder(holder, position, t)
        } catch (e: IndexOutOfBoundsException) {
            setOnBindViewHolder(holder, position, null)
        }

    }

    override fun getItemCount(): Int {
        return try {
            items.size + mAddCount
        } catch (e: Exception) {
            0
        }

    }

    protected fun addTotalCount(addCount: Int) {
        this.mAddCount = addCount
    }

}
