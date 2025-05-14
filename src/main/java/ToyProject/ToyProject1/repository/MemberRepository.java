package ToyProject.ToyProject1.repository;

import ToyProject.ToyProject1.domain.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByUserId(String userid);
    Optional<Member> existsByUserId(String id);
    List<Member> findAll();

}
