import java.util.Random;

public class Die {
	private Random rand = new Random();
	int dice;
	public Die() {
		this.rand = new Random();
		}
	public int roll() {
		dice = this.rand.nextInt(5);
		return dice;
	}
}
