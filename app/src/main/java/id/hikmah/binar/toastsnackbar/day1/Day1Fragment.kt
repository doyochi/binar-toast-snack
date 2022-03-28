package id.hikmah.binar.toastsnackbar.day1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import id.hikmah.binar.toastsnackbar.databinding.FragmentDay1Binding

class Day1Fragment : Fragment() {

    private var _binding: FragmentDay1Binding? = null
    private val binding get() = _binding!!

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
        showSnackBar()
        showSnackBarWithAction()
    }

    private fun showToast(){
        binding.btnToast.setOnClickListener{
            Toast.makeText(requireContext(), "Button Toast telah di tekan", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showSnackBar(){
        binding.btnSnackbar.setOnClickListener{
            Snackbar.make(it, "Button SnackBar telah di tekan", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun showSnackBarWithAction(){
        binding.btnActionsnack.setOnClickListener{
            Snackbar.make(it, "Button SnackBar dengan Action telah di tekan", Snackbar.LENGTH_INDEFINITE)
                .setAction("Take Action"){
                    Toast.makeText(requireContext(),"Take action di tekan!", Toast.LENGTH_LONG).show()
                }
                .show()
        }
    }
}