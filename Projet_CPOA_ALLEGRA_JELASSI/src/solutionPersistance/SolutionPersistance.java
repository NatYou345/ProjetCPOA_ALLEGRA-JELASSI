package solutionPersistance;

public class SolutionPersistance {

	Persistance Pers;
	
	public SolutionPersistance() {
		
		Pers = Persistance.MYSQL;
	}
	
	
	

	/**
	 * @return the pers
	 */
	public Persistance getPers() {
		return Pers;
	}

	/**
	 * @param pers the pers to set
	 */
	public void setPers(Persistance pers) {
		this.Pers=pers;
	}

}
