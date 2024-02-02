using Lab02;

Console.WriteLine("testing generation of simple stack");
Console.WriteLine("case size 0:");
try
{
    Lab02.Stack<string> s = new Lab02.Stack<string>(0);
    Console.WriteLine("unsuccessfull");
}
catch (ArgumentNullException)
{
    Console.WriteLine("Succsessfull");
}
Console.WriteLine("case size -1");
try
{
    Lab02.Stack<string> s1 = new Lab02.Stack<string>(-1);
    Console.WriteLine("unsuccessfull");
}
catch (ArgumentNullException)
{
    Console.WriteLine("Succsessfull");
}
Console.WriteLine("case size 50");
try
{
    Lab02.Stack<string> s2 = new Lab02.Stack<string>(10);
    Console.WriteLine("successfull");
}
catch (ArgumentNullException)
{
    Console.WriteLine("unsuccsessfull");
}

Console.WriteLine("------------------------------------------");
Console.WriteLine("testing push");
Console.WriteLine("case input null");
try
{
    Lab02.Stack<string> s2 = new Lab02.Stack<string>(10);
    s2.Push(null);
    Console.WriteLine("unsuccessfull");
}
catch (InvalidOperationException)
{
    Console.WriteLine("succsessfull");
}
Console.WriteLine("case input 'a'");

try
{
    Lab02.Stack<string> s2 = new Lab02.Stack<string>(10);
    s2.Push(null);
    Console.WriteLine("unsuccessfull");
}
catch (InvalidOperationException)
{
    Console.WriteLine("succsessfull");
}