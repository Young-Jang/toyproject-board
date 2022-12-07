package toyproject.board.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toyproject.board.application.DutchPayService;
import toyproject.board.application.LottoService;
import toyproject.board.rest.DTO.DutchPayReqDTO;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calcuate/")
public class CalculateController {

    private final DutchPayService dutchPayService;
    private final LottoService lottoService;

    @PostMapping("dutch-pay")
    public ResponseEntity<Object> dutchPay(@RequestBody DutchPayReqDTO dutchPayReqDTO){
        return new ResponseEntity(dutchPayService.dutch(dutchPayReqDTO), HttpStatus.OK);
    }


    @GetMapping("get-lotto")
    public ResponseEntity<Object> getLotto(){
        return new ResponseEntity(lottoService.createLottoNumber().stream()
                .map(String::valueOf)
                .collect(Collectors.joining("-","[","]")), HttpStatus.OK);
    }
}
