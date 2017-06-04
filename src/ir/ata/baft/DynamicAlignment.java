package ir.ata.baft;

import java.util.List;

public class DynamicAlignment {
	
	public static Cell[][] initalization(String Seq1, String Seq2,int Sim,int NonSimilar,int Gap){
			
		int M = Seq1.length();//Length+1//-AAA
        int N = Seq2.length();//Length+1//-AAA

        Cell[][] Matrix = new Cell[N][M];
        
        //Intialize the first Row With Gap Penality Equal To i*Gap 
        for (int i = 0; i < M; i++)
        {
            Matrix[0][i] = new Cell(0, i, i*Gap);
        }

        //Intialize the first Column With Gap Penality Equal To i*Gap 
        for (int i = 0; i < N; i++)
        {
            Matrix[i][0] = new Cell(i, 0, i*Gap);
        }
        
        // Fill Matrix with each cell has a value result from method Get_Max
        for (int j = 1; j < N; j++)
        {
            for (int i = 1; i < M; i++)
            {
                Matrix[j][i] =  Get_Max(i, j, Seq1, Seq2, Matrix,Sim,NonSimilar,Gap);
            }
        }
        return Matrix;
	}
	
	
	public static Cell Get_Max(int i, int j, String Seq1, String Seq2, Cell[][] Matrix,int Similar,int NonSimilar,int GapPenality)
    {
        Cell Temp = new Cell();
        int Sim;
        int Gap = GapPenality;
        if (Seq1.charAt(i) == Seq2.charAt(j))
            Sim = Similar;
        else
            Sim = NonSimilar;
        int M1, M2, M3;
        M1 = Matrix[j - 1][i - 1].getCellScore() + Sim;
        M2 = Matrix[j][i - 1].getCellScore() + Gap;
        M3 = Matrix[j - 1][i].getCellScore() + Gap;

        int max = M1 >= M2 ? M1 : M2;
        int Mmax = M3 >= max ? M3 : max;
        if (Mmax == M1)
        { Temp = new Cell(j, i, M1, Matrix[j - 1][i - 1], Cell.PrevcellType.Diagonal); }
        else
        {
            if (Mmax == M2)
            { Temp = new Cell(j, i, M2, Matrix[j][i - 1], Cell.PrevcellType.Left); }
            else
            {
                if (Mmax == M3)
                { Temp = new Cell(j, i, M3, Matrix[j - 1][i], Cell.PrevcellType.Above); }
            }
        }

        return Temp;
    }
	
	public static void Traceback_Step(Cell[][] Matrix, String Sq1, String Sq2, List<Character> Seq1, List<Character> Seq2)
    {
        Cell CurrentCell = Matrix[Sq2.length() - 1][Sq1.length() - 1];

        while (CurrentCell.getCellPointer() != null)
        {
            if (CurrentCell.getType() == Cell.PrevcellType.Diagonal)
            {
                Seq1.add(Sq1.charAt(CurrentCell.getCellColumn()));
                Seq2.add(Sq2.charAt(CurrentCell.getCellRow()));
            }
            if (CurrentCell.getType() == Cell.PrevcellType.Left)
            {
                Seq1.add(Sq1.charAt(CurrentCell.getCellColumn()));
                Seq2.add('-');
            }
            if (CurrentCell.getType() == Cell.PrevcellType.Above)
            {
                Seq1.add('-');
                Seq2.add(Sq2.charAt(CurrentCell.getCellRow()));
            }
            CurrentCell = CurrentCell.getCellPointer();
        }
    }
}
