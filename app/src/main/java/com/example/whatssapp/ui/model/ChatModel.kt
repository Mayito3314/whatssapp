package com.example.whatssapp.ui.model

/**
 * Modelo que representa una conversación en la lista de chats.
 *
 * @param name Nombre del contacto o grupo.
 * @param message Último mensaje enviado o recibido.
 * @param time Hora del último mensaje.
 * @param imageResId ID del recurso drawable del avatar o imagen del contacto.
 */
data class ChatModel(
    val name: String,
    val message: String,
    val time: String,
    val imageResId: Int
)
