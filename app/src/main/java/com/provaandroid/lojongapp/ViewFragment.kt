package com.provaandroid.lojongapp

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.provaandroid.lojongapp.databinding.FragmentViewBinding
import com.provaandroid.lojongapp.presentation.viewmodel.LojongViewModel


class ViewFragment : Fragment() {
    lateinit var viewModel: LojongViewModel
    private lateinit var fragmentViewBinding: FragmentViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentViewBinding = FragmentViewBinding.bind(view)
        viewModel= (activity as MainActivity).viewModel



        fragmentViewBinding.apply {
            fragmentViewBinding.elephant1.visibility = View.GONE
            fragmentViewBinding.elephant2.visibility = View.GONE
            fragmentViewBinding.elephant3.visibility = View.GONE
            fragmentViewBinding.elephant4.visibility = View.GONE
            fragmentViewBinding.elephant5.visibility = View.GONE

            step1.setOnClickListener {
                lojongCheckPoint("58e008800aac31001185ed07")
                fragmentViewBinding.elephant1.visibility = View.VISIBLE
                fragmentViewBinding.elephant2.visibility = View.GONE
                fragmentViewBinding.elephant3.visibility = View.GONE
                fragmentViewBinding.elephant4.visibility = View.GONE
                fragmentViewBinding.elephant5.visibility = View.GONE
            }
            step2.setOnClickListener {
                lojongCheckPoint("58e008630aac31001185ed01")
                fragmentViewBinding.elephant1.visibility = View.GONE
                fragmentViewBinding.elephant2.visibility = View.VISIBLE
                fragmentViewBinding.elephant3.visibility = View.GONE
                fragmentViewBinding.elephant4.visibility = View.GONE
                fragmentViewBinding.elephant5.visibility = View.GONE
            }

            step3.setOnClickListener {
                lojongCheckPoint("58e00a090aac31001185ed16")
                fragmentViewBinding.elephant1.visibility = View.GONE
                fragmentViewBinding.elephant2.visibility = View.GONE
                fragmentViewBinding.elephant3.visibility = View.VISIBLE
                fragmentViewBinding.elephant4.visibility = View.GONE
                fragmentViewBinding.elephant5.visibility = View.GONE
            }

            step4.setOnClickListener {
                lojongCheckPoint("58e009390aac31001185ed10")
                fragmentViewBinding.elephant1.visibility = View.GONE
                fragmentViewBinding.elephant2.visibility = View.GONE
                fragmentViewBinding.elephant3.visibility = View.GONE
                fragmentViewBinding.elephant4.visibility = View.VISIBLE
                fragmentViewBinding.elephant5.visibility = View.GONE
            }

            step5.setOnClickListener {
                lojongCheckPoint("58e008780aac31001185ed05")
                fragmentViewBinding.elephant1.visibility = View.GONE
                fragmentViewBinding.elephant2.visibility = View.GONE
                fragmentViewBinding.elephant3.visibility = View.GONE
                fragmentViewBinding.elephant4.visibility = View.GONE
                fragmentViewBinding.elephant5.visibility = View.VISIBLE
            }
        }

    }

    private fun lojongCheckPoint(id: String) {

        viewModel.getCheckPoint(id)
        viewModel.checkPoint.observe(viewLifecycleOwner,{response->
            when(response){
                is com.provaandroid.lojongapp.data.util.Resource.Success->{
                    response.data?.let {
                        showDialog(it.text)
                        Toast.makeText(activity, "Api ok", Toast.LENGTH_LONG).show()
                    }
                }
                is com.provaandroid.lojongapp.data.util.Resource.Error->{
                    response.message?.let {
                        print("An error occurred : $it")
                        Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
    }

    private fun showDialog( message: String) {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage(message)

        builder.setPositiveButton("OK"){dialog, which ->
            dialog.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


}