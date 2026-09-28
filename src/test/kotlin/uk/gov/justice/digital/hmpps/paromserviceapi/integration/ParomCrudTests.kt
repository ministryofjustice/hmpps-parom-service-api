package uk.gov.justice.digital.hmpps.paromserviceapi.integration

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import uk.gov.justice.digital.hmpps.paromserviceapi.model.Parom
import uk.gov.justice.digital.hmpps.paromserviceapi.repository.ParomRepository
import java.time.ZoneId
import java.time.ZonedDateTime

class ParomCrudTests : IntegrationTestBase() {

  @Autowired
  private lateinit var paromRepository: ParomRepository

  @Test
  fun `should create a PAROM record`() {
    webTestClient.post().uri("/parom").headers(setAuthorisation(roles = listOf("ROLE_PAROM__RW")))
      .bodyValue(Parom(crn = "X000001")).exchange().expectStatus().isCreated

    val parom = paromRepository.findByCrn("X000001").single()
    assertThat(parom.crn).isEqualTo("X000001")
    assertThat(parom.id).isNotNull()
    assertThat(parom.terminated).isFalse()
  }

  @Test
  fun `should fail to create if the crn is too long`() {
    webTestClient.post().uri("/parom").headers(setAuthorisation(roles = listOf("ROLE_PAROM__RW")))
      .bodyValue(Parom(crn = "X000001123456789123456")).exchange().expectStatus().isBadRequest.expectBody()
      .jsonPath("$.userMessage").isEqualTo("""Field: crn - must match "^[A-Z][0-9]{6}"""")
  }

  @Test
  fun `should update a PAROM record`() {
    val terminatedAt = ZonedDateTime.now(ZoneId.of("Europe/London")).withNano(0)

    webTestClient.post().uri("/parom").headers(setAuthorisation(roles = listOf("ROLE_PAROM__RW")))
      .bodyValue(Parom(crn = "X000002")).exchange().expectStatus().isCreated

    val parom = paromRepository.findByCrn("X000002").single()
    assertThat(parom.crn).isEqualTo("X000002")

    val paromBody = Parom(
      crn = "X000002",
      basicDetailsSaved = true,
      terminated = true,
      terminatedUnterminatedDate = terminatedAt,
    )

    webTestClient.put().uri("/parom/" + parom.id).headers(setAuthorisation(roles = listOf("ROLE_PAROM__RW")))
      .bodyValue(paromBody).exchange().expectStatus().isOk

    val updatedParom = paromRepository.findByCrn("X000002").single()
    assertThat(updatedParom.crn).isEqualTo("X000002")
    assertThat(updatedParom.basicDetailsSaved).isEqualTo(true)
    assertThat(updatedParom.terminated).isTrue()
    assertThat(updatedParom.terminatedUnterminatedDate).isEqualTo(terminatedAt)
  }

  @Test
  fun `should delete a Parom record`() {
    webTestClient.post().uri("/parom").headers(setAuthorisation(roles = listOf("ROLE_PAROM__RW")))
      .bodyValue(Parom(crn = "X000004")).exchange().expectStatus().isCreated

    val parom = paromRepository.findByCrn("X000004")
    assertThat(parom.first().crn).isEqualTo("X000004")
    assertThat(parom.first().id).isNotNull()

    webTestClient.delete().uri("/parom/" + parom.first().id).headers(setAuthorisation(roles = listOf("ROLE_PAROM__RW")))
      .exchange().expectStatus().isOk

    assertThat(paromRepository.findById(parom.first().id)).isEmpty
  }
}
