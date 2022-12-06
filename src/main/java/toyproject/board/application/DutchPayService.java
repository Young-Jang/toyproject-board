package toyproject.board.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toyproject.board.rest.DTO.DutchPayReqDTO;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DutchPayService {
    public String dutch(DutchPayReqDTO dutchPayReqDTO){
        Map<String,Double> amountMap = new HashMap<>();
        dutchPayReqDTO.getPayInfoList().forEach(payInfo -> {
            Double perAmount = payInfo.getAmount()/payInfo.getPeople().size();
            payInfo.getPeople().forEach(name->{
                if(amountMap.containsKey(name)){
                    amountMap.put(name,  amountMap.get(name)+perAmount);
                }else{
                    amountMap.put(name,  perAmount);
                }
            });
        });
        return buildPerAmountMessage(amountMap,dutchPayReqDTO.getBankName(), dutchPayReqDTO.getBankNumber());
    }

    private String buildPerAmountMessage(Map<String,Double> amountMap,String bankName, String bankNumber){
        StringBuilder stringBuilder = new StringBuilder();
        amountMap.forEach((name,amount)->{
            stringBuilder.append(name).append(":").append(amount.intValue()).append("원\n");
        });
        stringBuilder.append("입금계좌: ").append(bankName).append(bankNumber);
        return stringBuilder.toString();
    }
}
