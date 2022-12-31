package toyproject.almigty.board.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetUserInfoServiceTest {
    @InjectMocks
    private GetUserInfoService getUserInfoService;

    @Test
    @DisplayName("유저 정보를 가져온다.")
    public void getUserInfoSuccess() throws Exception{
        //given
        //when
        //then
        Assertions.assertThat( getUserInfoService.getUserInfo("").equals("success"));
    }
}