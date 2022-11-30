package toyproject.board.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String email;

    private String phone;

    private String address;

    public void patchMember(Member member){
        this.username = member.getUsername();
        this.email = member.getEmail();
        this.phone = member.getPhone();
        this.address = member.getAddress();
    }
}
