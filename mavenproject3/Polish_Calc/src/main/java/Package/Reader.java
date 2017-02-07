package Package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Reader
{

    private static String inputs;

    public static void main(String[] args) throws IOException
    {
        run();
        System.out.println("RPN Calculator started!");
    }

    public static void run() throws IOException, NumberFormatException
    {
        Stack stack = new Stack();

        while (true)
        {
            System.out.print("Input: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            inputs = in.readLine();

            if (!inputs.isEmpty())
            {
                String[] inputlist = inputs.split(" ");

                for (String input : inputlist)
                {
                    if (stack.isNumeric(input) || stack.isOperator(input))
                    {
                        if (stack.isOperator(input))
                        {
                            stack.push(input);
                        } else
                        {
                            stack.push(Integer.parseInt(input));
                        }
                    }
                    stack.calculate();
                }
                System.out.println("Current stack: " + stack.toString());
            }
        }
    }
}
