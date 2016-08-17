/**
 * 
 */
package member;


public class Member {
	private String id;
	private String pwd;	
	private String email;

	public Member() {
	}

	public Member(String id, String pwd, String email) {
		this.id = id;
		this.pwd = pwd;		
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj != null && obj instanceof Member) {
			Member m = (Member) obj;
			if (this.id.equals(m.getId())) {
				return true;
			}
		}
		return false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Membership [id=" + id + ", pwd=" + pwd + ", email=" + email + "]";
	}

}
