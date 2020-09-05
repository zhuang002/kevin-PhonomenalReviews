/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonomenalreviews;

/**
 *
 * @author zhuan
 */
public class PhonomenalReviews {

    static int pathLength=0;
    static int n=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        readInput();
        int node=0;
        int start=findFurthest(0);
        int end=findFurthest(start);
        System.out.println(2*(n-1-pathLength)+pathLength);
    
}

    private static void readInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static int findFurthest(int node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}