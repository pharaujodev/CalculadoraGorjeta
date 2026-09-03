package com.example.calculadoragorjeta.ui.screens

data class GorjetaUiState (
    val valorConta: String = "",
    val percentualGorjeta: String = "",
    val numeroPessoas: String = "",
    val valorGorjeta: Double? = null,
    val valorTotal: Double? = null,
    val valorPorPessoa: Double? = null,
    val mensagemErro: String? = null,
    val mensagemComplementar: String? = null
)
