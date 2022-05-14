package Week6;

public class pNode {
	pNode next;
	int playerID;
	String firstName;
	String lastName;
	String playerName;
	String playerType;
	float lifePoints;
	int totalScore;
	/**
	 * @param playerID
	 * @param firstName2
	 * @param lastName2
	 * @param playerName
	 * @param playerType
	 * @param lifePoints
	 * @param totalScore
	 */
	public pNode(int playerID, String firstName, String lastName, String playerName, String playerType, float lifePoints,
			int totalScore) {
		this.playerID = playerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.playerName = playerName;
		this.playerType = playerType;
		this.lifePoints = lifePoints;
		this.totalScore = totalScore;
	}
	
	
	
}

