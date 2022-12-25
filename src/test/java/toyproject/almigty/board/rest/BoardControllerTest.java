package toyproject.almigty.board.rest;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
class BoardControllerTest {

    @Test
    void JsonParserTest() throws ParseException {
        String jsonString = "{\"access_token\":\"c1Kwf1wrvQOwUyzmuR7c8G066BbLWxseQ0EIxdmsCisMpwAAAYVBlptl\",\"token_type\":\"bearer\",\"refresh_token\":\"1pOUd3Rb2gHSevL9zQ1GDSXbfQGxdeKxi4dEXeOwCisMpwAAAYVBlptk\",\"expires_in\":21599,\"scope\":\"account_email\",\"refresh_token_expires_in\":5183999}";
        JSONParser parser = new JSONParser();
        JSONObject jsonObject =(JSONObject) parser.parse(jsonString);
        System.out.println((String) jsonObject.get("access_token"));
    }

}