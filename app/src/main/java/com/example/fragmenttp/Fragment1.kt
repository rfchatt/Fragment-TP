package com.example.fragmenttp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class Fragment1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragement, container, false)

        var textView = view.findViewById<TextView>(R.id.framlayout_txt)

        var message_Typed = arguments?.getString("MESSAGE")

        if (message_Typed != null && message_Typed.isNotEmpty()) {
            textView.text = message_Typed
        } else {
            textView.text = "the Input is Empty !"
        }

        var btn_feedback = view.findViewById<MaterialButton>(R.id.btn_feedback)
        btn_feedback.setOnClickListener {
            envoyer()
        }

        return view

    }

    interface OnDataSentListener {
        fun envoyer_feedBack(feedBack: String)
    }

    private var listener: OnDataSentListener? = null

    fun envoyer () {
        listener?.envoyer_feedBack("[FeedBack] : ")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnDataSentListener) {
            listener = context
        }
    }

}