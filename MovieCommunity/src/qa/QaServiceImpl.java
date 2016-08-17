package qa;

import java.util.ArrayList;


public class QaServiceImpl implements QaService{
	private QaDao dao;
	
	public QaServiceImpl(QaDao dao) {
		this.dao = dao;
	}
	@Override
	public void addQa(Qa a) {
		// TODO Auto-generated method stub
		dao.insert(a);
	}

	@Override
	public Qa getQa(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}
	@Override
	public ArrayList<Qa> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public void editQa(Qa a) {
		// TODO Auto-generated method stub
		dao.update(a);
	}

	@Override
	public void delQa(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}
	@Override
	public void addQaRep(QaRep r, int num) {
		// TODO Auto-generated method stub
		dao.insertQaRep(r, num);
	}
	@Override
	public ArrayList<QaRep> allQaRep(int num) {
		// TODO Auto-generated method stub
		return dao.qarepAll(num);
	}

}
