using Lab05;

Console.WriteLine("insert filename");
string s = Console.ReadLine();
Runner r = new Runner();
r.ReadFromFile(s);
Console.WriteLine(r.Gewinn());
Console.ReadLine();