package com.parsing;

import com.model.Municipality;
import com.model.User;

import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Parser helper class: keeps the internal state of {@link User} and {@link Municipality} data
 */
public class UserMunicipalityParserHelper {

    private final LinkedList<User> users = new LinkedList<>();

    private final HashMap<String, Municipality> municipalitiesMap = new HashMap<>();

    private final MunicipalityParser municipalityParser = new MunicipalityParser();

    private final UserParser userParser = new UserParser();

    /**
     * Parses an input list of String representing municipalities and populates municipalities map;
     *
     * @param municipalitiesRow
     */
    public void parseMunicipalities(List<String> municipalitiesRow) {
        municipalitiesRow.forEach(municipalityStr -> {
            if (municipalityStr.trim().length() > 0) {
                Municipality municipality = municipalityParser.parseLine(municipalityStr);
                municipalitiesMap.put(municipality.getCode(), municipality);
            }
        });
    }

    /**
     * Parses an input list of String representing users and populates users list.
     * Use the {@link Municipality} information inside municipalityMap to enrich {@link User} data.
     *
     * @param usersRow
     */
    public void parseUsers(List<String> usersRow) {
        usersRow.forEach(userStr -> {
            if (userStr.trim().length() > 0) {
                try {
                    User user = userParser.parseLine(userStr);
                    Municipality municipality = this.municipalitiesMap.get(user.getMunicipalityCode());
                    if (municipality == null) {
                        throw new ParsingException("User Municipality Code " + user.getMunicipalityCode() + " does not exist");
                    } else {
                        user.setMunicipalityOpt(Optional.of(municipality));
                        users.add(user);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                    throw new ParsingException(e.getMessage());

                }
            }
        });
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    public HashMap<String, Municipality> getMunicipalitiesMap() {
        return municipalitiesMap;
    }
}
