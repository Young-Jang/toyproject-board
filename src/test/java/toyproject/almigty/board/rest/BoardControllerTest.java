package toyproject.almigty.board.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import toyproject.almigty.board.application.BoardService;
import toyproject.almigty.board.application.CustomOAuth2UserService;
import toyproject.almigty.board.application.GetUserInfoService;
import toyproject.almigty.board.application.RestJsonService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static toyproject.almigty.common.constants.BoardApiUrl.GET_BOARD_LIST;

@MockBean(JpaMetamodelMappingContext.class)
@WebMvcTest(BoardController.class)
@AutoConfigureMockMvc
class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private BoardService boardService;
    @MockBean
    private RestJsonService restJsonService;
    @MockBean
    private GetUserInfoService getUserInfoService;
    @MockBean
    private CustomOAuth2UserService customOAuth2UserService;
    @MockBean
    private ClientRegistrationRepository clientRegistrationRepository;

    @Test
    void JsonParserTest() throws ParseException {
        String jsonString = "{\"access_token\":\"c1Kwf1wrvQOwUyzmuR7c8G066BbLWxseQ0EIxdmsCisMpwAAAYVBlptl\",\"token_type\":\"bearer\",\"refresh_token\":\"1pOUd3Rb2gHSevL9zQ1GDSXbfQGxdeKxi4dEXeOwCisMpwAAAYVBlptk\",\"expires_in\":21599,\"scope\":\"account_email\",\"refresh_token_expires_in\":5183999}";
        JSONParser parser = new JSONParser();
        JSONObject jsonObject =(JSONObject) parser.parse(jsonString);
        System.out.println((String) jsonObject.get("access_token"));
    }

    @Test
    @DisplayName("게시판 리스트를 조한다.")
    void getList() throws Exception{
        //given

        //when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders.get(GET_BOARD_LIST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        //then
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}