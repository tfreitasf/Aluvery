package br.com.povengenharia.aluvery.sampledata

import br.com.povengenharia.aluvery.R
import br.com.povengenharia.aluvery.model.Product
import java.math.BigDecimal

val sampleProducts = listOf(
    Product(
        name = "Hamburguer",
        price = BigDecimal("12.99"),
        image = R.drawable.burger
    ),
    Product(
        name = "Pizza",
        price = BigDecimal("49.99"),
        image = R.drawable.pizza
    ),
    Product(
        name = "Batata frita",
        price = BigDecimal("8.99"),
        image = R.drawable.fries
    )
)