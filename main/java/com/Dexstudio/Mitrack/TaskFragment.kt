@file:Suppress("UNREACHABLE_CODE")

package com.Dexstudio.Mitrack

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


class TaskFragment : Fragment() {
    private lateinit var task: Task
    private lateinit var taskName: EditText
    private lateinit var dateButton: Button
    private lateinit var taskCompleted: CheckBox

    companion object {
        fun newInstance() = TaskFragment()
    }

    private lateinit var viewModel: TaskListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.task_fragment, container, false)
        taskName = view?.findViewById(R.id.task_name) as EditText
        dateButton = view?.findViewById(R.id.task_date) as Button
        taskCompleted = view?.findViewById(R.id.task_completed) as CheckBox

        dateButton.apply{
            text = task.isDue.toString()
            isEnabled = false
        }

        return view
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher = object : TextWatcher {

            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
                // This space intentionally left blank
            }

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                task.taskName = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {
                // This one too
            }
        }

        taskName.addTextChangedListener(titleWatcher)

        taskCompleted.apply{
            setOnCheckedChangeListener {_, isChecked ->
                task.isDone = isChecked
            }
        }

    }


}