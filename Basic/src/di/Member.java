package di;


public class Member {
	/*
	 * MemberUser의 생성자가 public에서 private로 변경되었다.
	 * MemberUser를  new 객체로 생성한 모든 class는 에러 발생!!
	 * MemberUser객체 선언만 한 느슨한 결합은 에러없이 잘 수행될 수 있음.
	 * ->Spring에서 DI를 궁극적으로 사용하는 이유이다!
	 */
	
	//강한결합!!
	Member() {
		//MemberUser m = new MemberUser("hi","hellow","andonggue");
		
		
	}
	//느슨한결합
	void Meber(MemberUser m)
	{
		m.setId("hi");
		m.setPasswd("hellow");
		m.setName("andonggue");
	}
}

