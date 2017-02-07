package Package;

public class Stack<T>
{

    public T[] data = null;
    public int top = 0;

    public Stack()
    {
        this.data = (T[]) new Object[10];
    }

    public void push(T element)
    {
        data[top++] = element;
    }
    
    public boolean isEmpty()
    {
        return top == 0;
    }
    
   @Override
    public String toString() 
    {
        if (!isEmpty())
        {
            String result = "";
            for (int i = 0; i < top; i++)
            {
                if (data[i] != null)
                {
                    result += data[i] + " ";
                }
            }
            return result;
        }
        return "The stack is empty!";
    }

    public boolean isOperator(String str)
    {
        return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }

    public boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c))
            {
                return false;
            }
        }
        return true;
    }

    public void calculate()
    {
        if (top >= 3)
        {
            if (isOperator(data[top - 1].toString()))
            {
                if (isNumeric(data[top - 2].toString()) && (isNumeric(data[top - 3].toString())))
                {
                    if (data[top - 1].equals("+"))
                    {
                        Integer res = Integer.parseInt(data[top - 2].toString()) + Integer.parseInt(data[top - 3].toString());
                        top = top - 3;
                        push((T) res);
                    }
                    if (data[top - 1].equals("-"))
                    {
                        Integer res = Integer.parseInt(data[top - 2].toString()) - Integer.parseInt(data[top - 3].toString());
                        top = top - 3;
                        push((T) res);
                    }
                    if (data[top - 1].equals("*"))
                    {
                        Integer res = Integer.parseInt(data[top - 2].toString()) * Integer.parseInt(data[top - 3].toString());
                        top = top - 3;
                        push((T) res);
                    }
                    if (data[top - 1].equals("/"))
                    {
                        Integer res = Integer.parseInt(data[top - 2].toString()) / Integer.parseInt(data[top - 3].toString());
                        top = top - 3;
                        push((T) res);
                    }
                }
            }
        }
    }
}
