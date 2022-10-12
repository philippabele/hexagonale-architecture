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
 * UserCommunicationPreferences
 */
@JsonPropertyOrder({
        UserCommunicationPreferences.JSON_PROPERTY_CONTACTED_BY_PHONE,
        UserCommunicationPreferences.JSON_PROPERTY_CONTACTED_BY_LETTER,
        UserCommunicationPreferences.JSON_PROPERTY_CONTACTED_BY_EMAIL,
        UserCommunicationPreferences.JSON_PROPERTY_CONTACTED_BY_SMS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-26T11:12:37.120286+02:00[Europe/Berlin]")
public class UserCommunicationPreferences {
    public static final String JSON_PROPERTY_CONTACTED_BY_PHONE = "contactedByPhone";
    private Boolean contactedByPhone;

    public static final String JSON_PROPERTY_CONTACTED_BY_LETTER = "contactedByLetter";
    private Boolean contactedByLetter;

    public static final String JSON_PROPERTY_CONTACTED_BY_EMAIL = "contactedByEmail";
    private Boolean contactedByEmail;

    public static final String JSON_PROPERTY_CONTACTED_BY_SMS = "contactedBySms";
    private Boolean contactedBySms;

    public UserCommunicationPreferences() {
    }

    public UserCommunicationPreferences contactedByPhone(Boolean contactedByPhone) {

        this.contactedByPhone = contactedByPhone;
        return this;
    }

    /**
     * Get contactedByPhone
     *
     * @return contactedByPhone
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_CONTACTED_BY_PHONE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getContactedByPhone() {
        return contactedByPhone;
    }


    @JsonProperty(JSON_PROPERTY_CONTACTED_BY_PHONE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContactedByPhone(Boolean contactedByPhone) {
        this.contactedByPhone = contactedByPhone;
    }


    public UserCommunicationPreferences contactedByLetter(Boolean contactedByLetter) {

        this.contactedByLetter = contactedByLetter;
        return this;
    }

    /**
     * Get contactedByLetter
     *
     * @return contactedByLetter
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_CONTACTED_BY_LETTER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getContactedByLetter() {
        return contactedByLetter;
    }


    @JsonProperty(JSON_PROPERTY_CONTACTED_BY_LETTER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContactedByLetter(Boolean contactedByLetter) {
        this.contactedByLetter = contactedByLetter;
    }


    public UserCommunicationPreferences contactedByEmail(Boolean contactedByEmail) {

        this.contactedByEmail = contactedByEmail;
        return this;
    }

    /**
     * Get contactedByEmail
     *
     * @return contactedByEmail
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_CONTACTED_BY_EMAIL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getContactedByEmail() {
        return contactedByEmail;
    }


    @JsonProperty(JSON_PROPERTY_CONTACTED_BY_EMAIL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContactedByEmail(Boolean contactedByEmail) {
        this.contactedByEmail = contactedByEmail;
    }


    public UserCommunicationPreferences contactedBySms(Boolean contactedBySms) {

        this.contactedBySms = contactedBySms;
        return this;
    }

    /**
     * Get contactedBySms
     *
     * @return contactedBySms
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_CONTACTED_BY_SMS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getContactedBySms() {
        return contactedBySms;
    }


    @JsonProperty(JSON_PROPERTY_CONTACTED_BY_SMS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContactedBySms(Boolean contactedBySms) {
        this.contactedBySms = contactedBySms;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserCommunicationPreferences userCommunicationPreferences = (UserCommunicationPreferences) o;
        return Objects.equals(this.contactedByPhone, userCommunicationPreferences.contactedByPhone) &&
                Objects.equals(this.contactedByLetter, userCommunicationPreferences.contactedByLetter) &&
                Objects.equals(this.contactedByEmail, userCommunicationPreferences.contactedByEmail) &&
                Objects.equals(this.contactedBySms, userCommunicationPreferences.contactedBySms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactedByPhone, contactedByLetter, contactedByEmail, contactedBySms);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserCommunicationPreferences {\n");
        sb.append("    contactedByPhone: ").append(toIndentedString(contactedByPhone)).append("\n");
        sb.append("    contactedByLetter: ").append(toIndentedString(contactedByLetter)).append("\n");
        sb.append("    contactedByEmail: ").append(toIndentedString(contactedByEmail)).append("\n");
        sb.append("    contactedBySms: ").append(toIndentedString(contactedBySms)).append("\n");
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

