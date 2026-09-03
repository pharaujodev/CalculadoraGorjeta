package com.example.calculadoragorjeta.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GorjetaViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GorjetaUiState())
    val uiState: StateFlow<GorjetaUiState> = _uiState.asStateFlow()

    fun onValorContaChange(valor: String){
        _uiState.value = _uiState.value.copy(
            valorConta = valor,
            mensagemErro = null,
            mensagemComplementar = null
        )
    }
    fun onPercentualGorjetaChange(valor: String){
        _uiState.value = _uiState.value.copy(
            percentualGorjeta = valor,
            mensagemErro = null,
            mensagemComplementar = null
        )
    }
    fun onNumeroPessoasChange(valor: String){
        _uiState.value = _uiState.value.copy(
            numeroPessoas = valor,
            mensagemErro = null,
            mensagemComplementar = null
        )
    }
    fun calcular() {
        val valorConta1 = _uiState.value.valorConta.toDoubleOrNull()
        val percentualGorjeta1 = _uiState.value.percentualGorjeta.toDoubleOrNull()
        val numeroPessoas1 = _uiState.value.numeroPessoas.toIntOrNull()

        if (valorConta1 == null || percentualGorjeta1 == null || numeroPessoas1 == null) {
            _uiState.value = _uiState.value.copy(
                valorTotal = null,
                valorGorjeta = null,
                valorPorPessoa = null,
                mensagemErro = "Preencha todos os campos com valores válidos.",
                mensagemComplementar = null
            )
            return
        }
        if (valorConta1 <= 0) {
            _uiState.value = _uiState.value.copy(
                valorTotal = null,
                valorGorjeta = null,
                valorPorPessoa = null,
                mensagemErro = "O valor da conta deve ser maior que zero.",
                mensagemComplementar = null
            )
            return
        }
        if (numeroPessoas1 < 1) {
            _uiState.value = _uiState.value.copy(
                valorTotal = null,
                valorGorjeta = null,
                valorPorPessoa = null,
                mensagemErro = "Informe ao menos 1 pessoa.",
                mensagemComplementar = null
            )
            return
        }
        if (percentualGorjeta1 < 0) {
            _uiState.value = _uiState.value.copy(
                valorTotal = null,
                valorGorjeta = null,
                valorPorPessoa = null,
                mensagemErro = "O percentual de gorjeta não pode ser negativo.",
                mensagemComplementar = null
            )
            return
        }
        val valorGorjeta1 = valorConta1 * (percentualGorjeta1 / 100)
        val valorTotal1 = valorGorjeta1 + valorConta1
        val valorPorPessoa1 = valorTotal1 / numeroPessoas1

        _uiState.value = _uiState.value.copy(
            valorGorjeta = valorGorjeta1,
            valorTotal = valorTotal1,
            valorPorPessoa = valorPorPessoa1,
            mensagemErro = null,
            mensagemComplementar = if (percentualGorjeta1 >= 20) {
                "Gorjeta generosa!"
            } else {
                null
            }
        )
    }
}
