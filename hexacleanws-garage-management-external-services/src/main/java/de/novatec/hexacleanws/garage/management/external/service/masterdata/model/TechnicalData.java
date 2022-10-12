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
 * The technical data of vehicle with origin
 */
@ApiModel(description = "The technical data of vehicle with origin")
@JsonPropertyOrder({
        TechnicalData.JSON_PROPERTY_TEXT_VALUE,
        TechnicalData.JSON_PROPERTY_TECHNICAL_DATA_TYPE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-26T11:12:37.615930+02:00[Europe/Berlin]")
public class TechnicalData {
    public static final String JSON_PROPERTY_TEXT_VALUE = "textValue";
    private String textValue;

    public static final String JSON_PROPERTY_TECHNICAL_DATA_TYPE = "technicalDataType";
    private String technicalDataType;

    public TechnicalData() {
    }

    public TechnicalData textValue(String textValue) {

        this.textValue = textValue;
        return this;
    }

    /**
     * Get textValue
     *
     * @return textValue
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_TEXT_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTextValue() {
        return textValue;
    }


    @JsonProperty(JSON_PROPERTY_TEXT_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }


    public TechnicalData technicalDataType(String technicalDataType) {

        this.technicalDataType = technicalDataType;
        return this;
    }

    /**
     * Get technicalDataType
     *
     * @return technicalDataType
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_TECHNICAL_DATA_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTechnicalDataType() {
        return technicalDataType;
    }


    @JsonProperty(JSON_PROPERTY_TECHNICAL_DATA_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTechnicalDataType(String technicalDataType) {
        this.technicalDataType = technicalDataType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TechnicalData technicalData = (TechnicalData) o;
        return Objects.equals(this.textValue, technicalData.textValue) &&
                Objects.equals(this.technicalDataType, technicalData.technicalDataType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textValue, technicalDataType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TechnicalData {\n");
        sb.append("    textValue: ").append(toIndentedString(textValue)).append("\n");
        sb.append("    technicalDataType: ").append(toIndentedString(technicalDataType)).append("\n");
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

