package com.demos.agora.user;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"boards"})
    List<User> findAll();

    // fineBy[컬럼이름] : 컬럼이름에 일치하는 사용자 데이터를 가져옴
    /* db table을 보면 username는 unique 제약조건이 걸려있으므로 하나의 데이터나
       없는 null값이 들어감 */
    User findByUsername(String username);

    // jsql임
    // %~~% %안에 있는 문자를 검색함. ?1은 첫번째 파라미터부터 보라는 뜻
    // 외부에서 메서드를 호출하게 되면 jsql이 sql로 변환돼서 호출된다.
    @Query("select u from User u where u.username like %?1%")
    List<User> findByUsernameQuery(String username);

    // NativeQuery로 할 경우에는 순수 sql query가 호출됨
    @Query(value = "select u from User u where u.username like %?1%", nativeQuery = true)
    List<User> findByUsernameNativeQuery(String username);
}