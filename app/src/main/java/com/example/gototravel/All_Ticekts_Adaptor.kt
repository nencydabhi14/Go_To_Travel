package com.example.gototravel

import android.app.Dialog
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class All_Ticekts_Adaptor(val allTickets: All_Tickets, val l1: ArrayList<ModelData>) :
    RecyclerView.Adapter<All_Ticekts_Adaptor.ViewData>() {

    companion object{
        var position : Int = 0
    }

    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var place_txt = itemView.findViewById<TextView>(R.id.place_txt)
        var where = itemView.findViewById<TextView>(R.id.where)
            var goby = itemView.findViewById<TextView>(R.id.goby)
        var cus_name = itemView.findViewById<TextView>(R.id.cus_name)
        var contact_num_txt = itemView.findViewById<TextView>(R.id.contact_num_txt)
        var total_pessanger = itemView.findViewById<TextView>(R.id.total_pessanger)
        var total_price_txt = itemView.findViewById<TextView>(R.id.total_price_txt)
        var mode_txt = itemView.findViewById<TextView>(R.id.mode_txt)
        var date = itemView.findViewById<TextView>(R.id.date)
        var Update_Data = itemView.findViewById<RelativeLayout>(R.id.Update_Data)
        var Delete_Data = itemView.findViewById<RelativeLayout>(R.id.Delete_Data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view = LayoutInflater.from(allTickets).inflate(R.layout.design_file_all, parent, false)
        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.place_txt.text = l1[position].From_where
        holder.where.text = l1[position].place
        holder.goby.text = l1[position].Go_by
        holder.cus_name.text = l1[position].Name
        holder.contact_num_txt.text = l1[position].Contact_no
        holder.total_pessanger.text = l1[position].Person
        holder.total_price_txt.text = l1[position].total_price
        holder.mode_txt.text = l1[position].Pay_by
        holder.date.text = l1[position].Date

        holder.Update_Data.setOnClickListener {
            updateDialog(position)
        }

        holder.Delete_Data.setOnClickListener {
            DB_helper(allTickets).DelateData(l1[position].id)
            var l1 = DB_helper(allTickets).Read_Data()
            allTickets.setUpRV(l1)
        }

    }

    override fun getItemCount(): Int {
        return l1.size
    }

    fun updateDialog(position: Int) {
        var dialog = Dialog(allTickets)
        dialog.setContentView(R.layout.item_dialod)
        dialog.show()

        var name_edt_d = dialog.findViewById<EditText>(R.id.name_edt_d)
        var mail_edt_d = dialog.findViewById<EditText>(R.id.mail_edt_d)
        var contact_edt_d = dialog.findViewById<EditText>(R.id.contact_edt_d)
        var from_where_D = dialog.findViewById<EditText>(R.id.from_where_D)
        var goby_d_edt = dialog.findViewById<EditText>(R.id.goby_d_edt)
        var number_of_tickets_d = dialog.findViewById<EditText>(R.id.number_of_tickets_d)
        var submit_btn_d = dialog.findViewById<RelativeLayout>(R.id.submit_btn_d)

        submit_btn_d.setOnClickListener {
            DB_helper(allTickets).UpdateData(l1[position].id,name_edt_d.text.toString(),mail_edt_d.text.toString(),contact_edt_d.text.toString(),from_where_D.text.toString(),goby_d_edt.text.toString(),number_of_tickets_d.text.toString())
            var l1 = DB_helper(allTickets).Read_Data()
            allTickets.setUpRV(l1)

            dialog.dismiss()
        }
    }

}
