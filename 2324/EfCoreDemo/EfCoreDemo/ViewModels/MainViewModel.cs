﻿using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;
using EfCoreDemoV2.Model;
using EfCoreDemoV2.Extensions;
using EfCoreDemoV2.Dto;
using System.Windows;
using CommunityToolkit.Mvvm.ComponentModel;
using Microsoft.EntityFrameworkCore;
using CommunityToolkit.Mvvm.Input;
using Bogus;
using EfCoreDemo2;

namespace EfCoreDemoV2.ViewModels {
    /// <summary>
    /// Viewmodel für MainWindow
    /// </summary>
    public sealed class MainViewModel : ObservableObject {
        /// <summary>
        /// Instanz der Personendatenbank.
        /// </summary>
        private readonly SchoolDb _db = new SchoolDb();

        public ICommand NewPupilCommand { get; }
        public ICommand SavePupilCommand { get; }
        public ICommand DeletePupilCommand { get; }
        public ICommand AddPupilCommand { get; }
        public ICommand NewExamCommand { get; }
        

        // Lesen aus der DB.
        public List<Schoolclass> Classes => _db.Classes.ToList();
        public List<Gender> Genders => _db.Genders.ToList();

        public List<Teacher> Teachers => _db.Teachers.ToList();

        /// <summary>
        /// Binding für die CollectionView. Ist eine ObservableCollection, damit die Liste 
        /// automatisch beim Hinzufügen oder Löschen aktualisiert wird.
        /// </summary>
        public ObservableCollection<StudentDto> Pupils { get; } = new ObservableCollection<StudentDto>();

        public ObservableCollection<Exam> Exams { get; } = new ObservableCollection<Exam>();

        /// <summary>
        /// Zustandsinfo (z.B. Exception). Ist das Bindingfeld für die View.
        /// </summary>
        private string _info = string.Empty;
        public string Info
        {
            get => _info;
            set => SetProperty(ref _info, value);
        }

        private Schoolclass? _currentClass;
        public Schoolclass? CurrentClass
        {
            get => _currentClass;
            set
            {
                _currentClass = value;
                // Entfernt alle alten Einträge aus der Pupils Collection und fügt die Schüler
                // der gewählten Klasse hinzu. Achtung: Pupils ist eine ObservableCollection, damit
                // die Anzeige aktualisiert wird darf sie nicht einfach neu gesetzt werden.
                if (_currentClass is null)
                {
                    Pupils.Clear();
                    return;
                }
                ReadStudents();
            }
        }

        /// <summary>
        /// Aktuell angezeigte Person. Ist das Bindingfeld für die View.
        /// </summary>
        private StudentDto? _currentStudent;
        public StudentDto? CurrentStudent
        {
            get => _currentStudent;
            set
            {
                
                SetProperty(ref _currentStudent, value);

                if(_currentStudent is null)
                {
                    Exams.Clear();
                    return;
                }
                ReadExams();
            }
        }

        private Exam _currentExam;
        public Exam CurrentExam
        {
            get { return _currentExam; }
            set {
                SetProperty(ref _currentExam, value); }
        }

        
        /// <summary>
        /// Konstruktor mit Initialisierungen.
        /// Initialisiert die Command Properties für die Buttons. Hier kann die Action, die durchgeführt
        /// werden soll, direkt mitgegeben werden. Bei längeren Methoden sollte aber die Methode
        /// im View Model als private definiert werden und es wird hier einfach der Methodenname
        /// übergeben.
        /// Das Erzeugen des RelayCommand sollte nicht direkt im getter des Binding Properties
        /// geschehen, da sonst immer eine neue Instanz erzeugt wird. Deswegen initialisieren wir
        /// hier vorher.
        /// </summary>


        private static Lazy<MainViewModel> lazy = new Lazy<MainViewModel>(() => new MainViewModel());
        public static MainViewModel Instance => lazy.Value;

        private MainViewModel()
        {
            NewPupilCommand = new RelayCommand(NewPupil);
            SavePupilCommand = new RelayCommand(SavePupil); //, () => CurrentStudent is not null);
            DeletePupilCommand = new RelayCommand(DeletePupil);
            AddPupilCommand = new RelayCommand(AddPupil);
            NewExamCommand = new RelayCommand(NewExam);
            
        }

