using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using ConsoleApp.Model;

namespace ConsoleApp;

public partial class Schule2023Context : DbContext
{
    public Schule2023Context()
    {
    }

    public Schule2023Context(DbContextOptions<Schule2023Context> options)
        : base(options)
    {
    }

    public virtual DbSet<Gegenstaende> Gegenstaendes { get; set; }

    public virtual DbSet<Klassen> Klassens { get; set; }

    public virtual DbSet<Lehrer> Lehrers { get; set; }

    public virtual DbSet<Pruefungen> Pruefungens { get; set; }

    public virtual DbSet<Raeume> Raeumes { get; set; }

    public virtual DbSet<Schueler> Schuelers { get; set; }

    public virtual DbSet<Stunden> Stundens { get; set; }

    public virtual DbSet<Vorgesetzte> Vorgesetztes { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        => optionsBuilder.UseSqlite("Data Source=Schule2023.db")
       // .LogTo(Console.WriteLine, Microsoft.Extensions.Logging.LogLevel.Information)
        ;

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Gegenstaende>(entity =>
        {
            entity.HasKey(e => e.GId);

            entity.ToTable("gegenstaende");

            entity.Property(e => e.GId)
                .HasMaxLength(10)
                .HasColumnName("G_ID");
            entity.Property(e => e.GBez)
                .HasMaxLength(50)
                .HasColumnName("G_Bez");
        });

        modelBuilder.Entity<Klassen>(entity =>
        {
            entity.HasKey(e => e.KId);

            entity.ToTable("klassen");

            entity.Property(e => e.KId)
                .HasMaxLength(10)
                .HasColumnName("K_ID");
            entity.Property(e => e.KBez)
                .HasMaxLength(50)
                .HasColumnName("K_Bez");
            entity.Property(e => e.KLKlavst)
                .HasMaxLength(5)
                .HasColumnName("K_L_Klavst");
            entity.Property(e => e.KSKlaspr).HasColumnName("K_S_Klaspr");
            entity.Property(e => e.KSKlasprstv).HasColumnName("K_S_Klasprstv");

            entity.HasOne(d => d.KLKlavstNavigation)
                    .WithMany(p => p.Klassens)
                    .HasForeignKey(d => d.KLKlavst)
                    .HasConstraintName("FK_klassen_lehrer");

            entity.HasOne(d => d.KSKlasprNavigation)
                .WithMany(p => p.KlassenKSKlasprNavigations)
                .HasForeignKey(d => d.KSKlaspr)
                .HasConstraintName("FK_klassen_schueler");

            entity.HasOne(d => d.KSKlasprstvNavigation)
                .WithMany(p => p.KlassenKSKlasprstvNavigations)
                .HasForeignKey(d => d.KSKlasprstv)
                .HasConstraintName("FK_klassen_schueler1");
        });

        modelBuilder.Entity<Lehrer>(entity =>
        {
            entity.HasKey(e => e.LId);

            entity.ToTable("lehrer");

            entity.Property(e => e.LId)
                .HasMaxLength(5)
                .HasColumnName("L_ID");
            entity.Property(e => e.LGebdat)
                .HasColumnType("datetime")
                .HasColumnName("L_Gebdat");
            entity.Property(e => e.LGehalt)
                .HasColumnType("DECIMAL(18,2)")
                .HasColumnName("L_Gehalt");
            entity.Property(e => e.LLChef)
                .HasMaxLength(5)
                .HasColumnName("L_L_Chef");
            entity.Property(e => e.LName)
                .HasMaxLength(50)
                .HasColumnName("L_Name");
            entity.Property(e => e.LVorname)
                .HasMaxLength(50)
                .HasColumnName("L_Vorname");

            entity.HasOne(d => d.LLChefNavigation).WithMany(p => p.InverseLLChefNavigation).HasForeignKey(d => d.LLChef);
        });

        modelBuilder.Entity<Pruefungen>(entity =>
        {
            entity.HasKey(e => new { e.PDatum, e.PSKandidat, e.PLPruefer, e.PGFach });

            entity.ToTable("pruefungen");

            entity.Property(e => e.PDatum)
                .HasColumnType("datetime")
                .HasColumnName("P_Datum");
            entity.Property(e => e.PSKandidat)
                .HasColumnType("INT")
                .HasColumnName("P_S_Kandidat");
            entity.Property(e => e.PLPruefer)
                .HasMaxLength(5)
                .HasColumnName("P_L_Pruefer");
            entity.Property(e => e.PGFach)
                .HasMaxLength(10)
                .HasColumnName("P_G_Fach");
            entity.Property(e => e.PArt)
                .HasMaxLength(3)
                .HasColumnName("P_Art");
            entity.Property(e => e.PNote)
                .HasColumnType("INT")
                .HasColumnName("P_Note");

            entity.HasOne(d => d.PGFachNavigation)
                    .WithMany(p => p.Pruefungens)
                    .HasForeignKey(d => d.PGFach)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_pruefungen_gegenstaende");

            entity.HasOne(d => d.PLPrueferNavigation)
                .WithMany(p => p.Pruefungens)
                .HasForeignKey(d => d.PLPruefer)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK_pruefungen_lehrer");

            entity.HasOne(d => d.PSKandidatNavigation)
                .WithMany(p => p.Pruefungens)
                .HasForeignKey(d => d.PSKandidat)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK_pruefungen_schueler");
        });

        modelBuilder.Entity<Raeume>(entity =>
        {
            entity.HasKey(e => e.RId);

            entity.ToTable("raeume");

            entity.Property(e => e.RId)
                .HasMaxLength(10)
                .HasColumnName("R_ID");
            entity.Property(e => e.RPlaetze)
                .HasColumnType("smallint")
                .HasColumnName("R_Plaetze");
        });

        modelBuilder.Entity<Schueler>(entity =>
        {
            entity.HasKey(e => e.SSchnr);

            entity.ToTable("schueler");

            entity.Property(e => e.SSchnr)
                .ValueGeneratedNever()
                .HasColumnType("INT")
                .HasColumnName("S_SCHNR");
            entity.Property(e => e.SAdresse)
                .HasMaxLength(50)
                .HasColumnName("S_Adresse");
            entity.Property(e => e.SGebdat)
                .HasColumnType("datetime")
                .HasColumnName("S_Gebdat");
            entity.Property(e => e.SKKlasse)
                .HasMaxLength(10)
                .HasColumnName("S_K_Klasse");
            entity.Property(e => e.SName)
                .HasMaxLength(50)
                .HasColumnName("S_Name");
            entity.Property(e => e.SVorname)
                .HasMaxLength(50)
                .HasColumnName("S_Vorname");

            entity.HasOne(d => d.SKKlasseNavigation).WithMany(p => p.Schuelers).HasForeignKey(d => d.SKKlasse)
            .HasConstraintName("FK_schueler_klassen");
        });

        modelBuilder.Entity<Stunden>(entity =>
        {
            entity.HasKey(e => new { e.StKKlasse, e.StStunde });

            entity.ToTable("stunden");

            entity.Property(e => e.StKKlasse)
                .HasMaxLength(10)
                .HasColumnName("ST_K_Klasse");
            entity.Property(e => e.StStunde)
                .HasMaxLength(5)
                .HasColumnName("ST_Stunde");
            entity.Property(e => e.StGFach)
                .HasMaxLength(10)
                .HasColumnName("ST_G_Fach");
            entity.Property(e => e.StLLehrer)
                .HasMaxLength(5)
                .HasColumnName("ST_L_Lehrer");
            entity.Property(e => e.StRRaum)
                .HasMaxLength(10)
                .HasColumnName("ST_R_Raum");

            entity.HasOne(d => d.StGFachNavigation)
                    .WithMany(p => p.Stundens)
                    .HasForeignKey(d => d.StGFach)
                    .HasConstraintName("FK_stunden_gegenstaende");

            entity.HasOne(d => d.StKKlasseNavigation)
                .WithMany(p => p.Stundens)
                .HasForeignKey(d => d.StKKlasse)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK_stunden_klassen");

            entity.HasOne(d => d.StLLehrerNavigation)
                .WithMany(p => p.Stundens)
                .HasForeignKey(d => d.StLLehrer)
                .HasConstraintName("FK_stunden_lehrer");

            entity.HasOne(d => d.StRRaumNavigation)
                .WithMany(p => p.Stundens)
                .HasForeignKey(d => d.StRRaum)
                .HasConstraintName("FK_stunden_raeume");
        });

        modelBuilder.Entity<Vorgesetzte>(entity =>
        {
            entity.HasKey(e => new { e.VLVorg, e.VArt, e.VLUnt });

            entity.ToTable("vorgesetzte");

            entity.Property(e => e.VLVorg)
                .HasMaxLength(5)
                .HasColumnName("V_L_Vorg");
            entity.Property(e => e.VArt)
                .HasMaxLength(50)
                .HasColumnName("V_Art");
            entity.Property(e => e.VLUnt)
                .HasMaxLength(5)
                .HasColumnName("V_L_Unt");

            entity.HasOne(d => d.VLUntNavigation).WithMany(p => p.VorgesetzteVLUntNavigations)
                .HasForeignKey(d => d.VLUnt)
                .OnDelete(DeleteBehavior.ClientSetNull);

            entity.HasOne(d => d.VLVorgNavigation).WithMany(p => p.VorgesetzteVLVorgNavigations)
                .HasForeignKey(d => d.VLVorg)
                .OnDelete(DeleteBehavior.ClientSetNull);

        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
