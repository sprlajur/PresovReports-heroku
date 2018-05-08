/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.json.*;

/**
 *
 * @author sprlajur
 */
public class RPOJsonParser {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private static final String ID = "id";
    private static final String CIN = "cin";
    private static final String NAME = "name";
    private static final String FORMATTED_ADDRESS = "formatted_address";
    private static final String CREATED_AT = "created_at";
    private static final String ESTABLISHED_ON = "established_on";
    private static final String TERMINATED_ON = "terminated_on";
    private static final String REGISTRATION_OFFICE = "registration_office";
    private static final String REGISTRATION_NUMBER = "registration_number";
    private static final String RPO_ORGANIZATIONS = "rpo_organizations";
    private static final String ACCOUNTING_ENTITIES = "ruz_accounting_entities";
    private static final String URL = "url";

    private static final String EFFECTIVE_FROM = "effective_from";
    private static final String EFFECTIVE_TO = "effective_to";
    private static final String SOURCE_REGISTER = "source_register";
    private static final String ADDRESS_ENTRIES = "address_entries";
    private static final String ADDRESS_ENTRIES_STREET = "street";
    private static final String ADDRESS_ENTRIES_REG_NR = "reg_number";
    private static final String ADDRESS_ENTRIES_BUILDING_NR = "building_number";
    private static final String ADDRESS_ENTRIES_POSTAL_CODE = "postal_code";
    private static final String ADDRESS_ENTRIES_MUNICIPALITY = "municipality";
    private static final String ADDRESS_ENTRIES_COUNTRY = "country";

    private static final String ALTERNATE_NAMES_ENTRIES = "alternate_name_entries";
    private static final String ALTERNATE_NAMES_ENTRIES_NAME = "name";

    private static final String DEPOSIT_ENTRIES = "deposit_entries";
    private static final String FULL_NAME = "full_name";
    private static final String DEPOSIT_ENTRIES_PERSON_FORMATTED_NAME = "person_formatted_name";
    private static final String DEPOSIT_ENTRIES_DEPOSIT_AMOUNT = "deposit_amount";
    private static final String DEPOSIT_ENTRIES_DEPOSIT_CURRENCY = "deposit_currency";
    private static final String DEPOSIT_ENTRIES_DEPOSIT_TYPE = "deposit_type";

    private static final String AUTHORIZATION_ENTRIES = "authorization_entries";
    private static final String AUTHORIZATION_ENTRIES_BODY = "body";

    private static final String ECONOMIC_ACTIVITY_ENTRIES = "economic_activity_entries";
    private static final String ECONOMIC_ACTIVITY_ENTRIES_DESCRIPTION = "description";
    private static final String ECONOMIC_ACTIVITY_ENTRIES_SUSPENDED_FROM = "suspended_from";
    private static final String ECONOMIC_ACTIVITY_ENTRIES_SUSPENDED_TO = "suspended_to";

    private static final String EQUITY_ENTRIES = "equity_entries";
    private static final String EQUITY_ENTRIES_INVESTMENT_AMOUNT = "investment_amount";
    private static final String EQUITY_ENTRIES_INVESTMENT_CURRENCY = "investment_currency";
    private static final String EQUITY_ENTRIES_PAID_AMOUNT = "paid_amount";
    private static final String EQUITY_ENTRIES_PAID_CURRENCY = "paid_currency";
    private static final String EQUITY_ENTRIES_APPROVED_AMOUNT = "approved_amount";
    private static final String EQUITY_ENTRIES_APPROVED_CURRENCY = "approved_currency";

    private static final String LEGAL_FORM_ENTRIES = "legal_form_entries";
    private static final String LEGAL_FORM_ENTRIES_LEGAL_FORM = "legal_form";
    private static final String LEGAL_FORM_ENTRIES_LEGAL_FORM_NAME = "name";

    private static final String LEGAL_STATUS_ENTRIES = "legal_status_entries";
    private static final String LEGAL_STATUS_ENTRIES_BODY = "body";

    private static final String NAME_ENTRIES = "name_entries";
    private static final String NAME_ENTRIES_NAME = "name";

    private static final String PREDECESSOR_ENTRIES = "predecessor_entries";
    private static final String SUCCESSOR_ENTRIES = "successor_entries";
    private static final String ENTRIES_ICO = "ico";
    private static final String ENTRIES_FULL_NAME = "full_name";

