package uk.gov.justice.digital.hmpps.paromserviceapi.entity

import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.util.UUID

@Entity
@Table(name = "signatory")
@EntityListeners(AuditingEntityListener::class)
data class SignatoryEntity(
  @Id
  val id: UUID = UUID.randomUUID(),
  @ManyToOne
  @JoinColumn(name = "parom_id")
  var parom: ParomEntity? = null,
  var forename: String? = null,
  var surname: String? = null,
  var username: String? = null,
  var emailAddress: String? = null,
  var region: String? = null,
  var telephoneNumber: String? = null,
  // Validated against SignatoryLevel in the service layer; not DB-constrained.
  var signatoryLevel: String? = null,
  var signed: Boolean? = null,
  var signatureDate: ZonedDateTime? = null,
  @CreatedBy
  var createdByUser: String? = null,
  @CreatedDate
  var createdDatetime: LocalDateTime? = null,
  @LastModifiedBy
  var lastUpdatedUser: String? = null,
  @LastModifiedDate
  var lastUpdatedDatetime: LocalDateTime? = null,
)
