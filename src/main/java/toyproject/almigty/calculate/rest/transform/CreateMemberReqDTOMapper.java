package toyproject.almigty.calculate.rest.transform;


import org.mapstruct.Mapper;
import toyproject.almigty.board.domain.command.CreateMemberCommand;
import toyproject.almigty.board.rest.DTO.CreateMemberReqDTO;

@Mapper(componentModel = "spring")
public interface CreateMemberReqDTOMapper {
    CreateMemberCommand toCommand(CreateMemberReqDTO createMemberReqDTO);
}
