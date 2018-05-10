package bridge;

public abstract class Show {

	public ShowInterface si;
	
	public Show() {}
	
	public Show(ShowInterface si) {
		this.si = si;
	}
	
	public abstract void print();
}
