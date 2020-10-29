import java.util.Scanner;

public class DIeSimulation {
	private Die die;
	private Counter[] fiveCounters;
	public DIeSimulation() {
		fiveCounters = new Counter[5];
		this.die = new Die();
		fiveCounters[0] = new Counter("zero");
		fiveCounters[1] = new Counter("one");
		fiveCounters[2] = new Counter("two");
		fiveCounters[3] = new Counter("three");
		fiveCounters[4] = new Counter("four");
	}
	public String run() {
		Scanner sc = new Scanner(System.in);
		int numRuns = sc.nextInt();
		for (int i = 0; i < numRuns; i++) {
			this.die.roll();
			if (this.die.roll() == 0) {
				fiveCounters[0].increment();
			}
			else if (this.die.roll() == 1) {
				this.fiveCounters[1].increment();
			}
			else if (this.die.roll() == 2) {
				this.fiveCounters[2].increment();
			}
			else if (this.die.roll() == 3) {
				this.fiveCounters[3].increment();
			}
			else if (this.die.roll() == 4) {
				this.fiveCounters[4].increment();
			}
		}
		return this.fiveCounters[0].toString() + this.fiveCounters[1].toString() + this.fiveCounters[2].toString() + this.fiveCounters[3].toString() + this.fiveCounters[4].toString();
	}
	public static void main(String[] args) {
		DIeSimulation dieSim = new DIeSimulation();
		System.out.println(dieSim.run());
	}
}
