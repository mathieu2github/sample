package paintHouse;

import java.util.Arrays;

public class PaintHouse {
	public class BestResult {
		public int[] colors;
		public int cost;
		public BestResult(int[] colors, int cost) {
			this.colors = colors;
			this.cost = cost;
		}
		
	}	
	private int[][] cost;
	private BestResult[][] best;	
	public PaintHouse(int[][] cost) {
		this.cost = cost;
		this.best = new BestResult[cost.length][cost[0].length];
	}	
	public BestResult calc() {
		return calc(cost[0].length, -1);
	}
	private BestResult calc(int n, int forbiden) {
		if (forbiden >= 0 && best[forbiden][n-1] != null)
			return best[forbiden][n-1];
		BestResult min = null;
		for (int c = 0, h = cost[0].length - n; c< cost.length; ++c) {
			if (c != forbiden) {
				 if (n == 1) {
					 if (min == null || min.cost > cost[c][h]) {
						 min = new BestResult(new int[] {c}, cost[c][h]);
					 }
				 } else {
					 BestResult next = calc(n-1, c);
					 if (min == null 
                                            || min.cost > (next.cost + cost[c][h])) {
						 min = new BestResult(new int[next.colors.length+1], 
                                                   next.cost + cost[c][h]);
						 min.colors[0] = c;
						 System.arraycopy(next.colors, 0, 
                                                  min.colors, 1, next.colors.length);
					 }
				 }
			}
		}
		if (forbiden >= 0)
			best[forbiden][n-1] = min;
		return min;
	}

	public static void main(String[] args) {

			int[][] cost = new int[][] { 
					new int[] { 7, 3, 8, 6, 1, 2},
					new int[] { 5, 6, 7, 2, 4, 3},
					new int[] {10, 1, 4, 9, 7, 6}
			};
			PaintHouse calc = new PaintHouse(cost);
			BestResult bestResult = calc.calc();
			System.out.println("Colors: " + Arrays.toString(bestResult.colors));
			System.out.println("Cost: " + bestResult.cost);		

	}

}

