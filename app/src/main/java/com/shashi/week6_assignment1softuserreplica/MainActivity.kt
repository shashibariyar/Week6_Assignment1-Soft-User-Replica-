package com.shashi.week6_assignment1softuserreplica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.shashi.week6_assignment1softuserreplica.dashboard.DashboardActivity
import com.shashi.week6_assignment1softuserreplica.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText;
    private lateinit var etPassword: EditText;
    private lateinit var btnLogin: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val user = User();
                val isLogin =
                    user.LoginOperation(etUsername.text.toString(), etPassword.text.toString());

                if (TextUtils.isEmpty(etUsername.text.toString())) {
                    etUsername.setError("Username Required");
                    etUsername.requestFocus();
                } else if (TextUtils.isEmpty(etPassword.text.toString())) {
                    etPassword.setError("Password Required");
                    etPassword.requestFocus();
                } else {
                    if (isLogin) {
                        startActivity(Intent(this@MainActivity, DashboardActivity::class.java));
                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            "Either Username or Password Does not Match",
                            Toast.LENGTH_SHORT
                        )
                            .show();
                    }
                }
            }
        })
    }
}