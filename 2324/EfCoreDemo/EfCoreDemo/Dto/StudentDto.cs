using EfCoreDemoV2.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EfCoreDemoV2.Dto {
    /// <summary>
    /// DTO Klasse für den Schüler
    /// Wenn wir einen neuen Schüler eingeben, müssen wir eine Instanz als Ziel für das Binding
    /// erstellen. Die Schülerklasse hat aber einen Konstruktor. Daher verwenden wir eine DTO
    /// Klasse mit offenen Settern.
    /// Da wir nicht wissen, was initialisiert wird, ist jedes Property nullable.
    /// </summary>
    public class StudentDto {
        public int? Id { get; set; }
        public string? Firstname { get; set; }
        public string? Lastname { get; set; }
        public DateTime? DateOfBirth { get; set; }
        public Gender? Gender { get; set; }
        public Schoolclass? Schoolclass { get; set; }

        public static StudentDto CreateFrom(Student student)
        {
            return new StudentDto
            {
                Id = student.Id,
                Firstname = student.Firstname,
                Lastname = student.Lastname,
                DateOfBirth = student.DateOfBirth,
                Gender = student.Gender,
                Schoolclass = student.Schoolclass
            };
        }
        public static Student CreateFrom(StudentDto studentDto)
        {
            return new Student(
                studentDto.Firstname ?? throw new ArgumentException("Firstname Null"),
                studentDto.Lastname ?? throw new ArgumentException("Lastname Null"),
                studentDto.Gender ?? throw new ArgumentException("Gender Null"),
                studentDto.Schoolclass ?? throw new ArgumentException("Schoolclass Null"),
                studentDto.DateOfBirth ?? throw new ArgumentException("DateOfBirth Null")
                )
            { Id = studentDto.Id.HasValue ? studentDto.Id.Value : 0 };
        }
    }
}
