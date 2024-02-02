using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab04
{
    class SchoolClass
    {
        /// TODO: 
        ///    - Create a constructor to initialize Name, ClassTeacher (KV).
        ///    - Add a List of students to manage the students in this class.
        ///    - Use IReadOnlyList for your public property. It should NOT be possible to add or remove students from outside
        ///      without calling AddStudent or RemoveStudent.
        ///    - Add a read-only property of type HashSet<string> to get the different cities in this class.
        public string Name { get; }
        public string ClassTeacher { get; }
        private List<Student> _students;
        public IReadOnlyList<Student> Students { get { return _students; } }
        private HashSet<string> _cities;
        public HashSet<string> Cities { get { return _cities; } }


        public SchoolClass(string name,string classTeacher)
        {
            Name = name;
            ClassTeacher = classTeacher;
            _students = new List<Student>();
            _cities = new HashSet<string>();
        }
        /// <summary>
        /// Adds a student and modifies the schoolclass reference of the provided
        /// student.
        /// </summary>
        public void AddStudent(Student s)
        {
            if (s != null && !(_students.Contains(s))) {
                s.SchoolClass = this;
                _students.Add(s); 
            }
            else throw new InvalidDataException("invalid input");
            Cities.Add(s.City);
        }


        /// <summary>
        /// Removes a student and modifies the schoolclass reference of the provided
        /// student.
        /// </summary>
        public void RemoveStudent(Student s)
        {
            string temp;
            bool cont=false;
            if (s!=null&&_students.Contains(s))
            {
                _students.Remove(s);
                s.SchoolClass = null;
                temp = s.City;
            }
            else throw new InvalidDataException("input invalide");
            foreach(Student s2 in _students)
            {
                if (s2.City == temp)
                {
                    cont=true; break;
                }
            }
            if (!cont)
            {
                Cities.Remove(temp);
            }

        }
    }
}
