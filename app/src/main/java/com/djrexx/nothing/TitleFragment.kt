package com.djrexx.nothing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController



/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {


    companion object {
        private val TAG = TitleFragment::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        try {
//           inflater.inflate(R.layout.fragment_title, container, false)
//            Log.e(TAG, "onCreateView is NOT the issue")
//        } catch (e: Exception) {
//            Log.e(TAG, "onCreateView is the issue");
//        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_title, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val playButton = view.findViewById<Button>(R.id.playGameButton)
        playButton.setOnClickListener{ _ ->
            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }



    }

}
