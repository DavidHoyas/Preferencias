package es.etg.pmdm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val boton: Button = findViewById(R.id.tvLogin)

        val nombre = leer()
        if(nombre !=null){
            val txtNombre = findViewById<TextView>(R.id.txtName).setText(nombre);
        }
    }


    fun guardar(view: View){
        val nombre = findViewById<TextView>(R.id.txtName).text
        val sharedPref = getSharedPreferences("Login", MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("nombre", nombre.toString())
        editor.apply()
        navegar()
    }

    fun navegar() {
        val intent = Intent(this, Details::class.java)

        startActivity(intent)

    }

    fun leer(): String? {
        val sharedPref = getSharedPreferences("Login", MODE_PRIVATE)
        val nombre = sharedPref.getString("nombre", "")
        return nombre
    }
}
