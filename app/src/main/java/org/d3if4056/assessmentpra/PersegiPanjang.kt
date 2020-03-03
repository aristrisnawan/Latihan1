package org.d3if4056.assessmentpra


import android.content.ActivityNotFoundException
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi_panjang.*
import org.d3if4056.assessmentpra.databinding.FragmentPersegiPanjangBinding

/**
 * A simple [Fragment] subclass.
 */
class PersegiPanjang : Fragment() {
        private var keliling = 0
        private var luas = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding =  DataBindingUtil.inflate<FragmentPersegiPanjangBinding>(inflater,R.layout.fragment_persegi_panjang, container, false)
        if (savedInstanceState != null){
            luas = savedInstanceState.getInt("luas")
            keliling = savedInstanceState.getInt("keliling")
            binding.nilaiLuas.text = luas.toString()
            binding.nilaiKeliling.text = keliling.toString()
        }
        binding.btnHasil.setOnClickListener {
            val panjang = binding.isiPanjang.text.toString().toInt()
            val lebar = binding.isiLebar.text.toString().toInt()

            luas = panjang * lebar
            keliling = 2*(panjang+lebar)

            binding.nilaiLuas.text = luas.toString()
            binding.nilaiKeliling.text = keliling.toString()
        }
        binding.btnShare.setOnClickListener {
            onShare()
        }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("luas",luas)
        outState.putInt("keliling",keliling)
        super.onSaveInstanceState(outState)
    }

    private fun onShare() {
        var shareIntent = this.activity?.let {
            ShareCompat.IntentBuilder.from(it)
                .setText("Hallo")
                .setType("text/plain")
                .intent
        }

        try {
            startActivity(shareIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(this.activity, "Tai" , Toast.LENGTH_LONG).show()
        }
    }
}
