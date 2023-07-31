package example.micronaut.clients;

import example.micronaut.models.User;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

import java.util.List;

@Client("users") // <1>
public interface UsersClient {
    @Get("/users/{id}")
    User getById(int id);

    @Post("/users")
    User createUser(@Body User user);

    @Get("/users")
    List<User> getUsers();
}

