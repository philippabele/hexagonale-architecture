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
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * UserResponseBody
 */
@JsonPropertyOrder({
        UserResponseBody.JSON_PROPERTY_CIAM_ID,
        UserResponseBody.JSON_PROPERTY_USER_ID,
        UserResponseBody.JSON_PROPERTY_CREATED_AT,
        UserResponseBody.JSON_PROPERTY_CREATED_BY,
        UserResponseBody.JSON_PROPERTY_IS_EMAIL_CIAM_VERIFIED,
        UserResponseBody.JSON_PROPERTY_IS_MOBILE_CIAM_VERIFIED,
        UserResponseBody.JSON_PROPERTY_ACCOUNT_VERIFIED,
        UserResponseBody.JSON_PROPERTY_ACCOUNT_IDENTIFIER,
        UserResponseBody.JSON_PROPERTY_UPDATED_AT,
        UserResponseBody.JSON_PROPERTY_IDENTIFICATION_TYPE,
        UserResponseBody.JSON_PROPERTY_CASE_NUMBER,
        UserResponseBody.JSON_PROPERTY_FIRST_NAME,
        UserResponseBody.JSON_PROPERTY_LAST_NAME1,
        UserResponseBody.JSON_PROPERTY_LAST_NAME2,
        UserResponseBody.JSON_PROPERTY_TITLE,
        UserResponseBody.JSON_PROPERTY_NAME_PREFIX,
        UserResponseBody.JSON_PROPERTY_MIDDLE_INITIAL,
        UserResponseBody.JSON_PROPERTY_SALUTATION_CODE,
        UserResponseBody.JSON_PROPERTY_EMAIL,
        UserResponseBody.JSON_PROPERTY_LANDLINE_PHONE,
        UserResponseBody.JSON_PROPERTY_MOBILE_PHONE_NUMBER,
        UserResponseBody.JSON_PROPERTY_BIRTHDAY,
        UserResponseBody.JSON_PROPERTY_PREFERRED_LANGUAGE_CODE,
        UserResponseBody.JSON_PROPERTY_ACCOUNT_COUNTRY_CODE,
        UserResponseBody.JSON_PROPERTY_ADDRESS,
        UserResponseBody.JSON_PROPERTY_COMMUNICATION_PREFERENCES,
        UserResponseBody.JSON_PROPERTY_VIP,
        UserResponseBody.JSON_PROPERTY_IDENTIFICATION_NUMBER,
        UserResponseBody.JSON_PROPERTY_TAX_NUMBER
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-26T11:12:37.120286+02:00[Europe/Berlin]")
public class UserResponseBody {
    public static final String JSON_PROPERTY_CIAM_ID = "ciamId";
    private String ciamId;

    public static final String JSON_PROPERTY_USER_ID = "userId";
    private String userId;

    public static final String JSON_PROPERTY_CREATED_AT = "createdAt";
    private DateTime createdAt;

    public static final String JSON_PROPERTY_CREATED_BY = "createdBy";
    private String createdBy;

    public static final String JSON_PROPERTY_IS_EMAIL_CIAM_VERIFIED = "isEmailCiamVerified";
    private Boolean isEmailCiamVerified;

    public static final String JSON_PROPERTY_IS_MOBILE_CIAM_VERIFIED = "isMobileCiamVerified";
    private Boolean isMobileCiamVerified;

    public static final String JSON_PROPERTY_ACCOUNT_VERIFIED = "accountVerified";
    private Boolean accountVerified;

    public static final String JSON_PROPERTY_ACCOUNT_IDENTIFIER = "accountIdentifier";
    private String accountIdentifier;

    public static final String JSON_PROPERTY_UPDATED_AT = "updatedAt";
    private DateTime updatedAt;

    public static final String JSON_PROPERTY_IDENTIFICATION_TYPE = "identificationType";
    private String identificationType;

    public static final String JSON_PROPERTY_CASE_NUMBER = "caseNumber";
    private String caseNumber;

    public static final String JSON_PROPERTY_FIRST_NAME = "firstName";
    private String firstName;

    public static final String JSON_PROPERTY_LAST_NAME1 = "lastName1";
    private String lastName1;

    public static final String JSON_PROPERTY_LAST_NAME2 = "lastName2";
    private String lastName2;

    public static final String JSON_PROPERTY_TITLE = "title";
    private String title;

    public static final String JSON_PROPERTY_NAME_PREFIX = "namePrefix";
    private String namePrefix;

    public static final String JSON_PROPERTY_MIDDLE_INITIAL = "middleInitial";
    private String middleInitial;

    public static final String JSON_PROPERTY_SALUTATION_CODE = "salutationCode";
    private String salutationCode;

    public static final String JSON_PROPERTY_EMAIL = "email";
    private String email;

    public static final String JSON_PROPERTY_LANDLINE_PHONE = "landlinePhone";
    private String landlinePhone;

    public static final String JSON_PROPERTY_MOBILE_PHONE_NUMBER = "mobilePhoneNumber";
    private String mobilePhoneNumber;

    public static final String JSON_PROPERTY_BIRTHDAY = "birthday";
    private LocalDate birthday;

    public static final String JSON_PROPERTY_PREFERRED_LANGUAGE_CODE = "preferredLanguageCode";
    private String preferredLanguageCode;

    public static final String JSON_PROPERTY_ACCOUNT_COUNTRY_CODE = "accountCountryCode";
    private String accountCountryCode;

    public static final String JSON_PROPERTY_ADDRESS = "address";
    private UserAddress address;

    public static final String JSON_PROPERTY_COMMUNICATION_PREFERENCES = "communicationPreferences";
    private UserCommunicationPreferences communicationPreferences;

    public static final String JSON_PROPERTY_VIP = "vip";
    private Boolean vip;

    public static final String JSON_PROPERTY_IDENTIFICATION_NUMBER = "identificationNumber";
    private String identificationNumber;

    public static final String JSON_PROPERTY_TAX_NUMBER = "taxNumber";
    private String taxNumber;

    public UserResponseBody() {
    }

    public UserResponseBody ciamId(String ciamId) {

        this.ciamId = ciamId;
        return this;
    }

    /**
     * Get ciamId
     *
     * @return ciamId
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_CIAM_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getCiamId() {
        return ciamId;
    }


    @JsonProperty(JSON_PROPERTY_CIAM_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCiamId(String ciamId) {
        this.ciamId = ciamId;
    }


    public UserResponseBody userId(String userId) {

        this.userId = userId;
        return this;
    }

    /**
     * Get userId
     *
     * @return userId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUserId() {
        return userId;
    }


    @JsonProperty(JSON_PROPERTY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUserId(String userId) {
        this.userId = userId;
    }


    public UserResponseBody createdAt(DateTime createdAt) {

        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public DateTime getCreatedAt() {
        return createdAt;
    }


    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }


    public UserResponseBody createdBy(String createdBy) {

        this.createdBy = createdBy;
        return this;
    }

    /**
     * Get createdBy
     *
     * @return createdBy
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_CREATED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreatedBy() {
        return createdBy;
    }


    @JsonProperty(JSON_PROPERTY_CREATED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public UserResponseBody isEmailCiamVerified(Boolean isEmailCiamVerified) {

        this.isEmailCiamVerified = isEmailCiamVerified;
        return this;
    }

    /**
     * Get isEmailCiamVerified
     *
     * @return isEmailCiamVerified
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_IS_EMAIL_CIAM_VERIFIED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getIsEmailCiamVerified() {
        return isEmailCiamVerified;
    }


    @JsonProperty(JSON_PROPERTY_IS_EMAIL_CIAM_VERIFIED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIsEmailCiamVerified(Boolean isEmailCiamVerified) {
        this.isEmailCiamVerified = isEmailCiamVerified;
    }


    public UserResponseBody isMobileCiamVerified(Boolean isMobileCiamVerified) {

        this.isMobileCiamVerified = isMobileCiamVerified;
        return this;
    }

    /**
     * Get isMobileCiamVerified
     *
     * @return isMobileCiamVerified
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_IS_MOBILE_CIAM_VERIFIED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getIsMobileCiamVerified() {
        return isMobileCiamVerified;
    }


    @JsonProperty(JSON_PROPERTY_IS_MOBILE_CIAM_VERIFIED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIsMobileCiamVerified(Boolean isMobileCiamVerified) {
        this.isMobileCiamVerified = isMobileCiamVerified;
    }


    public UserResponseBody accountVerified(Boolean accountVerified) {

        this.accountVerified = accountVerified;
        return this;
    }

    /**
     * Get accountVerified
     *
     * @return accountVerified
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ACCOUNT_VERIFIED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getAccountVerified() {
        return accountVerified;
    }


    @JsonProperty(JSON_PROPERTY_ACCOUNT_VERIFIED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAccountVerified(Boolean accountVerified) {
        this.accountVerified = accountVerified;
    }


    public UserResponseBody accountIdentifier(String accountIdentifier) {

        this.accountIdentifier = accountIdentifier;
        return this;
    }

    /**
     * Get accountIdentifier
     *
     * @return accountIdentifier
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_ACCOUNT_IDENTIFIER)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getAccountIdentifier() {
        return accountIdentifier;
    }


    @JsonProperty(JSON_PROPERTY_ACCOUNT_IDENTIFIER)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }


    public UserResponseBody updatedAt(DateTime updatedAt) {

        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Get updatedAt
     *
     * @return updatedAt
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public DateTime getUpdatedAt() {
        return updatedAt;
    }


    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


    public UserResponseBody identificationType(String identificationType) {

        this.identificationType = identificationType;
        return this;
    }

    /**
     * Get identificationType
     *
     * @return identificationType
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_IDENTIFICATION_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getIdentificationType() {
        return identificationType;
    }


    @JsonProperty(JSON_PROPERTY_IDENTIFICATION_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }


    public UserResponseBody caseNumber(String caseNumber) {

        this.caseNumber = caseNumber;
        return this;
    }

    /**
     * Get caseNumber
     *
     * @return caseNumber
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_CASE_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCaseNumber() {
        return caseNumber;
    }


    @JsonProperty(JSON_PROPERTY_CASE_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }


    public UserResponseBody firstName(String firstName) {

        this.firstName = firstName;
        return this;
    }

    /**
     * Get firstName
     *
     * @return firstName
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_FIRST_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFirstName() {
        return firstName;
    }


    @JsonProperty(JSON_PROPERTY_FIRST_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public UserResponseBody lastName1(String lastName1) {

        this.lastName1 = lastName1;
        return this;
    }

    /**
     * Get lastName1
     *
     * @return lastName1
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_LAST_NAME1)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLastName1() {
        return lastName1;
    }


    @JsonProperty(JSON_PROPERTY_LAST_NAME1)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }


    public UserResponseBody lastName2(String lastName2) {

        this.lastName2 = lastName2;
        return this;
    }

    /**
     * Get lastName2
     *
     * @return lastName2
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_LAST_NAME2)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLastName2() {
        return lastName2;
    }


    @JsonProperty(JSON_PROPERTY_LAST_NAME2)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }


    public UserResponseBody title(String title) {

        this.title = title;
        return this;
    }

    /**
     * Get title
     *
     * @return title
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_TITLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTitle() {
        return title;
    }


    @JsonProperty(JSON_PROPERTY_TITLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTitle(String title) {
        this.title = title;
    }


    public UserResponseBody namePrefix(String namePrefix) {

        this.namePrefix = namePrefix;
        return this;
    }

    /**
     * Get namePrefix
     *
     * @return namePrefix
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_NAME_PREFIX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getNamePrefix() {
        return namePrefix;
    }


    @JsonProperty(JSON_PROPERTY_NAME_PREFIX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }


    public UserResponseBody middleInitial(String middleInitial) {

        this.middleInitial = middleInitial;
        return this;
    }

    /**
     * Get middleInitial
     *
     * @return middleInitial
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_MIDDLE_INITIAL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMiddleInitial() {
        return middleInitial;
    }


    @JsonProperty(JSON_PROPERTY_MIDDLE_INITIAL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }


    public UserResponseBody salutationCode(String salutationCode) {

        this.salutationCode = salutationCode;
        return this;
    }

    /**
     * Get salutationCode
     *
     * @return salutationCode
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_SALUTATION_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSalutationCode() {
        return salutationCode;
    }


    @JsonProperty(JSON_PROPERTY_SALUTATION_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSalutationCode(String salutationCode) {
        this.salutationCode = salutationCode;
    }


    public UserResponseBody email(String email) {

        this.email = email;
        return this;
    }

    /**
     * Get email
     *
     * @return email
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_EMAIL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getEmail() {
        return email;
    }


    @JsonProperty(JSON_PROPERTY_EMAIL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEmail(String email) {
        this.email = email;
    }


    public UserResponseBody landlinePhone(String landlinePhone) {

        this.landlinePhone = landlinePhone;
        return this;
    }

    /**
     * Get landlinePhone
     *
     * @return landlinePhone
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_LANDLINE_PHONE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLandlinePhone() {
        return landlinePhone;
    }


    @JsonProperty(JSON_PROPERTY_LANDLINE_PHONE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLandlinePhone(String landlinePhone) {
        this.landlinePhone = landlinePhone;
    }


    public UserResponseBody mobilePhoneNumber(String mobilePhoneNumber) {

        this.mobilePhoneNumber = mobilePhoneNumber;
        return this;
    }

    /**
     * Get mobilePhoneNumber
     *
     * @return mobilePhoneNumber
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_MOBILE_PHONE_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }


    @JsonProperty(JSON_PROPERTY_MOBILE_PHONE_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }


    public UserResponseBody birthday(LocalDate birthday) {

        this.birthday = birthday;
        return this;
    }

    /**
     * Get birthday
     *
     * @return birthday
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_BIRTHDAY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public LocalDate getBirthday() {
        return birthday;
    }


    @JsonProperty(JSON_PROPERTY_BIRTHDAY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }


    public UserResponseBody preferredLanguageCode(String preferredLanguageCode) {

        this.preferredLanguageCode = preferredLanguageCode;
        return this;
    }

    /**
     * Get preferredLanguageCode
     *
     * @return preferredLanguageCode
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_PREFERRED_LANGUAGE_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPreferredLanguageCode() {
        return preferredLanguageCode;
    }


    @JsonProperty(JSON_PROPERTY_PREFERRED_LANGUAGE_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPreferredLanguageCode(String preferredLanguageCode) {
        this.preferredLanguageCode = preferredLanguageCode;
    }


    public UserResponseBody accountCountryCode(String accountCountryCode) {

        this.accountCountryCode = accountCountryCode;
        return this;
    }

    /**
     * Get accountCountryCode
     *
     * @return accountCountryCode
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ACCOUNT_COUNTRY_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAccountCountryCode() {
        return accountCountryCode;
    }


    @JsonProperty(JSON_PROPERTY_ACCOUNT_COUNTRY_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAccountCountryCode(String accountCountryCode) {
        this.accountCountryCode = accountCountryCode;
    }


    public UserResponseBody address(UserAddress address) {

        this.address = address;
        return this;
    }

    /**
     * Get address
     *
     * @return address
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ADDRESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public UserAddress getAddress() {
        return address;
    }


    @JsonProperty(JSON_PROPERTY_ADDRESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAddress(UserAddress address) {
        this.address = address;
    }


    public UserResponseBody communicationPreferences(UserCommunicationPreferences communicationPreferences) {

        this.communicationPreferences = communicationPreferences;
        return this;
    }

    /**
     * Get communicationPreferences
     *
     * @return communicationPreferences
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_COMMUNICATION_PREFERENCES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public UserCommunicationPreferences getCommunicationPreferences() {
        return communicationPreferences;
    }


    @JsonProperty(JSON_PROPERTY_COMMUNICATION_PREFERENCES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCommunicationPreferences(UserCommunicationPreferences communicationPreferences) {
        this.communicationPreferences = communicationPreferences;
    }


    public UserResponseBody vip(Boolean vip) {

        this.vip = vip;
        return this;
    }

    /**
     * Get vip
     *
     * @return vip
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_VIP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getVip() {
        return vip;
    }


    @JsonProperty(JSON_PROPERTY_VIP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVip(Boolean vip) {
        this.vip = vip;
    }


    public UserResponseBody identificationNumber(String identificationNumber) {

        this.identificationNumber = identificationNumber;
        return this;
    }

    /**
     * Get identificationNumber
     *
     * @return identificationNumber
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_IDENTIFICATION_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getIdentificationNumber() {
        return identificationNumber;
    }


    @JsonProperty(JSON_PROPERTY_IDENTIFICATION_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }


    public UserResponseBody taxNumber(String taxNumber) {

        this.taxNumber = taxNumber;
        return this;
    }

    /**
     * Get taxNumber
     *
     * @return taxNumber
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_TAX_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTaxNumber() {
        return taxNumber;
    }


    @JsonProperty(JSON_PROPERTY_TAX_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserResponseBody userResponseBody = (UserResponseBody) o;
        return Objects.equals(this.ciamId, userResponseBody.ciamId) &&
                Objects.equals(this.userId, userResponseBody.userId) &&
                Objects.equals(this.createdAt, userResponseBody.createdAt) &&
                Objects.equals(this.createdBy, userResponseBody.createdBy) &&
                Objects.equals(this.isEmailCiamVerified, userResponseBody.isEmailCiamVerified) &&
                Objects.equals(this.isMobileCiamVerified, userResponseBody.isMobileCiamVerified) &&
                Objects.equals(this.accountVerified, userResponseBody.accountVerified) &&
                Objects.equals(this.accountIdentifier, userResponseBody.accountIdentifier) &&
                Objects.equals(this.updatedAt, userResponseBody.updatedAt) &&
                Objects.equals(this.identificationType, userResponseBody.identificationType) &&
                Objects.equals(this.caseNumber, userResponseBody.caseNumber) &&
                Objects.equals(this.firstName, userResponseBody.firstName) &&
                Objects.equals(this.lastName1, userResponseBody.lastName1) &&
                Objects.equals(this.lastName2, userResponseBody.lastName2) &&
                Objects.equals(this.title, userResponseBody.title) &&
                Objects.equals(this.namePrefix, userResponseBody.namePrefix) &&
                Objects.equals(this.middleInitial, userResponseBody.middleInitial) &&
                Objects.equals(this.salutationCode, userResponseBody.salutationCode) &&
                Objects.equals(this.email, userResponseBody.email) &&
                Objects.equals(this.landlinePhone, userResponseBody.landlinePhone) &&
                Objects.equals(this.mobilePhoneNumber, userResponseBody.mobilePhoneNumber) &&
                Objects.equals(this.birthday, userResponseBody.birthday) &&
                Objects.equals(this.preferredLanguageCode, userResponseBody.preferredLanguageCode) &&
                Objects.equals(this.accountCountryCode, userResponseBody.accountCountryCode) &&
                Objects.equals(this.address, userResponseBody.address) &&
                Objects.equals(this.communicationPreferences, userResponseBody.communicationPreferences) &&
                Objects.equals(this.vip, userResponseBody.vip) &&
                Objects.equals(this.identificationNumber, userResponseBody.identificationNumber) &&
                Objects.equals(this.taxNumber, userResponseBody.taxNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ciamId, userId, createdAt, createdBy, isEmailCiamVerified, isMobileCiamVerified, accountVerified, accountIdentifier, updatedAt, identificationType, caseNumber, firstName, lastName1, lastName2, title, namePrefix, middleInitial, salutationCode, email, landlinePhone, mobilePhoneNumber, birthday, preferredLanguageCode, accountCountryCode, address, communicationPreferences, vip, identificationNumber, taxNumber);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserResponseBody {\n");
        sb.append("    ciamId: ").append(toIndentedString(ciamId)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    isEmailCiamVerified: ").append(toIndentedString(isEmailCiamVerified)).append("\n");
        sb.append("    isMobileCiamVerified: ").append(toIndentedString(isMobileCiamVerified)).append("\n");
        sb.append("    accountVerified: ").append(toIndentedString(accountVerified)).append("\n");
        sb.append("    accountIdentifier: ").append(toIndentedString(accountIdentifier)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
        sb.append("    identificationType: ").append(toIndentedString(identificationType)).append("\n");
        sb.append("    caseNumber: ").append(toIndentedString(caseNumber)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName1: ").append(toIndentedString(lastName1)).append("\n");
        sb.append("    lastName2: ").append(toIndentedString(lastName2)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    namePrefix: ").append(toIndentedString(namePrefix)).append("\n");
        sb.append("    middleInitial: ").append(toIndentedString(middleInitial)).append("\n");
        sb.append("    salutationCode: ").append(toIndentedString(salutationCode)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    landlinePhone: ").append(toIndentedString(landlinePhone)).append("\n");
        sb.append("    mobilePhoneNumber: ").append(toIndentedString(mobilePhoneNumber)).append("\n");
        sb.append("    birthday: ").append(toIndentedString(birthday)).append("\n");
        sb.append("    preferredLanguageCode: ").append(toIndentedString(preferredLanguageCode)).append("\n");
        sb.append("    accountCountryCode: ").append(toIndentedString(accountCountryCode)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    communicationPreferences: ").append(toIndentedString(communicationPreferences)).append("\n");
        sb.append("    vip: ").append(toIndentedString(vip)).append("\n");
        sb.append("    identificationNumber: ").append(toIndentedString(identificationNumber)).append("\n");
        sb.append("    taxNumber: ").append(toIndentedString(taxNumber)).append("\n");
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
