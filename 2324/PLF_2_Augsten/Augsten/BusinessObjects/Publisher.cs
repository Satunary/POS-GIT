using System;
using System.Collections.Generic;
using System.Drawing;
using System.Text;

namespace LinqInAction.LinqBooks.Common
{
    public class Publisher
    {
        public required string Name { get; set; }
        public string Logo { get; set; } = string.Empty;
        public string WebSite { get; set; } = string.Empty;

        public override string ToString()
        {
            return Name;
        }
    }
}
