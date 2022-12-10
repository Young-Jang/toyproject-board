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
        int count = 1;
        boolean endFlag = false;
        while(!endFlag){
            List<String> lottoList = lottoService.createLottoNumber(1);
            String result = lottoList.get(0).substring(1,lottoList.get(0).length()-1);
            String[] strings = result.split("-");
            for(int i = 1; i < 7; i++){
                if(!strings[i-1].equals(jsonObject.get("drwtNo"+i))){
                    break;
                }
                if(i==6)
                    endFlag = true;

            }
            System.out.println(count++);
        }
    }
}