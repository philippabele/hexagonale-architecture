/*
 * User API
 * #### Change History | Date | Name | Changes | |------|------|---------| | 13.07.2018  | Johannes Dilli  | Create updateUser in version 2 | | 07.09.2018  | Mathias Köhrer  | Create createUser in version 2 | | 07.09.2018  | Berna Kösem     | Create deleteUser in version 2 | | 07.09.2018  | Miguel Ruiz     | Create getUser in version 2 | | 07.09.2018  | Duygu Kücük     | Add account verification message trigger in version 2 | | 10.09.2018  | Duygu Kücük     | Map Error code 178 as invalid Tax number in updateUser and createUser | | 10.10.2018  | Miguel Ruiz     | Create searchUser operation | | 11.10.2018  | Miguel Ruiz     | Create syncUser operation | | 16.10.2018  | Miguel Ruiz     | Create createUserByCiamId operation | | 17.10.2018  | Miguel Ruiz     | Create searchUsersByWildcards operation | | 22.10.2018  | Timo Freiberg   | Remove X-UserId Header | | 27.11.2018  | Duygu Kücük     | Add optional X-CiamRegistrationUrl header to createUser interface | | 31.01.2019  | Miguel Ruiz     | Create getCiamIdForUserId operation | | 06.06.2019  | Duygu Kücük     | Remove ucId from user profile | | 19.06.2019  | Duygu Kücük     | Add getUserIdForCiamId operation |  ### 1 Introduction   CPD User API.    ### 2 Error Responses  In case of business specific errors resource provider will deliver an standard error response object being described in each resource definition. Intended use of the object is logging only. Please refer to the standardized error response code about additional meta information about the error.  In order to recognize a business error do the following:  * Check if HTTP status code is higher or equal to 400  * Check availability of HTTP Header X-ErrorCode.  ### 3 Error Codes ``` 2 - no user found 5 - The user is not authorized to perform this operation 6 - marketCountryCode header is required 7 - The ciamId does not match the pattern. 99 - CPD encountered an unexpected error. 113 - email already in use 116 - The user is already verified. 139 - mobile phone number already in use 143 - Resource could not be modified, because it was concurrently modified. 144 - The ciamId was not found in CIAM. 146 - The user already exists in CPD. 154 - CPD encountered a timeout while communicating with a backend system. 158 - CPD encountered a validation error from CIAM. 168 - The end-consumer profile was found, but the caller application has no rights to modify it (for example because the profile belongs to another application). 170 - birthday is out of range 174 - The user has not enough permissions to change a field 177 - CPD encountered an unexpected error during communication with a backend system. 178 - tax number is invalid  ```  ### 4 HTTP Status Code Restrictions Resources below define HTTP status codes for business errors (with HTTP-header X-ErrorCode) only. Technical or infrastructure errors are not documented ### 5 Common HTTP Headers Meta information consists of data that is not included in the actual payload, but otherwise required (e.g. for logging, tracing, etc.). Meta information is transferred as HTTP header parameters. The following HTTP headers are relevant for the services defined in this API description:   ##### Request Headers  * `X-TrackingId`: Globally unique id, which allows tracking requests beyond system boundaries. Type 4 (pseudo randomly generated) UUID     + Example 046b6c7f-0b8a-43b9-b35d-6489e6daee91     + following regular expression _[0-9a-fA-F]{8}-?[0-9a-fA-F]{4}-?4[0-9a-fA-F]{3}-?[89abAB][0-9a-fA-F]{3}-?[0-9a-fA-F]{12}_   * `X-ApplicationName`: Used for identifying calling application  * `X-FinOrVin`: FIN or VIN of the vehicle. Must be set if the request path or body contains a FIN or VIN.  * `X-CiamId`: Ciam ID. Must be set if the request path or body contains a Ciam ID.  * `X-MarketCountryCode`: Country code (ISO 3166 ALPHA2) to comply with the Russian Data Localization Law.  * `Cache-Control`: Controls caching of resource responses.  * `Content-Type`: The MIME type of the body of the request. If a body is expected for the request, this header field is mandatory.    ##### Response Headers  * `X-ErrorCode`: Error code for identifying business specific errors  ### 6 Authorization The version 2 of the user API changes the authorization concept. The authenticated consumer still needs the corresponding security role for each request. Only with if the authenticated consumer is in the corresponding security role the call can be successful.  In addition the consumer need a security role for most of the fields or group of fields of the user profile. This roles are independent from the concrete request and are valid for all REST operations listed bellow. The following roles for a user profile exist:  | Role | Fields | -------|--------| | userNamesRestConsumer | firstName, lastName1, lastName2, title, namePrefix, middleInitial, salutationCode| | userEmailRestConsumer | email | | userPhoneRestConsumer | landlinePhone, mobilePhoneNumber | | userAddressRestConsumer | All fields of the address | | userCommunicationPreferencesRestConsumer | All fields of the communication preferences | | userIdentificationRestConsumer | caseNumber, identificationType | | userAccountIdentifierRestConsumer | accountIdentifier | | userAccountVerifiedRestConsumer | accountVerified | | userPreferredLanguageCodeRestConsumer | preferredLanguagecode | | userBirthdayRestConsumer | birthday | | userVipRestConsumer | vip | | userTaxNumberRestConsumer | taxNumber | | userAccountCountryCodeRestConsumer | accountCountryCode | | userIdentificationNumberRestConsumer | identificationNumber |  If a field is not listed in this table, it's accessable for all users, e.g. updatedAt.   A detailed mapping between security roles and REST operations is documented here: https://mcmwiki.detss.corpintra.net/display/MBC/CPD+REST+Service+Security  If the authorization fails, the service request returns with an HTTP `403 Forbidden` error code.  ### 7 Authentication Consumers calling the Mercedes me connect API are authenticated using:   * A SSL client certificate, which is required to establish the HTTPS connection  * A preemptive HTTP Basic authentication using a technical user/password  If the authentication fails, the service request returns with an HTTP `401 Unauthorized` error code.  ### 8 MatterMost Channel    All upcoming changes will be posted on the following mattermost channel. Please join us to be informed early.    * Registration link: https://matter.i.daimler.com/signup_user_complete/?id=y6rcykda4fr7ucbnc9m4fe5joh  * User channel link: https://matter.i.daimler.com/mbc-api/channels/cpd-user-api
 *
 * The version of the OpenAPI document: v2.192.125.9.54
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package de.novatec.hexacleanws.garage.management.external.service.registration.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * UserAddress
 */
