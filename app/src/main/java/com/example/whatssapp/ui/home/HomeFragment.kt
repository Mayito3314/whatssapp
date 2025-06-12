package com.example.whatssapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatssapp.databinding.FragmentHomeBinding
import com.example.whatssapp.ui.base.BaseFragment
import com.example.whatssapp.utils.ChatUtils


/**
 * `BaseFragment` es una clase base que maneja automáticamente el ciclo de vida de `ViewBinding`.
 *
 * Al extender de `BaseFragment`, evitamos repetir el mismo código en cada fragmento
 * para inflar y liberar el binding. Esto reduce errores y hace que el código sea más limpio y reutilizable.
 *
 * Ventajas de usar `BaseFragment`:
 * - No necesitas escribir `_binding = ...` ni `_binding = null`.
 * - Accedes a `binding` directamente y de forma segura.
 * - Centralizas la lógica común entre fragmentos (como estilos de status bar, márgenes, etc.).
 */

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private lateinit var chatAdapter: ChatAdapter



    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        setupSearchView()
    }


    /**
     * Inicializa el RecyclerView con una lista de chats simulados.
     *
     * Esta función obtiene una lista de chats desde una clase utilitaria (`ChatUtils`)
     * y la asigna al adaptador `ChatAdapter` que se encarga de mostrar cada elemento.
     * También configura un `LinearLayoutManager` para que los elementos se muestren en lista vertical.
     *
     * Esta implementación es útil para pruebas visuales o prototipos rápidos,
     * ya que la lista está hardcodeada y no proviene de un servidor ni de una base de datos.
     */
    private fun initRecycler(){
        val chatList = ChatUtils.getChatList()
        chatAdapter = ChatAdapter(chatList)
        binding.chatRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.chatRecyclerView.adapter = chatAdapter
    }


    /**
     * Configura el listener del componente SearchView para filtrar la lista de chats en tiempo real.
     *
     * Este método escucha los cambios de texto que el usuario escribe en el campo de búsqueda
     * y actualiza dinámicamente el contenido del RecyclerView filtrando los elementos que coincidan
     * con el nombre o el último mensaje del contacto.
     *
     * La lógica de filtrado se delega al adaptador (`chatAdapter.filter()`), que actualiza
     * su lista interna con los resultados coincidentes.
     *
     * @see ChatAdapter.filter para más detalles del proceso de filtrado.
     */
    private fun setupSearchView() {
        binding.search.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                chatAdapter.filter(newText.orEmpty())
                return true
            }
        })
    }

}
