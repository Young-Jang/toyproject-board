package toyproject.board.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toyproject.board.application.DutchPayService;
import toyproject.board.rest.DTO.DutchPayReqDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calcuate/")
public class CalculateController {

    private final DutchPayService dutchPayService;

    @PostMapping("dutch-pay")
    public ResponseEntity<Object> dutchPay(@RequestBody DutchPayReqDTO dutchPayReqDTO){
        return new ResponseEntity(dutchPayService.dutch(dutchPayReqDTO), HttpStatus.OK);
    }
}
