package com.example.binlist.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.binlist.databinding.FragmentMainBinding
import com.example.binlist.domain.entity.BinInfo
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainFragment: Fragment() {

    private lateinit var viewModel: MainViewModel

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("FragmentMainBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        setupListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.errorInputBin.observe(viewLifecycleOwner) {
            if (it) {
                binding.tvTextErrorInfo.text = "Введите строку"
            }
        }
        viewModel.binInfo.observe(viewLifecycleOwner) {
            val binInfo = viewModel.binInfo.value
            with (binding) {
                tvTextScheme.text = binInfo?.scheme
                tvTextBrand.text = binInfo?.brand
                tvTextLength.text = binInfo?.number?.length.toString()
                tvTextLuhn.text = binInfo?.number?.luhn.toString()
                tvTextType.text = binInfo?.type
                tvTextPrepaid.text = binInfo?.prepaid.toString()
                tvTextCountry.text = binInfo?.country?.name
                tvTextLatitude.text = binInfo?.country?.latitude?.toString()
                tvTextLongitude.text = binInfo?.country?.longitude?.toString()
                tvTextBank.text = "${binInfo?.bank?.name}, ${binInfo?.bank?.city}"
                tvTextUrl.text = binInfo?.bank?.url
                tvTextPhone.text = binInfo?.bank?.phone
            }
        }
        viewModel.httpError.observe(viewLifecycleOwner) {
                binding.tvTextErrorInfo.text = it
        }
    }

    private var textChangeCountDownJob: Job = Job()

    private fun setupListeners() {
        binding.etInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun afterTextChanged(p0: Editable?) {
                textChangeCountDownJob.cancel()
                textChangeCountDownJob = lifecycleScope.launch {
                    delay(1500)
                    val bin = binding.etInput.text.toString()
                    viewModel.loadBinInfo(bin)
                }
            }
        })
    }

}