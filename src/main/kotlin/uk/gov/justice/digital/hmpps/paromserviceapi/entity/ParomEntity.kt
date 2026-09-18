package uk.gov.justice.digital.hmpps.paromserviceapi.entity

import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "parom")
@EntityListeners(AuditingEntityListener::class)
data class ParomEntity(
  @Id
  val id: UUID = UUID.randomUUID(),
  var crn: String,
  var titleAndFullName: String? = null,
  var dateOfForm: LocalDate? = null,
  var sheetSentBy: String? = null,
)
