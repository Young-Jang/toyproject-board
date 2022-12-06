package toyproject.board.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toyproject.board.rest.DTO.DutchPayReqDTO;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DutchPayServiceTest {

    @Autowired
    private DutchPayService payService;


    @Test
    void dutchPayServiceTest(){
        List<DutchPayReqDTO.PayInfo> list = new ArrayList<>();
        List<String> people1 = new ArrayList<>();
        people1.add("A");
        people1.add("B");
        people1.add("C");

        List<String> people2 = new ArrayList<>();
        people2.add("B");

        list.add(DutchPayReqDTO.PayInfo.builder()
                .amount(15000d)
                .people(people1)
                .build());

        list.add(DutchPayReqDTO.PayInfo.builder()
                .amount(5000d)
                .people(people2)
                .build());

        DutchPayReqDTO dutchPayReqDTO = DutchPayReqDTO.builder()
                .bankName("신한")
                .bankNumber("111111111111")
                .payInfoList(list)
                .build();

        String result = payService.dutch(dutchPayReqDTO);
        String[] splitResult = result.split("\n");
        assertEquals(splitResult[0],"A:5000원");
        assertEquals(splitResult[1],"B:10000원");
        assertEquals(splitResult[2],"C:5000원");
        assertEquals(splitResult[3],"입금계좌: 신한111111111111");
    }
}