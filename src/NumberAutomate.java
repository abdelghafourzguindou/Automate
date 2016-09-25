import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;


public class NumberAutomate {

	public NumberAutomate() {
		// TODO Auto-generated constructor stub
	}
	
	private static int[][] transTab = new int[4][256];
	
	private static void Init() {
		for(int i=0; i<4; i++)
			for(int j=0; j<256; j++)
				transTab[i][j] = -1;
	}
	
	private static void Fill() {
		for(int i=(int)'0'; i<=(int)'9'; i++) {
			transTab[0][i] = 1;
			transTab[1][i] = 1;
			transTab[2][i] = 3;
			transTab[3][i] = 3;
		}
		transTab[1][(int)'.'] = 2;
	}
	
	public static boolean isNumber(String Number) {
		Init();
		Fill();
		int i=0;
		int state=0;
		while(i < Number.length() && transTab[state][(int)Number.charAt(i)] != -1) {
			state = transTab[state][(int)Number.charAt(i)];
			i++;
		}
		if((state == 3 || state == 1) && i==Number.length()) return true;
		return false;
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner GET = new Scanner(System.in);
		System.out.print("Get Number : ");
		String num = GET.nextLine();
		if(isNumber(num)) System.out.println("Number vaid");
		else System.out.println("Number no valid");
	}*/

}
