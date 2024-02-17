using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab13.Model
{
    public class Item
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int ITID { get; set; }

        public string Name { get; set; } = "Default"!;
        public string Description { get; set; } = "Default"!;
        public int Weight { get; set; } = 0!;
        public bool Stackable { get; set; } = false!;

    }
}
