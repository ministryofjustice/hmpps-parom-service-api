package uk.gov.justice.digital.hmpps.paromserviceapi.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import uk.gov.justice.digital.hmpps.paromserviceapi.model.InitialiseParom
import uk.gov.justice.digital.hmpps.paromserviceapi.model.Parom
import uk.gov.justice.digital.hmpps.paromserviceapi.service.ParomService
import uk.gov.justice.digital.hmpps.paromserviceapi.service.SnsService
import uk.gov.justice.hmpps.kotlin.common.ErrorResponse
import java.util.UUID

@Validated
@RestController
@PreAuthorize("hasRole('ROLE_PAROM__RW')")
@RequestMapping(value = ["/parom"], produces = ["application/json"])
class ParomController(
  private val paromService: ParomService,
  private val snsService: SnsService,
) {
  @GetMapping("/{uuid}")
  @Operation(
    summary = "Retrieve a PAROM record by uuid",
    description = "Calls through the PAROM service to retrieve PAROM record",
    security = [SecurityRequirement(name = "parom-api-ui-role")],
    responses = [
      ApiResponse(responseCode = "200", description = "PAROM record returned"),
      ApiResponse(
        responseCode = "401",
        description = "Unauthorized to access this endpoint",
        content = [Content(mediaType = "application/json", schema = Schema(implementation = ErrorResponse::class))],
      ),
      ApiResponse(
        responseCode = "403",
        description = "Forbidden to access this endpoint",
        content = [Content(mediaType = "application/json", schema = Schema(implementation = ErrorResponse::class))],
      ),
    ],
  )
  fun getParomById(@PathVariable uuid: UUID): Parom? = paromService.getParomById(uuid)

  @PostMapping
  @Operation(
    summary = "Initialises a PAROM record",
    description = "Calls the API to initialise a PAROM record",
    security = [SecurityRequirement(name = "parom-api-ui-role")],
    responses = [
      ApiResponse(responseCode = "201", description = "PAROM record created"),
      ApiResponse(
        responseCode = "401",
        description = "Unauthorized to access this endpoint",
        content = [Content(mediaType = "application/json", schema = Schema(implementation = ErrorResponse::class))],
      ),
      ApiResponse(
        responseCode = "403",
        description = "Forbidden to access this endpoint",
        content = [Content(mediaType = "application/json", schema = Schema(implementation = ErrorResponse::class))],
      ),
    ],
  )
  @ResponseStatus(HttpStatus.CREATED)
  fun initialiseParom(@Valid @RequestBody initialiseParom: InitialiseParom) = paromService.initialiseParom(initialiseParom)

  @PutMapping("/{id}")
  @Operation(
    summary = "Update a PAROM record",
    description = "Calls through the PAROM service to update a PAROM record",
    security = [SecurityRequirement(name = "parom-api-ui-role")],
    responses = [
      ApiResponse(responseCode = "200", description = "Parom record updated"),
      ApiResponse(
        responseCode = "400",
        description = "cant change the CRN on an update",
        content = [Content(mediaType = "application/json", schema = Schema(implementation = ErrorResponse::class))],
      ),
      ApiResponse(
        responseCode = "401",
        description = "Unauthorized to access this endpoint",
        content = [Content(mediaType = "application/json", schema = Schema(implementation = ErrorResponse::class))],
      ),
      ApiResponse(
        responseCode = "403",
        description = "Forbidden to access this endpoint",
        content = [Content(mediaType = "application/json", schema = Schema(implementation = ErrorResponse::class))],
      ),
      ApiResponse(
        responseCode = "404",
        description = "The PAROM id was not found",
        content = [Content(mediaType = "application/json", schema = Schema(implementation = ErrorResponse::class))],
      ),
    ],
  )
  fun updateParom(@PathVariable id: UUID, @RequestBody parom: Parom) {
    paromService.updateParom(id, parom)
  }

  @DeleteMapping("/{id}")
  @Operation(
    summary = "Delete a PAROM record",
    description = "Calls through the PAROM service to delete a PAROM record",
    security = [SecurityRequirement(name = "parom-api-ui-role")],
    responses = [
      ApiResponse(responseCode = "200", description = "PAROM record deleted"),
      ApiResponse(
        responseCode = "401",
        description = "Unauthorized to access this endpoint",
        content = [Content(mediaType = "application/json", schema = Schema(implementation = ErrorResponse::class))],
      ),
      ApiResponse(
        responseCode = "403",
        description = "Forbidden to access this endpoint",
        content = [Content(mediaType = "application/json", schema = Schema(implementation = ErrorResponse::class))],
      ),
      ApiResponse(
        responseCode = "404",
        description = "The PAROM id was not found",
        content = [Content(mediaType = "application/json", schema = Schema(implementation = ErrorResponse::class))],
      ),
    ],
  )
  fun deleteParom(@PathVariable id: UUID) {
    val crn = paromService.deleteParom(id)
    snsService.sendDeleteDomainEvent(crn, id)
  }
}
