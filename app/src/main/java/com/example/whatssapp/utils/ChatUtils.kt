package com.example.whatssapp.utils

import com.example.whatssapp.R
import com.example.whatssapp.ui.model.ChatModel

/**
 * Clase de utilidad que provee una lista de chats simulados.
 *
 * Esta información está hardcodeada con fines de prueba y demostración visual
 * en la interfaz de usuario. Se utiliza principalmente para validar el diseño del
 * `RecyclerView`, los estilos de texto, imágenes y comportamiento básico.
 *
 * En una implementación real, esta lista podría ser obtenida desde un servicio web (API REST),
 * una base de datos local (Room, SQLite), o incluso sincronizada en tiempo real con Firestore/Firebase.
 */
object ChatUtils {

    fun getChatList(): List<ChatModel> {
        return listOf(
            ChatModel(
                name = "Valeria Ruiz",
                message = "✓✓ Te veo en la tarde para repasar eso.",
                time = "3:45 p.m.",
                imageResId = R.drawable.profile_1
            ),
            ChatModel(
                name = "Andrés Medina",
                message = "✓ Ya mandé el correo, revísalo porfa.",
                time = "3:12 p.m.",
                imageResId = R.drawable.profile_2
            ),
            ChatModel(
                name = "Grupo Proyecto UX",
                message = "📎 Se agregó un archivo nuevo al drive.",
                time = "2:58 p.m.",
                imageResId = R.drawable.profile_3
            ),
            ChatModel(
                name = "Caro T. ❤️",
                message = "✓✓ ¿Y si mejor cenamos en tu casa? 😏",
                time = "2:33 p.m.",
                imageResId = R.drawable.profile_4
            ),
            ChatModel(
                name = "Tío Memo",
                message = "Llévate el taladro que te presté.",
                time = "1:59 p.m.",
                imageResId = R.drawable.profile_5
            ),
            ChatModel(
                name = "Clases de Inglés",
                message = "📝 Recuerda tu clase mañana a las 9:00 a.m.",
                time = "1:42 p.m.",
                imageResId = R.drawable.profile_6
            ),
            ChatModel(
                name = "Alejandro L.",
                message = "✓✓ Estoy en camino, en 5 llego.",
                time = "1:25 p.m.",
                imageResId = R.drawable.profile_7
            ),
            ChatModel(
                name = "Naty 🐾",
                message = "🐶 Te dejé la comida del perro en el refri.",
                time = "12:55 p.m.",
                imageResId = R.drawable.profile_8
            )
        )
    }
}
