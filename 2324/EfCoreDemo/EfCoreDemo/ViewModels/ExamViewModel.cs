using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using EfCoreDemoV2.Dto;
using EfCoreDemoV2.Model;
using EfCoreDemoV2.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace EfCoreDemoV2.ViewModels
{
   public class ExamViewModel:ObservableObject
    {
        private readonly SchoolDb _db = new SchoolDb();

        private bool _examWritableEntry;
        public bool ExamReadOnlyEntry { get { return _examWritableEntry; } set { SetProperty(ref _examWritableEntry, value); } }

        private bool _examWritablePicker;
        public bool ExamEnabledPicker { get { return _examWritablePicker; } set { SetProperty(ref _examWritablePicker, value); } }

        public ICommand SaveExamCommand { get; }

        public List<Teacher> Teachers => MainViewModel.Instance.Teachers;

        private Exam _currentExam2;
        public Exam CurrentExam2
        {
            get { return _currentExam2; }
            set
            {
                SetProperty(ref _currentExam2, value);
            }
        }
        public ExamViewModel()
        {
            SaveExamCommand = new RelayCommand(SaveExam);
            CurrentExam2 = MainViewModel.Instance.CurrentExam;
        }

        

        private async void SaveExam()
        {
            if (CurrentExam2 is null || CurrentExam2.Grade == 0 || CurrentExam2.Subject.Length < 1) { return; }
            CurrentExam2.Student=_db.Pupils.Where(s=>s.Id==CurrentExam2.Student.Id).First();
            CurrentExam2.Examiner = _db.Teachers.Where(s => s.TeacherNr == CurrentExam2.Examiner.TeacherNr).First();
            _db.Exams.Add(CurrentExam2);
            _db.SaveChanges();
            MainViewModel.Instance.Exams.Add(CurrentExam2);
            await Shell.Current.Navigation.PopAsync();
        }
    }
}
