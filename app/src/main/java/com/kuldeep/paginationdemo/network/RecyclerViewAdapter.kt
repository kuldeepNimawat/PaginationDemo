package com.kuldeep.paginationdemo.network

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kuldeep.paginationdemo.R

class RecyclerViewAdapter: PagingDataAdapter<CharacterData, RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack()) {
    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
       holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewTypes: Int): RecyclerViewAdapter
    .MyViewHolder {
        val inflater= LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_item,parent,false)
        return MyViewHolder(inflater)
    }

    class MyViewHolder(view : View): RecyclerView.ViewHolder(view){
        val imageView: ImageView=view.findViewById(R.id.imageView)
        val textViewName: TextView=view.findViewById(R.id.textViewName)
        val textViewDesc: TextView=view.findViewById(R.id.textViewDesc)
        fun bind(data: CharacterData){
           textViewName.text=data.name
            textViewDesc.text=data.species
            Glide.with(imageView)
                .load(data.image)
                .circleCrop()
                .into(imageView)
        }
    }

    class DiffUtilCallBack: DiffUtil.ItemCallback<CharacterData>(){
        override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name==newItem.name
        }

        override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name==newItem.name && oldItem.species==newItem.species
        }


    }
}