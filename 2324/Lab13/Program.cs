using Lab13.Model;
using Microsoft.EntityFrameworkCore;

using (var db = new MyDBContext(new DbContextOptionsBuilder().UseSqlite("Data Source=Play.db").Options))
{
    db.Database.EnsureDeleted();
    db.Database.EnsureCreated();

    Item i = new Item() { Name = "weeeee", Stackable = true, Weight = 1 };
    Item i2 = new Item() { Name = "beeeee", Stackable = false, Weight = 10 };

    Skill s = new Skill() { Name = "argh!", Description = "u don't need to know" };

    Player player = new Player() { Name = "Sat", ItemSlot1 = i, SkSlot1 = s };

    db.Items.Add(i);
    db.Items.Add(i2);
    db.Skills.Add(s);
    db.Players.Add(player);
    db.SaveChanges();

    Console.WriteLine($"Player Name: {db.Players.First().Name}, Item: {db.Players.First().ItemSlot1.Name}, Skill: {db.Players.First().SkSlot1.Name}");
    Console.WriteLine("-----------------------------------------------");
    Console.WriteLine("Changing Item");
    db.Players.First().ItemSlot1 = i2;
    db.SaveChanges();
    Console.WriteLine($"Player Name: {db.Players.First().Name}, Item: {db.Players.First().ItemSlot1.Name}, Skill: {db.Players.First().SkSlot1.Name}");
    Console.WriteLine("-----------------------------------------------");
    Console.WriteLine("List of Items:");
    foreach (var item in db.Items)
    {
        Console.WriteLine($"Name: {item.Name} ID: {item.ITID}");
    }
    Console.WriteLine("removing item 1");
    db.Items.Remove(i);
    db.SaveChanges();
    Console.WriteLine("List of Items:");
    foreach (var item in db.Items)
    {
        Console.WriteLine($"Name: {item.Name} ID: {item.ITID}");
    }
}
