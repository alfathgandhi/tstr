package com.example.belajarassesment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.belajarassesment1.databinding.FragmentHasilBinding

/**
 * A simple [Fragment] subclass.
 */
class Hasil : Fragment() {
private lateinit var bind:FragmentHasilBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val argument by navArgs<HasilArgs>()





        bind=DataBindingUtil.inflate(inflater,R.layout.fragment_hasil, container, false)
        bind.textView2.text="SCORE: "+argument.score.toString()
        bind.button.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_hasil_to_titleFragment3)
        }

        return bind.root

    }

}
