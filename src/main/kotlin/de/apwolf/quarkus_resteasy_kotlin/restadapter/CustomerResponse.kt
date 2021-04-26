package de.apwolf.quarkus_resteasy_kotlin.restadapter

import java.time.LocalDate

data class CustomerResponse(val id: Int, val name: String, val birthday: LocalDate)