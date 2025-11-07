# Preferencias

## Introducción

Es una aplicación que solicita al usuario un nombre y password, cuadno el usuario pulse el botón "Login", mostrará el nombre en pantalla y se almacenará para que sea recuperado de forma automática en nuevas ejecuciones de la aplicación.

---

## Login.kt

``` kotlin
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
```

---

## Details.kt

``` kotlin
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
```

---

## Layout

### activity_login.xml


``` kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Login">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="72dp"
        android:layout_marginTop="84dp"
        android:layout_marginEnd="281dp"
        android:text="User"
        android:textSize="24sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView3" />

    <EditText
        android:id="@+id/txtName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="85dp"
        android:layout_marginTop="26dp"
        android:layout_marginEnd="116dp"
        android:ems="10"
        android:hint="@string/Name"
        android:inputType="text"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="83dp"
        android:layout_marginTop="70dp"
        android:layout_marginEnd="221dp"
        android:text="Password"
        android:textSize="24sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/txtName" />

    <EditText
        android:id="@+id/tvPassword"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="88dp"
        android:layout_marginTop="34dp"
        android:layout_marginEnd="113dp"
        android:ems="10"
        android:hint="@string/Password"
        android:inputType="text"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView2" />

    <Button
        android:id="@+id/tvLogin"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="267dp"
        android:layout_marginTop="64dp"
        android:layout_marginEnd="54dp"
        android:layout_marginBottom="101dp"
        android:text="@string/Login"
        android:onClick="guardar"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/tvPassword" />

    <TextView
        android:id="@+id/textView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="171dp"
        android:layout_marginTop="96dp"
        android:layout_marginEnd="182dp"
        android:text="LOGIN"
        android:textSize="34sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

---

### activity_details.xml

``` kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/textView4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="172dp"
        android:layout_marginTop="96dp"
        android:layout_marginEnd="180dp"
        android:text="BIENVENIDA"
        android:textSize="34sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/txtName2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="98dp"
        android:layout_marginTop="76dp"
        android:layout_marginEnd="103dp"
        android:ems="10"
        android:hint="@string/Name"
        android:inputType="text"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView4" />

    <Button
        android:id="@+id/tvBack"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="248dp"
        android:layout_marginTop="196dp"
        android:layout_marginEnd="73dp"
        android:layout_marginBottom="224dp"
        android:text="@string/Volver"
        android:onClick="navegar"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/txtName2" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

---

## Values

### Strings.xml

``` kotlin
<resources>
    <string name="app_name">Login</string>
    <string name="Name">Nombre</string>
    <string name="Password">Contraseña</string>
    <string name="Login">Iniciar Sesión</string>
    <string name="Volver">Volver</string>
</resources>
```

---

### Strings.xml(en)

``` kotlin
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="app_name">Login</string>
    <string name="Name">Name</string>
    <string name="Password">Password</string>
    <string name="Login">Login</string>
    <string name="Volver">Back</string>
</resources>
```
