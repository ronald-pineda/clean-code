package portaltek.cleancode.module.security.api.web.user;


import portaltek.cleancode.infra.util.Converter;
import portaltek.cleancode.module.security.domain.published.core.UserDO;

class UserDtoConverter implements Converter<UserDto, UserDO> {

    public UserDtoConverter() {
    }

    @Override
    public UserDto fromDomain(UserDO domain) {
        return UserDto.builder()
                .id(domain.id())
                .username(domain.username())
                .enabled(domain.enabled())
                .build();
    }

    @Override
    public UserDO toDomain(UserDto userDTO) {
        return UserDO.builder()
                .id(userDTO.id())
                .username(userDTO.username())
                .enabled(userDTO.enabled())
                .build();
    }
}