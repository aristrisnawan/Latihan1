package org.d3if4056.assessmentpra


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if4056.assessmentpra.databinding.FragmentBangunRuangBinding

/**
 * A simple [Fragment] subclass.
 */
class BangunRuang : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentBangunRuangBinding>(inflater,R.layout.fragment_bangun_ruang, container, false)

        binding.btnPersegi.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_bangunRuang_to_persegiPanjang)
        )
        binding.btnTiga.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_bangunRuang_to_segiTiga)
        )
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }


}
