/*
 * Vehicle Master Data API
 * This specification describes the REST API for the Vehicle Master Data API provided by Vehicle Data Cache (VDC).
 *
 * The version of the OpenAPI document: 5.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package de.novatec.hexacleanws.garage.management.external.service.masterdata.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * List of number (Sachnummer) of the Software installed on a control unit.
 */
@ApiModel(description = "List of number (Sachnummer) of the Software installed on a control unit.")
@JsonPropertyOrder({
        InstalledSoftware.JSON_PROPERTY_SW_NUMBER
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-26T11:12:37.615930+02:00[Europe/Berlin]")
public class InstalledSoftware {
    public static final String JSON_PROPERTY_SW_NUMBER = "swNumber";
    private String swNumber;

    public InstalledSoftware() {
    }

    public InstalledSoftware swNumber(String swNumber) {

        this.swNumber = swNumber;
        return this;
    }

    /**
     * Get swNumber
     *
     * @return swNumber
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_SW_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSwNumber() {
        return swNumber;
    }


    @JsonProperty(JSON_PROPERTY_SW_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSwNumber(String swNumber) {
        this.swNumber = swNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InstalledSoftware installedSoftware = (InstalledSoftware) o;
        return Objects.equals(this.swNumber, installedSoftware.swNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(swNumber);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InstalledSoftware {\n");
        sb.append("    swNumber: ").append(toIndentedString(swNumber)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
