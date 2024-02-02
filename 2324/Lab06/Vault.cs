using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Lab06
{
    public class Vault
    {
        public enum sortable
        {
            weight,
            durability,
            id,
            value
        }
        private Dictionary<string, Item>? items;

        private List<string>? names;

        public Vault()
        {
            items = new Dictionary<string, Item>();
            names = new List<string>();
        }

       

        public void AddItem(Item i, string name)
        {
            if (!(names.Contains(name)))
            {
                names.Add(name);
                items.Add(name, i);
            }
        }

        public void Delete(string name)
        {
            if (name.Contains(name))
            {
                items.Remove(name);
                names.Remove(name);
            }
        }

        public void Sort(sortable typ)
        {
            if (items == null || typ == null) { throw new Exception(); }
            switch (typ)
            {
                case sortable.weight:
                    items= (from item in items orderby item.Value.Weight descending select item).ToDictionary<KeyValuePair<string, Item>, string, Item>(pair => pair.Key, pair => pair.Value);
                    break;
                case sortable.durability:
                    items = (from item in items orderby item.Value.Durability descending select item).ToDictionary<KeyValuePair<string, Item>, string, Item>(pair => pair.Key, pair => pair.Value);
                    break;
                case sortable.id:
                    items = (from item in items orderby item.Value.ID descending select item).ToDictionary<KeyValuePair<string, Item>, string, Item>(pair => pair.Key, pair => pair.Value);
                    break;
                case sortable.value:
                    items = (from item in items orderby item.Value.Value descending select item).ToDictionary<KeyValuePair<string, Item>, string, Item>(pair => pair.Key, pair => pair.Value);
                    break;
            }
        }

        public override string ToString()
        {
            string s = "";
            foreach (var item in items)
            {
                s += item.Value.ToString() + "\n";
            }
            return s;
        }

        public void Print()
        {
            Console.WriteLine(ToString());
        }

        public void PrintNames()
        {
            Console.WriteLine(names.ToString());
        }

        public void Print(string s)
        {
            if (names.Contains(s)) { Console.WriteLine(items.GetValueOrDefault(s).ToString()); }
            else
            {
                Console.WriteLine("invalid name");
            }
        }
    }
}