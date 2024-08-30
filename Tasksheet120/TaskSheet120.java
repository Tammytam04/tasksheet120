import java.util.ArrayList;
import java.util.Scanner;

 class TaskSheet120 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> inputs = new ArrayList<>();

    System.out.println("\n--- Enter 3 numbers ---");

    // Limit input to 3 numbers
    for (int i = 0; i < 3; i++) {
      System.out.print("Enter number " + (i + 1) + ": ");
      inputs.add(scanner.nextInt());
    }

    scanner.close();

    int[] arrayInputs = inputs.stream().mapToInt(Integer::intValue).toArray();
    Result result = calculateSums(arrayInputs);

    
    for (int i = 0; i < result.getCumulativeSums().length; i++) {
      System.out.println("Sum up to " + inputs.get(i) + ": " + result.getCumulativeSums()[i]);
    }
    System.out.println("Total of all cumulative sums: " + result.getCumulativeSumsTotal());
  }

  public static Result calculateSums(int... numbers) {
    int cumulativeSumsTotal = 0;
    int[] cumulativeSums = new int[numbers.length];

    for (int i = 0; i < numbers.length; i++) {
      int cumulativeSum = numbers[i] * (numbers[i] + 1) / 2;
      cumulativeSums[i] = cumulativeSum;
      cumulativeSumsTotal += cumulativeSum;
    }
    return new Result(cumulativeSums, cumulativeSumsTotal);
  }
}

class Result {
  private final int cumulativeSumsTotal;
  private final int[] cumulativeSums;

  Result(int[] cumulativeSums, int cumulativeSumsTotal) {
    this.cumulativeSums = cumulativeSums;
    this.cumulativeSumsTotal = cumulativeSumsTotal;
  }

  public int[] getCumulativeSums() { return cumulativeSums; }
  public int getCumulativeSumsTotal() { return cumulativeSumsTotal; }
}
