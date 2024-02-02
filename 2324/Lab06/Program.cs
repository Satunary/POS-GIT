using Lab06;

Vault v = new Vault();
v.AddItem(new Armor(10, 1, 50, 100), "baisicLeather");
v.AddItem(new Weapon(5, 2, 10, 100), "baisicShortSword");
v.AddItem(new Weapon(7, 3, 15, 100), "baisicLongSword");

v.Print();
Console.WriteLine("----------------------------------------------");
v.Sort(Vault.sortable.value);

v.Print();
Console.WriteLine("----------------------------------------------");
v.Delete("baisicShortSword");

v.PrintNames();
