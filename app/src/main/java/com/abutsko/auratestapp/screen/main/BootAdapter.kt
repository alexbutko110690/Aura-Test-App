package com.abutsko.auratestapp.screen.main

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abutsko.auratestapp.data.local.BootLocal
import com.abutsko.auratestapp.databinding.ItemBootBinding

class BootAdapter(private val context: Context) :
    RecyclerView.Adapter<BootAdapter.BootViewHolder>() {

    private val newsItemList: MutableList<BootLocal> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(list: List<BootLocal>) {
        newsItemList.clear()
        newsItemList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BootViewHolder {
        val binding = ItemBootBinding.inflate(LayoutInflater.from(context), parent, false)
        return BootViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BootViewHolder, position: Int) {
        val foodItem = newsItemList[position]
        holder.bind(foodItem)
    }

    override fun getItemCount(): Int {
        return newsItemList.size
    }


    class BootViewHolder(itemBootBinding: ItemBootBinding) :
        RecyclerView.ViewHolder(itemBootBinding.root) {

        private val binding = itemBootBinding

        fun bind(boot: BootLocal) {
            with(binding) {

            }
        }

    }
}