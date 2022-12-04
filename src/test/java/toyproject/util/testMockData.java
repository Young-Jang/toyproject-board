package toyproject.util;

import toyproject.board.domain.command.CreateMemberCommand;

public class testMockData {
    public static CreateMemberCommand commonCreateMemberCommand(){
        return CreateMemberCommand.builder()
                .userId("testId")
                .password("password")
                .phone("000-0000-0000")
                .email("test@com")
                .address("korea")
                .username("tester")
                .build();
    }
}
