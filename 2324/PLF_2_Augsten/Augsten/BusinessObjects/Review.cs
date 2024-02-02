using System;
using System.Collections.Generic;
using System.Text;

namespace LinqInAction.LinqBooks.Common
{
    public class Review
    {
        public required Book Book { get; set; }
        public required User User { get; set; }
        public int Rating { get; set; }
        public string Comments { get; set; } = string.Empty;
    }
}