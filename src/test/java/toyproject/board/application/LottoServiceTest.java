package toyproject.board.application;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toyproject.board.infrastructure.LottoFeignClient;

import org.json.simple.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class LottoServiceTest {

    @Autowired
    private LottoService lottoService;

    @Autowired
    private LottoFeignClient lottoFeignClient;

    private Set<String> set;

    @Test
    @DisplayName("로또회차별 당첨 확률")
    void dutchPayServiceTest() throws ParseException {
        //TODO 로또 번호 검증
        int drwNo = 100;
        String response = lottoFeignClient.getLottoNum(drwNo);
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(response);
        JSONObject jsonObject = (JSONObject) obj;
        StringBuilder luckyNumber = new StringBuilder();
        for(int i = 1; i < 7; i++) {
            luckyNumber.append(jsonObject.get("drwtNo"+i));
        }
        System.out.println("[Lucky Number]: "+luckyNumber.toString());
        boolean endFlag = false;
        int count = 0;
        while(!endFlag){
            List<String> lottoList = lottoService.createLottoNumber(1);
            String result = lottoList.get(0).substring(1,lottoList.get(0).length()-1);
            String string = result.replaceAll("-","");
            if(string.equals(luckyNumber.toString()))
                endFlag = true;
            count++;
        }
        System.out.println(count);
    }

    @Test
    void forLoopTest() throws Exception{
        //given
        set = new HashSet<>();
        for(int i = 0 ;i<10000;i++)
            set.add("test"+i);
        set.add("test");
        //when
        String cardName = createCardNickname("test");

        //then
        System.out.println(cardName);
    }
    private boolean existsByCardNickname(String cardNickname){
        return set.contains(cardNickname);
    }

    private String createCardNickname(String cardName) throws UnsupportedEncodingException {
        String cardNickname = cardName;
        int nicknamePostFix = 0;

        while(existsByCardNickname(cardNickname)){
            String nextPostFix = Integer.toString(++nicknamePostFix);
            if(cardName.getBytes("euc-kr").length + nextPostFix.getBytes("euc-kr").length > 20){
                cardNickname = cardName.substring(0,20 - nextPostFix.getBytes("euc-kr").length) + nextPostFix;
            }else{
                cardNickname = cardName+nextPostFix;
            }
        }
        return cardNickname;
    }
}