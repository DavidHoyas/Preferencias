package es.etg.pmdm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        val nombre = leerNombre()

        val txtName2 = findViewById<TextView>(R.id.txtName2)
        txtName2.text = "$nombre"
    }

    fun leerNombre(): String? {
        val sharedPref = getSharedPreferences("Login", MODE_PRIVATE)
        return sharedPref.getString("nombre", "")
    }

    fun navegar(view: View) {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
}
