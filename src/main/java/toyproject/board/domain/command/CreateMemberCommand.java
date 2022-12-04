package toyproject.board.domain.command;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateMemberCommand {

    private String userId;

    private String password;

    private String username;

    private String email;

    private String phone;

    private String address;
}
