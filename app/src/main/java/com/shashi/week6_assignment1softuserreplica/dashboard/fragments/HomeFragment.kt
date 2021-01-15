package com.shashi.week6_assignment1softuserreplica.dashboard.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shashi.week6_assignment1softuserreplica.R
import com.shashi.week6_assignment1softuserreplica.adapter.StudentListAdapter
import com.shashi.week6_assignment1softuserreplica.dashboard.DashboardActivity
import com.shashi.week6_assignment1softuserreplica.model.Student

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView;



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recyclerView);

        Student("Shashi Bariyar", "25", "Imadol", "Male");
        val adapter = StudentListAdapter(this.context!!, DashboardActivity.lisfOfStudent)
        recyclerView.adapter = adapter;
        recyclerView.layoutManager = LinearLayoutManager(this.context);

        return view;
    }


}