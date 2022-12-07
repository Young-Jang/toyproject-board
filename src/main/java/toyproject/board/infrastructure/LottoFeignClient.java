package toyproject.board.infrastructure;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import toyproject.board.config.FeignClientConfiguration;

@FeignClient(name = "getLottoNumber", url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber",configuration = FeignClientConfiguration.class)
public interface LottoFeignClient {
    @GetMapping()
    String getLottoNum(@RequestParam("drwNo") int drwNo);
}
