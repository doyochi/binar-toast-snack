package id.hikmah.binar.toastsnackbar.day1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import id.hikmah.binar.toastsnackbar.R
import id.hikmah.binar.toastsnackbar.databinding.FragmentDay1Binding

class Day1Fragment : Fragment() {

    private var _binding: FragmentDay1Binding? = null
    private val binding get() = _binding!!

    private lateinit var snackbar2: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDay1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showToast()
        snackbar2 = Snackbar.make(binding.btnSnackbar, "Button SnackBar telah di tekan", Snackbar.LENGTH_SHORT)
        showSnackBar()
        showSnackBarWithAction()
    }


    private fun showToast(){
        binding.btnToast.setOnClickListener{
//            Toast.makeText(requireContext(), "Button Toast telah di tekan", Toast.LENGTH_SHORT).show()
            createToast("Button Toast telah di tekan").show()
        }
    }

    private fun showSnackBar(){
        binding.btnSnackbar.setOnClickListener{
            snackbar2 = Snackbar.make(it, "Button SnackBar telah di tekan", Snackbar.LENGTH_SHORT)
                snackbar2.show()
        }
    }

    private fun hideSnackBar(){
        binding.btnDissnackbar.setOnClickListener{
            if(snackbar2.isShown){
                snackbar2.dismiss()
            }
        }
    }

    private fun showSnackBarWithAction(){
        binding.btnActionsnack.setOnClickListener{
            Snackbar.make(it, "Button SnackBar dengan Action telah di tekan", Snackbar.LENGTH_INDEFINITE)
                .setAction("Take Action"){
//                    Toast.makeText(requireContext(),"Take action di tekan!", Toast.LENGTH_LONG).show()
                    createToast("Take action di tekan").show()
                }
                .show()
        }
    }

    private fun createToast(message: String): Toast {
        return Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
    }

    private fun createSnackBar(it: View, message: String): Snackbar {
        return Snackbar.make(it, message, Snackbar.LENGTH_INDEFINITE)
    }

    private fun customColorSnackBar(it: View, message: String) : Snackbar {
        val snackbar = createSnackBar(it, message)
        snackbar.setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.purple_200))
            .setActionTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            .setTextColor(ContextCompat.getColor(requireContext(), R.color.teal_200))
        return snackbar
    }
}