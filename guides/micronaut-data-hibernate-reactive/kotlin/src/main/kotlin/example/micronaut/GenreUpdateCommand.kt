package example.micronaut

import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.constraints.NotBlank

@Serdeable // <1>
class GenreUpdateCommand(var id: Long, @field:NotBlank var name: String)