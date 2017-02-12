
public class CountPerfectSquare {

	/*
	 * An Integer P is a whole Square if it is a square of some integer Q
	 * if P = Q^2
	 *
	 * For example, A = 6 B = 16, return 2
	 *
	 * Two Solution
	 *
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer1 = solution1(9,16);
		int answer2 = solution2(1,10);
		System.out.println("Solution 1");
		System.out.println(answer1);
		System.out.println("Solution 2");
		System.out.println(answer2);
	}

	public static int solution2(int A, int B){
		return (int)(Math.floor(Math.sqrt(B)) - Math.ceil(Math.sqrt(A)) +1);
	}

	public static int solution1(int A, int B){

		int count = 0;

		for(int i = A ; i <= B ; i++){

			for(int j = 1 ; j*j <= i ; j++){
				if(j*j == i ){
					count++;
				}
			}
		}
		return count;

	}


}
