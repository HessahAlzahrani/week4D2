package com.example.week4d2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.week4d2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var GetViwe: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GetViwe = ActivityMainBinding.inflate(layoutInflater)
        setContentView(GetViwe.root)

       GetViwe.buttonId.setOnClickListener { infoprint() } // call fun
    }

    fun infoprint() {
        var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+" ////
        var Name = GetViwe.inputnameid.text.toString()
        var email = GetViwe.emailTd.text.toString()
        var pass1 = GetViwe.passId.text.toString()
        var pass2 = GetViwe.pass2Id.text.toString()
        var det = GetViwe.DateId.text.toString()
        var gender = when (GetViwe.gropId.checkedRadioButtonId) {
            GetViwe.melaId.id -> GetViwe.melaId.text.toString()
            GetViwe.femalId.id -> "femal"
            else -> "not selected "         ///   user not choes (male - female )
        } ///////end when

        if (TextUtils.isEmpty(Name) == false &&
            TextUtils.isEmpty(email) == false &&
            TextUtils.isEmpty(pass1) == false &&
            TextUtils.isEmpty(pass2) == false &&
            TextUtils.isEmpty(det) == false &&
            TextUtils.isEmpty(gender) == false
        ) {
            if (email.trim { it <= ' ' }.matches(emailPattern.toRegex()) == false){
                Toast.makeText(applicationContext,"email is error",Toast.LENGTH_SHORT)
            }else if(pass1 == pass2){
                GetViwe.ViweinfoId.setText("Name is : $Name\n" +
                        "Email ia :$email\n"+
                        "your birthdy ON $det\n"+
                        "your gender is: $gender\n")
            }
        } else
            forErrornull()

    } //////////end fun infoprint


    fun forErrornull() {
        Snackbar.make(
            findViewById(R.id.myappId), "sorry info is not completed ", Snackbar.LENGTH_SHORT
        ).show()

    } ////end fun forError


} ////end class