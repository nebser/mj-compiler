package rs.ac.bg.etf.pp1.util;

import java.util.ArrayList;

public class VarList {
	private ArrayList<Var> vars = new ArrayList<Var>();

	public void add(Var v) {
		vars.add(v);
	}

	public void add(VarList varList) {
		varList.vars.forEach(v -> {
			vars.add(v);
		});
	}

	public ArrayList<Var> getVars() {
		return vars;
	}

	public int size() {
		return vars.size();
	}
}
