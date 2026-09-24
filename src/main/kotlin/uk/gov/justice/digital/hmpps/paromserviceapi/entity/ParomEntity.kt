package uk.gov.justice.digital.hmpps.paromserviceapi.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
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
@Table(name = "parom")
@EntityListeners(AuditingEntityListener::class)
data class ParomEntity(
  @Id
  val id: UUID = UUID.randomUUID(),
  var crn: String,
  var terminated: Boolean? = null,
  var terminatedUnterminatedDate: ZonedDateTime? = null,

  var basicDetailsSaved: Boolean? = null,
  var mentalHealthSaved: Boolean? = null,
  var prisonerContactSaved: Boolean? = null,
  var attitudesSaved: Boolean? = null,
  var victimsSaved: Boolean? = null,
  var opdAndProgrammesSaved: Boolean? = null,
  var mappaAndPlansSaved: Boolean? = null,
  var professionalOpinionsSaved: Boolean? = null,
  var ippdppSaved: Boolean? = null,
  var memberCaseAssessmentSaved: Boolean? = null,
  var conclusionSaved: Boolean? = null,
  var signOffSaved: Boolean? = null,

  var titleAndFullName: String? = null,
  var reportDate: LocalDateTime? = null,
  var nomisNumber: String? = null,
  var prisonNumber: String? = null,
  var paroleEligibilityDate: LocalDateTime? = null,
  var communityOffenderManager: String? = null,
  var dateAppointed: LocalDateTime? = null,
  var completingTheForm: String? = null,
  @Column(name = "position")
  var position: String? = null,

  var mentalHealthConcerns: String? = null,
  var mentalCapacityConcerns: String? = null,
  var opdPathway: Boolean? = null,

  var knowledgeOfPrisoner: String? = null,
  var prisonersFamily: String? = null,
  var prisonerAgencies: String? = null,

  var attitudeToIndexOffences: String? = null,
  var attitudeToPreviousOffences: String? = null,

  var victimContactScheme: Boolean? = null,
  var liaisonOfficerContactDate: LocalDateTime? = null,
  var victimPersonalStatement: Boolean? = null,

  var custodialBehaviour: String? = null,
  var programmesInterventions: String? = null,
  var impactOfInterventions: String? = null,

  var mappaCategory: String? = null,
  var mappaLevel: String? = null,
  var resettlementPlan: String? = null,
  var supervisionPlan: String? = null,
  var proposedLicenseConditions: String? = null,
  var riskOfAbsconding: String? = null,

  var ippTerminationCase: Boolean? = null,
  var ippRecommendation: String? = null,

  var reportAuthorsProfessionalOpinion: String? = null,
  var professionalOpinion: String? = null,
  var confirmViewedReport: Boolean? = null,
  var testConsiderationOpenConditions: Boolean? = null,

  var licenceTerminationCase: Boolean? = null,
  var assessmentOralConsiderations: String? = null,

  var previousConvictions: Boolean? = null,
  var cpsDocuments: Boolean? = null,
  var sentencersComments: Boolean? = null,
  var paroleCaseRecords: Boolean? = null,
  var paroleDossier: Boolean? = null,
  var paroleCustodyReport: Boolean? = null,
  var other: Boolean? = null,
  var reportAssessmentsDirections: String? = null,
  var limitationsToSourcesProvided: Boolean? = null,
  var limitationsDetails: String? = null,
  var qualityOfInformation: Boolean? = null,
  var oasysManagementPlan: Boolean? = null,
  var paroleBoardReport: Boolean? = null,

  var psRegion: String? = null,
  var pdu: String? = null,
  var emailAddress: String? = null,
  var contactTelephoneNumber: String? = null,

  @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, mappedBy = "parom")
  val programmeInterventionList: MutableList<ProgrammeInterventionEntity> = mutableListOf(),
  @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, mappedBy = "parom")
  val signatoryList: MutableList<SignatoryEntity> = mutableListOf(),

  @CreatedBy
  var createdByUser: String? = null,
  @CreatedDate
  var createdDatetime: LocalDateTime? = null,
  @LastModifiedBy
  var lastUpdatedUser: String? = null,
  @LastModifiedDate
  var lastUpdatedDatetime: LocalDateTime? = null,
)
