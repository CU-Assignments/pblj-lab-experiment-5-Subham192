import java.util.ArrayList;
import java.util.List;
public class SumCalculator
{
public static Integer parseStringToInteger(String str)
{
try {
return Integer.parseInt(str);
} catch (NumberFormatException e)
{
System.out.println("Invalid number format: " + str);
return null;
}
}
public static int calculateSum(List<Integer> numbers)
{
int sum = 0;
for (Integer num : numbers)
{
if (num != null) sum += num;
}
return sum;
}
public static void main(String[] args)
{
List<Integer> numbers = new ArrayList<>();
numbers.add(10);
  numbers.add(20);
numbers.add(30);
String[] inputStrings = {"40", "50", "invalid"};
for (String str : inputStrings)
{
Integer num = parseStringToInteger(str);
if (num != null) numbers.add(num);
}
System.out.println("The sum of the list is: " + calculateSum(numbers));
}
}

