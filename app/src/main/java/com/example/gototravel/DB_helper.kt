package com.example.gototravel

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DB_helper(context: Context?) : SQLiteOpenHelper(context, "Trip.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        var query =
            "CREATE TABLE Book(id INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Email TEXT,Contact_no TEXT,From_where TEXT,Go_by TEXT,total_price TEXT,Pay_by TEXT,Date TEXT,Person TEXT,place TEXT,tem Int )"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun insertData(
        Name: String,
        Email: String,
        Contact_no: String,
        From_where: String,
        Go_by: String,
        total_price: String,
        Pay_by: String,
        Date: String,
        Person: String,
        place: String,
        tem: Int,
    ) {
        var db = writableDatabase

        var cv = ContentValues()
        cv.put("Name", Name)
        cv.put("Email", Email)
        cv.put("Contact_no", Contact_no)
        cv.put("From_where", From_where)
        cv.put("Go_by", Go_by)
        cv.put("total_price", total_price)
        cv.put("Pay_by", Pay_by)
        cv.put("Date", Date)
        cv.put("Person", Person)
        cv.put("place", place)
        cv.put("tem", tem)
        var res = db.insert("Book", null, cv)
        println(res)
    }

    fun UpdateData(
        id: String,
        Name: String,
        Email: String,
        Contact_no: String,
        From_where: String,
        Go_by: String,
        Person: String,
    ) {
        var db = writableDatabase

        var cv = ContentValues()
        cv.put("Name", Name)
        cv.put("Email", Email)
        cv.put("Contact_no", Contact_no)
        cv.put("From_where", From_where)
        cv.put("Go_by", Go_by)
        cv.put("Person", Person)

        db.update("Book", cv, "id = $id", null)
    }

    @SuppressLint("Range")
    fun Read_Data(): ArrayList<ModelData> {

        var list = arrayListOf<ModelData>()

        var db = readableDatabase
        var query = "SELECT * FROM Book"

        var cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                var id = cursor.getString(cursor.getColumnIndex("id"))
                var Name = cursor.getString(cursor.getColumnIndex("Name"))
                var Email = cursor.getString(cursor.getColumnIndex("Email"))
                var Contact_no = cursor.getString(cursor.getColumnIndex("Contact_no"))
                var From_where = cursor.getString(cursor.getColumnIndex("From_where"))
                var Go_by = cursor.getString(cursor.getColumnIndex("Go_by"))
                var total_price = cursor.getString(cursor.getColumnIndex("total_price"))
                var Pay_by = cursor.getString(cursor.getColumnIndex("Pay_by"))
                var Date = cursor.getString(cursor.getColumnIndex("Date"))
                var Person = cursor.getString(cursor.getColumnIndex("Person"))
                var place = cursor.getString(cursor.getColumnIndex("place"))
                var tem = cursor.getString(cursor.getColumnIndex("tem"))

                var m1 = ModelData(
                    id,
                    Name,
                    Email,
                    Contact_no,
                    From_where,
                    Go_by,
                    total_price,
                    Pay_by,
                    Date,
                    Person, place, tem
                )
                list.add(m1)

            } while (cursor.moveToNext())
        }
        return list
    }

    @SuppressLint("Range")
    fun Read_DataPlace(valu : Int): ArrayList<ModelData> {

        var list = arrayListOf<ModelData>()

        var db = readableDatabase
        var query = "SELECT * FROM Book where tem = $valu"

        var cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                var id = cursor.getString(cursor.getColumnIndex("id"))
                var Name = cursor.getString(cursor.getColumnIndex("Name"))
                var Email = cursor.getString(cursor.getColumnIndex("Email"))
                var Contact_no = cursor.getString(cursor.getColumnIndex("Contact_no"))
                var From_where = cursor.getString(cursor.getColumnIndex("From_where"))
                var Go_by = cursor.getString(cursor.getColumnIndex("Go_by"))
                var total_price = cursor.getString(cursor.getColumnIndex("total_price"))
                var Pay_by = cursor.getString(cursor.getColumnIndex("Pay_by"))
                var Date = cursor.getString(cursor.getColumnIndex("Date"))
                var Person = cursor.getString(cursor.getColumnIndex("Person"))
                var place = cursor.getString(cursor.getColumnIndex("place"))
                var tem = cursor.getString(cursor.getColumnIndex("tem"))

                var m1 = ModelData(
                    id,
                    Name,
                    Email,
                    Contact_no,
                    From_where,
                    Go_by,
                    total_price,
                    Pay_by,
                    Date,
                    Person, place,tem
                )
                list.add(m1)

            } while (cursor.moveToNext())
        }
        return list
    }


    fun DelateData(id: String) {
        var db = writableDatabase
        db.delete("Book", "id = $id", null)

    }

}