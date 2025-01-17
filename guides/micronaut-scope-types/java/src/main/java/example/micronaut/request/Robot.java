package example.micronaut.request;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpRequest;
import io.micronaut.runtime.http.scope.RequestAware;
import io.micronaut.runtime.http.scope.RequestScope;
import java.util.Objects;

@RequestScope // <1>
public class Robot implements RequestAware { // <2>
    @NonNull
    private String serialNumber;

    @NonNull
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public void setRequest(HttpRequest<?> request) {
        this.serialNumber = Objects.requireNonNull(request.getHeaders().get("UUID"));
    }
}
