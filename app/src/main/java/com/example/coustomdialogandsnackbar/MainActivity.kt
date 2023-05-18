package com.example.coustomdialogandsnackbar

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar



class MainActivity : AppCompatActivity() {

    private var snackBarBtn : ImageButton? = null
    private var alertDlgBtn : Button? = null
    private var customDlgBtn : Button? = null
    private var customProgDlgBtn :Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        snackBarBtn = findViewById(R.id.imageButton)
        snackBarBtn?.setOnClickListener{
            view ->
            Snackbar.make(view , "you have clicked the image button" , Snackbar.LENGTH_LONG).show()
        }

        alertDlgBtn = findViewById(R.id.button)
        alertDlgBtn!!.setOnClickListener{
            alertDialogFunction()
        }

        customProgDlgBtn = findViewById(R.id.button3)
        customProgDlgBtn!!.setOnClickListener{
            customDialogProgressFunction()
        }

        customDlgBtn = findViewById(R.id.button2)
        customDlgBtn!!.setOnClickListener{
            customDialogFunction()
        }


    }

    private fun alertDialogFunction(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("this is an alert dialog. which is used to show alert in our app.")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setPositiveButton("yes") {dialogInterface ,
            which -> Toast.makeText(applicationContext , "clicked yes", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        builder.setNeutralButton("cancel"){ dialogInterface , which->
            Toast.makeText(applicationContext , "clicked cancel \n operation cancelled" , Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("No"){ dialogInterface , which->
            Toast.makeText(applicationContext , "Clicked no" , Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false) // will not allow user to cancel by clicking on the remaining area
        alertDialog.show()

    }

    private fun customDialogFunction(){
        val customDialog = Dialog(this)

        customDialog.setContentView(R.layout.dialog_custom)
        customDialog.findViewById<TextView>(R.id.tv_submit).setOnClickListener(View.OnClickListener { it
        Toast.makeText(applicationContext , "Clicked Submit" , Toast.LENGTH_LONG).show()
        customDialog.dismiss()
        })
        customDialog.findViewById<TextView>(R.id.tv_cancel).setOnClickListener(View.OnClickListener { it
            Toast.makeText(applicationContext , "Clicked cancel" , Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        })

        customDialog.show()

    }

    private fun customDialogProgressFunction(){
        val customProgressDialog = Dialog(this)
        customProgressDialog.setContentView(R.layout.dialog_coustom_progress)
        customProgressDialog.show()
    }
}