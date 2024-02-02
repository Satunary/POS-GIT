using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Lab06
{
    abstract public class Item
    {
        public int Weight {  get; set; }
        public int ID { get; init; }
        public int Value { get; init; }
        public int Durability { get; set; }

        public Item(int weight, int id, int value, int durability) 
        {
            Weight = weight;
            ID = id;
            Value = value;
            Durability = durability;
        }

        public abstract void use(int n);

        public override bool Equals(object? obj)
        {
            return obj is Item item &&
                   ID == item.ID;
        }

        public override int GetHashCode()
        {
            return HashCode.Combine(ID);
        }

        public override string ToString()
        {
            return $"ID: {ID}; Value: {Value}; Weight {Weight}; Durability: {Durability}";
        }
    }
}