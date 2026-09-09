package uk.gov.justice.digital.hmpps.paromserviceapi.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uk.gov.justice.digital.hmpps.paromserviceapi.service.ParomService

@Validated
@RestController
@PreAuthorize("hasRole('ROLE_PAROM__RW')")
@RequestMapping(value = ["/parom"], produces = ["application/json"])
class ParomController(
  private val paromService: ParomService,
)
