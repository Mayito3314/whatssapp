package com.example.whatssapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatssapp.databinding.ChatItemBinding
import com.example.whatssapp.ui.model.ChatModel

/**
 * Adaptador para mostrar una lista de chats en un RecyclerView.
 *
 * Este adapter recibe una lista de objetos [ChatModel] y los enlaza con el layout `chat_item.xml`.
 * Utiliza [Glide] para cargar imágenes de perfil en formato circular.
 *
 * @property chats Lista de chats a mostrar en la interfaz.
 */
class ChatAdapter(
    private val chats: List<ChatModel>
) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    private var filteredList: List<ChatModel> = chats

    /**
     * ViewHolder encargado de enlazar los datos de [ChatModel] con la vista del ítem.
     *
     * @param binding ViewBinding generado a partir del layout `chat_item.xml`.
     */
    inner class ChatViewHolder(private val binding: ChatItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Asocia los datos del modelo [ChatModel] con los elementos visuales del layout.
         *
         * - Muestra el nombre del contacto
         * - Muestra el último mensaje
         * - Muestra la hora
         * - Carga la imagen de perfil usando Glide con formato circular
         *
         * @param chat Objeto que contiene los datos a mostrar.
         */
        fun bind(chat: ChatModel) = with(binding) {
            tvName.text = chat.name
            tvLastMessage.text = chat.message
            tvTime.text = chat.time

            // Glide se utiliza para cargar imágenes de forma eficiente y aplicar transformaciones como círculo
            Glide.with(imgProfile.context)
                .load(chat.imageResId)
                .circleCrop() // Hace la imagen circular
                .into(imgProfile)
        }
    }

    /**
     * Crea una nueva instancia de [ChatViewHolder] cada vez que se necesite un nuevo ítem en pantalla.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = ChatItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ChatViewHolder(binding)
    }

    /**
     * Enlaza los datos de la posición dada con el [ChatViewHolder].
     */
    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(filteredList[position])
    }

    /**
     * Devuelve el total de elementos a mostrar en el RecyclerView.
     */
    override fun getItemCount(): Int = filteredList.size

    /**
     * Actualiza la vista con los filtros
     */
    fun filter(query: String) {
        filteredList = if (query.isBlank()) {
            chats
        } else {
            chats.filter {
                it.name.contains(query, ignoreCase = true) ||
                        it.message.contains(query, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }
}
