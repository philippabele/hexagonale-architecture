package de.novatec.hexacleanws.garage.management.external.service.masterdata.api;

import de.novatec.hexacleanws.garage.management.external.service.masterdata.ApiClient;
import de.novatec.hexacleanws.garage.management.external.service.masterdata.model.VehicleMasterdataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.UUID;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-26T11:12:37.615930+02:00[Europe/Berlin]")
public class VehicleMasterDataApi {

    private ApiClient apiClient;

    public VehicleMasterDataApi() {
        this(new ApiClient());
    }

    @Autowired
    public VehicleMasterDataApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Mono<VehicleMasterdataResponse> vehicledataGet(UUID xTrackingId, String xApplicationName, String vin, String fin) throws WebClientResponseException {
        ParameterizedTypeReference<VehicleMasterdataResponse> localVarReturnType = new ParameterizedTypeReference<VehicleMasterdataResponse>() {
        };
        return null;
    }

}
