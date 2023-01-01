package toyproject.almigty.board.domain.model;

import lombok.*;
import toyproject.almigty.board.domain.command.CreateMemberCommand;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String password;

    private String username;

    private String email;

    private String phone;

    private String address;

    public Member(CreateMemberCommand createMemberCommand){
        this.userId = createMemberCommand.getUserId();
        this.password = createMemberCommand.getPassword();
        this.username = createMemberCommand.getUsername();
        this.email = createMemberCommand.getEmail();
        this.phone = createMemberCommand.getPhone();
        this.address = createMemberCommand.getAddress();
    }

    public void patchMember(Member member){
        this.username = member.getUsername();
        this.email = member.getEmail();
        this.phone = member.getPhone();
        this.address = member.getAddress();
    }
}
