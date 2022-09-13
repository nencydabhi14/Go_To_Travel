package com.example.gototravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.gototravel.databinding.ActivityBookingFormBinding
import java.text.SimpleDateFormat
import java.util.*

class Booking_Form : AppCompatActivity() {
    lateinit var binding: ActivityBookingFormBinding
    lateinit var mode: String
    lateinit var total: String
    lateinit var price: String
    var temp: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBookingFormBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backForm.setOnClickListener {
            finish()
        }

        var db = DB_helper(this)

        price = intent.getStringExtra("price").toString()
        var place = intent.getStringExtra("place").toString()
        temp = intent.getIntExtra("value",0)!!.toInt()

//        var t = (price+total)

        binding.tryTxt.text = price

        window.statusBarColor = ContextCompat.getColor(this, R.color.blue)

        binding.bookBtn.setOnClickListener {

            total = binding.personEdt.text.toString()

            if (binding.cashOnlineGroup.checkedRadioButtonId == R.id.cash) {
                mode = "cash"
            } else if (binding.cashOnlineGroup.checkedRadioButtonId == R.id.online) {
                mode = "online"
            }

            var c = Calendar.getInstance()
            var simple = SimpleDateFormat("dd/MM/yyyy")
            var datecurrent = simple.format(c.time).toString()

            db.insertData(
                binding.nameEdt.text.toString(),
                binding.mailEdt.text.toString(),
                binding.contactEdt.text.toString(),
                binding.fromWhereEdt.text.toString(),
                binding.goByEdt.text.toString(),
                price,
                mode, datecurrent,binding.personEdt.text.toString(),place,temp
            )

            binding.progressbar.isVisible = true
            Handler(Looper.getMainLooper()).postDelayed({

                Toast.makeText(this,"Booked Successfully...!!!",Toast.LENGTH_SHORT).show()
                finish()
            }, 2000)


        }

    }
}