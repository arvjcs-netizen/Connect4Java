public class Board { // Board Class: Used to create the Connect 4 board. 
    private String[][] boardState;
    public Board(){
        boardState = new String[6][7];
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                boardState[i][j] = "E"; // E means empty, R means red, Y means yellow
            }
        }
    }
    public Boolean dropPiece(int column, String player){
        if(column < 0 || column>6){
            return false;
        }
        for(int row = 5; row >= 0; row--){
            if(boardState[row][column].equals("E")){
                boardState[row][column] = player;
                return true;
            }
        }
        return false;
    }
    public String checkColumnWin(){
        String[] column = new String[6];
        
        String colOf4;
        for(int i =0; i < 7; i++){
            for (int row = 0; row < 6; row++) {
                column[row] = boardState[row][i];
            }
            for(int j = 0; j<3; j++){
                colOf4 = "";
                for(int k = 0; k<4;k++){
                    colOf4 += column[(j+k)];
                }
                if(colOf4.equals("RRRR")){
                    return "R";
                }
                if(colOf4.equals("YYYY")){
                    return "Y";
                }
            }
        }
        return "none";
        
    }
    public String checkRowWin(){
        String[] row = new String[7];
        String rowOf4;
        for(int i =0; i < 6; i++){
            row = boardState[i];
            for(int j = 0; j<4; j++){
                rowOf4 = "";
                for(int k = 0; k<4;k++){
                    rowOf4 += row[(j+k)];
                }
                if(rowOf4.equals("RRRR")){
                    return "R";
                }
                if(rowOf4.equals("YYYY")){
                    return "Y";
                }
            }
        }
        return "none";
    }
    public String checkDiagonalWin(){
        //Check slope 1 diagonals
        String diagonalOf4;
        for(int i = 3; i <6; i++){
            for(int j = 0; j<4; j++){
                diagonalOf4 = "";
                for(int k = 0; k <4; k++){
                    diagonalOf4 += boardState[i-k][j+k];
                }
                if(diagonalOf4.equals("RRRR")){
                    return "R";
                }
                if(diagonalOf4.equals("YYYY")){
                    return "Y";
                }
            }
        }
        //Checks slope -1 diagonals
        for(int i = 3; i <6; i++){
            for(int j = 3; j<7; j++){
                diagonalOf4 = "";
                for(int k = 0; k <4; k++){
                    diagonalOf4 += boardState[i-k][j-k];
                }
                if(diagonalOf4.equals("RRRR")){
                    return "R";
                }
                if(diagonalOf4.equals("YYYY")){
                    return "Y";
                }
            }
        }
        
        return "none";

    }
    public String checkBoard(){
        if(!(checkColumnWin().equals("none"))){
            return checkColumnWin();
        }
        if(!(checkRowWin().equals("none"))){
            return checkRowWin();
        }
        if(!(checkDiagonalWin().equals("none"))){
            return checkDiagonalWin();
        }
        return "none";
    }
    public boolean checkTie(){
        for (int i = 0; i < boardState.length; i++) {
            for(int j = 0; j < boardState[i].length; j++) {
                if(boardState[i][j].equals("E")){
                    return false;
                }
            }
            
        }
        return true;
    }
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < boardState.length; i++) {
            for(int j = 0; j < boardState[i].length; j++) {
                result += boardState[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }
}
