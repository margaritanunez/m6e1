package com.example.m6e1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.m6e1.databinding.FragmentAddBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private val taskViewModel : TaskViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        initListener()
        loadTasks()
        return binding.root
    }



    private fun initListener() {
        binding.addTaskButton.setOnClickListener{
            var texto = binding.taskNameTxt.text.toString()
            saveTask(texto)
        }
    }

    private fun saveTask(texto: String) {
        val task = Task(texto)
        taskViewModel.insertarTareas(task)
    }

    private fun loadTasks() {
        taskViewModel.obtenerTareas().observe(viewLifecycleOwner){
            val tasksAsText = it.joinToString("\n") { it.nombreTarea }
            binding.textView.text = tasksAsText

        }
    }
}