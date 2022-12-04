package toyproject.board.rest.DTO;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateMemberReqDTO {

    @NotNull
    private String userId;
    @NotNull
    private String password;

    private String username;

    private String email;

    private String phone;

    private String address;
}
