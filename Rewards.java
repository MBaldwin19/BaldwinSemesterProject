/*
Michelle Baldwin
SDEV200
Semester Project 
Reward class
Last update: 10/10/21
*/
import java.util.*;

public class Rewards {
	private Map<Integer, String> rewardList = new HashMap<Integer, String>();
	
	//assign default rewards to reward map
	public Rewards() {
		rewardList.put(50, "Take a bath");
		rewardList.put(75, "Do a face mask");
		rewardList.put(100, "Eat a small sweet treat");
		rewardList.put(150, "Drink a glass of wine");
		rewardList.put(200, "Buy yourself flowers");
		//add more default rewards for full program
	}
	//create a completely custom list of rewards
	//this isn't used in this main program, but would be beneficial for further upgrades
	public Rewards(Integer points, String reward) {
		rewardList.put(points, reward);
	}
	
	//getter
	public Map<Integer, String> getRewardList() {
		return rewardList;
	}
	
	//add a custom reward to the map
	public void addReward(Integer points, String reward) {
		rewardList.put(points, reward);
	}
	
	//output complete list of rewards
	public void printRewards() {
		Iterator<Map.Entry<Integer, String>> iterator = rewardList.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, String> reward = iterator.next();
			System.out.println("Points : " + reward.getKey());
			System.out.println("Reward: " + reward.getValue());
		}
	}
}
