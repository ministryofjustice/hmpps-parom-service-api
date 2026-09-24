package uk.gov.justice.digital.hmpps.paromserviceapi.model

import java.time.ZonedDateTime
import java.util.UUID

data class ProgrammeIntervention(
  val id: UUID? = null,
  var nameOfProgramme: String? = null,
  var dateCompleted: ZonedDateTime? = null,
  var postProgrammeReport: Boolean? = null,
)
