import java.util.Scanner;

public class AFD {
	
	public AFD() {

	}
	
	public static Integer[][] transTab = new Integer[12][256];
	
	public static void Inisialiser() 
	{	for(int i=0; i<12; i++)
		for(int j=0; j<256; j++)
		{
			//transTab[0][j] = -1;
			//transTab[1][j] = -1;
			//transTab[2][j] = -1;
			transTab[i][j] = -1;
		}
	}
	
	public static void Remplire() {
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
		for(int i=48; i<=57; i++) 
		{
			transTab[0][i] = 1;
			transTab[1][i] = 1;
		}
		//-_.
		transTab[0][95] = 1;
		transTab[1][95] = 1;
		transTab[0][46] = 1;
		transTab[1][46] = 1;
		transTab[0][45] = 1;
		transTab[1][45] = 1;
		//@gmail.com
		//transTab[1][255]= 2;
		transTab[1][(int)'@'] = 2;
		transTab[2][(int)'g'] = 3;
		transTab[3][(int)'m'] = 4;
		transTab[4][(int)'a'] = 5;
		transTab[5][(int)'i'] = 6;
		transTab[6][(int)'l'] = 7;
		transTab[7][(int)'.'] = 8;
		transTab[8][(int)'c'] = 9;
		transTab[9][(int)'o'] = 10;
		transTab[10][(int)'m'] = 11;
	}
	
	static void print(){
		for(int i=0; i<12; i++)
		{
			for(int j=0; j<256; j++) System.out.print(transTab[i][j]+"  ");
			System.out.println();
		}
	}
	
	public static int CharToInt(char c)
	{
		return (int)c;
	}
	
	public static boolean GmailAFD(String Gmail)
	{
		Inisialiser();
		Remplire();
		int state = 0, i = 0;
		while(i < Gmail.length() && transTab[state][CharToInt(Gmail.charAt(i))] != -1)
		{
			//System.out.println(state);
			state = transTab[state][CharToInt(Gmail.charAt(i))];
			i++;
			//if(state == 11) return true;
		}
		//System.out.println(state);
		if(state == 11) return true;
		return false;
	}
	
	/*public static void main(String[] args) {
		Scanner GET = new Scanner(System.in);
		System.out.print("Get your gmail : ");
		String mail = GET.nextLine();
		//System.out.println("LENGHT = "+mail.length());
		if(GmailAFD(mail)) System.out.println("Mail valid");
		else System.out.println("Mail no valid");
	}*/

}
