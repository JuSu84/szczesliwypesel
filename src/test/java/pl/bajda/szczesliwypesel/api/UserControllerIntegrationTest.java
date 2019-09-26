package pl.bajda.szczesliwypesel.api;


import org.junit.*;
import org.junit.runner.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import pl.bajda.szczesliwypesel.model.User;
import pl.bajda.szczesliwypesel.repository.UserRepository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserControllerIntegrationTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void whenFindByName_thenReturnUser() {
        // given
        User stefan = new User();

        stefan.setName("Stefan");
        stefan.setEmail("stefan@gmail.com");
        entityManager.persist(stefan);
        entityManager.flush();

        // when
        List<User> found = userRepository.findByName(stefan.getName());

        // then
        assertThat(found.get(0).getName()).isEqualTo("Stefan");

    }

    @Test
    public void whenFindById_thenReturnUser() {
        // given
        User stefan = new User();

        stefan.setName("Stefan");
        stefan.setEmail("stefan@gmail.com");
        entityManager.persist(stefan);
        entityManager.flush();

        // when
        User found = userRepository.findById(stefan.getId()).get();

        // then
        assertThat(found.getId()).isEqualTo(stefan.getId());
    }

    @Test
    public void whenDeleteById_thenIsNotPresent() {
        // given
        User stefan = new User();

        stefan.setName("Stefan");
        stefan.setEmail("stefan@gmail.com");
        entityManager.persist(stefan);
        entityManager.flush();

        // when
        userRepository.deleteById(stefan.getId());

        // then
        assert !userRepository.findById(stefan.getId()).isPresent();
    }

}
