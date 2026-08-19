package uk.gov.justice.digital.hmpps.paromserviceapi.model

import jakarta.validation.constraints.Pattern
import java.time.LocalDate

data class Parom(
  @field:Pattern(regexp = "^[A-Z][0-9]{6}")
  var crn: String,
  var titleAndFullName: String? = null,
  var dateOfForm: LocalDate? = null,
  var sheetSentBy: String? = null,
)
