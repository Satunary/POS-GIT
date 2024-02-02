

internal class Program
{
    private static void Main(string[] args)
    {
        Stack<char> s = new Stack<char>(20);
        Console.Write("Ihre Eingabe: ");
        string input = Console.ReadLine();
        foreach (char c in input)
        {
            if (c.Equals('('))
            {
                s.Push(c);
            }
            if (c.Equals(')'))
            {
                try
                {
                    s.Pop();
                }
                catch (Exception e)
                {
                    Console.WriteLine("unopened )");
                }
            }
        }
        try
        {
            for (int i = 0; i < 20; i++) {
           
                Console.WriteLine("unclosed "+s.Pop());
            }
        } catch (Exception e) {
        
        }
    }
}