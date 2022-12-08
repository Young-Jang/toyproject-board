package toyproject.board.application;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toyproject.board.infrastructure.LottoFeignClient;

import org.json.simple.JSONObject;

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
        Object obj = jsonParser.parse(response);
        JSONObject jsonObject = (JSONObject) obj;

        jsonObject.get("drwtNo");
        int count = 0;
        for(int i = 1; i < 7; i++){
            List<Integer> lottoList = lottoService.createLottoNumber();
            System.out.println(lottoList.get(i));
            System.out.println(jsonObject.get("drwtNo"+i));
            if(!lottoList.get(i).equals(jsonObject.get("drwtNo"+i))){
                i=1;
                continue;
            }
            count++;
        }
        System.out.println(count);

    }
}