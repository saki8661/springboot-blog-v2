package shop.mtcoding.blogv2.board;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * save(), findById(), findAll(), count(), deleteById()
 */
// 스프링이 실행될 때, BoardRepository의 구현체가 Ioc컨테이너에 로드된다
public interface BoardRepository extends JpaRepository<Board, Integer> {

}
