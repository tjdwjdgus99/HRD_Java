package ch14;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory1(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
			System.out.println("1");
		} catch (InterruptedException e) {
			System.out.println("2");
		}
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}
	

	public void setMemory2(int memory) {
		synchronized (this) {
			this.memory = memory;
			try {
				Thread.sleep(2000);
				System.out.println("3");
			} catch (InterruptedException e) {
				System.out.println("4");
			}
			System.out.println(Thread.currentThread().getName() + ": " + this.memory);

		}
	}

}