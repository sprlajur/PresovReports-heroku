/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author sprlajur
 */
public class RPOApiDataGetter {

    private static final String RPO_API_BASE_URL = "https://datahub.ekosystem.slovensko.digital/api/datahub/corporate_bodies/search?q=cin:";
    private static final String AUTHORIZATION_TOKEN = "Token b0464a12da0721c24a64b37cda01dd125f98abd04108d57e753d8c02f2014cda62ac11044aa32c14";
    private static final int HTTP_OK_CODE = 200;

    public static RPOLegalPerson getRPOData(String ico) {
        if (ico == null || ico.isEmpty()) {
            return null;
        }
        RPOLegalPerson legalPerson = new RPOLegalPerson();
        String jsonData = getLegalPersonAPIJsonData(RPO_API_BASE_URL + ico, true);
        legalPerson = RPOJsonParser.parseIntermediaryAPIData(jsonData, legalPerson);
        if (legalPerson != null) {
            jsonData = getLegalPersonAPIJsonData(legalPerson.getRpo_API_url(), false);
            RPOJsonParser.parseFullRPOData(jsonData, legalPerson);
            jsonData = getLegalPersonAPIJsonData(legalPerson.getAccounting_entities_API_url(), false);
            RPOJsonParser.parseAccountingEntitiesData(jsonData, legalPerson);
        }
        return legalPerson;
    }

    public static String getLegalPersonAPIJsonData(String apiUrl, boolean authorizationRequired) {
        if (apiUrl == null || apiUrl.isEmpty()) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (authorizationRequired) {
                conn.setRequestProperty("Authorization", AUTHORIZATION_TOKEN);
            }
            if (conn.getResponseCode() == HTTP_OK_CODE) {
                try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String line;
                    while ((line = rd.readLine()) != null) {
                        result.append(line);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
