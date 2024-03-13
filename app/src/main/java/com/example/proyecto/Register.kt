package com.example.proyecto

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {

    private lateinit var usuarioEditText: EditText
    private lateinit var contraseñaEditText: EditText
    private lateinit var guardarButton: Button
    private var UsersList = UserList
    private lateinit var usuarioCreado: User
    private lateinit var creadoButton: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)

        usuarioEditText = findViewById(R.id.etUserReg)
        contraseñaEditText = findViewById(R.id.etContraseñaReg)
        guardarButton = findViewById(R.id.btnValidarReg)
        creadoButton = findViewById(R.id.btnCreadoReg)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(this, R.array.fechas, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(adapter)

        UsersList = UserList
        usuarioCreado = User("","")
        creadoButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        guardarButton.setOnClickListener {

            usuarioCreado.setUser(usuarioEditText.text.toString())
            usuarioCreado.setPassword(contraseñaEditText.text.toString())
            if (usuarioCreado.getUser().isEmpty() || usuarioCreado.getPassword().isEmpty()) {
                Toast.makeText(this, "Introduce todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                if (usuarioExistente(usuarioCreado.getUser())) {
                    Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_SHORT).show()
                } else {
                    UsersList.addUser(usuarioCreado)
                    Toast.makeText(this, "Usuario guardado correctamente", Toast.LENGTH_SHORT).show()

                    usuarioEditText.setText("")
                    contraseñaEditText.setText("")
                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun usuarioExistente(usuario: String): Boolean {
        if (UsersList.checkUsers(usuario)==true){
            return true;
        }
        return false;
    }
}