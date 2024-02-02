using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Lab06
{
    public class Weapon:Item
    {

        public Weapon(int weight, int id, int value,int durability) : base(weight, id, value, durability)
        {

        }

        public override void use(int n)
        {
            Durability -= n;
        }
    }
}