package portaltek.cleancode.module.security.spi.repo;


import portaltek.cleancode.module.security.domain.published.core.RoleDO;
import portaltek.cleancode.module.security.domain.published.port.spi.repo.RoleRepoPort;

class RoleRepoPortImpl implements RoleRepoPort {

    private RoleRepo roleRepo;
    private RoleConverter converter;

    public RoleRepoPortImpl(RoleRepo roleRepo,
                            RoleConverter converter) {
        this.roleRepo = roleRepo;
        this.converter = converter;
    }

    @Override
    public RoleDO create(RoleDO domain) {
        Role role = converter.fromDomain(domain);
        roleRepo.save(role);
        return converter.toDomain(role);
    }

    @Override
    public RoleDO read(Integer id) {
        Role role = roleRepo.findById(id)
                .orElseThrow(NoRecordFoundException::new);
        return converter.toDomain(role);
    }

    @Override
    public RoleDO update(RoleDO role) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
