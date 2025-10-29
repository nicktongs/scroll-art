


// Satellite ASCII art
class Satellite {
    public static char[][] getSatellite() {
        int SatHeight = 20;
        int SatWidth = 60;
        char[][] img = new char[SatHeight][SatWidth];
        for (int y = 0; y < SatHeight; y++)
            for (int x = 0; x < SatWidth; x++)
                img[y][x] = ' ';

        // Basic satellite ASCII layout (you can edit freely)
        for (int i=2; i<12; i++) img[i][24] = '|';
        for (int i=3; i<12; i++) img[i][25] = '|';
        for (int i=3; i<12; i++) img[i][33] = '|';
        for (int i=2; i<12; i++) img[i][34] = '|';
        for (int i=26; i<33; i++) img[1][i] = '-';
        for (int i=26; i<33; i++) img[11][i] = '-';
        for (int i=19; i<24; i++) img[6][i] = '=';
        for (int i=35; i<40; i++) img[6][i] = '=';
        for (int i=4; i<9; i++) img[i][18] = '|';
        for (int i=4; i<9; i++) img[i][40] = '|';
        for (int i=4; i<9; i++) img[i][0] = '|';
        for (int i=4; i<9; i++) img[i][58] = '|';
        for (int i=1; i<18; i++) img[4][i] = '-';
        for (int i=41; i<58; i++) img[4][i] = '-';
        for (int i=1; i<18; i++) img[8][i] = '-';
        for (int i=41; i<58; i++) img[8][i] = '-';
        for (int x=5; x<8; x++)
            for (int i=2; i<18; i=i+2) img[x][i] = '|';
        for (int x=5; x<8; x++)
            for (int i=1; i<19; i=i+2) img[x][i] = '-';
        for (int x=5; x<8; x++)
            for (int i=42; i<58; i=i+2) img[x][i] = '|';
        for (int x=5; x<8; x++)
            for (int i=41; i<59; i=i+2) img[x][i] = '-';

        for (int i=6; i<10; i=i+1) img[i][30] = '|';
        for (int i=6; i<10; i=i+1) img[i][31] = '-';
        for (int i=6; i<10; i=i+1) img[i][32] = '|';
        
        for (int i=6; i<10; i=i+1) img[i][26] = '|';
        for (int i=6; i<10; i=i+1) img[i][27] = '-';
        for (int i=6; i<10; i=i+1) img[i][28] = '|';
        for (int i=3; i<6; i=i+1) img[i][27] = '|';
        for (int i=3; i<6; i=i+1) img[i][31] = '|';
        for (int x=3; x<6; x=x+2)
            for (int i=28; i<31; i=i+1) img[x][i] = '-';
        img[4][28] = '\\'; 
        img[4][29] = '0'; 
        img[4][30] = '/';

        img[1][25] = '|'; 
        img[1][33] = '|';
        img[12][28] = '/'; img[12][29] = '`'; img[12][30] = '\\';
        img[13][27] = '/'; img[13][28] = '/'; img[13][29] = '('; img[13][30] = '`'; img[13][31] = '\\';
        img[14][26] = '/'; img[14][27] = '('; img[14][28] = ' '; img[14][29] = '('; img[14][30] = '\\'; img[14][31] = ' '; img[14][32] = '`';
        img[15][26] = '('; img[15][27] = ' '; img[15][28] = '/'; img[15][29] = '`'; img[15][30] = ' '; img[15][31] = '\\'; img[15][32] = ')';
        img[16][26] = ' '; img[16][27] = '/'; img[16][28] = '/'; img[16][29] = ')'; img[16][30] = '\\'; img[16][31] = ')'; img[16][32] = '`';
        


        return img;
    }
}

// Terminal animation handler
public class TerminalArraySatellite {

    public static char[][] getTerm() {
        int width = 100;      // terminal width
        int SatWidth = 60;    // satellite art width
        int SatHeight = 20;   // satellite art height

        char[][] terminal = new char[204][width];

        for (int y = 0; y < 204; y++) {
            for (int x = 0; x < width; x++) {
                terminal[y][x] = ' ';
            }
        }

       
        char[][] satellite = Satellite.getSatellite();

        // Insert the satellite multiple times vertically for repetition
        int startX = 20;
        for (int repeat = 0; repeat < 6; repeat++) {
            int offsetY = 25 * repeat;
            for (int y = 0; y < SatHeight; y++) {
                for (int x = 0; x < SatWidth; x++) {
                    if (offsetY + y < terminal.length && startX + x < width) {
                        terminal[offsetY + y][startX + x] = satellite[y][x];
                    }
                }
            }
        }

        return terminal;
    }

    // Continuous looping print — repeats the scroll animation infinitely
    public static void printTerminalLoop() {
        while (true) {
            char[][] art = getTerm();
            for (int i = 0; i < art.length; i++) {
                for (int j = 0; j < art[i].length; j++) {
                    System.out.print(art[i][j]);
                }
                System.out.println();
                try {
                    Thread.sleep(60);
                } catch (InterruptedException exception) {
                }
            }
        }
    }

    // Print one frame (no repetition)
    public static void printTerminalOnce() {
        char[][] art = getTerm();
        for (int i = 0; i < art.length; i++) {
            for (int j = 0; j < art[i].length; j++) {
                System.out.print(art[i][j]);
            }
            System.out.println();
        }
    }

    // Entry point
    public static void main(String[] args) {
        printTerminalLoop(); // Change to printTerminalOnce() if testing one frame
    }
}
