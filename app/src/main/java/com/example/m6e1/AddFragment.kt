package com.example.m6e1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val dao= TaskDataBase.getDataBase(requireContext()).getTaskDao()
        val task = Task(texto)
        GlobalScope.launch { dao.insertTask(task)}
    }

    private fun loadTasks() {
        val dao = TaskDataBase.getDataBase(requireContext()).getTaskDao()
        GlobalScope.launch {
            val tasks = dao.getTasks()
            val tasksAsText = tasks.joinToString("\n") { it.nombreTarea }
            binding.textView.text = tasksAsText
        }

    }
}