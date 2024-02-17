using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab13.Model
{
    public class Player
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int PLID { get; set; }
        public string Name { get; set; } = "MAX"!;

        [ForeignKey("SKID")]
        public Skill SkSlot1 { get; set; } = null!;
        [ForeignKey("ITID")]
       
        
        public Item ItemSlot1 { get; set; } = null!;
      
    }
}
