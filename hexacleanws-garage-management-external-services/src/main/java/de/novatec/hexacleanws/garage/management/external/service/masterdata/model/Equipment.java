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
 * Equipment codes with origin.
 */
@ApiModel(description = "Equipment codes with origin.")
@JsonPropertyOrder({
        Equipment.JSON_PROPERTY_CODE,
        Equipment.JSON_PROPERTY_ORIGIN,
        Equipment.JSON_PROPERTY_DESCRIPTION
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-26T11:12:37.615930+02:00[Europe/Berlin]")
public class Equipment {
    public static final String JSON_PROPERTY_CODE = "code";
    private String code;

    public static final String JSON_PROPERTY_ORIGIN = "origin";
    private String origin;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public Equipment() {
    }

    public Equipment code(String code) {

        this.code = code;
        return this;
    }

    /**
     * Get code
     *
     * @return code
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCode() {
        return code;
    }


    @JsonProperty(JSON_PROPERTY_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCode(String code) {
        this.code = code;
    }


    public Equipment origin(String origin) {

        this.origin = origin;
        return this;
    }

    /**
     * Get origin
     *
     * @return origin
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ORIGIN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getOrigin() {
        return origin;
    }


    @JsonProperty(JSON_PROPERTY_ORIGIN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setOrigin(String origin) {
        this.origin = origin;
    }


    public Equipment description(String description) {

        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }


    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Equipment equipment = (Equipment) o;
        return Objects.equals(this.code, equipment.code) &&
                Objects.equals(this.origin, equipment.origin) &&
                Objects.equals(this.description, equipment.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, origin, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Equipment {\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
