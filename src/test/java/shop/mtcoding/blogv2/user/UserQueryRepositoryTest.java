package shop.mtcoding.blogv2.user;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(UserQueryRepository.class)
@DataJpaTest
public class UserQueryRepositoryTest {

    @Autowired
    private UserQueryRepository userQueryRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void save_test() {
        User user = User.builder()
                .username("love")
                .password("1234")
                .email("love@nate.com")
                .build();
        userQueryRepository.save(user); // 영속화
        // em.flush();

    }

    // 1차 캐시
    @Test
    public void findById_test() {
        System.out.println("1. pc는 비어았다");
        userQueryRepository.findById(1);
        System.out.println("2. pc의 user 1은 영속화 되어 있다");
        userQueryRepository.findById(2);
    }
}
