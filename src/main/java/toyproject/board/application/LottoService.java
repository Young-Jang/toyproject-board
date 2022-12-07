package toyproject.board.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LottoService {
    public List<Integer> createLottoNumber(){
        List<Integer> lotto = new ArrayList<>();

        for(int i=0;i<6;i++){
            int luckyNumber = (int) ((Math.random()*45)+1);
            if(lotto.stream().anyMatch(lottoNum->lottoNum==luckyNumber)) {
                i--;
                continue;
            }
            lotto.add(luckyNumber);
        }
        Collections.sort(lotto);
        return lotto;
    }
}
