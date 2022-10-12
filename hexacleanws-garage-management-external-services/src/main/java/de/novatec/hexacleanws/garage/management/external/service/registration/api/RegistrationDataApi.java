package de.novatec.hexacleanws.garage.management.external.service.registration.api;

import de.novatec.hexacleanws.garage.management.external.service.registration.ApiClient;
import de.novatec.hexacleanws.garage.management.external.service.registration.model.RegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-26T11:12:37.120286+02:00[Europe/Berlin]")
public class RegistrationDataApi {
    private ApiClient apiClient;

    public RegistrationDataApi() {
        this(new ApiClient());
    }

    @Autowired
    public RegistrationDataApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Mono<RegistrationDto> getRegistrationData(String xApplicationName, String xTrackingId, String customerId, String vin) throws WebClientResponseException {
        ParameterizedTypeReference<RegistrationDto> localVarReturnType = new ParameterizedTypeReference<RegistrationDto>() {
        };
        return null;
    }

}
