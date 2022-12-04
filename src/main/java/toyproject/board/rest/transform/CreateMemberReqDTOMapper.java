package toyproject.board.rest.transform;


import org.mapstruct.Mapper;
import toyproject.board.domain.command.CreateMemberCommand;
import toyproject.board.rest.DTO.CreateMemberReqDTO;

@Mapper(componentModel = "spring")
public interface CreateMemberReqDTOMapper {
    CreateMemberCommand toCommand(CreateMemberReqDTO createMemberReqDTO);
}
