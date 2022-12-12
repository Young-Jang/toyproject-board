package toyproject.almigty.lotto.rest;

import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import toyproject.almigty.config.ControllerDocumentation;
import toyproject.almigty.lotto.application.LottoService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lotto/")
@ControllerDocumentation
public class LottoController {

    private final LottoService lottoService;

    @GetMapping("get-lucky-number")
    public ResponseEntity<Object> getLotto(@RequestParam int count){
        return new ResponseEntity(lottoService.createLottoNumber(count), HttpStatus.OK);
    }

    @GetMapping("win-percentage")
    public ResponseEntity<Object> getWinPercentage(@RequestParam int drwNo) throws ParseException {
        return new ResponseEntity(lottoService.getWinPercentage(drwNo), HttpStatus.OK);
    }
}
