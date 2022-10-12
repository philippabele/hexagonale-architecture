package de.novatec.hexacleanws.garage.management.external.service.customer.api;

import de.novatec.hexacleanws.garage.management.external.service.customer.ApiClient;
import de.novatec.hexacleanws.garage.management.external.service.customer.model.Authorizations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.UUID;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-26T11:12:38.074888+02:00[Europe/Berlin]")
public class CustomerApi {
    private ApiClient apiClient;

    public CustomerApi() {
        this(new ApiClient());
    }

    @Autowired
    public CustomerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Mono<Authorizations> getAuthorizations(UUID xTrackingId, String callerId, String finOrVin, String customerId) throws WebClientResponseException {
        ParameterizedTypeReference<Authorizations> localVarReturnType = new ParameterizedTypeReference<Authorizations>() {
        };
        return null;
    }

}
