package uk.gov.justice.digital.hmpps.paromserviceapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import uk.gov.justice.digital.hmpps.paromserviceapi.entity.ParomEntity
import java.util.UUID

@Repository
interface ParomRepository : JpaRepository<ParomEntity, UUID>
