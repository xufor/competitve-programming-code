import java.util.Scanner;

public class CheckPathThatMakesAGivenWord {
    public static boolean checkPath(char[][] characterMatrix, int N, int M, String targetWord, boolean[][] visitedMatrix,
            int currentX, int currentY) {
        
        if(targetWord.isEmpty())
            return true;

        if(currentX < 0 || currentX >= M || currentY < 0 || currentY >= N)
            return false;

        boolean result1 = checkPath(characterMatrix, N, M, targetWord.substring(1), visitedMatrix, currentX - 1, currentY - 1);
        boolean result2 = checkPath(characterMatrix, N, M, targetWord.substring(1), visitedMatrix, currentX - 1, currentY);
        boolean result3 = checkPath(characterMatrix, N, M, targetWord.substring(1), visitedMatrix, currentX - 1, currentY + 1);
        boolean result4 = checkPath(characterMatrix, N, M, targetWord.substring(1), visitedMatrix, currentX, currentY + 1);
        boolean result5 = checkPath(characterMatrix, N, M, targetWord.substring(1), visitedMatrix, currentX + 1, currentY + 1);
        boolean result6 = checkPath(characterMatrix, N, M, targetWord.substring(1), visitedMatrix, currentX + 1, currentY);
        boolean result7 = checkPath(characterMatrix, N, M, targetWord.substring(1), visitedMatrix, currentX + 1, currentY - 1);
        boolean result8 = checkPath(characterMatrix, N, M, targetWord.substring(1), visitedMatrix, currentX, currentY - 1);

        return (targetWord.charAt(0) == characterMatrix[currentX][currentY])
                && (result1 || result2 || result3 || result4 || result5 || result6 || result7 || result8);
    }

    public static boolean checkPath(char[][] characterMatrix, int N, int M, String targetWord) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (characterMatrix[i][j] == targetWord.charAt(0)) {
                    return checkPath(characterMatrix, N, M, targetWord, new boolean[M][N], i, j);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int N = scnr.nextInt(), M = scnr.nextInt();
        char[][] characterMatrix = new char[N][M];
        for (int i = 0; i < N; i++) {
            characterMatrix[i] = scnr.next().toCharArray();
        }
        String targetWord = scnr.next();
        System.out.println(checkPath(characterMatrix, N, M, targetWord));
        scnr.close();
    }
}

/*
5 5
AAAAA
ATAAA
AIAZA
AGEAA
AAAAA
TIGER

5 5
AAAAA
ATAAA
AIAAA
AGEAA
AAARA
TIGER

5 5
AAAAA
ATAAA
AIAAA
AGAAA
AEARA
TIGER

5 5
AAAAA
ATAAA
AIARA
AGEAA
AAAAA
TIGER

3 3
AXX
XTX
XXX
AT

3 3
TXE
XXX
AXK
AXE

3 3
TXE
XYX
AXK
AXE
*/