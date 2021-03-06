package portaltek.cleancode.module.security.spi.repo;


import portaltek.cleancode.infra.util.Converter;
import portaltek.cleancode.module.security.core.published.domain.RoleDO;

class RoleConverter implements Converter<Role, RoleDO> {


    @Override
    public Role fromDomain(RoleDO domain) {
        Role dto = new Role();
        dto.setId(domain.id());
        dto.setRoleName(domain.name());
        return dto;
    }

    @Override
    public RoleDO toDomain(Role dto) {
        return toDomain(RoleDO.builder().build(), dto);
    }


    public RoleDO toDomain(RoleDO domain, Role dto) {
        return domain
                .id(dto.getId())
                .name(dto.getRoleName());
    }

}
