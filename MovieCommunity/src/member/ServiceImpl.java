package member;

import java.util.ArrayList;

public class ServiceImpl implements Service{

	private Dao dao;

	public ServiceImpl(Dao dao){
		this.dao = dao;
	}
	
	@Override
	public void join(Member m) {
		// TODO Auto-generated method stub
		dao.insert(m);
	}

	@Override
	public Member getMember(String id) {
		// TODO Auto-generated method stub
		return dao.select(id);
	
	}

	@Override
	public void editMember(Member m) {
		// TODO Auto-generated method stub
		dao.update(m);
	}

	@Override
	public void delMember(String id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public boolean checkId(String id) {
		// TODO Auto-generated method stub
		return dao.checkId(id);
	}

	@Override
	public ArrayList<Member> getMembers() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		Member m = dao.select(id);
		if (m != null) {
			if (pwd.equals(m.getPwd())) {
				return true;
			}
		}
		return false;
	}
		
		
		
	}
