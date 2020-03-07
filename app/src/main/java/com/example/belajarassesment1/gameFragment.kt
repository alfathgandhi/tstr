package com.example.belajarassesment1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.belajarassesment1.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class gameFragment : Fragment() {
private lateinit var binding:FragmentGameBinding
private lateinit var word:String
    private lateinit var wordlist:MutableList<String>
private var score=0


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        shuffleWordlist()
        getWord()

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_game, container, false)

        binding.apply{
            binding.Correct.setOnClickListener {

                getWord()
                setWord()
                score++
                setScore()
            }
        }
        setWord()
        setScore()



        return binding.root
    }

    fun shuffleWordlist(){
        wordlist= mutableListOf(
            "Alfath",
            "Gandhi",
            "Iskandar",
            "Haha"
        )
        wordlist.shuffle()


    }
    fun getWord(){
        if(wordlist.isEmpty()){

        val nav=gameFragmentDirections.actionGameFragmentToHasil(score)
            view?.findNavController()?.navigate(nav)

        }else{
            word=wordlist.removeAt(0)
        }
    }
    fun setWord(){
        binding.idword.text=word

    }
    @SuppressLint("SetTextI18n")
    fun setScore(){
        binding.idscore.text=getString(R.string.score) + score.toString()

    }

}




