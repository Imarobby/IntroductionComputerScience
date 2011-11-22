/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einh�lt:
 * Jeder, der den Quelltext, ob in Teilen oder komplett, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training6;

import java.util.Arrays;

public class Conflict {
    public static int wife(int n) {
        if (n == 0)
            return 1;
        else
            return n - husband(wife(n - 1));
    }

    public static int husband(int n) {
        if (n == 0)
            return 0;
        else
            return n - wife(husband(n - 1));
    }

    public static boolean fight(int n) {
        return !(wife(n) == husband(n));
    }

    // little buggy, kA warum -> statt fuer n = 6 [1, 2, 3, 5, 8, 13] sollte [1, 1, 2, 3, 5, 8] kommen
    public static int[] differenceFights(int n) {
        int[] result = new int[n];

        int last = 0;
        for (int i = 0, j = 0; i < n; ++j) {
            if (fight(j)) {
                if (last == 0)
                    last = j;

                else {
                    result[i++] = j - last;
                    last = j;
                }
            }
        }

        return result;
    }

    public static void test() {
        // Fibonnacci!
        for (int i = 0; i < 10; ++i) {
            System.out.println(Arrays.toString(differenceFights(i)));
        }

        if (fight(7)) {
            System.out.println("Die kupferne Hochzeit findet im Streit statt!");
        }
        else
            System.out
                    .println("Die kupferne Hochzeit wird friedlich verlaufen!");

        if (fight(25)) {
            System.out.println("Die silberne Hochzeit findet im Streit statt!");
        }
        else
            System.out
                    .println("Die silberne Hochzeit wird friedlich verlaufen!");

        // Vertragen sich besser, da die Difference immer groesser wird.
    }
}
