package com.shashi.week6_assignment1softuserreplica.dashboard.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.shashi.week6_assignment1softuserreplica.R
import com.shashi.week6_assignment1softuserreplica.dashboard.DashboardActivity
import com.shashi.week6_assignment1softuserreplica.model.Student

class StudentFragment : Fragment() {

    private lateinit var etFullname: EditText;
    private lateinit var etAddress: EditText;
    private lateinit var etAge: EditText;
    private lateinit var rGender: RadioGroup;
    private lateinit var rMale: RadioButton;
    private lateinit var rFemale: RadioButton;
    private lateinit var rOther: RadioButton;
    private lateinit var btnSave: Button;


    var gender: String ="";


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student, container, false);
        BindView(view)

        btnSave.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                if (TextUtils.isEmpty(etFullname.text.toString())) {
                    etFullname.setError("Enter Fullname");
                    etFullname.requestFocus();
                } else if (TextUtils.isEmpty(etAge.text.toString())) {
                    etAge.setError("Enter Age");
                    etAge.requestFocus();
                } else if (TextUtils.isEmpty(etAddress.text.toString())) {
                    etAddress.setError("Enter Address");
                    etAddress.requestFocus();
                } else if (!rMale.isChecked && !rFemale.isChecked && !rOther.isChecked) {
                    Toast.makeText(context, "Please Select Gender", Toast.LENGTH_SHORT).show();
                } else {
                    val fullname = etFullname.text.toString();
                    val address = etAddress.text.toString();
                    val age = etAge.text.toString();
                    if(rMale.isChecked){
                        gender="Male"
                    }
                    else if (rFemale.isChecked){
                        gender="Female"
                    }
                    else if (rOther.isChecked){
                        gender="Others"
                    }
                    else{
                        Toast.makeText(
                            context,
                            "Please Select A gender",
                            Toast.LENGTH_SHORT
                        ).show();

                    }

                    DashboardActivity.lisfOfStudent.add(Student(fullname,age,address,gender))
                    Toast.makeText(
                        context,
                        "Student Added Successfully",
                        Toast.LENGTH_SHORT
                    ).show();
                    resetFields();
                }
            }
        })


        return view;
    }
    public fun BindView(view: View){
        etFullname = view.findViewById(R.id.etFullname);
        etAddress = view.findViewById(R.id.etAddress);
        etAge = view.findViewById(R.id.etAge);
        rGender = view.findViewById(R.id.rGroup);
        rMale = view.findViewById(R.id.rMale);
        rFemale = view.findViewById(R.id.rFemale);
        rOther = view.findViewById(R.id.rOther);
        btnSave = view.findViewById(R.id.btnSave);


    }

    fun resetFields() {

        etFullname.setText("");
        etAge.setText("");
        etAddress.setText("");
        rMale.isChecked = false;
        rFemale.isChecked = false;
        rOther.isChecked = false;

    }


}