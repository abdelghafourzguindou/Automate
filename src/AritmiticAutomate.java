import java.util.Scanner;


public class AritmiticAutomate {

	public AritmiticAutomate() {
		// TODO Auto-generated constructor stub
	}
	
	private static int[][] transTab = new int[6][256];
	
	private static void Init() {
		for(int i=0; i<6; i++)
			for(int j=0; j<256; j++)
				transTab[i][j] = -1;
	}
	
	private static void Fill() {
		
		//transTab[0][0] 		  = 1;
		transTab[1][(int)'='] = 2;
		transTab[3][(int)'*'] = 4;
		transTab[3][(int)'+'] = 4;
		transTab[3][(int)'-'] = 4;
		transTab[3][(int)'/'] = 4;
		transTab[3][(int)'%'] = 4;
		transTab[4][(int)';'] = 5;
		
		for(int i=(int)'0'; i<=(int)'9'; i++) {
			transTab[2][i] = 3;
			transTab[3][i] = 3;
			transTab[4][i] = 4;
		}
	}
	
	public static boolean isAritmiticExpr(String op) {
		Init();
		Fill();
		int i = 0;
		/*String id = "";
		while(op.charAt(i) != '=' && i<op.length()) {
			id += op.charAt(i);
			i++;
		}*/
		String id = op.substring(0, op.indexOf('='));
		if(!IdAutomate.isID(id)) return false;
		int state    = 1;
		//int thisChar = i;
		int thisChar  = 0;
		String str = op.substring(op.indexOf('='));
		
		while(thisChar < str.length() && 
			  transTab[state][(int)str.charAt(thisChar)] != -1) 
		{
			state = transTab[state][(int)str.charAt(thisChar)];
			//System.out.println("st = "+state+" symb = "+str.charAt(thisChar));
			thisChar++;
		} 
		if(state == 5 && thisChar == str.length()) return true;
		return false;
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner GET = new Scanner(System.in);
		System.out.print("Get op : ");
		String op = GET.nextLine();
		if(isAritmiticExpr(op)) System.out.println("op vaid");
		else System.out.println("op no valid");
	}*/
}
