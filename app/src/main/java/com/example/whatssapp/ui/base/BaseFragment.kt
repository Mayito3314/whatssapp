package com.example.whatssapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * BaseFragment simplifica el uso de ViewBinding en los fragments.
 *
 * En lugar de escribir el mismo código para inflar el binding en cada fragmento,
 * puedes extender esta clase y solo indicar cómo inflar el layout.
 *
 * También se encarga de liberar el binding en `onDestroyView()` para evitar errores
 * de memoria cuando el fragmento se destruye.
 *
 * Adicionalmente, aplica automáticamente:
 * - Un **margen superior de 30dp** al root del layout, útil para evitar que el contenido
 *   se solape con la barra de estado.
 * - Un **status bar blanco** por defecto, para dar una apariencia limpia y moderna.
 *
 * @param VB Es el tipo del ViewBinding que vas a usar en tu fragmento.
 *
 * ## ¿Para qué sirve `binding`?
 * La propiedad `binding` te da acceso directo a todas las vistas del layout.
 * Se marca como `protected` para que solo pueda usarse dentro del fragmento o sus clases hijas,
 * no desde afuera.
 */
abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null

    /**
     * Acceso seguro al binding de las vistas del fragmento.
     */
    protected val binding get() = _binding!!

    /**
     * Debes implementar este método en tu fragmento para indicar cómo inflar el binding.
     */
    abstract fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = inflateBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Márgen superior para evitar que el contenido se tape con el status bar
        binding.root.setPadding(
            binding.root.paddingLeft,
            dpToPx(30),
            binding.root.paddingRight,
            binding.root.paddingBottom
        )
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Convierte una cantidad de dp a píxeles.
     *
     * @param dp La cantidad de dp a convertir.
     * @return El valor equivalente en píxeles.
     */
    private fun dpToPx(dp: Int): Int {
        val density = resources.displayMetrics.density
        return (dp * density).toInt()
    }
}
