package toyproject.almigty.calculate.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toyproject.almigty.calculate.application.DutchPayService;
import toyproject.almigty.calculate.rest.DTO.DutchPayReqDTO;
import toyproject.almigty.config.ControllerDocumentation;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calcuate/")
@ControllerDocumentation
public class CalculateController {

    private final DutchPayService dutchPayService;

    @PostMapping("dutch-pay")
    public ResponseEntity<Object> dutchPay(@RequestBody DutchPayReqDTO dutchPayReqDTO){
        return new ResponseEntity(dutchPayService.dutch(dutchPayReqDTO), HttpStatus.OK);
    }
}
