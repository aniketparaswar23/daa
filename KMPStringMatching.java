import java.util.ArrayList;
import java.util.Collections;

public class KMPStringMatching {
   public static ArrayList<Integer> prefixFunction(String var0) {
      int var1 = var0.length();
      ArrayList var2 = new ArrayList(Collections.nCopies(var1, 0));

      for(int var3 = 1; var3 < var1; ++var3) {
         int var4;
         for(var4 = (Integer)var2.get(var3 - 1); var4 > 0 && var0.charAt(var3) != var0.charAt(var4); var4 = (Integer)var2.get(var4 - 1)) {
         }

         if (var0.charAt(var3) == var0.charAt(var4)) {
            ++var4;
         }

         var2.set(var3, var4);
      }

      return var2;
   }

   public static void main(String[] var0) {
      String var1 = "aniket";
      ArrayList var2 = prefixFunction(var1);
      String var3 = "paraswar_aniket_amar";
      long var4 = System.nanoTime();
      int var6 = -1;
      int var7 = 0;
      int var8 = 0;

      while(var7 < var3.length()) {
         if (var3.charAt(var7) == var1.charAt(var8)) {
            ++var8;
            ++var7;
            if (var8 == var1.length()) {
               var6 = var7 - var1.length();
               break;
            }
         } else if (var8 != 0) {
            var8 = (Integer)var2.get(var8 - 1);
         } else {
            ++var7;
         }
      }

      long var9 = System.nanoTime();
      long var11 = var9 - var4;
      System.out.println("Position: " + var6);
      System.out.println("Execution time: " + var11 + " ns");
   }
}