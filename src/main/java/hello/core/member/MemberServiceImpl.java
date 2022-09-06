package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 인터페이스만 있으면 NullPointerException발생 -> 구현 객체를 선택해줘야함
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 실제 할당하는 부분은 구현체를 의존하고 있음
    // 따라서 멤버서비스임플이 추상화(멤버레파지토리)와 구체화(메모리멤버레파지토리) 모두 의존중임 => DIP를 위반하고있음

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
