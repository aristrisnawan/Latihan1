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
import org.d3if4056.assessmentpra.databinding.FragmentSegiTigaBinding

/**
 * A simple [Fragment] subclass.
 */
class SegiTiga : Fragment() {

        private var luas = 0.0
        private var keliling = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding = DataBindingUtil.inflate<FragmentSegiTigaBinding>(inflater,R.layout.fragment_segi_tiga, container, false)
        if (savedInstanceState != null){
            luas = savedInstanceState.getDouble("luas")
            keliling = savedInstanceState.getDouble("keliling")

            binding.nilaiLuas.text = luas.toString()
            binding.nilaiKeliling.text = keliling.toString()
        }
        binding.btnHasil.setOnClickListener {
            val alas = binding.isiAlas.text.toString().toDouble()
            val tinggi = binding.isiTinggi.text.toString().toDouble()

            luas = (alas*tinggi)/2
            var sisiMiring = Math.sqrt(Math.pow(alas,2.0)+(Math.pow(tinggi,2.0)))
            keliling = alas + tinggi  +sisiMiring


            binding.nilaiLuas.text = luas.toString()
            binding.nilaiKeliling.text = keliling.toString()

        }
        binding.btnShare.setOnClickListener {
            onShare()  
        }
        return  binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("luas",luas)
        outState.putDouble("keliling",keliling)
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
