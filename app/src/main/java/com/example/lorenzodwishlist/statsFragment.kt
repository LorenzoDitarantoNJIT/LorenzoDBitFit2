package com.example.lorenzodwishlist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch



private lateinit var articlesRecyclerView: RecyclerView
private lateinit var itemAdapter: ItemAdapter

class statsFragment : Fragment() {

    lateinit var items: List<Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Change this statement to store the view in a variable instead of a return statement
        val view = inflater.inflate(R.layout.fragment_stats, container, false)

        val emailsRV = view.findViewById<TextView>(R.id.title)
        var items : MutableList<Item> = ArrayList()
        val adapter = ItemAdapter(items)

        lifecycleScope.launch {
            //this is weird
            (requireActivity().application as ItemApplication).db.itemDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    Item(
                        entity.name,
                        entity.price,
                        entity.url
                    )
                }.also { mappedList ->
                    items.clear()
                    items.addAll(mappedList)
                    adapter.notifyDataSetChanged()
                }
            }
        }

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Call the new method within onViewCreated

    }

    companion object {
        fun newInstance(): statsFragment {
            return statsFragment()
        }
    }
}