@JsonPropertyOrder({
        UserAddress.JSON_PROPERTY_COUNTRY_CODE,
        UserAddress.JSON_PROPERTY_STATE,
        UserAddress.JSON_PROPERTY_PROVINCE,
        UserAddress.JSON_PROPERTY_PLACE_OF_BIRTH,
        UserAddress.JSON_PROPERTY_GENDER_OF_BIRTH,
        UserAddress.JSON_PROPERTY_STREET,
        UserAddress.JSON_PROPERTY_HOUSE_NO,
        UserAddress.JSON_PROPERTY_ZIP_CODE,
        UserAddress.JSON_PROPERTY_CITY,
        UserAddress.JSON_PROPERTY_STREET_TYPE,
        UserAddress.JSON_PROPERTY_HOUSE_NAME,
        UserAddress.JSON_PROPERTY_FLOOR_NO,
        UserAddress.JSON_PROPERTY_DOOR_NO,
        UserAddress.JSON_PROPERTY_ADDRESS_LINE1,
        UserAddress.JSON_PROPERTY_ADDRESS_LINE2,
        UserAddress.JSON_PROPERTY_ADDRESS_LINE3,
        UserAddress.JSON_PROPERTY_POST_OFFICE_BOX
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-26T11:12:37.120286+02:00[Europe/Berlin]")
public class UserAddress {
    public static final String JSON_PROPERTY_COUNTRY_CODE = "countryCode";
    private String countryCode;

    public static final String JSON_PROPERTY_STATE = "state";
    private String state;

    public static final String JSON_PROPERTY_PROVINCE = "province";
    private String province;

    public static final String JSON_PROPERTY_PLACE_OF_BIRTH = "placeOfBirth";
    private String placeOfBirth;

    public static final String JSON_PROPERTY_GENDER_OF_BIRTH = "genderOfBirth";
    private String genderOfBirth;

    public static final String JSON_PROPERTY_STREET = "street";
    private String street;

    public static final String JSON_PROPERTY_HOUSE_NO = "houseNo";
    private String houseNo;

    public static final String JSON_PROPERTY_ZIP_CODE = "zipCode";
    private String zipCode;

    public static final String JSON_PROPERTY_CITY = "city";
    private String city;

    public static final String JSON_PROPERTY_STREET_TYPE = "streetType";
    private String streetType;

    public static final String JSON_PROPERTY_HOUSE_NAME = "houseName";
    private String houseName;

    public static final String JSON_PROPERTY_FLOOR_NO = "floorNo";
    private String floorNo;

    public static final String JSON_PROPERTY_DOOR_NO = "doorNo";
    private String doorNo;

    public static final String JSON_PROPERTY_ADDRESS_LINE1 = "addressLine1";
    private String addressLine1;

    public static final String JSON_PROPERTY_ADDRESS_LINE2 = "addressLine2";
    private String addressLine2;

    public static final String JSON_PROPERTY_ADDRESS_LINE3 = "addressLine3";
    private String addressLine3;

    public static final String JSON_PROPERTY_POST_OFFICE_BOX = "postOfficeBox";
    private String postOfficeBox;

    public UserAddress() {
    }

    public UserAddress countryCode(String countryCode) {

        this.countryCode = countryCode;
        return this;
    }

    /**
     * Get countryCode
     *
     * @return countryCode
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_COUNTRY_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCountryCode() {
        return countryCode;
    }


    @JsonProperty(JSON_PROPERTY_COUNTRY_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    public UserAddress state(String state) {

        this.state = state;
        return this;
    }

    /**
     * Get state
     *
     * @return state
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getState() {
        return state;
    }


    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setState(String state) {
        this.state = state;
    }


    public UserAddress province(String province) {

        this.province = province;
        return this;
    }

    /**
     * Get province
     *
     * @return province
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_PROVINCE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getProvince() {
        return province;
    }


    @JsonProperty(JSON_PROPERTY_PROVINCE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProvince(String province) {
        this.province = province;
    }


    public UserAddress placeOfBirth(String placeOfBirth) {

        this.placeOfBirth = placeOfBirth;
        return this;
    }

    /**
     * Get placeOfBirth
     *
     * @return placeOfBirth
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_PLACE_OF_BIRTH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }


    @JsonProperty(JSON_PROPERTY_PLACE_OF_BIRTH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }


    public UserAddress genderOfBirth(String genderOfBirth) {

        this.genderOfBirth = genderOfBirth;
        return this;
    }

    /**
     * Get genderOfBirth
     *
     * @return genderOfBirth
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_GENDER_OF_BIRTH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getGenderOfBirth() {
        return genderOfBirth;
    }


    @JsonProperty(JSON_PROPERTY_GENDER_OF_BIRTH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGenderOfBirth(String genderOfBirth) {
        this.genderOfBirth = genderOfBirth;
    }


    public UserAddress street(String street) {

        this.street = street;
        return this;
    }

    /**
     * Get street
     *
     * @return street
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_STREET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getStreet() {
        return street;
    }


    @JsonProperty(JSON_PROPERTY_STREET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStreet(String street) {
        this.street = street;
    }


    public UserAddress houseNo(String houseNo) {

        this.houseNo = houseNo;
        return this;
    }

    /**
     * Get houseNo
     *
     * @return houseNo
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_HOUSE_NO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getHouseNo() {
        return houseNo;
    }


    @JsonProperty(JSON_PROPERTY_HOUSE_NO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }


    public UserAddress zipCode(String zipCode) {

        this.zipCode = zipCode;
        return this;
    }

    /**
     * Get zipCode
     *
     * @return zipCode
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ZIP_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getZipCode() {
        return zipCode;
    }


    @JsonProperty(JSON_PROPERTY_ZIP_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    public UserAddress city(String city) {

        this.city = city;
        return this;
    }

    /**
     * Get city
     *
     * @return city
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_CITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCity() {
        return city;
    }


    @JsonProperty(JSON_PROPERTY_CITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCity(String city) {
        this.city = city;
    }


    public UserAddress streetType(String streetType) {

        this.streetType = streetType;
        return this;
    }

    /**
     * Get streetType
     *
     * @return streetType
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_STREET_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getStreetType() {
        return streetType;
    }


    @JsonProperty(JSON_PROPERTY_STREET_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }


    public UserAddress houseName(String houseName) {

        this.houseName = houseName;
        return this;
    }

    /**
     * Get houseName
     *
     * @return houseName
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_HOUSE_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getHouseName() {
        return houseName;
    }


    @JsonProperty(JSON_PROPERTY_HOUSE_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }


    public UserAddress floorNo(String floorNo) {

        this.floorNo = floorNo;
        return this;
    }

    /**
     * Get floorNo
     *
     * @return floorNo
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_FLOOR_NO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFloorNo() {
        return floorNo;
    }


    @JsonProperty(JSON_PROPERTY_FLOOR_NO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }


    public UserAddress doorNo(String doorNo) {

        this.doorNo = doorNo;
        return this;
    }

    /**
     * Get doorNo
     *
     * @return doorNo
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_DOOR_NO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDoorNo() {
        return doorNo;
    }


    @JsonProperty(JSON_PROPERTY_DOOR_NO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }


    public UserAddress addressLine1(String addressLine1) {

        this.addressLine1 = addressLine1;
        return this;
    }

    /**
     * Get addressLine1
     *
     * @return addressLine1
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ADDRESS_LINE1)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAddressLine1() {
        return addressLine1;
    }


    @JsonProperty(JSON_PROPERTY_ADDRESS_LINE1)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }


    public UserAddress addressLine2(String addressLine2) {

        this.addressLine2 = addressLine2;
        return this;
    }

    /**
     * Get addressLine2
     *
     * @return addressLine2
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ADDRESS_LINE2)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAddressLine2() {
        return addressLine2;
    }


    @JsonProperty(JSON_PROPERTY_ADDRESS_LINE2)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }


    public UserAddress addressLine3(String addressLine3) {

        this.addressLine3 = addressLine3;
        return this;
    }

    /**
     * Get addressLine3
     *
     * @return addressLine3
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ADDRESS_LINE3)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAddressLine3() {
        return addressLine3;
    }


    @JsonProperty(JSON_PROPERTY_ADDRESS_LINE3)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }


    public UserAddress postOfficeBox(String postOfficeBox) {

        this.postOfficeBox = postOfficeBox;
        return this;
    }

    /**
     * Get postOfficeBox
     *
     * @return postOfficeBox
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_POST_OFFICE_BOX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPostOfficeBox() {
        return postOfficeBox;
    }


    @JsonProperty(JSON_PROPERTY_POST_OFFICE_BOX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPostOfficeBox(String postOfficeBox) {
        this.postOfficeBox = postOfficeBox;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserAddress userAddress = (UserAddress) o;
        return Objects.equals(this.countryCode, userAddress.countryCode) &&
                Objects.equals(this.state, userAddress.state) &&
                Objects.equals(this.province, userAddress.province) &&
                Objects.equals(this.placeOfBirth, userAddress.placeOfBirth) &&
                Objects.equals(this.genderOfBirth, userAddress.genderOfBirth) &&
                Objects.equals(this.street, userAddress.street) &&
                Objects.equals(this.houseNo, userAddress.houseNo) &&
                Objects.equals(this.zipCode, userAddress.zipCode) &&
                Objects.equals(this.city, userAddress.city) &&
                Objects.equals(this.streetType, userAddress.streetType) &&
                Objects.equals(this.houseName, userAddress.houseName) &&
                Objects.equals(this.floorNo, userAddress.floorNo) &&
                Objects.equals(this.doorNo, userAddress.doorNo) &&
                Objects.equals(this.addressLine1, userAddress.addressLine1) &&
                Objects.equals(this.addressLine2, userAddress.addressLine2) &&
                Objects.equals(this.addressLine3, userAddress.addressLine3) &&
                Objects.equals(this.postOfficeBox, userAddress.postOfficeBox);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, state, province, placeOfBirth, genderOfBirth, street, houseNo, zipCode, city, streetType, houseName, floorNo, doorNo, addressLine1, addressLine2, addressLine3, postOfficeBox);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserAddress {\n");
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    province: ").append(toIndentedString(province)).append("\n");
        sb.append("    placeOfBirth: ").append(toIndentedString(placeOfBirth)).append("\n");
        sb.append("    genderOfBirth: ").append(toIndentedString(genderOfBirth)).append("\n");
        sb.append("    street: ").append(toIndentedString(street)).append("\n");
        sb.append("    houseNo: ").append(toIndentedString(houseNo)).append("\n");
        sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    streetType: ").append(toIndentedString(streetType)).append("\n");
        sb.append("    houseName: ").append(toIndentedString(houseName)).append("\n");
        sb.append("    floorNo: ").append(toIndentedString(floorNo)).append("\n");
        sb.append("    doorNo: ").append(toIndentedString(doorNo)).append("\n");
        sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
        sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
        sb.append("    addressLine3: ").append(toIndentedString(addressLine3)).append("\n");
        sb.append("    postOfficeBox: ").append(toIndentedString(postOfficeBox)).append("\n");
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

