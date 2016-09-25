import java.util.Scanner;


public class IdAutomate {

	public IdAutomate() {
		// TODO Auto-generated constructor stub
	}
	
	private static int[][] transTab = new int[2][256];
	
	private static void Init() {
		for(int i=0; i<256; i++) {
			transTab[0][i] = -1;
			transTab[1][i] = -1;
		}
	}
	
	private static void Fill() {
		//_
		transTab[0][(int)'_'] = 1;
		transTab[1][(int)'_'] = 1;
		//a...z
		for(int i=97; i<=122; i++) 
		{
			transTab[0][i] = 1;
			transTab[1][i] = 1;
		}
		//A...Z
		for(int i=65; i<=90; i++) 
		{
			transTab[0][i] = 1;
			transTab[1][i] = 1;
		}
		//0...9
		for(int i=48; i<=57; i++)  transTab[1][i] = 1;
	}
	
	public static boolean isID(String id) {
		Init();
		Fill();
		int i = 0;
		int state = 0;
		while(i < id.length() && transTab[state][(int)id.charAt(i)] != -1) {
			state = transTab[state][(int)id.charAt(i)];
			i++;
		}
		if(state == 1 && i == id.length()) return true;
		return false;
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner GET = new Scanner(System.in);
		System.out.print("Get id : ");
		String id = GET.nextLine();
		if(isID(id)) System.out.println("id vaid");
		else System.out.println("id no valid");
	}*/

}
