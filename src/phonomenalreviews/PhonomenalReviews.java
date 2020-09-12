/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonomenalreviews;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class PhonomenalReviews {

    static int pathLength = 0;
    static int[][] map = null;
    static int[] phoRestaurants = null;
    static int[] steps = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        readInput();
        preprocess();
        int start = findFurthest(phoRestaurants[0]);
        int end = findFurthest(start);
        System.out.println(2 * (map.length - 1 - pathLength) + pathLength);
    }

    private static void readInput() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n][n];
        phoRestaurants = new int[n];
        steps = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            phoRestaurants[i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int pho = sc.nextInt();
            phoRestaurants[pho] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = 1;
            map[y][x] = 1;
        }
    }

    private static int findFurthest(int node) {
        ArrayList<Integer> current = new ArrayList();
        ArrayList<Integer> next = new ArrayList();
        for (int i = 0; i < steps.length; i++) {
            steps[i] = -1;
        }
        steps[node] = 0;
        current.add(node);
        int step = 1;
        while (!current.isEmpty()) {
            for (Integer n : current) {
                for (int j = 0; j < map.length; j++) {
                    if (map[n][j] == 1 && steps[j] == -1) {
                        next.add(j);
                        steps[j] = step;
                    }
                }
            }
            current = next;
            next = new ArrayList();
            step++;
        }
        pathLength = -1;
        int retNode = -1;
        for (int i = 0; i < map.length; i++) {
            if (phoRestaurants[i] == 1) {
                if (pathLength < steps[i]) {
                    pathLength = steps[i];
                    retNode = i;
                }
            }
        }
        return retNode;
    }

    private static void preprocess() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
