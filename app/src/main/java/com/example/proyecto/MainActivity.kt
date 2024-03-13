package com.example.proyecto

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//@AndroidEntryPoint habilita la inyección de dependencias en esta clase.
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var textomenu1: TextView
    private lateinit var textomenu2: TextView
    //private lateinit var preferenciasCompartidas: Preferences

    // Inyección de la clase Hilt2 en MainActivity.
    @Inject
    lateinit var pruebaHilt: Hilt2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Uso de la instancia de Hilt2 inyectada para obtener un mensaje relacionado con la inyección de dependencias.
        val hilt = pruebaHilt.pruebaHilt()
        Toast.makeText( this, hilt, Toast. LENGTH_LONG).show()

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.fragment_container)
        navigationView = findViewById(R.id.navigationView)

        /*
        preferenciasCompartidas = Preferences(this)

        if (!preferenciasCompartidas.isAutenticado()) {
            val intent = Intent(this@MainActivity, Login::class.java)
            startActivity(intent)
            finish()
            return
        }

        val usuario = preferenciasCompartidas.obtenerUsuario()

         */
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        val headerView = navigationView.getHeaderView(0)
        textomenu1 = headerView.findViewById(R.id.textomenu1)
        textomenu2 = headerView.findViewById(R.id.textomenu2)

        //textomenu1.text = usuario
        //textomenu2.text = "$usuario@ejemplo.com"

        navigationView.setNavigationItemSelectedListener { menuItem ->
            val currentFragmentId = navController.currentDestination?.id

            when (menuItem.itemId) {
                R.id.nav_home -> {
                    navController.navigate(R.id.listFragment)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_gallery -> {
                    if (currentFragmentId == R.id.listFragment) {
                        val action = ListFragmentDirections.actionListFragmentToBlankFragment()
                        navController.navigate(action)
                    } else if (currentFragmentId == R.id.fragmentConfiguracion) {
                        val action = ConfigFragmentDirections.actionFragmentConfiguracionToBlankFragment()
                        navController.navigate(action)
                    }else if  (currentFragmentId == R.id.detailsFragment) {

                        val action = DetailsFragmentDirections.actionDetailsFragmentToBlankFragment()
                        navController.navigate(action)
                    }
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_logout -> {
                    //preferenciasCompartidas.limpiarPreferencias()
                    val intent = Intent(this@MainActivity, Login::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }
        }



        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    @SuppressLint("ResourceType")
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.toolbar_list -> {
                navController.navigate(R.id.listFragment)
                true
            }
            R.id.toolbar_configuration -> {
                navController.navigate(R.id.fragmentConfiguracion)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}

