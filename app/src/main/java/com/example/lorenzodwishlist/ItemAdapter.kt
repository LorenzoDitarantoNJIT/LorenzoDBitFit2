package com.example.lorenzodwishlist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(private val itemList: List<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            // TODO: Create member variables for any view that will be set
            val senderTextView: TextView
            val titleTextView: TextView
            val summaryTextView: TextView

            init {
                // TODO: Store each of the layout's views into
                // the public final member variables created above
                senderTextView = itemView.findViewById(R.id.sender)
                titleTextView = itemView.findViewById(R.id.title)
                summaryTextView = itemView.findViewById(R.id.summary)
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val context = parent.context
            val inflater = LayoutInflater.from(context)
            val contactView = inflater.inflate(R.layout.insidewishlist, parent, false)
            return ViewHolder(contactView)
        }
        override fun getItemCount(): Int {
            return itemList.size
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val currItem = itemList.get(position)
            // Set item views based on views and data model
            holder.senderTextView.text = currItem.Name
            holder.titleTextView.text = currItem.Price
            holder.summaryTextView.text = currItem.Link
        }




    }
