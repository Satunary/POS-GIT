using System;
using System.Collections.Generic;
using System.Text;

namespace LinqInAction.LinqBooks.Common
{
    public class Subject
    {
        public required string Description { get; set; }
        public required string Name { get; set; }


        public override string ToString()
        {
            return Name;
        }
    }
}