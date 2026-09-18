package uk.gov.justice.digital.hmpps.paromserviceapi.listener

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.awspring.cloud.sqs.annotation.SqsListener
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import uk.gov.justice.digital.hmpps.paromserviceapi.model.DomainEventsMessage
import uk.gov.justice.digital.hmpps.paromserviceapi.service.NDeliusIntegrationService
import uk.gov.justice.digital.hmpps.paromserviceapi.service.ParomService
import kotlin.text.get

@Service
class DomainEventsListener(
  private val paromService: ParomService,
  private val objectMapper: ObjectMapper,
  private val nDeliusIntegrationService: NDeliusIntegrationService,
) {

  @Transactional
  @SqsListener("hmppsparomqueue", factory = "hmppsQueueContainerFactoryProxy")
  fun listen(msg: String) {
    val (message, attributes) = objectMapper.readValue<SQSMessage>(msg)
    val domainEventMessage = objectMapper.readValue<DomainEventsMessage>(message)
    handleMessage(domainEventMessage)
  }

  private fun handleMessage(message: DomainEventsMessage) {
    when (message.eventType) {
      // TODO
    }
  }
}

data class SQSMessage(
  @JsonProperty("Message") val message: String,
  @JsonProperty("MessageAttributes") val attributes: MessageAttributes = MessageAttributes(),
)

data class MessageAttributes(
  @JsonAnyGetter @JsonAnySetter private val attributes: MutableMap<String, MessageAttribute> = mutableMapOf(),
) : MutableMap<String, MessageAttribute> by attributes {

  val eventType = attributes[EVENT_TYPE_KEY]?.value

  companion object {
    private const val EVENT_TYPE_KEY = "eventType"
  }
}

data class MessageAttribute(@JsonProperty("Type") val type: String, @JsonProperty("Value") val value: String)