    private static final String SHARE_ENTRIES = "share_entries";
    private static final String SHARE_ENTRIES_PRICE = "share_price";
    private static final String SHARE_ENTRIES_CURRENCY = "share_currency";
    private static final String SHARE_ENTRIES_AMOUNT = "share_amount";
    private static final String SHARE_ENTRIES_TRANSFER = "share_transfer";
    private static final String SHARE_ENTRIES_TYPE = "share_type";
    private static final String SHARE_ENTRIES_FORM = "share_form";
    private static final String SHARE_ENTRIES_NAME = "name";

    private static final String STAKEHOLDER_ENTRIES = "stakeholder_entries";
    private static final String STATUTORY_ENTRIES = "statutory_entries";
    private static final String STAKEHOLDER_TYPE = "stakeholder_type";
    private static final String PERSON_FORMATTED_NAME = "person_formatted_name";
    private static final String ADDRESS_FORMATTED = "address_formatted";
    private static final String ADDRESS_STREET = "address_street";
    private static final String ADDRESS_REG_NR = "address_reg_number";
    private static final String ADDRESS_BUILDING_NR = "address_building_number";
    private static final String ADDRESS_POSTAL_CODE = "address_postal_code";
    private static final String ADDRESS_MUNICIPALITY = "address_municipality";
    private static final String ADDRESS_COUNTRY = "address_country";
    private static final String ADDRESS_DISTRICT = "address_district";
    private static final String PERSON_FAMILY_NAME = "person_family_name";
    private static final String PERSON_GIVEN_NAME = "person_given_name";

    private static final String MAIN_ACTIVITY_CODE = "main_activity_code";
    private static final String ESA2010_CODE = "esa2010_code";

    private static final String NACE_CATEGORY = "sk_nace_category";
    private static final String ORGANIZATION_SIZE = "organization_size";
    private static final String OWNERSHIP_TYPE = "ownership_type";
    private static final String NAME_SK = "name_sk";

    public static RPOLegalPerson parseIntermediaryAPIData(String jsonData, RPOLegalPerson person) {
        if (jsonData == null || jsonData.isEmpty()) {
            return null;
        }
        try {
            JSONObject obj = new JSONObject(jsonData);
            if (!obj.isNull(ID)) {
                person.setRpo_id(obj.getInt(ID));
            }
            if (!obj.isNull(NAME)) {
                person.setName(obj.getString(NAME));
            }
            if (!obj.isNull(FORMATTED_ADDRESS)) {
                person.setFormatted_address(obj.getString(FORMATTED_ADDRESS));
            }
            if (!obj.isNull(CREATED_AT)) {
                person.setCreatedAt(LocalDateTime.parse(obj.getString(CREATED_AT), DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));
            }
            if (!obj.isNull(REGISTRATION_OFFICE)) {
                person.setRegistration_office(obj.getString(REGISTRATION_OFFICE));
            }
            if (!obj.isNull(REGISTRATION_NUMBER)) {
                person.setRegistration_nr(obj.getString(REGISTRATION_NUMBER));
            }
            if (!obj.isNull(ESTABLISHED_ON)) {
                person.setEstablished_on(LocalDate.parse(obj.getString(ESTABLISHED_ON), DateTimeFormatter.ofPattern(DATE_FORMAT)));
            }
            if (!obj.isNull(TERMINATED_ON)) {
                person.setTerminated_on(LocalDate.parse(obj.getString(TERMINATED_ON), DateTimeFormatter.ofPattern(DATE_FORMAT)));
            }
            if (!obj.isNull(RPO_ORGANIZATIONS)) {
                JSONArray orgs = obj.getJSONArray(RPO_ORGANIZATIONS);
                if (orgs != null) {
                    if (!((JSONObject) orgs.get(0)).isNull(URL)) {
                        person.setRpo_API_url(((JSONObject) orgs.get(0)).getString(URL));
                    }
                }
            }
            if (!obj.isNull(ACCOUNTING_ENTITIES)) {
                JSONArray orgs = obj.getJSONArray(ACCOUNTING_ENTITIES);
                if (orgs != null) {
                    if (!((JSONObject) orgs.get(0)).isNull(URL)) {
                        person.setAccounting_entities_API_url(((JSONObject) orgs.get(0)).getString(URL));
                    }
                }
            }
        } catch (JSONException | NumberFormatException e) {
            e.printStackTrace();
        }
        return person;
    }

