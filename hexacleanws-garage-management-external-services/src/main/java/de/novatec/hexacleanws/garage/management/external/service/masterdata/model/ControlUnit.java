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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Control units
 */
@ApiModel(description = "Control units")
@JsonPropertyOrder({
        ControlUnit.JSON_PROPERTY_CODING_ID,
        ControlUnit.JSON_PROPERTY_SERIAL_NUMBER,
        ControlUnit.JSON_PROPERTY_HW_NUMBER,
        ControlUnit.JSON_PROPERTY_CU_DESIGNATION,
        ControlUnit.JSON_PROPERTY_TYPE_OF,
        ControlUnit.JSON_PROPERTY_INSTALLED_SOFTWARE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-26T11:12:37.615930+02:00[Europe/Berlin]")
public class ControlUnit {
    public static final String JSON_PROPERTY_CODING_ID = "codingId";
    private String codingId;

    public static final String JSON_PROPERTY_SERIAL_NUMBER = "serialNumber";
    private String serialNumber;

    public static final String JSON_PROPERTY_HW_NUMBER = "hwNumber";
    private String hwNumber;

    public static final String JSON_PROPERTY_CU_DESIGNATION = "cuDesignation";
    private String cuDesignation;

    public static final String JSON_PROPERTY_TYPE_OF = "typeOf";
    private String typeOf;

    public static final String JSON_PROPERTY_INSTALLED_SOFTWARE = "installedSoftware";
    private List<InstalledSoftware> installedSoftware = new ArrayList<>();

    public ControlUnit() {
    }

    public ControlUnit codingId(String codingId) {

        this.codingId = codingId;
        return this;
    }

    /**
     * The coding id of the control unit.
     *
     * @return codingId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The coding id of the control unit.")
    @JsonProperty(JSON_PROPERTY_CODING_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCodingId() {
        return codingId;
    }


    @JsonProperty(JSON_PROPERTY_CODING_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCodingId(String codingId) {
        this.codingId = codingId;
    }


    public ControlUnit serialNumber(String serialNumber) {

        this.serialNumber = serialNumber;
        return this;
    }

    /**
     * Get serialNumber
     *
     * @return serialNumber
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_SERIAL_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSerialNumber() {
        return serialNumber;
    }


    @JsonProperty(JSON_PROPERTY_SERIAL_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }


    public ControlUnit hwNumber(String hwNumber) {

        this.hwNumber = hwNumber;
        return this;
    }

    /**
     * Get hwNumber
     *
     * @return hwNumber
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_HW_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getHwNumber() {
        return hwNumber;
    }


    @JsonProperty(JSON_PROPERTY_HW_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setHwNumber(String hwNumber) {
        this.hwNumber = hwNumber;
    }


    public ControlUnit cuDesignation(String cuDesignation) {

        this.cuDesignation = cuDesignation;
        return this;
    }

    /**
     * Get cuDesignation
     *
     * @return cuDesignation
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_CU_DESIGNATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCuDesignation() {
        return cuDesignation;
    }


    @JsonProperty(JSON_PROPERTY_CU_DESIGNATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCuDesignation(String cuDesignation) {
        this.cuDesignation = cuDesignation;
    }


    public ControlUnit typeOf(String typeOf) {

        this.typeOf = typeOf;
        return this;
    }

    /**
     * Get typeOf
     *
     * @return typeOf
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_TYPE_OF)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTypeOf() {
        return typeOf;
    }


    @JsonProperty(JSON_PROPERTY_TYPE_OF)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTypeOf(String typeOf) {
        this.typeOf = typeOf;
    }


    public ControlUnit installedSoftware(List<InstalledSoftware> installedSoftware) {

        this.installedSoftware = installedSoftware;
        return this;
    }

    public ControlUnit addInstalledSoftwareItem(InstalledSoftware installedSoftwareItem) {
        this.installedSoftware.add(installedSoftwareItem);
        return this;
    }

    /**
     * Get installedSoftware
     *
     * @return installedSoftware
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_INSTALLED_SOFTWARE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<InstalledSoftware> getInstalledSoftware() {
        return installedSoftware;
    }


    @JsonProperty(JSON_PROPERTY_INSTALLED_SOFTWARE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setInstalledSoftware(List<InstalledSoftware> installedSoftware) {
        this.installedSoftware = installedSoftware;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ControlUnit controlUnit = (ControlUnit) o;
        return Objects.equals(this.codingId, controlUnit.codingId) &&
                Objects.equals(this.serialNumber, controlUnit.serialNumber) &&
                Objects.equals(this.hwNumber, controlUnit.hwNumber) &&
                Objects.equals(this.cuDesignation, controlUnit.cuDesignation) &&
                Objects.equals(this.typeOf, controlUnit.typeOf) &&
                Objects.equals(this.installedSoftware, controlUnit.installedSoftware);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codingId, serialNumber, hwNumber, cuDesignation, typeOf, installedSoftware);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ControlUnit {\n");
        sb.append("    codingId: ").append(toIndentedString(codingId)).append("\n");
        sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
        sb.append("    hwNumber: ").append(toIndentedString(hwNumber)).append("\n");
        sb.append("    cuDesignation: ").append(toIndentedString(cuDesignation)).append("\n");
        sb.append("    typeOf: ").append(toIndentedString(typeOf)).append("\n");
        sb.append("    installedSoftware: ").append(toIndentedString(installedSoftware)).append("\n");
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
