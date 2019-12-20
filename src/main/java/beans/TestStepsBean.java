package beans;

public class TestStepsBean extends BinaryTrade {
	byte[] stepno, actionstep, expectedstep;

	public TestStepsBean(String stepno, String actionstep, String expectedstep) {
		setStepno(stepno);
		setActionstep(actionstep);
		setExpectedstep(expectedstep);
	}

	public String getStepno() {
		try {
			return new String(stepno);
		} catch (NullPointerException ne) {
			return "";
		}
	}

	public void setStepno(String Stepno) {
		if (Stepno == null || Stepno.length() == 0) {
			return;
		}
		this.stepno = new byte[Stepno.length()];
		string2Bytes(Stepno, this.stepno);
	}

	public String getActionstep() {
		try {
			return new String(actionstep);
		} catch (NullPointerException ne) {
			return "";
		}
	}

	public void setActionstep(String Actionstep) {
		if (Actionstep == null || Actionstep.length() == 0) {
			return;
		}
		this.actionstep = new byte[Actionstep.length()];
		string2Bytes(Actionstep, this.actionstep);
	}

	public String getExpectedstep() {
		try {
			return new String(expectedstep);
		} catch (NullPointerException ne) {
			return "";
		}
	}

	public void setExpectedstep(String Expectedstep) {
		if (Expectedstep == null || Expectedstep.length() == 0) {
			return;
		}
		this.expectedstep = new byte[Expectedstep.length()];
		string2Bytes(Expectedstep, this.expectedstep);
	}
}
