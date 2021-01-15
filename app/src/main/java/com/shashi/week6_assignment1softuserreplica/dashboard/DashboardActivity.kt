package com.shashi.week6_assignment1softuserreplica.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.shashi.week6_assignment1softuserreplica.R
import com.shashi.week6_assignment1softuserreplica.adapter.ViewPagerAdapter
import com.shashi.week6_assignment1softuserreplica.dashboard.fragments.AboutFragment
import com.shashi.week6_assignment1softuserreplica.dashboard.fragments.HomeFragment
import com.shashi.week6_assignment1softuserreplica.dashboard.fragments.StudentFragment
import com.shashi.week6_assignment1softuserreplica.model.Student

class DashboardActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager;
    private lateinit var tabLayout: TabLayout;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportActionBar?.hide();
        setContentView(R.layout.activity_dashboard)

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        loadViewPagerAdapter();
        loadlist()
    }

    private fun loadViewPagerAdapter() {

        val adapter = ViewPagerAdapter(supportFragmentManager);
        adapter.addFragment(HomeFragment(), "Home");
        adapter.addFragment(StudentFragment(), "Add Student");
        adapter.addFragment(AboutFragment(), "About Us");
        viewPager.adapter = adapter;
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24);
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_icons8_student_registration_100);
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_notifications_24);


    }

    private fun loadlist(){
        if (lisfOfStudent.size==0){
            lisfOfStudent.add(Student("Shashi Bariyar", "25", "Imadol", "Male"));
            lisfOfStudent.add(Student("Ace Shretha", "24", "Kathmandu", "Female"));
            lisfOfStudent.add(Student("Ravi", "21", "Bardiya", "Male"));
        }
    }
    companion object {
        var lisfOfStudent = arrayListOf<Student>();
    }


}