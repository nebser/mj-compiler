package rs.ac.bg.etf.pp1.util;

import java.util.ArrayList;

import rs.etf.pp1.symboltable.concepts.Obj;

public class ObjList {
	private ArrayList<Obj> objs = new ArrayList<Obj>();

	public ArrayList<Obj> getObjs() {
		return objs;
	}

	public void add(Obj o) {
		objs.add(o);
	}

	public void add(ObjList objList) {
		objList.objs.forEach(o -> {
			objs.add(o);
		});
	}

	public int size() {
		return objs.size();
	}
}
