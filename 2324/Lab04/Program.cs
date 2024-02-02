using Lab04;
using System.Text.Json;

public class Program
{
    static void Main(string[] args)
    {
        Dictionary<string, SchoolClass> classes = new();
        classes.Add("3AHIF", new SchoolClass(name: "3AHIF", classTeacher: "KV1"));
        classes.Add("3BHIF", new SchoolClass(name: "3BHIF", classTeacher: "KV2"));
        classes.Add("3CHIF", new SchoolClass(name: "3CHIF", classTeacher: "KV3"));

        classes["3AHIF"].AddStudent(new Student(id: 1001, firstname: "FN1", lastname: "LN1", city: "CTY1"));
        classes["3AHIF"].AddStudent(new Student(id: 1002, firstname: "FN2", lastname: "LN2", city: "CTY1"));
        classes["3AHIF"].AddStudent(new Student(id: 1003, firstname: "FN3", lastname: "LN3", city: "CTY2"));
        classes["3BHIF"].AddStudent(new Student(id: 1011, firstname: "FN4", lastname: "LN4", city: "CTY1"));
        classes["3BHIF"].AddStudent(new Student(id: 1012, firstname: "FN5", lastname: "LN5", city: "CTY1"));
        classes["3BHIF"].AddStudent(new Student(id: 1013, firstname: "FN6", lastname: "LN6", city: "CTY1"));

        Student s = classes["3AHIF"].Students[0];
        Console.WriteLine($"s sitzt in der Klasse {s.SchoolClass?.Name} mit dem KV {s.SchoolClass?.ClassTeacher}.");
        Console.WriteLine($"In der 3AHIF sind folgende Städte: {JsonSerializer.Serialize(classes["3AHIF"].Cities)}.");

        Console.WriteLine("3AHIF vor ChangeKlasse:");
        Console.WriteLine(JsonSerializer.Serialize(classes["3AHIF"].Students));
        s.ChangeClass(classes["3BHIF"]);
        Console.WriteLine("3AHIF nach ChangeKlasse:");
        Console.WriteLine(JsonSerializer.Serialize(classes["3AHIF"].Students));
        Console.WriteLine("3BHIF nach ChangeKlasse:");
        Console.WriteLine(JsonSerializer.Serialize(classes["3BHIF"].Students));
        Console.WriteLine($"s sitzt in der Klasse {s.SchoolClass?.Name} mit dem KV {s.SchoolClass?.ClassTeacher}.");
    }
}