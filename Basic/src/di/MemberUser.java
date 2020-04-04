package di;

public class MemberUser {
	private String name;
	private String passwd;
	private String id;
	
	private MemberUser(String id, String passwd, String name){
		this.name = name;
		this.passwd= passwd;
		this.id = id;
	}

	@Override
	public String toString() {
		return "MemberUser [name=" + name + ", passwd=" + passwd + ", id=" + id + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
