package com.example.gototravel

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gototravel.databinding.ActivityAllTicketsBinding

class All_Tickets : AppCompatActivity() {

    lateinit var binding: ActivityAllTicketsBinding
    private var size: Int = 0
    var list = arrayListOf<ModelData>()
    lateinit var city: String

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAllTicketsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.blue)


        binding.filter.setOnClickListener {
            filter_Dialog()
        }
    }

    fun filter_Dialog() {
        var dialog = Dialog(this)
        dialog.setContentView(R.layout.filter_dialog)
        dialog.show()

        var all_City = dialog.findViewById<RadioGroup>(R.id.all_City)
        var done_btn = dialog.findViewById<RelativeLayout>(R.id.done_btn)

        done_btn.setOnClickListener {
            if (all_City.checkedRadioButtonId == R.id.dubai) {
                city = "Dubai"

                var db = DB_helper(this)
                db.Read_DataPlace(0)
            } else if (all_City.checkedRadioButtonId == R.id.maldives) {
                city = "Maldives"
            } else if (all_City.checkedRadioButtonId == R.id.bali) {
                city = "Bali"
            } else if (all_City.checkedRadioButtonId == R.id.singapore) {
                city = "Singapore"
            } else if (all_City.checkedRadioButtonId == R.id.moscow) {
                city = "Moscow"
            }else if (all_City.checkedRadioButtonId == R.id.america) {
                city = "America"
            }

            if (list[All_Ticekts_Adaptor.position].place.equals(city)){


//                Toast.makeText(this,"$city",Toast.LENGTH_SHORT).show()
            }

//            Toast.makeText(this,"$city",Toast.LENGTH_SHORT).show()


            dialog.dismiss()
        }


    }

    fun setUpRV(l1: ArrayList<ModelData>) {
        var adaptor = All_Ticekts_Adaptor(this, l1)
        var lm = LinearLayoutManager(this)
        binding.allTickts.layoutManager = lm
        binding.allTickts.adapter = adaptor
    }

    override fun onResume() {
        super.onResume()

        var db = DB_helper(this)

        list = db.Read_Data()
        size = list.size
        setUpRV(list)

        if (list.size.equals(0)) {
            binding.imgNo.isVisible = true
            binding.nothing.isVisible = true
            binding.book.isVisible = true
        } else {
            binding.imgNo.isVisible = false
            binding.nothing.isVisible = false
            binding.book.isVisible = false
        }
    }

}