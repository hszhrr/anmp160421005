package com.ubayadev.adv160421005week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ubayadev.adv160421005week2.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding:FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun GenerateQuestion () : Int {
        var num1 = (0..100).random()
        var num2 = (0..100).random()
        var ans = num1 + num2
        binding.txtNum.text = num1.toString()
        binding.txtNum2.text = num2.toString()

        return ans
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var score = 0
        var answer = GenerateQuestion()
        var pAns = binding.txtAnswer.text.toString().toInt()

        binding.btnSubmit.setOnClickListener {
            if (pAns == answer) {
                score+=1
                binding.txtAnswer.text.toString().toIntOrNull()
                answer = GenerateQuestion()
            }
            else {
                val action = MainFragmentDirections.mainToResult(score)
                Navigation.findNavController(it).navigate(action)
            }
        }

        binding.btnStart.setOnClickListener {
            val name = binding.txtName.text.toString()
            val action = MainFragmentDirections.actionGameFragment(name)
            Navigation.findNavController(it).navigate(action)
        }
    }
}