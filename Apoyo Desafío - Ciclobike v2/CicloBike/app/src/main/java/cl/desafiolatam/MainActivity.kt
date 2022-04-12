package cl.desafiolatam

import ListaAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var lista: ArrayList<Ciclovia>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_filtrar = findViewById<Button>(R.id.button_filtrar) as Button
        val button_no_filtrar = findViewById<Button>(R.id.button_no_filtrar) as
                Button
        val lista_ciclovias = findViewById<RecyclerView>(R.id.lista_ciclovias) as
                RecyclerView
        setupCiclovias()
        lista_ciclovias.layoutManager = LinearLayoutManager(this)
        val listaAdapter = ListaAdapter(this)
        lista_ciclovias.adapter = listaAdapter
        listaAdapter.setupData(lista!!)

        button_filtrar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val listaAux: ArrayList<Ciclovia>? = ArrayList()
                lista!!.forEach {
                    when (it.comuna) {
                        "Las Condes" -> listaAux!!.add(it)
                    }
                }
                listaAdapter.setupData(listaAux!!)
            }
        })
        button_no_filtrar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                listaAdapter.setupData(lista!!)
            }
        })
    }

    private fun setupCiclovias() {
        val setupCiclovias = SetupCiclovias()
        lista = setupCiclovias.init()
    }
}
