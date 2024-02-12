using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace nwConsole.Model;

public partial class Northwind4SqliteContext : DbContext
{
    public Northwind4SqliteContext()
    {
    }

    public Northwind4SqliteContext(DbContextOptions<Northwind4SqliteContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Category> Categories { get; set; }

    public virtual DbSet<Customer> Customers { get; set; }

    public virtual DbSet<Employee> Employees { get; set; }

    public virtual DbSet<EmployeeTerritory> EmployeeTerritories { get; set; }

    public virtual DbSet<Order> Orders { get; set; }

    public virtual DbSet<OrderDetail> OrderDetails { get; set; }

    public virtual DbSet<Product> Products { get; set; }

    public virtual DbSet<Shipper> Shippers { get; set; }

    public virtual DbSet<Supplier> Suppliers { get; set; }

    public virtual DbSet<Territory> Territories { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseSqlite("Data Source= Northwind4SQLite.db");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Category>(entity =>
        {
            entity.HasIndex(e => e.CategoryName, "CategoryName");

            entity.Property(e => e.CategoryId).ValueGeneratedNever();
            entity.Property(e => e.CategoryName).HasColumnType("nvarchar (15)");
            entity.Property(e => e.Description).HasColumnType("ntext");
            entity.Property(e => e.Picture).HasColumnType("image");
        });

        modelBuilder.Entity<Customer>(entity =>
        {
            entity.HasIndex(e => e.City, "City");

            entity.HasIndex(e => e.CompanyName, "CompanyNameCustomers");

            entity.HasIndex(e => e.PostalCode, "PostalCodeCustomers");

            entity.HasIndex(e => e.Region, "Region");

            entity.Property(e => e.CustomerId).HasColumnType("nchar (5)");
            entity.Property(e => e.Address).HasColumnType("nvarchar (60)");
            entity.Property(e => e.City).HasColumnType("nvarchar (15)");
            entity.Property(e => e.CompanyName).HasColumnType("nvarchar (40)");
            entity.Property(e => e.ContactName).HasColumnType("nvarchar (30)");
            entity.Property(e => e.ContactTitle).HasColumnType("nvarchar (30)");
            entity.Property(e => e.Country).HasColumnType("nvarchar (15)");
            entity.Property(e => e.Fax).HasColumnType("nvarchar (24)");
            entity.Property(e => e.Phone).HasColumnType("nvarchar (24)");
            entity.Property(e => e.PostalCode).HasColumnType("nvarchar (10)");
            entity.Property(e => e.Region).HasColumnType("nvarchar (15)");
        });

        modelBuilder.Entity<Employee>(entity =>
        {
            entity.HasIndex(e => e.LastName, "LastName");

            entity.HasIndex(e => e.PostalCode, "PostalCodeEmployees");

            entity.Property(e => e.EmployeeId).ValueGeneratedNever();
            entity.Property(e => e.Address).HasColumnType("nvarchar (60)");
            entity.Property(e => e.BirthDate).HasColumnType("datetime");
            entity.Property(e => e.City).HasColumnType("nvarchar (15)");
            entity.Property(e => e.Country).HasColumnType("nvarchar (15)");
            entity.Property(e => e.Extension).HasColumnType("nvarchar (4)");
            entity.Property(e => e.FirstName).HasColumnType("nvarchar (10)");
            entity.Property(e => e.HireDate).HasColumnType("datetime");
            entity.Property(e => e.HomePhone).HasColumnType("nvarchar (24)");
            entity.Property(e => e.LastName).HasColumnType("nvarchar (20)");
            entity.Property(e => e.Notes).HasColumnType("ntext");
            entity.Property(e => e.Photo).HasColumnType("image");
            entity.Property(e => e.PhotoPath).HasColumnType("nvarchar (255)");
            entity.Property(e => e.PostalCode).HasColumnType("nvarchar (10)");
            entity.Property(e => e.Region).HasColumnType("nvarchar (15)");
            entity.Property(e => e.ReportsTo).HasColumnType("INT");
            entity.Property(e => e.Title).HasColumnType("nvarchar (30)");
            entity.Property(e => e.TitleOfCourtesy).HasColumnType("nvarchar (25)");
        });

        modelBuilder.Entity<EmployeeTerritory>(entity =>
        {
            entity.HasNoKey();

            entity.Property(e => e.EmployeeId).HasColumnType("INT");
            entity.Property(e => e.TerritoryId).HasColumnType("nvarchar] (20");
        });

        modelBuilder.Entity<Order>(entity =>
        {
            entity.HasIndex(e => e.CustomerId, "CustomerId");

            entity.HasIndex(e => e.CustomerId, "CustomersOrders");

            entity.HasIndex(e => e.EmployeeId, "EmployeeId");

            entity.HasIndex(e => e.EmployeeId, "EmployeesOrders");

            entity.HasIndex(e => e.OrderDate, "OrderDate");

            entity.HasIndex(e => e.ShipPostalCode, "ShipPostalCode");

            entity.HasIndex(e => e.ShippedDate, "ShippedDate");

            entity.HasIndex(e => e.ShipVia, "ShippersOrders");

            entity.Property(e => e.OrderId).ValueGeneratedNever();
            entity.Property(e => e.CustomerId).HasColumnType("nchar (5)");
            entity.Property(e => e.EmployeeId).HasColumnType("INT");
            entity.Property(e => e.Freight)
                .HasDefaultValue(0.0)
                .HasColumnType("money");
            entity.Property(e => e.OrderDate).HasColumnType("datetime");
            entity.Property(e => e.RequiredDate).HasColumnType("datetime");
            entity.Property(e => e.ShipAddress).HasColumnType("nvarchar (60)");
            entity.Property(e => e.ShipCity).HasColumnType("nvarchar (15)");
            entity.Property(e => e.ShipCountry).HasColumnType("nvarchar (15)");
            entity.Property(e => e.ShipName).HasColumnType("nvarchar (40)");
            entity.Property(e => e.ShipPostalCode).HasColumnType("nvarchar (10)");
            entity.Property(e => e.ShipRegion).HasColumnType("nvarchar (15)");
            entity.Property(e => e.ShipVia).HasColumnType("INT");
            entity.Property(e => e.ShippedDate).HasColumnType("datetime");

            entity.HasOne(d => d.Customer).WithMany(p => p.Orders).HasForeignKey(d => d.CustomerId);

            entity.HasOne(d => d.Employee).WithMany(p => p.Orders).HasForeignKey(d => d.EmployeeId);

            entity.HasOne(d => d.ShipViaNavigation).WithMany(p => p.Orders).HasForeignKey(d => d.ShipVia);
        });

        modelBuilder.Entity<OrderDetail>(entity =>
        {
            entity.HasKey(e => new { e.OrderId, e.ProductId });

            entity.ToTable("Order Details");

            entity.HasIndex(e => e.OrderId, "OrderId");

            entity.HasIndex(e => e.OrderId, "OrdersOrder_Details");

            entity.HasIndex(e => e.ProductId, "ProductId");

            entity.HasIndex(e => e.ProductId, "ProductsOrder_Details");

            entity.Property(e => e.OrderId).HasColumnType("INT");
            entity.Property(e => e.ProductId).HasColumnType("INT");
            entity.Property(e => e.Quantity)
                .HasDefaultValue((short)1)
                .HasColumnType("smallint");
            entity.Property(e => e.UnitPrice).HasColumnType("money");

            entity.HasOne(d => d.Order).WithMany(p => p.OrderDetails)
                .HasForeignKey(d => d.OrderId)
                .OnDelete(DeleteBehavior.ClientSetNull);

            entity.HasOne(d => d.Product).WithMany(p => p.OrderDetails)
                .HasForeignKey(d => d.ProductId)
                .OnDelete(DeleteBehavior.ClientSetNull);
        });

        modelBuilder.Entity<Product>(entity =>
        {
            entity.HasIndex(e => e.CategoryId, "CategoriesProducts");

            entity.HasIndex(e => e.CategoryId, "CategoryId");

            entity.HasIndex(e => e.ProductName, "ProductName");

            entity.HasIndex(e => e.SupplierId, "SupplierId");

            entity.HasIndex(e => e.SupplierId, "SuppliersProducts");

            entity.Property(e => e.ProductId).ValueGeneratedNever();
            entity.Property(e => e.CategoryId).HasColumnType("INT");
            entity.Property(e => e.Discontinued).HasColumnType("bit");
            entity.Property(e => e.ProductName).HasColumnType("nvarchar (40)");
            entity.Property(e => e.QuantityPerUnit).HasColumnType("nvarchar (20)");
            entity.Property(e => e.ReorderLevel)
                .HasDefaultValue((short)0)
                .HasColumnType("smallint");
            entity.Property(e => e.SupplierId).HasColumnType("INT");
            entity.Property(e => e.UnitPrice)
                .HasDefaultValue(0.0)
                .HasColumnType("money");
            entity.Property(e => e.UnitsInStock)
                .HasDefaultValue((short)0)
                .HasColumnType("smallint");
            entity.Property(e => e.UnitsOnOrder)
                .HasDefaultValue((short)0)
                .HasColumnType("smallint");

            entity.HasOne(d => d.Category).WithMany(p => p.Products).HasForeignKey(d => d.CategoryId);

            entity.HasOne(d => d.Supplier).WithMany(p => p.Products).HasForeignKey(d => d.SupplierId);
        });

        modelBuilder.Entity<Shipper>(entity =>
        {
            entity.Property(e => e.ShipperId).ValueGeneratedNever();
            entity.Property(e => e.CompanyName).HasColumnType("nvarchar (40)");
            entity.Property(e => e.Phone).HasColumnType("nvarchar (24)");
        });

        modelBuilder.Entity<Supplier>(entity =>
        {
            entity.HasIndex(e => e.CompanyName, "CompanyNameSuppliers");

            entity.HasIndex(e => e.PostalCode, "PostalCodeSuppliers");

            entity.Property(e => e.SupplierId).ValueGeneratedNever();
            entity.Property(e => e.Address).HasColumnType("nvarchar (60)");
            entity.Property(e => e.City).HasColumnType("nvarchar (15)");
            entity.Property(e => e.CompanyName).HasColumnType("nvarchar (40)");
            entity.Property(e => e.ContactName).HasColumnType("nvarchar (30)");
            entity.Property(e => e.ContactTitle).HasColumnType("nvarchar (30)");
            entity.Property(e => e.Country).HasColumnType("nvarchar (15)");
            entity.Property(e => e.Fax).HasColumnType("nvarchar (24)");
            entity.Property(e => e.HomePage).HasColumnType("ntext");
            entity.Property(e => e.Phone).HasColumnType("nvarchar (24)");
            entity.Property(e => e.PostalCode).HasColumnType("nvarchar (10)");
            entity.Property(e => e.Region).HasColumnType("nvarchar (15)");
        });

        modelBuilder.Entity<Territory>(entity =>
        {
            entity.HasNoKey();

            entity.Property(e => e.RegionId).HasColumnType("INT");
            entity.Property(e => e.TerritoryDescription).HasColumnType("nchar] (50");
            entity.Property(e => e.TerritoryId).HasColumnType("nvarchar] (20");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
