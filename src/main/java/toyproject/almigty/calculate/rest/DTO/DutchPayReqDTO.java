package toyproject.almigty.calculate.rest.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DutchPayReqDTO {
    private String bankName;
    private String bankNumber;
    private List<PayInfo> payInfoList;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class PayInfo {
        private Double amount;
        private List<String> people;
    }
}
