package toyproject.board.application;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LottoService {
    public List<String> createLottoNumber(int count){
        List<String> lottoList = new ArrayList<>();
        List<Integer> lotto = new ArrayList<>();
        for(int j=0;j<count;j++) {
            for (int i = 0; i < 6; i++) {
                int luckyNumber = (int) ((Math.random() * 45) + 1);
                if (lotto.stream().anyMatch(lottoNum -> lottoNum == luckyNumber)) {
                    i--;
                    continue;
                }
                lotto.add(luckyNumber);
            }
            Collections.sort(lotto);
            lottoList.add(lotto.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("-","[","]")));
            lotto.clear();
        }
        return lottoList;
    }
}
