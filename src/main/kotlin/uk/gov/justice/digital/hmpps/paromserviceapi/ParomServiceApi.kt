package uk.gov.justice.digital.hmpps.paromserviceapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ParomServiceApi

fun main(args: Array<String>) {
  runApplication<ParomServiceApi>(*args)
}
