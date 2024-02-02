using System;
using System.Collections.Generic;
using System.Text;

namespace LinqInAction.LinqBooks.Common
{
    public class Author
    {
        public required string FirstName { get; set; }
        public required string LastName { get; set; }
        public string WebSite { get; set; } = string.Empty;
        public DateTime Birthdate { get; set; } // Geburtdatum
        public IEnumerable<Book> Books { get; set; } = default!;
    }
}