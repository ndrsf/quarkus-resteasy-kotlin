package de.apwolf.quarkus_resteasy_kotlin.restadapter

import java.time.LocalDate

data class CustomerRequest(var id: Int?, val name: String, val birthday: LocalDate)