    public static RPOLegalPerson parseFullRPOData(String jsonData, RPOLegalPerson person) {
        if (jsonData == null || jsonData.isEmpty()) {
            return null;
        }
        try {
            JSONObject obj = new JSONObject(jsonData);
            if (!obj.isNull(SOURCE_REGISTER)) {
                person.setSource_register(SOURCE_REGISTER);
            }
            if (!obj.isNull(ADDRESS_ENTRIES)) {
                parseAddressEntries(obj, person);
            }
            if (!obj.isNull(ALTERNATE_NAMES_ENTRIES)) {
                parseAlternateNameEntries(obj, person);
            }
            if (!obj.isNull(DEPOSIT_ENTRIES)) {
                parseDepositEntries(obj, person);
            }
            if (!obj.isNull(AUTHORIZATION_ENTRIES)) {
                parseAuthorizationEntries(obj, person);
            }
            if (!obj.isNull(ECONOMIC_ACTIVITY_ENTRIES)) {
                parseEconomicActivityEntries(obj, person);
            }
            if (!obj.isNull(EQUITY_ENTRIES)) {
                parseEquityEntries(obj, person);
            }
            if (!obj.isNull(LEGAL_FORM_ENTRIES)) {
                parseLegalFormEntries(obj, person);
            }
            if (!obj.isNull(LEGAL_STATUS_ENTRIES)) {
                parseLegalStatusEntries(obj, person);
            }
            if (!obj.isNull(NAME_ENTRIES)) {
                parseNameEntries(obj, person);
            }
            if (!obj.isNull(PREDECESSOR_ENTRIES)) {
                parsePredecessorSuccessorEntries(obj, person, false);
            }
            if (!obj.isNull(SUCCESSOR_ENTRIES)) {
                parsePredecessorSuccessorEntries(obj, person, true);
            }
            if (!obj.isNull(SHARE_ENTRIES)) {
                parseShareEntries(obj, person);
            }
            if (!obj.isNull(STAKEHOLDER_ENTRIES)) {
                parseStakeholderStatutoryEntries(obj, person, false);
            }
            if (!obj.isNull(STATUTORY_ENTRIES)) {
                parseStakeholderStatutoryEntries(obj, person, true);
            }
            if (!obj.isNull(MAIN_ACTIVITY_CODE)) {
                parseMainActivityCode(obj, person);
            }
            if (!obj.isNull(ESA2010_CODE)) {
                parseESA2010Code(obj, person);
            }
        } catch (JSONException | NumberFormatException e) {
            e.printStackTrace();
        }
        return person;
    }

