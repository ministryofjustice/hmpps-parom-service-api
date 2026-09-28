package uk.gov.justice.digital.hmpps.paromserviceapi.model

import jakarta.validation.constraints.Pattern

data class InitialiseParom(
  @field:Pattern(regexp = "^[A-Z][0-9]{6}")
  val crn: String,
)
