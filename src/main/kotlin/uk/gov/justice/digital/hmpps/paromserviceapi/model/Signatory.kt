package uk.gov.justice.digital.hmpps.paromserviceapi.model

import java.time.ZonedDateTime
import java.util.UUID

data class Signatory(
  val id: UUID? = null,
  var forename: String? = null,
  var surname: String? = null,
  var username: String? = null,
  var emailAddress: String? = null,
  var region: String? = null,
  var telephoneNumber: String? = null,
  var signatoryLevel: SignatoryLevel? = null,
  var signed: Boolean? = null,
  var signatureDate: ZonedDateTime? = null,
)
