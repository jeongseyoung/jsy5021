package qa;

import java.util.ArrayList;



public interface QaService {
	void addQa(Qa a);
	Qa getQa(int num);
	ArrayList<Qa> getAll();
	void editQa(Qa a);
	void delQa(int num);
	void addQaRep(QaRep r, int num);
	ArrayList<QaRep> allQaRep(int num);
}
