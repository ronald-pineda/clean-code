package portaltek.cleancode.module.security.core.published.port.spi.repo;


import portaltek.cleancode.module.security.core.published.domain.UserDO;


public interface UserRepoPort {

    UserDO findUserById(Long id);
    UserDO findUserByUsername(String username);
    UserDO create(UserDO u);
}
