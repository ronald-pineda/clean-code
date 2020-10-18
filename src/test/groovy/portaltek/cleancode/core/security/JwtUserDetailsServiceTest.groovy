package portaltek.cleancode.core.security

import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import portaltek.cleancode.spi.datastore.model.User
import portaltek.cleancode.spi.datastore.repository.UserRepo
import spock.lang.Specification

class JwtUserDetailsServiceTest extends Specification {

    UserRepo userRepo = Mock(UserRepo)
    User user = new User("Username","Password", true)
    UserDetailsService service = new JwtUserDetailsService(userRepo);


    def "load existing user by username returns UserDetails"() {
        given:
        userRepo.findByUsername("Username") >> user

        when:
        def userFound = service.loadUserByUsername("Username")

        then:
        userFound != null
        userFound.username == 'Username'
    }

    def "load non-existing user by username throws UsernameNotFoundException"() {
        given:

        when:
        service.loadUserByUsername("Username")

        then:
        UsernameNotFoundException ex = thrown()
        ex.message == "No user found with username 'Username'."
    }

}