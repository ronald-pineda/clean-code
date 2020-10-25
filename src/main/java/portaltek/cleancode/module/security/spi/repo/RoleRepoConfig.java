package portaltek.cleancode.module.security.spi.repo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import portaltek.cleancode.module.security.domain.published.port.spi.repo.RoleRepoPort;
import portaltek.cleancode.module.security.domain.published.port.spi.repo.UserRepoPort;

@Configuration
class RoleRepoConfig {

    @Bean
    public RoleRepoPort roleRepoPort(RoleRepo roleRepo) {
        return new RoleRepoPortImpl(roleRepo);
    }


}