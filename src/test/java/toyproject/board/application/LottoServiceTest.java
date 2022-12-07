package toyproject.board.application;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toyproject.board.infrastructure.LottoFeignClient;

import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class LottoServiceTest {

    @Autowired
    private LottoService lottoService;

    @Autowired
    private LottoFeignClient lottoFeignClient;

    @Test
    void dutchPayServiceTest() throws ParseException {
        //TODO 로또 번호 검증
        int drwNo = 100;
        String response = lottoFeignClient.getLottoNum(drwNo);
        JSONParser jsonParser = new JSONParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(response);

        jsonObject.get("drwtNo");

        lottoService.createLottoNumber();

    }
}