        private void SavePupil()
        {
            if (CurrentStudent is null) { return; }
            try
            {
                Info = "";

                // Gibt es den Schüler schon?
                var studentDb = _db.Pupils.FirstOrDefault(p => p.Id == CurrentStudent.Id);
                // Wenn nein, machen wir ein INSERT.
                if (studentDb is null)
                {
                    
                }
                else
                {
                    // Ansonsten ein UPDATE
                    // Automapper kann eine existierende Instanz (studentDb) ergänzen.
                    // Hier ohne Automapper:
                    studentDb.Firstname = CurrentStudent.Firstname is null ? studentDb.Firstname : CurrentStudent.Firstname;
                    studentDb.Lastname = CurrentStudent.Lastname is null ? studentDb.Lastname : CurrentStudent.Lastname;
                    studentDb.DateOfBirth = CurrentStudent.DateOfBirth.HasValue ? studentDb.DateOfBirth : CurrentStudent.DateOfBirth;
                    studentDb.Gender = CurrentStudent.Gender is null ? studentDb.Gender : CurrentStudent.Gender;
                }
                _db.SaveChanges();
                ReadStudents();

                // Die Felder für die Schülerbearbeitung werden wieder geleert.
                CurrentStudent = null;
            }
            catch (ArgumentException e)
            {
                Info = e.Message;
            }
            catch (DbUpdateException e)
            {
                Info = e.Message;
            }
        }

        private async void NewPupil()
        {
            _currentStudent = new StudentDto();
            await Shell.Current.Navigation.PushAsync(new NewPupilPage());
        }

        private async void AddPupil()
        {
            CurrentStudent.Schoolclass = CurrentClass;
            CurrentStudent.DateOfBirth??=CurrentStudent.DateOfBirth=DateTime.Now;
            Student s = StudentDto.CreateFrom(CurrentStudent);
            _db.Pupils.Add(s);
            Pupils.Add(CurrentStudent);
            await Shell.Current.Navigation.PopAsync();
            
           
        }

        /// <summary>
        /// Liest den selektierten Schüler einer Klasse.
        /// </summary>
        private void DeletePupil()
        {
            if (CurrentStudent is null) { return; }
            Info = "";

            // Suchen des Schuelers
            var studentDb = _db.Pupils.FirstOrDefault(p => p.Id == CurrentStudent.Id);
            if (studentDb is null)
            {
                // Wenn nein, Programmierfehler!
                Info = $"Gibt es nicht in der DB!? Student Id: {CurrentStudent.Id}";
                return;
            }
            _db.Pupils.Remove(studentDb);

            _db.SaveChanges();
            ReadStudents();

            // Die Felder für die Schülerbearbeitung werden wieder geleert.
            CurrentStudent = null;
        }

        private async void NewExam()
        {

            Student s = _db.Pupils.Where(p=>p.Id==CurrentStudent.Id).FirstOrDefault();
            s??=StudentDto.CreateFrom(CurrentStudent);
            CurrentExam = new Exam("", DateTime.Now, Teachers.First(), s, 0);
            
            await Shell.Current.Navigation.PushAsync(new NewExamPage());
        }

        

        /// <summary>
        /// Liest alle Schüler einer Klasse in die ObservableCollection
        /// </summary>
        private void ReadStudents()
        {
            if (CurrentClass is null)
            {
                Pupils.Clear();
                return;
            }
            // Wir lesen alle Students der Klasse (der Name ist der PK) und sortieren nach dem Namen.
            var students = _db.Pupils
                .Include(p => p.Gender)
                .Where(p => p.Schoolclass.Name == CurrentClass.Name)
                .OrderBy(p => p.Lastname)
                .ThenBy(p => p.Firstname)
                ;

            Pupils.ReplaceAll(students.Select(x => StudentDto.CreateFrom(x)));
        }

        private void ReadExams()
        {
            if (CurrentStudent is null)
            {
                Exams.Clear();
                return;
            }
            // Wir lesen alle Students der Klasse (der Name ist der PK) und sortieren nach dem Namen.
            var examss = _db.Exams.Where(e=> e.Student == StudentDto.CreateFrom(CurrentStudent));

            Exams.ReplaceAll(examss);
            
        }
    }
}