    public static RPOLegalPerson parseAccountingEntitiesData(String jsonData, RPOLegalPerson person) {
        if (jsonData == null || jsonData.isEmpty()) {
            return null;
        }
        try {
            JSONObject obj = new JSONObject(jsonData);
            if (!obj.isNull(ORGANIZATION_SIZE)) {
                JSONObject orgSizeJSONObj = obj.getJSONObject(ORGANIZATION_SIZE);
                if (!orgSizeJSONObj.isNull(NAME_SK)) {
                    person.setOrganizationSize(orgSizeJSONObj.getString(NAME_SK));
                }
            }
            if (!obj.isNull(NACE_CATEGORY)) {
                JSONObject naceCatJSONObj = obj.getJSONObject(NACE_CATEGORY);
                if (!naceCatJSONObj.isNull(NAME_SK)) {
                    person.setSkNACECategory(naceCatJSONObj.getString(NAME_SK));
                }
            }
            if (!obj.isNull(OWNERSHIP_TYPE)) {
                JSONObject ownTypeJSONObj = obj.getJSONObject(OWNERSHIP_TYPE);
                if (!ownTypeJSONObj.isNull(NAME_SK)) {
                    person.setOwnershipType(ownTypeJSONObj.getString(NAME_SK));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return person;
    }

    private static void parseAddressEntries(JSONObject jsonObject, RPOLegalPerson person) {
        List<RPOAddressEntry> addressEntries = new ArrayList<>();
        JSONArray addressesJSON = jsonObject.getJSONArray(ADDRESS_ENTRIES);
        if (addressesJSON != null) {

            addressesJSON.forEach(identifier -> {
                JSONObject jsonAddress = (JSONObject) identifier;
                RPOAddressEntry addressEntry = new RPOAddressEntry();
                if (!jsonAddress.isNull(ADDRESS_ENTRIES_STREET)) {
                    addressEntry.setStreet(jsonAddress.getString(ADDRESS_ENTRIES_STREET));
                }
                if (!jsonAddress.isNull(ADDRESS_ENTRIES_BUILDING_NR)) {
                    addressEntry.setBuilding_nr(jsonAddress.getString(ADDRESS_ENTRIES_BUILDING_NR));
                }
                if (!jsonAddress.isNull(ADDRESS_ENTRIES_COUNTRY)) {
                    addressEntry.setCountry(jsonAddress.getString(ADDRESS_ENTRIES_COUNTRY));
                }
                if (!jsonAddress.isNull(ADDRESS_ENTRIES_MUNICIPALITY)) {
                    addressEntry.setMunicipality(jsonAddress.getString(ADDRESS_ENTRIES_MUNICIPALITY));
                }
                if (!jsonAddress.isNull(ADDRESS_ENTRIES_REG_NR)) {
                    addressEntry.setReg_nr(jsonAddress.getInt(ADDRESS_ENTRIES_REG_NR));
                }
                setEffectiveDates(addressEntry, jsonAddress);
                addressEntries.add(addressEntry);
            });
        }
        if (!addressEntries.isEmpty()) {
            person.setAddressEntries(addressEntries);
        }
    }

    private static void parseAlternateNameEntries(JSONObject jsonObject, RPOLegalPerson person) {
        List<RPOOneStringEntry> alternateNames = new ArrayList<RPOOneStringEntry>();
        JSONArray alternateNamesJSON = jsonObject.getJSONArray(ALTERNATE_NAMES_ENTRIES);
        if (alternateNamesJSON != null) {
            alternateNamesJSON.forEach(alterName -> {
                JSONObject alterNameJSONObject = (JSONObject) alterName;
                RPOOneStringEntry rpoAlternateName = new RPOOneStringEntry();
                if (!alterNameJSONObject.isNull(ALTERNATE_NAMES_ENTRIES_NAME)) {
                    rpoAlternateName.setBody(alterNameJSONObject.getString(ALTERNATE_NAMES_ENTRIES_NAME));
                }
                setEffectiveDates(rpoAlternateName, alterNameJSONObject);
                alternateNames.add(rpoAlternateName);
            });
        }
        if (!alternateNames.isEmpty()) {
            person.setAlternateNameEntries(alternateNames);
        }
    }

    private static void parseDepositEntries(JSONObject jsonObject, RPOLegalPerson person) {
        List<RPODepositEntry> depositEntries = new ArrayList<>();
        JSONArray depositEntriesJSONArr = jsonObject.getJSONArray(DEPOSIT_ENTRIES);
        if (depositEntriesJSONArr != null) {
            depositEntriesJSONArr.forEach(iterator -> {
                RPODepositEntry rpoDepositEntry = new RPODepositEntry();
                JSONObject depositJSONObject = (JSONObject) iterator;
                if (!depositJSONObject.isNull(FULL_NAME)) {
                    rpoDepositEntry.setFullName(depositJSONObject.getString(FULL_NAME));
                }
                if (!depositJSONObject.isNull(DEPOSIT_ENTRIES_PERSON_FORMATTED_NAME)) {
                    rpoDepositEntry.setPersonFormattedName(depositJSONObject.getString(DEPOSIT_ENTRIES_PERSON_FORMATTED_NAME));
                }
                if (!depositJSONObject.isNull(DEPOSIT_ENTRIES_DEPOSIT_AMOUNT)) {
                    rpoDepositEntry.setAmount(depositJSONObject.getFloat(DEPOSIT_ENTRIES_DEPOSIT_AMOUNT));
                }
                if (!depositJSONObject.isNull(DEPOSIT_ENTRIES_DEPOSIT_CURRENCY)) {
                    rpoDepositEntry.setCurrency(depositJSONObject.getString(DEPOSIT_ENTRIES_DEPOSIT_CURRENCY));
                }
                if (!depositJSONObject.isNull(DEPOSIT_ENTRIES_DEPOSIT_TYPE)) {
                    rpoDepositEntry.setType(depositJSONObject.getString(DEPOSIT_ENTRIES_DEPOSIT_TYPE));
                }
                setEffectiveDates(rpoDepositEntry, depositJSONObject);
                depositEntries.add(rpoDepositEntry);
            });
        }
        if (!depositEntries.isEmpty()) {
            person.setDepositEntries(depositEntries);
        }
    }

    private static void parseAuthorizationEntries(JSONObject jsonObject, RPOLegalPerson person) {
        List<RPOOneStringEntry> authorizationEntries = new ArrayList<>();
        JSONArray authorizationJSON = jsonObject.getJSONArray(AUTHORIZATION_ENTRIES);
        if (authorizationJSON != null) {
            authorizationJSON.forEach(authorization -> {
                JSONObject authorizationJSONObject = (JSONObject) authorization;
                RPOOneStringEntry rpoAuthorizationEntry = new RPOOneStringEntry();
                if (!authorizationJSONObject.isNull(AUTHORIZATION_ENTRIES_BODY)) {
                    rpoAuthorizationEntry.setBody(authorizationJSONObject.getString(AUTHORIZATION_ENTRIES_BODY));
                }
                setEffectiveDates(rpoAuthorizationEntry, authorizationJSONObject);
                authorizationEntries.add(rpoAuthorizationEntry);
            });
        }
        if (!authorizationEntries.isEmpty()) {
            person.setAuthorizationEntries(authorizationEntries);
        }
    }

    private static void parseEconomicActivityEntries(JSONObject jsonObject, RPOLegalPerson person) {
        List<RPOOneStringEntry> economicActivityEntries = new ArrayList<>();
        JSONArray economicActivityJSON = jsonObject.getJSONArray(ECONOMIC_ACTIVITY_ENTRIES);
        if (economicActivityJSON != null) {
            economicActivityJSON.forEach(economicActivity -> {
                JSONObject economicActivityJSONObject = (JSONObject) economicActivity;
                RPOOneStringEntry rpoEconomicActivityEntry = new RPOOneStringEntry();
                if (!economicActivityJSONObject.isNull(ECONOMIC_ACTIVITY_ENTRIES_DESCRIPTION)) {
                    rpoEconomicActivityEntry.setBody(economicActivityJSONObject.getString(ECONOMIC_ACTIVITY_ENTRIES_DESCRIPTION));
                }
                economicActivityEntries.add(rpoEconomicActivityEntry);
                setEffectiveDates(rpoEconomicActivityEntry, economicActivityJSONObject);
            });
        }
        if (!economicActivityEntries.isEmpty()) {
            person.setEconomicActivityEntries(economicActivityEntries);
        }
    }

    private static void parseEquityEntries(JSONObject jsonObject, RPOLegalPerson person) {
        List<RPOEquityEntry> equities = new ArrayList<RPOEquityEntry>();
        JSONArray equitiesJSON = jsonObject.getJSONArray(EQUITY_ENTRIES);
        if (equitiesJSON != null) {
            equitiesJSON.forEach(equity -> {
                RPOEquityEntry rpoEquityEntry = new RPOEquityEntry();
                JSONObject equityJSONObject = (JSONObject) equity;
                if (!equityJSONObject.isNull(EQUITY_ENTRIES_APPROVED_AMOUNT)) {
                    rpoEquityEntry.setApprovedAmount(equityJSONObject.getFloat(EQUITY_ENTRIES_APPROVED_AMOUNT));
                }
                if (!equityJSONObject.isNull(EQUITY_ENTRIES_APPROVED_CURRENCY)) {
                    rpoEquityEntry.setApprovedCurrency(equityJSONObject.getString(EQUITY_ENTRIES_APPROVED_CURRENCY));
                }
                if (!equityJSONObject.isNull(EQUITY_ENTRIES_PAID_AMOUNT)) {
                    rpoEquityEntry.setApprovedAmount(equityJSONObject.getFloat(EQUITY_ENTRIES_PAID_AMOUNT));
                }
                if (!equityJSONObject.isNull(EQUITY_ENTRIES_PAID_CURRENCY)) {
                    rpoEquityEntry.setApprovedCurrency(equityJSONObject.getString(EQUITY_ENTRIES_PAID_CURRENCY));
                }
                if (!equityJSONObject.isNull(EQUITY_ENTRIES_INVESTMENT_AMOUNT)) {
                    rpoEquityEntry.setApprovedAmount(equityJSONObject.getFloat(EQUITY_ENTRIES_INVESTMENT_AMOUNT));
                }
                if (!equityJSONObject.isNull(EQUITY_ENTRIES_INVESTMENT_CURRENCY)) {
                    rpoEquityEntry.setApprovedCurrency(equityJSONObject.getString(EQUITY_ENTRIES_INVESTMENT_CURRENCY));
                }
                setEffectiveDates(rpoEquityEntry, equityJSONObject);
                equities.add(rpoEquityEntry);
            });
        }
        if (!equities.isEmpty()) {
            person.setEquityEntries(equities);
        }
    }

    private static void parseLegalFormEntries(JSONObject jsonObject, RPOLegalPerson person) {
        List<RPOOneStringEntry> legalForms = new ArrayList<RPOOneStringEntry>();
        JSONArray legalFormsJSON = jsonObject.getJSONArray(LEGAL_FORM_ENTRIES);
        if (legalFormsJSON != null) {
            legalFormsJSON.forEach(legalFormIt -> {
                JSONObject legalFormEntryJSONObject = (JSONObject) legalFormIt;
                RPOOneStringEntry legalForm = new RPOOneStringEntry();
                if (!legalFormEntryJSONObject.isNull(LEGAL_FORM_ENTRIES_LEGAL_FORM)) {
                    JSONObject legalFormJSONObject = (JSONObject) legalFormEntryJSONObject.getJSONObject(LEGAL_FORM_ENTRIES_LEGAL_FORM);
                    if (!legalFormJSONObject.isNull(LEGAL_FORM_ENTRIES_LEGAL_FORM_NAME)) {
                        legalForm.setBody(legalFormJSONObject.getString(LEGAL_FORM_ENTRIES_LEGAL_FORM_NAME));
                        setEffectiveDates(legalForm, legalFormEntryJSONObject);
                        legalForms.add(legalForm);
                    }
                }
            });
        }
        if (!legalForms.isEmpty()) {
            person.setLegalForms(legalForms);
        }
    }

    private static void parseLegalStatusEntries(JSONObject jsonObject, RPOLegalPerson person) {
        List<RPOOneStringEntry> legalStatusEntries = new ArrayList<>();
        JSONArray legalStatusJSON = jsonObject.getJSONArray(LEGAL_STATUS_ENTRIES);
        if (legalStatusJSON != null) {
            legalStatusJSON.forEach(legalStatus -> {
                JSONObject legalStatusJSONObject = (JSONObject) legalStatus;
                RPOOneStringEntry rpoLegalStatusEntry = new RPOOneStringEntry();
                if (!legalStatusJSONObject.isNull(LEGAL_STATUS_ENTRIES_BODY)) {
                    rpoLegalStatusEntry.setBody(legalStatusJSONObject.getString(LEGAL_STATUS_ENTRIES_BODY));
                }
                setEffectiveDates(rpoLegalStatusEntry, legalStatusJSONObject);
                legalStatusEntries.add(rpoLegalStatusEntry);
            });
        }
        if (!legalStatusEntries.isEmpty()) {
            person.setLegalStatusEntries(legalStatusEntries);
        }
    }

    private static void parseNameEntries(JSONObject jsonObject, RPOLegalPerson person) {
        List<RPOOneStringEntry> nameEntries = new ArrayList<>();
        JSONArray nameJSON = jsonObject.getJSONArray(NAME_ENTRIES);
        if (nameJSON != null) {
            nameJSON.forEach(name -> {
                JSONObject nameJSONObject = (JSONObject) name;
                RPOOneStringEntry rpoNameEntry = new RPOOneStringEntry();
                if (!nameJSONObject.isNull(NAME_ENTRIES_NAME)) {
                    rpoNameEntry.setBody(nameJSONObject.getString(NAME_ENTRIES_NAME));
                }
                setEffectiveDates(rpoNameEntry, nameJSONObject);
                nameEntries.add(rpoNameEntry);
            });
        }
        if (!nameEntries.isEmpty()) {
            person.setNameEntries(nameEntries);
        }
    }

    private static void parsePredecessorSuccessorEntries(JSONObject jsonObject, RPOLegalPerson person, Boolean successor) {
        List<RPOPredecessorSuccessorEntry> predecessorSucessorEntries = new ArrayList<>();
        JSONArray predecessorSucessorJSON = jsonObject.getJSONArray(successor == true ? SUCCESSOR_ENTRIES : PREDECESSOR_ENTRIES);
        if (predecessorSucessorJSON != null) {
            predecessorSucessorJSON.forEach(it -> {
                JSONObject JSONObject = (JSONObject) it;
                RPOPredecessorSuccessorEntry rpoPredecessorEntry = new RPOPredecessorSuccessorEntry();
                if (!JSONObject.isNull(ENTRIES_ICO)) {
                    rpoPredecessorEntry.setIco(JSONObject.getBigInteger(ENTRIES_ICO));
                }
                if (!JSONObject.isNull(ENTRIES_FULL_NAME)) {
                    rpoPredecessorEntry.setName(JSONObject.getString(ENTRIES_FULL_NAME));
                }
                setEffectiveDates(rpoPredecessorEntry, JSONObject);
                predecessorSucessorEntries.add(rpoPredecessorEntry);
            });
        }
        if (!predecessorSucessorEntries.isEmpty()) {
            if (successor == true) {
                person.setSuccessorEntries(predecessorSucessorEntries);
            } else {
                person.setPredecessorEntries(predecessorSucessorEntries);
            }
        }
    }

    private static void parseShareEntries(JSONObject jsonObject, RPOLegalPerson person) {
        List<RPOShareEntry> shares = new ArrayList<RPOShareEntry>();
        JSONArray sharesJSON = jsonObject.getJSONArray(SHARE_ENTRIES);
        if (sharesJSON != null) {
            sharesJSON.forEach(shareIt -> {
                JSONObject shareJSONObject = (JSONObject) shareIt;
                RPOShareEntry share = new RPOShareEntry();
                if (!shareJSONObject.isNull(SHARE_ENTRIES_PRICE)) {
                    share.setPrice(shareJSONObject.getFloat(SHARE_ENTRIES_PRICE));
                }
                if (!shareJSONObject.isNull(SHARE_ENTRIES_CURRENCY)) {
                    share.setCurrency(shareJSONObject.getString(SHARE_ENTRIES_CURRENCY));
                }
                if (!shareJSONObject.isNull(SHARE_ENTRIES_AMOUNT)) {
                    share.setAmount(shareJSONObject.getInt(SHARE_ENTRIES_AMOUNT));
                }
                if (!shareJSONObject.isNull(SHARE_ENTRIES_TRANSFER)) {
                    share.setTransferDescription(shareJSONObject.getString(SHARE_ENTRIES_TRANSFER));
                }
                if (!shareJSONObject.isNull(SHARE_ENTRIES_TYPE)) {
                    JSONObject shareTypeJsonObject = (JSONObject) shareJSONObject.getJSONObject(SHARE_ENTRIES_TYPE);
                    if (!shareTypeJsonObject.isNull(SHARE_ENTRIES_NAME)) {
                        share.setType(shareTypeJsonObject.getString(SHARE_ENTRIES_NAME));
                    }
                }
                if (!shareJSONObject.isNull(SHARE_ENTRIES_FORM)) {
                    JSONObject shareFormJsonObject = (JSONObject) shareJSONObject.getJSONObject(SHARE_ENTRIES_FORM);
                    if (!shareFormJsonObject.isNull(SHARE_ENTRIES_NAME)) {
                        share.setForm(shareFormJsonObject.getString(SHARE_ENTRIES_NAME));
                    }
                }
                setEffectiveDates(share, shareJSONObject);
                shares.add(share);
            });
        }
        if (!shares.isEmpty()) {
            person.setShareEntries(shares);
        }
    }

    private static void parseStakeholderStatutoryEntries(JSONObject jsonObject, RPOLegalPerson person, boolean isStatutory) {
        List<RPOStatutoryStakeholderEntry> statutoriesStakeholders = new ArrayList<RPOStatutoryStakeholderEntry>();
        JSONArray jsonArray = jsonObject.getJSONArray(isStatutory ? STATUTORY_ENTRIES : STAKEHOLDER_ENTRIES);
        if (jsonArray != null) {
            jsonArray.forEach(iter -> {
                JSONObject mainJSONObject = (JSONObject) iter;
                RPOStatutoryStakeholderEntry statutoryStakeholder = new RPOStatutoryStakeholderEntry();
                if(!mainJSONObject.isNull(PERSON_FAMILY_NAME)){
                    statutoryStakeholder.setLastName(mainJSONObject.getString(PERSON_FAMILY_NAME));
                }
                if(!mainJSONObject.isNull(PERSON_GIVEN_NAME)){
                    statutoryStakeholder.setFirstName(mainJSONObject.getString(PERSON_GIVEN_NAME));
                }
                if (!mainJSONObject.isNull(FULL_NAME)) {
                    statutoryStakeholder.setFullName(mainJSONObject.getString(FULL_NAME));
                }
                if (!mainJSONObject.isNull(PERSON_FORMATTED_NAME)) {
                    statutoryStakeholder.setFormattedName(mainJSONObject.getString(PERSON_FORMATTED_NAME));
                }
                if (!mainJSONObject.isNull(ADDRESS_FORMATTED)) {
                    statutoryStakeholder.setFormattedAddress(mainJSONObject.getString(ADDRESS_FORMATTED));
                }
                if (!mainJSONObject.isNull(ADDRESS_STREET)) {
                    statutoryStakeholder.setStreet(mainJSONObject.getString(ADDRESS_STREET));
                }
                if (!mainJSONObject.isNull(ADDRESS_BUILDING_NR)) {
                    statutoryStakeholder.setBuildingNr(mainJSONObject.getString(ADDRESS_BUILDING_NR));
                }
                if (!mainJSONObject.isNull(ADDRESS_COUNTRY)) {
                    statutoryStakeholder.setCountry(mainJSONObject.getString(ADDRESS_COUNTRY));
                }
                if (!mainJSONObject.isNull(ADDRESS_DISTRICT)) {
                    statutoryStakeholder.setDistrict(mainJSONObject.getString(ADDRESS_DISTRICT));
                }
                if (!mainJSONObject.isNull(ADDRESS_MUNICIPALITY)) {
                    statutoryStakeholder.setMunicipality(mainJSONObject.getString(ADDRESS_MUNICIPALITY));
                }
                if (!mainJSONObject.isNull(ADDRESS_POSTAL_CODE)) {
                    statutoryStakeholder.setPostalCode(mainJSONObject.getString(ADDRESS_POSTAL_CODE));
                }
                if (!mainJSONObject.isNull(ENTRIES_ICO)) {
                    statutoryStakeholder.setIco(mainJSONObject.getBigInteger(ENTRIES_ICO).toString());
                }
                if (!mainJSONObject.isNull(STAKEHOLDER_TYPE)) {
                    JSONObject stakeholderTypeJsonObject = (JSONObject) mainJSONObject.getJSONObject(STAKEHOLDER_TYPE);
                    if (!stakeholderTypeJsonObject.isNull(NAME)) {
                        statutoryStakeholder.setType(stakeholderTypeJsonObject.getString(NAME));
                    }
                }
                setEffectiveDates(statutoryStakeholder, mainJSONObject);
                statutoriesStakeholders.add(statutoryStakeholder);
            });
        }
        if (!statutoriesStakeholders.isEmpty()) {
            if (isStatutory) {
                person.setStatutoryEntries(statutoriesStakeholders);
            } else {
                person.setStakeholderEntries(statutoriesStakeholders);
            }
        }
    }

    private static void parseMainActivityCode(JSONObject jsonObject, RPOLegalPerson person) {
        JSONObject maJSONObject = (JSONObject) jsonObject.getJSONObject(MAIN_ACTIVITY_CODE);
        if (!maJSONObject.isNull(NAME_ENTRIES_NAME)) {
            person.setMainActivityCode(maJSONObject.getString(NAME_ENTRIES_NAME));
        }
    }

    private static void parseESA2010Code(JSONObject jsonObject, RPOLegalPerson person) {
        JSONObject esaJSONObject = (JSONObject) jsonObject.getJSONObject(MAIN_ACTIVITY_CODE);
        if (!esaJSONObject.isNull(NAME_ENTRIES_NAME)) {
            person.setEsa2010Code(esaJSONObject.getString(NAME_ENTRIES_NAME));
        }
    }

    private static void setEffectiveDates(AbstractRPOEntry identEntry, JSONObject jsonIdentifier) {
        if (!jsonIdentifier.isNull(EFFECTIVE_FROM)) {
            identEntry.setEffectiveFrom(LocalDate.parse(jsonIdentifier.getString(EFFECTIVE_FROM), DateTimeFormatter.ofPattern(DATE_FORMAT)));
        }
        if (!jsonIdentifier.isNull(EFFECTIVE_TO)) {
            identEntry.setEffectiveTo(LocalDate.parse(jsonIdentifier.getString(EFFECTIVE_TO), DateTimeFormatter.ofPattern(DATE_FORMAT)));
        }
    }
}
