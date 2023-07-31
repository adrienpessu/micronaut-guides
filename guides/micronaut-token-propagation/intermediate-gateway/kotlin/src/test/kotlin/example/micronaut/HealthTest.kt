package example.micronaut

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.HttpStatus.OK
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@MicronautTest
class HealthTest(@Client("/") val client: HttpClient) {

    @Test
    fun healthEndpointExposed() {
        val status = client.toBlocking().retrieve(HttpRequest.GET<Any>("/health"), HttpStatus::class.java)
        assertEquals(OK, status)
    }
}
