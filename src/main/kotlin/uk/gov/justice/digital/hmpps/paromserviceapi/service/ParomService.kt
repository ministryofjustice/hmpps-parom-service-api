package uk.gov.justice.digital.hmpps.paromserviceapi.service

import org.springframework.stereotype.Service
import uk.gov.justice.digital.hmpps.paromserviceapi.entity.ParomEntity
import uk.gov.justice.digital.hmpps.paromserviceapi.model.Parom
import uk.gov.justice.digital.hmpps.paromserviceapi.repository.ParomRepository

@Service
class ParomService(
  private val paromRepository: ParomRepository,
) {
  private fun Parom.toEntity(existingEntity: ParomEntity? = null): ParomEntity = existingEntity?.copy(
    crn = crn,
    titleAndFullName = titleAndFullName,
    dateOfForm = dateOfForm,
    sheetSentBy = sheetSentBy,
  ) ?: ParomEntity(
    crn = crn,
    titleAndFullName = titleAndFullName,
    dateOfForm = dateOfForm,
    sheetSentBy = sheetSentBy,
  )

  private fun ParomEntity.toModel(): Parom = Parom(
    crn = crn,
    titleAndFullName = titleAndFullName,
    dateOfForm = dateOfForm,
    sheetSentBy = sheetSentBy,
  )
}