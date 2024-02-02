using System;
using System.Collections.Generic;
using System.Text;

namespace LinqInAction.LinqBooks.Common
{
    public class Book
    {
        public IEnumerable<Author> Authors { get; set; } = default!;
        public string Isbn { get; set; } = string.Empty;
        public string Notes { get; set; } = string.Empty;
        public int PageCount { get; set; }
        public decimal Price { get; set; }
        public DateTime PublicationDate { get; set; }
        public required Publisher Publisher { get; set; }
        public IEnumerable<Review> Reviews { get; set; } = default!;
        public required Subject Subject { get; set; }
        public string Summary { get; set; } = string.Empty;
        public required string Title { get; set; }

        public int Sold { get; set; }   // Verkaufte Buecher

        public override String ToString()
        {
            return Title;
        }
    }
}