using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab13.Model
{
    public class MyDBContext : DbContext
    {
        public MyDBContext(DbContextOptions opt) : base(opt) { }

        public virtual DbSet<Item> Items { get; set; }
        public virtual DbSet<Skill> Skills { get; set; }
        public virtual DbSet<Player> Players { get; set; }
    }

}
