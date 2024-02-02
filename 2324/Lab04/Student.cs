using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace Lab04
{
    class Student
    {
        /// TODO: 
        ///    - Add a constructor to initialize the properties Id, Firstname, Lastname and City.
        ///    - Add a reference to the class of the student (type SchoolClass). This reference is optional,
        ///      if a student is not assigned to a class is has the value null.
        ///    - Add an annotation [JsonIgnore] above this property to suppress the content of
        ///      the class object in your serialized output
        public int Id { get; }
        public string Lastname { get; }
        public string Firstname { get; }
        public string City { get; set; }

        public Student(int id, string firstname,string lastname,string city)
        {
            Id= id;
            Firstname= firstname;
            Lastname= lastname;
            City= city;
        }
        
        /// <summary>
        /// Updates the reference of the student and adds the student to the new class.
        /// </summary>
        /// <param name="k"></param>
        public void ChangeClass(SchoolClass k)
        {
            SchoolClass.RemoveStudent(this);
            k.AddStudent(this);
        }
        //liegt ganz unten weil ich mir nicht sicher bin ob JsonIgnore alles folgende ignoriert oder nur das nächste attribut
        [JsonIgnore]
        public SchoolClass SchoolClass { get; set; }
    }
}
