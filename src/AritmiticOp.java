import java.util.Scanner;


public class AritmiticOp {

	public AritmiticOp() {
		// TODO Auto-generated constructor stub
	}

	private static int[][] transTab = new int[6][256];
	
	private static void Init() {
		for(int i=0; i<6; i++)
			for(int j=0; j<256; j++)
				transTab[i][j] = -1;
	}
	
	private static void Fill() {
		
		transTab[0][0] 		  = 1;
		transTab[2][1] 		  = 3;
		transTab[2][0] 		  = 4;
	
		transTab[1][(int)'='] = 2;
		
		transTab[3][(int)'*'] = 2;
		transTab[3][(int)'+'] = 2;
		transTab[3][(int)'-'] = 2;
		transTab[3][(int)'/'] = 2;
		transTab[3][(int)'%'] = 2;
		
		transTab[4][(int)'*'] = 2;
		transTab[4][(int)'+'] = 2;
		transTab[4][(int)'-'] = 2;
		transTab[4][(int)'/'] = 2;
		transTab[4][(int)'%'] = 2;
		
		transTab[3][(int)';'] = 5;
		transTab[4][(int)';'] = 5;
	}
	
	private static int GetFirstOp(String str) {
		int place = 0;
		while(place < str.length() && (str.charAt(place) != '+') &&
									  (str.charAt(place) != '*') &&
									  (str.charAt(place) != '/') &&
									  (str.charAt(place) != '-') &&
									  (str.charAt(place) != '%') &&
									  (str.charAt(place) != '=')) {
			place++;
		}
		if(place == str.length()) return -1;
		return place;
	}
	
	private static int GetSymbol(String str) {
		if(IdAutomate.isID(str))		 return 0;
		if(NumberAutomate.isNumber(str)) return 1;
		return -1;
	}
	
	public static boolean isAritmiticExpr(String op) {
		
		Init();
		Fill();
		
		int i 		 = 0;
		int state    = 0;
		int thisChar = 0;
		int symb     = 0;
		
		char opr = 0;
		
		String id  = null;
		String str = null;
		
		if(GetFirstOp(op) == -1) return false;
		
		opr = op.charAt(GetFirstOp(op));
		id  = op.substring(0, op.indexOf(opr));
		str = op.substring(op.indexOf(opr)+1);
		symb  = GetSymbol(id);
		if(symb == -1 || symb == 1) return false;
		
		while(state != -1 && state != 5) 
		{
			state = transTab[state][symb];
			state = transTab[state][(int)opr];
		
			if(GetFirstOp(str) != -1) {
				opr   = str.charAt(GetFirstOp(str));
				id    = str.substring(0, str.indexOf(opr)); 
				str   = str.substring(str.indexOf(opr)+1);
				symb  = GetSymbol(id);
				if(symb == -1) return false;
			}
			else {
				if(!str.endsWith(";")) return false;
				id    = str.substring(0, str.length()-1); 
				symb  = GetSymbol(id);
				if(symb == -1) return false;
				state = transTab[state][symb];
				state = transTab[state][(int)';'];
			}
		} 
		if(state == 5 ) return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner GET = new Scanner(System.in);
		System.out.print("Get op : ");
		String op = GET.nextLine();
		if(isAritmiticExpr(op)) System.out.println("op vaid");
		else System.out.println("op no valid");
	}

}
