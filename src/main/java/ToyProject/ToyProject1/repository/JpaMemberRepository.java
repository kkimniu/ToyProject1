package ToyProject.ToyProject1.repository;

import ToyProject.ToyProject1.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
       Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByUserId(String userid) {
        return em.createQuery("SELECT m FROM Member m WHERE m.userid = :userid", Member.class).
                setParameter("userid", userid)
                .getResultStream()
                .findAny();

    }

    @Override
    public Optional<Member> existsByUserId(String userid) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m",Member.class).getResultList();
    }
}
