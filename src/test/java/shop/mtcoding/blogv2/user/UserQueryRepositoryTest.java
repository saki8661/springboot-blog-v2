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
        em.clear();
        userQueryRepository.findById(1);
    }

    @Test
    public void update_test() {
        // JPA update 알고리즘
        // 1. 업데이트 할 객체를 영속화
        // 2. 객체 상태 변경
        // 3. em.flush() or @Transactional 정상 종료
        // 테스트의 끝은 롤백이 일어나기 때문에 트랜잭션을 확인 할 수 없다
        User user = userQueryRepository.findById(1);
        user.setEmail("ssarmango@nate.com");
        em.flush();
    } // rollback
}
